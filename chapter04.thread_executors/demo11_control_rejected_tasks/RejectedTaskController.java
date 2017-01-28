package demo11_control_rejected_tasks;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedTaskController implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.err.printf("RejectedTaskController: The task %s has been rejected\n", r.toString());
		System.err.printf("RejectedTaskController: %s\n", executor.toString());
		System.err.printf("RejectedTaskController: Terminating: %s\n", executor.isTerminating());
		System.err.printf("RejectedTaksController: Terminated: %s\n", executor.isTerminated());
	}

}
