/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es_preverifica1;

import java.util.Scanner;

/**
 *
 * @author diliberti_alessandro
 */
public class Es_preverifica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        java.io.BufferedReader console = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        
        System.out.println("quanti caratteri vuoi generare prova fghfgh?");
        int n = input.nextInt();
        

        DatiCondivisi ptrDati = new DatiCondivisi(n);
        
        ThGenera th1= new ThGenera(ptrDati);
        ThContaP th2= new ThContaP(ptrDati);
        ThContaS th3= new ThContaS(ptrDati);
        ThVisualizza th4= new ThVisualizza(ptrDati);
        
        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
    
}
