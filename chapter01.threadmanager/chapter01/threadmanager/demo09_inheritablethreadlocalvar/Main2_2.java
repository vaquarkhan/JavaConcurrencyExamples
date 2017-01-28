package chapter01.threadmanager.demo09_inheritablethreadlocalvar;

/**
	
 */
public class Main2_2 {

	// InheritableThreadLocal
	private static InheritableThreadLocal<StringBuffer> holder = new InheritableThreadLocal<StringBuffer>() {
		@Override
		protected StringBuffer initialValue() {
			return new StringBuffer("aaa");
		};
	};

	public static void main(String[] args) {
		System.out.println("begin=" + holder.get());					// aaa
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("thread1-begin=" + holder.get());
				
//				holder.set(new StringBuffer("vvvvvvvvvvvvv"));	// 
				holder.set(holder.get().append(", hello"));		// 
				
				System.out.println("thread1-end=" + holder.get());	
			}
		}).start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 
		System.out.println("end=" + holder.get());						// aaa
	}
	
	/**
	    holder.set(new StringBuffer("vvvvvvvvvvvvv"));
	 	begin=aaa
		thread-begin=aaa
		thread-end=vvvvvvvvvvvvv
		end=aaa
		
		holder.set(holder.get().append(", hello"));	的运行结果：
		begin=aaa
		thread1-begin=aaa
		thread1-end=aaa, hello
		end=aaa, hello
		
		
	 */
}
