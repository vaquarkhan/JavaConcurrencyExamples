package demo02.semaphore_access_multi_res;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	/**
	 * 
	 */
	private Semaphore semaphore;

	/**
	 *
	 */
	private boolean freePrinters[];

	/**
	 * freePrinters
	 */
	private Lock lockPrinters;

	private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");

	public PrintQueue() {
		semaphore = new Semaphore(3);
		freePrinters = new boolean[3];
		for (int i = 0; i < 3; i++) {
			freePrinters[i] = true;
		}
		lockPrinters = new ReentrantLock();
	}

	public void printJob(Object document) {
		String name = Thread.currentThread().getName();
		try {
			// 
			semaphore.acquire();

			System.out.println(name + "  at : " + sdf.format(new Date()));

			// 取得空闲打印者的数目
			int assignedPrinter = getPrinter();

			Long duration = (long) (Math.random() * 10);
			System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n", name,
					assignedPrinter, duration);
			TimeUnit.SECONDS.sleep(duration);

			//
			freePrinters[assignedPrinter] = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(name + " 释放信号量  at : " + sdf.format(new Date()) + "\r\n");

			semaphore.release();
		}
	}

	private int getPrinter() {
		int ret = -1;

		try {
			// 获取锁
			lockPrinters.lock();

			for (int i = 0; i < freePrinters.length; i++) {
				if (freePrinters[i]) {
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lockPrinters.unlock();
		}

		return ret;
	}
}
