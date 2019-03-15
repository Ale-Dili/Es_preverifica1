/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es_preverifica1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author diliberti_alessandro
 */
public class DatiCondivisi {
    private char[] lista;
    private int spaziIns;
    private int puntiIns;
    private int spaziLetti;  
    private int puntiLetti;
    private int maxEle;
    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;
    private Semaphore sem4;

    public DatiCondivisi(char[] lista, int spaziIns, int puntiIns, int spaziLetti, int puntiLetti, int maxEle, Semaphore sem1, Semaphore sem2, Semaphore sem3, Semaphore sem4) {
        this.lista = lista;
        this.spaziIns = spaziIns;
        this.puntiIns = puntiIns;
        this.spaziLetti = spaziLetti;
        this.puntiLetti = puntiLetti;
        this.maxEle = maxEle;
        this.sem1 = sem1;
        this.sem2 = sem2;
        this.sem3 = sem3;
        this.sem4 = sem4;
    }
    
    public DatiCondivisi(int maxEle) { 
        this.maxEle = maxEle;
        lista = new char[maxEle];
        this.sem1 = new Semaphore(1);
        this.sem2 = new Semaphore(0);
        this.sem3 = new Semaphore(0);
        this.sem4 = new Semaphore(0);
    }

    synchronized public char[] getLista() {
        return lista;
    }

    synchronized public int getSpaziIns() {
        return spaziIns;
    }

    synchronized public int getPuntiIns() {
        return puntiIns;
    }

    synchronized public int getSpaziLetti() {
        return spaziLetti;
    }

    synchronized public int getPuntiLetti() {
        return puntiLetti;
    }

    public int getMaxEle() {
        return maxEle;
    }

    synchronized public void setLista(char[] lista) {
        this.lista = lista;
    }

    synchronized public void setSpaziIns(int spaziIns) {
        this.spaziIns = spaziIns;
    }

    synchronized public void setPuntiIns(int puntiIns) {
        this.puntiIns = puntiIns;
    }

    synchronized public void setSpaziLetti(int spaziLetti) {
        this.spaziLetti = spaziLetti;
    }

    synchronized public void setPuntiLetti(int puntiLetti) {
        this.puntiLetti = puntiLetti;
    }

    public void setMaxEle(int maxEle) {
        this.maxEle = maxEle;
    }
    
    
    
    public void Sem1Wait() throws InterruptedException{
        sem1.acquire();
    }
    public void Sem2Wait() throws InterruptedException{
        sem2.acquire();
    }
    public void Sem3Wait() throws InterruptedException{
        sem3.acquire();
    }
    public void Sem4Wait() throws InterruptedException{
        sem4.acquire();
    }
    
    
    public void Sem1Signal() throws InterruptedException{
        sem1.release();
    }   
    public void Sem2Signal() throws InterruptedException{
        sem2.release();
    }
    public void Sem3Signal() throws InterruptedException{
        sem3.release();
    }
    public void Sem4Signal() throws InterruptedException{
        sem4.release();
    }
    
    synchronized public void setEleLista(int pos,char ele){
        lista[pos]= ele;
    }
    
    synchronized public void incPuntiLetti() {
        this.puntiLetti++;
    }
    synchronized public void incSpaziLetti() {
        this.spaziLetti++;
    }
    synchronized public void incPuntiIns() {
        this.puntiIns++;
    }
    synchronized public void incSpaziIns() {
        this.spaziIns++;
    }
    
    
    
    
    
    
    
    

}
