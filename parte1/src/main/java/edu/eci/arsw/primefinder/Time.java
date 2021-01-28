package edu.eci.arsw.primefinder;

public class Time implements Runnable{
	public Time(){}
	
	
	@Override
	public void run() {
	
		
		PrimeFinderThread.suspender(true);
		Main.seguirHilo();
	}
	

}
