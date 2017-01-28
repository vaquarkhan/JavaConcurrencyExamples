package chapter01.threadmanager.demo11_threadgroupexception;

public class Main {

	public static void main(String[] args) {
		// 
		MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
		Task task = new Task();
		// 
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(threadGroup, task);
			t.start();
		}
	}
}
