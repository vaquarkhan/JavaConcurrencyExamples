package chapter01.threadmanager.demo09_inheritablethreadlocalvar;

// childValue()
public class Main2_3 {

	private final static InheritableThreadLocal<String> holder = new InheritableThreadLocal<String>() {
		//
		@Override
		protected String childValue(String value) {
			return "Child created from " + value;
		};
	};

	public static void main(String[] args) {
		// 
		holder.set("Lily");
		System.out.println("main begin=" + holder.get());			// Lily		
		
		//
		Thread a = new Thread() {
			@Override
			public void run() {
				//
				System.out.println("thread-begin=" + holder.get());	// Child created from Lily
				holder.set("Lucy");
				System.out.println("thread-end=" + holder.get());	// Lucy
			}
		};
		a.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main end=" + holder.get());				// Lily			
	}
	
	/**
	 	main begin=Lily
		thread-begin=Child created from Lily
		thread-end=Lucy
		main end=Lily
	 */
}
