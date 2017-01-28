package chapter01.threadmanager.demo08_uncheckedexception;

public class Task implements Runnable {

	@Override
	public void run() {
		
		Integer.parseInt("TTT");
		
		System.out.println("=====run end=====");
	}
}
