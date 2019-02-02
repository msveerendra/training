package com.veeru.sample.playground.corejava;

public class ThreadDemo extends Thread {
	
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		ThreadDemo demo = new ThreadDemo();
		demo.start();

	}

}
