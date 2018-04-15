/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dap2Algo;

/**
 *
 * @author vl
 */
public class Eratosthenes {
    private int n;
    private boolean[] isPrime;
    
    public Eratosthenes(int n){
        this.n = n-1;
        this.isPrime = new boolean[this.n];
        for(int i = 0; i<this.n; i++){
            this.isPrime[i] = true;
        }
    }
    
    // (i+2)*k ist das k-fache einer Zahl im Array, also auf jeden Fall KEINE Primzahl
    public void sieve(){       
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
    
    public void countPrimeNumbers(){
        int counter = 0;
        for(int i = 0; i<isPrime.length; i++){
            if(isPrime[i]==true){
                counter++;
            }
        }
        System.out.println("Number of prime numbers is: " + counter);
    }
    
    public void printPrimeNumbers(){
        System.out.print("Prime numbers are: ");
        for(int i = 0; i<isPrime.length; i++){
            if(isPrime[i]==true){
                System.out.print((i+2) + " ");
            }
        }
    }
    
    public static void main(String[] args){
        try{
            int n = Integer.parseInt(args[0]);
            Eratosthenes obj = new Eratosthenes(n);
            obj.sieve();
            obj.countPrimeNumbers();
            String s = args[1];
            if(s.equals("-o") && n!=0){
                obj.printPrimeNumbers();
            }
        }
        catch(java.lang.ArrayIndexOutOfBoundsException|java.lang.NegativeArraySizeException|java.lang.NumberFormatException e){
            System.out.println("wrong usage of Eratosthenes." + '\n' + "usage: Eratosthenes <positive integer> <-o>");
        }
    }
}