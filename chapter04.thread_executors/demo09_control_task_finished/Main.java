package demo09_control_task_finished;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

		ResultTask[] resultTasks = new ResultTask[5];
		for (int i = 0; i < 5; i++) {
			ExecutableTask executableTask = new ExecutableTask("Task " + i);
			resultTasks[i] = new ResultTask(executableTask);
			executor.submit(resultTasks[i]);
		}

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		for (int i = 0; i < resultTasks.length; i++) {
			resultTasks[i].cancel(true);
		}

		
		System.out.println("\r\nPrint the results:\n");
		for (int i = 0; i < resultTasks.length; i++) {
			try {
				if (!resultTasks[i].isCancelled()) {
					System.out.printf("%s\n", resultTasks[i].get());
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		// Finish the executor.
		executor.shutdown();
	}
	
	
	/**
	 	Task 4: Waiting 5 seconds for results.
		Task 3: Waiting 0 seconds for results.
		Task 3: Has finished
		Task 2: Waiting 3 seconds for results.
		Task 0: Waiting 4 seconds for results.
		Task 1: Waiting 4 seconds for results.
		Task 2: Has finished
		Task 0: Has been cancelled
		Task 1: Has been cancelled
		Task 4: Has been cancelled
		Hello, world. I'm Task 2
		Hello, world. I'm Task 3
	 */
}
