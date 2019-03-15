/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es_preverifica1;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diliberti_alessandro
 */
public class ThGenera extends Thread{
    private DatiCondivisi ptrDati;

    public ThGenera(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }
    
    
    
    public void run(){
        
        for(int i=0; i<ptrDati.getMaxEle(); i++ ){
            try {
                ptrDati.Sem1Wait();
                Random rand = new Random();
                String stringa = "abcdefghijklmnopqrstuvwxyz . . . .";
                char lettera= stringa.charAt(rand.nextInt(stringa.length()));
                
                if(lettera == ' '){
                    ptrDati.incSpaziIns();
                }
                
                if(lettera == '.'){
                    ptrDati.incPuntiIns();
                }
                
                ptrDati.setEleLista(i, lettera);
                
                
                ptrDati.Sem2Signal();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ThGenera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
