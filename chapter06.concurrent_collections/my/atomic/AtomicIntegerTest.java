package my.atomic;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class AtomicIntegerTest {

	@Test
	public void testAll() throws InterruptedException {
		final AtomicInteger value = new AtomicInteger(10);
	System.out.println(value.compareAndSet(1, 2));	// false
		System.out.println(value.get());				// 10
		System.out.println(value.compareAndSet(10, 3));	// true
		System.out.println(value.get());				// 3
		value.set(0);

		// incrementAndGet()£º		System.out.println(value.incrementAndGet());	// 1
	
		System.out.println(value.getAndAdd(2));			// 1
		System.out.println(value.get());				// 3
		System.out.println(value.getAndSet(5));			// 3
		System.out.println(value.get());				// 5
		

		final int threadSize = 10;
		Thread[] ts = new Thread[threadSize];
		for (int i = 0; i < threadSize; i++) {
			ts[i] = new Thread() {
				@Override
				public void run() {
					value.incrementAndGet();
				}
			};
		}
		
		for (Thread t : ts) {
			t.start();
		}
		for (Thread t : ts) {
			t.join();
		}
		
		System.out.println(value.get());	// 15
	}

}
