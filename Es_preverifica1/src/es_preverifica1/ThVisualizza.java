/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es_preverifica1;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diliberti_alessandro
 */
public class ThVisualizza extends Thread{
    private DatiCondivisi ptrDati;

    public ThVisualizza(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }
    
    public void run(){
       for(int i=0; i<ptrDati.getMaxEle(); i++){
           try {
               ptrDati.Sem4Wait();
               System.out.println("------------------------------------------");
               System.out.println(Arrays.toString(ptrDati.getLista()));
               System.out.println("Spazi Inseriti= "+ ptrDati.getSpaziIns());
               System.out.println("Spazi Letti= "+ ptrDati.getSpaziLetti());
               System.out.println("Punti Inseriti= "+ ptrDati.getPuntiIns());
               System.out.println("Punti Letti= "+ ptrDati.getPuntiLetti());
               System.out.println("------------------------------------------");
               
               ptrDati.Sem1Signal();
               
               
           } catch (InterruptedException ex) {
               Logger.getLogger(ThVisualizza.class.getName()).log(Level.SEVERE, null, ex);
           }
       
       }
    }
}
