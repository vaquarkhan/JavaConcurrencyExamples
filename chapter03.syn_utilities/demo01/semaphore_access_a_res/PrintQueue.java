package demo01.semaphore_access_a_res;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 
 */
public class PrintQueue {
	private final Semaphore semaphore;
	private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");

	public PrintQueue() {
//		semaphore = new Semaphore(1);
		semaphore = new Semaphore(2);
	}

	public void printJob(Object document) {
		String name = Thread.currentThread().getName();
		try {
		
			semaphore.acquire();
			
			System.out.println(name + " :: at : " + sdf.format(new Date()));

			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", name,
					duration);

			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			
			
			System.out.println(name + " :: at : " + sdf.format(new Date()) + "\r\n");
			semaphore.release();
		}
	}
}
