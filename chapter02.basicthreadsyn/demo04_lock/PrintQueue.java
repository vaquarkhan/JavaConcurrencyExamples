package demo04_lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class PrintQueue {

	private final Lock queueLock = new ReentrantLock();
//	private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");	
	private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS.sss");

	public void printJob(Object document) {
		
		queueLock.lock();
//		System.out.println("获得锁  at : " + new Date());
		
		System.out.println("获得锁  at : " + sdf.format(new Date()));

		try {
			long duration = (long) (Math.random() * 10000);
//			System.out.println((duration / 1000));
			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds, sleep at %s \n", Thread.currentThread().getName(),
					(duration / 1000), sdf.format(new Date()));
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			
			System.out.println("释放锁  at : " + sdf.format(new Date()) + "\r\n");

			queueLock.unlock();		
		}
	}
}
