package edu.eci.arsw.primefinder;


import java.util.LinkedList;
import java.util.List;

public class PrimeFinderThread extends Thread{

	private static boolean suspender=false;
	int a,b;
	
	private List<Integer> primes=new LinkedList<Integer>();
	
	public PrimeFinderThread(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public void run(){
		for (int i=a;i<=b;i++){						
			if (isPrime(i)){
				primes.add(i);
				System.out.println(i);
				
			}
			if(suspender) {
				try {
					synchronized (this) {
						wait();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
	
	public  boolean isPrime(int n) {
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	public static void suspender(boolean b) {
		suspender=b;
	}

	public List<Integer> getPrimes() {
		return primes;
	}

	
	
	
	
}
