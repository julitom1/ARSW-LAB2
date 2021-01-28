package edu.eci.arsw.primefinder;


import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Main {
	private static PrimeFinderThread[] lista;
	private static ScheduledExecutorService executor;
	private static Time time;
	public static void main(String [] args) {
		executor = Executors.newScheduledThreadPool(1);
		time=new Time();
		
		//PrimeFinderThread pft=new PrimeFinderThread(0, 30000000);
		int numero=3;
		int division=30000000/numero;
		lista=new PrimeFinderThread[numero];
		executor.schedule(time, 5 , TimeUnit.SECONDS);
		for(int i=0;i<numero;i++) {
			PrimeFinderThread pft=new PrimeFinderThread(i*division+1, (i+1)*division);
			pft.start();
			lista[i]=pft;
		}
		
      executor.shutdown();
	}	
	public static void seguirHilo() {
	
		Scanner scannerObj = new Scanner(System.in);
		scannerObj.nextLine();
		
		PrimeFinderThread.suspender(false);
		for(int i=0;i<3;i++) {
		
		      synchronized (lista[i])
		      {
		        lista[i].notify();
		      }
		    
		 
		}
	
	}
}
