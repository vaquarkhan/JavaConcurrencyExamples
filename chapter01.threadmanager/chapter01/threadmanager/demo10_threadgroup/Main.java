package chapter01.threadmanager.demo10_threadgroup;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// ThreadGroup
		ThreadGroup threadGroup = new ThreadGroup("Searcher");
		Result result = new Result();

		// SearchTask
		SearchTask searchTask = new SearchTask(result);
		for (int i = 0; i < 5; i++) {
			//
			Thread thread = new Thread(threadGroup, searchTask);
			thread.start();

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
		System.out.printf("Information about the Thread Group\n");
		// list()
		threadGroup.list();

		//
		Thread[] threads = new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads); //
		for (int i = 0; i < threadGroup.activeCount(); i++) {
			System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
		}

		//
		waitFinish(threadGroup);

		// 
		threadGroup.interrupt();
	}

	private static void waitFinish(ThreadGroup threadGroup) {
		//
		while (threadGroup.activeCount() > 4) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 	Thread Thread-0: Start
		Thread Thread-0: 92
		Thread Thread-1: Start
		Thread Thread-1: 83
		Thread Thread-2: Start
		Thread Thread-2: 64
		Thread Thread-3: Start
		Thread Thread-3: 53
		Thread Thread-4: Start
		Thread Thread-4: 81
		Number of Threads: 5
		Information about the Thread Group
		java.lang.ThreadGroup[name=Searcher,maxpri=10]
		    Thread[Thread-0,5,Searcher]
		    Thread[Thread-1,5,Searcher]
		    Thread[Thread-2,5,Searcher]
		    Thread[Thread-3,5,Searcher]
		    Thread[Thread-4,5,Searcher]
		Thread Thread-0: TIMED_WAITING
		Thread Thread-1: TIMED_WAITING
		Thread Thread-2: TIMED_WAITING
		Thread Thread-3: TIMED_WAITING
		Thread Thread-4: TIMED_WAITING
		Thread Thread-3: End
		Thread Thread-0: Interrupted
		Thread Thread-4: Interrupted
		Thread Thread-2: Interrupted
		Thread Thread-1: Interrupted
		
		
		
		Thread Thread-0: Start
		Thread Thread-0: 76
		Thread Thread-1: Start
		Thread Thread-1: 74
		Thread Thread-2: Start
		Thread Thread-2: 2
		Thread Thread-3: Start
		Thread Thread-3: 93
		Thread Thread-2: End
		Thread Thread-4: Start
		Thread Thread-4: 74
		Number of Threads: 4
		Information about the Thread Group
		java.lang.ThreadGroup[name=Searcher,maxpri=10]
		    Thread[Thread-0,5,Searcher]
		    Thread[Thread-1,5,Searcher]
		    Thread[Thread-3,5,Searcher]
		    Thread[Thread-4,5,Searcher]
		Thread Thread-0: TIMED_WAITING
		Thread Thread-1: TIMED_WAITING
		Thread Thread-3: TIMED_WAITING
		Thread Thread-4: TIMED_WAITING
		Thread Thread-1: Interrupted
		Thread Thread-0: Interrupted
		Thread Thread-3: Interrupted
		Thread Thread-4: Interrupted
	 */
}
