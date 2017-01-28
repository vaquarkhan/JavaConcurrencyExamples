package demo03.countdownlatch_wait_multi_events;

import java.util.concurrent.CountDownLatch;


public class Videoconference implements Runnable {

	private final CountDownLatch controller;

	/**
	 * @param number
	 */
	public Videoconference(int number) {
		controller = new CountDownLatch(number);
	}

	public void arrive(String name) {
		System.out.printf("%s has arrived.\n", name);
		//
		controller.countDown();
		System.out.printf("VideoConference: Waiting for %d participants.\n", controller.getCount());
	}

	@Override
	public void run() {
		System.out.printf("VideoConference: Initialization: %d participants.\n\n", controller.getCount());

		try {
			// CountDownLatch
			controller.await();

			// 
			System.out.printf("\r\nVideoConference: All the participants have come\n");
			System.out.printf("VideoConference: Let's start...\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
