/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dap2Algo;
import java.io.IOException;

/**
 *
 * @author vl
 */
public class Eratosthenes {
    
    public static boolean[] initArray(int n){
        boolean[] isPrime = new boolean[n];
            for(int i = 0; i<n; i++){
                isPrime[i] = true;
            }
        return isPrime;
    }
    
    // (i+2)*k ist das k-fache einer Zahl im Array, also auf jeden Fall KEINE Primzahl
    public static void sieve(boolean[] isPrime){       
        // da das Array bei 2 anfangen soll, entspricht der Index 0 der Zahl 2
        // also wäre i*k bei großem k direkt zu Beginn schon größer als die max. #Elemente des Arrays
        // deswegen nur bis zur Hälfte von isPrime.length
        for(int k = 2; k<(isPrime.length/2); k++){
            // überprüft nur Zahlen, die auch im Array sind
            for(int i = 0; ((i+2)*k - 2)<isPrime.length; i++){
                isPrime[(i+2)*k - 2] = false;
            }
        }
    }
    
    public static int countPrimeNumbers(boolean[] isPrime){
        int counter = 0;
        for(int i = 0; i<isPrime.length; i++){
            if(isPrime[i]==true){
                counter++;
            }
        }
        return counter;
    }
    
    public static void printPrimeNumbers(boolean[] isPrime){
        System.out.print("Prime numbers are: ");
        for(int i = 0; i<isPrime.length; i++){
            if(isPrime[i]==true){
                System.out.print((i+2) + " ");
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        try{
            int n = Integer.parseInt(args[0]);
            if(args.length==1){
                boolean[] a = initArray(n-2);
                sieve(a);
                int counter = countPrimeNumbers(a);
                System.out.println("Number of prime numbers is: " + counter);
            }
            if(args.length==2){
                if(args[1].equals("-o") && n!=0){
                    boolean[] a = initArray(n-2);
                    sieve(a);
                    int counter = countPrimeNumbers(a);
                    System.out.println("Number of prime numbers is: " + counter);
                    printPrimeNumbers(a);
                }
            }
            else{
                throw new IOException();
            }
        }
        catch(IOException e){
            System.out.println("wrong usage of Eratosthenes." + '\n' + "usage: Eratosthenes <positive integer> <-o>");
        }
        catch(Exception e){
            System.out.println("wrong usage of Eratosthenes." + '\n' + "usage: Eratosthenes <positive integer> <-o>");
        }
    }
}