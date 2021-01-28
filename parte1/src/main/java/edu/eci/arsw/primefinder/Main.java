package edu.eci.arsw.primefinder;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Main {
	private final static int timeInEjecution=300000;
	private static Timer timer;
	private static PrimeFinderThread[] lista;
	public static void main(String [] args) {
		timer=new Timer();
		//PrimeFinderThread pft=new PrimeFinderThread(0, 30000000);
		int numero=3;
		int division=30000000/numero;
		lista=new PrimeFinderThread[numero];
		
		for(int i=0;i<numero;i++) {
			PrimeFinderThread pft=new PrimeFinderThread(i*division+1, (i+1)*division);
			pft.start();
			lista[i]=pft;
		}
		
		calculateTime();
		
		
		
		
		
	}
	
	public static void calculateTime(){
		TimerTask taskTime=new TimerTask(){
            public void run(){
            	System.out.println("=========================================");
            	
            	for(int i=0;i<lista.length;i++) {
            		
						try {
							lista[i].wait();
						} catch (InterruptedException e) {
						
						}
					
            	}
            	
            	
            	
            	
            } 
        };
        	
		timer.schedule(taskTime,5000,5000);
	
	}
}
