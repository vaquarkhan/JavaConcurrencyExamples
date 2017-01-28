package chapter01.threadmanager.demo09_inheritablethreadlocalvar;

public class InheritableThreadLocalTest {
	private static InheritableThreadLocal<StringBuffer> ITL = new InheritableThreadLocal<StringBuffer>() {
		@Override
		protected StringBuffer initialValue() {
			return new StringBuffer("hello");
		}
	};

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " : " + ITL.get());					// hello
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " : " + ITL.get());			// hello
				new Thread(new Runnable() {
					@Override
					public void run() {
						System.out.println(Thread.currentThread().getName() + " : " + ITL.get());	// hello
						((StringBuffer) ITL.get()).append(", wqf");
//						ITL.set(ITL.get().append(", wqf"));
						System.out.println(Thread.currentThread().getName() + " : " + ITL.get());	// hello, wqf
					}
				}, "inner-inner").start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " : " + ITL.get());			// hello, wqf
			}
		}, "inner").start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " : " + ITL.get());					// hello, wqf
	}
}
