package chapter01.threadmanager.demo09_inheritablethreadlocalvar;

/**
	ThreadLocal
	InheritableThreadLocal
	
 */
public class Main2 {

	// InheritableThreadLocal
	private final static InheritableThreadLocal<String> holder = new InheritableThreadLocal<String>();

	public static void main(String[] args) {
		holder.set("aaa");
		System.out.println("begin=" + holder.get());					// aaa
		// 
		Thread a = new Thread() {
			@Override
			public void run() {
				System.out.println("thread-begin=" + holder.get());		// aaa
				// 
				holder.set("vvvvvvvvvvvvv");
				// 
				System.out.println("thread-end=" + holder.get());		// vvvvvvvvvvvvv
			}
		};
		a.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//
		System.out.println("end=" + holder.get());						// aaa
	}
	
	/**
	 	begin=aaa
		thread-begin=aaa
		thread-end=vvvvvvvvvvvvv
		end=aaa
	 */
}
