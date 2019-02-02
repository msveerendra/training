package com.veeru.sample.playground.corejava;

public class ThreadRunnableDemo implements Runnable {
	
	public void run() {
		for(int i=0 ; i <100; i++) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		
		ThreadRunnableDemo demo = new ThreadRunnableDemo();
		Thread thread = new Thread(demo);
		thread.start();

	}

}
