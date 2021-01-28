package edu.eci.arsw.primefinder;


import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Main {
	private static PrimeFinderThread[] lista;
	public static void main(String [] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		Time time=new Time();
		
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
	public  static void DetenerHilos() throws InterruptedException  {
		for(int i=0;i<3;i++) {
			lista[i].suspender();
		}
		
	}

}
