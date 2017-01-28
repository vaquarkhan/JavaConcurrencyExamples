package demo04.cyclicbarrier_syn_tasks_common_point;

import java.util.concurrent.CyclicBarrier;

public class Main {

	public static void main(String[] args) {

		/*
		 *  10000 1000
		 */
		final int ROWS = 10000;					
		final int NUMBERS = 1000;				
		final int SEARCH = 5;					
		final int LINES_PARTICIPANT = 2000;		
		MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);

		Results results = new Results(ROWS);

		Grouper grouper = new Grouper(results);

		final int PARTICIPANTS = 5;	// 参与者数量
		CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);

		Searcher searchers[] = new Searcher[PARTICIPANTS];
		for (int i = 0; i < PARTICIPANTS; i++) {
			searchers[i] = new Searcher(i * LINES_PARTICIPANT, (i * LINES_PARTICIPANT) + LINES_PARTICIPANT, mock,
					results, 5, barrier);
			Thread thread = new Thread(searchers[i]);
			thread.start();
		}
		
		System.out.printf("Main: The main thread has finished.\n");
	}

}
