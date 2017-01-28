package my.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest02 {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final Semaphore sp = new Semaphore(3);
		for (int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						sp.acquire();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
					System.out.println("Test" + Thread.currentThread().getName() + ":"
							+ (3 - sp.availablePermits()) + "tEST");
					
					try {
						Thread.sleep((long) (Math.random() * 10000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("test" + Thread.currentThread().getName() + ":");
					sp.release();
					System.out.println("tEST" + Thread.currentThread().getName() + ":"
							+ (3 - sp.availablePermits()) + "	aa");
				}
			};
			service.execute(runnable);
		}
	}
}
