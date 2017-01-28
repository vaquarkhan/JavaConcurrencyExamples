package chapter01.threadmanager.demo03_interrupt;

import java.util.concurrent.TimeUnit;

// 
public class Main {

	public static void main(String[] args) throws InterruptedException {
		Thread task = new PrimeGenerator();
		task.start();	// 
		
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		task.interrupt();
		
		Thread.sleep(5000);
		System.out.println(task.getState());	// TERMINATED
		task.interrupt();	// 
	}

}

