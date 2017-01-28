package demo08.custom_lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
public class MyAbstractQueuedSynchronizer extends AbstractQueuedSynchronizer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AtomicInteger state;
	
	public MyAbstractQueuedSynchronizer() {
		state = new AtomicInteger(0);
	}
	
	@Override
	public boolean tryAcquire(int arg) {
		return state.compareAndSet(0, 1);
	}
	
	@Override
	public boolean tryRelease(int arg) {
		return state.compareAndSet(1, 0);
	}
}

