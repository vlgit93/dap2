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
public class Euclid {
    private int a, b;
    
    public Euclid(){
        this(0, 0);
    }
    
    public Euclid(int a, int b){
        this.a = a;
        this.b = b;
    }
    
    // Euklids Algorithmus zur Bestimmung des größten gemeinsamen Teilers
    public int euclidAlgo(int a, int b){
        if(b == 0){
            return a;
        }
        else{
            return euclidAlgo(b, a%b);
        }
    }
    public static void main(String[] args) throws IOException{
        try{
            if(args.length==2){
                int a = Integer.parseInt(args[0]);
                int b = Integer.parseInt(args[1]);
                if(a>0 && b>0){
                    Euclid obj = new Euclid(a, b);
                    System.out.println("ggT von " + a + " und " + b + ": " + obj.euclidAlgo(a, b));
                }
            }
            else{
                throw new IOException();
            }
        }
        catch(IOException e){
            System.out.println("wrong usage of Euclid." + '\n' + "usage: Euclid <Integer> <Integer>");
        }
        catch(Exception e){
            System.out.println("wrong usage of Euclid." + '\n' + "usage: Euclid <Integer> <Integer>");
        }
    }
}