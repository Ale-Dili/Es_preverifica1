/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es_preverifica1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diliberti_alessandro
 */
public class ThContaS extends Thread{
    private char[]lista;
    private DatiCondivisi ptrDati;

    public ThContaS(DatiCondivisi ptrDati) {       
        this.ptrDati = ptrDati;
        this.lista = ptrDati.getLista();
    }
    
    public void run(){
        for(int i=0;i<ptrDati.getMaxEle();i++){
            try {
                ptrDati.Sem3Wait();
                int cont=0;
                lista = ptrDati.getLista();
                for(int j=0;j<ptrDati.getMaxEle();j++){
                    if(lista[j]==' '){
                        cont++;
                    }
                }
                ptrDati.setSpaziLetti(cont);
                ptrDati.Sem4Signal();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThContaP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
