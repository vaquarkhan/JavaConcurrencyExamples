package demo10_separate_tasks;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

//CompletionService
public class ReportProcessor implements Runnable {
	private CompletionService<String> service;

	private boolean end;

	public ReportProcessor(CompletionService<String> service) {
		this.service = service;
		end = false;
	}

	@Override
	public void run() {
		while (!end) {
			try {
				Future<String> result = service.poll(20, TimeUnit.SECONDS);
				if (result != null) {
					String report = result.get();
					System.out.printf("ReportReceiver: Report Recived: %s\n", report);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("ReportSender: End\n");
	}

	public void setEnd(boolean end) {
		this.end = end;
	}
}
