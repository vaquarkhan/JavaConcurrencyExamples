package demo03.threadfactory;

import java.util.Date;

public class MyThread extends Thread {

	private Date creationDate;

	private Date startDate;

	private Date finishDate;

	public MyThread(Runnable target, String name) {
		super(target, name);
		setCreationDate();
	}

	@Override
	public void run() {
		setStartDate();
		super.run();
		setFinishDate();
	}

	public void setCreationDate() {
		creationDate = new Date();
	}

	public void setStartDate() {
		startDate = new Date();
	}

	public void setFinishDate() {
		finishDate = new Date();
	}

	public long getExecutionTime() {
		return finishDate.getTime() - startDate.getTime();
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append(getName());
		buffer.append(": ");
		buffer.append(" Creation Date: ");
		buffer.append(creationDate);
		buffer.append(" : Running time: ");
		buffer.append(getExecutionTime());
		buffer.append(" Milliseconds.");
		return buffer.toString();
	}

}
