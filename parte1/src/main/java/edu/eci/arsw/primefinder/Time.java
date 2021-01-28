package edu.eci.arsw.primefinder;



public class Time implements Runnable{
	public Time(){}
	
	
	@Override
	public void run() {
	
		
		try {
		
			Main.DetenerHilos();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} 
	}
	

}
