package chapter01.threadmanager.demo03_interrupt;

public class PrimeGenerator extends Thread {
	
	@Override
	public void run() {
		long number = 1L;
		
		//
		while(true) {
			if(isPrime(number)) {
				System.out.printf("Number % d is Prime\n", number);
			}
			
			// 
			if(isInterrupted()) {
				//
				System.out.println("PrimeGenerator status£º" + getState());
				System.out.println("The Prime Generator has been Interrupted\n");
				//
				return;
			}
			
			number ++;
		}
	}
	
	
	//
	private boolean isPrime(long number) {
		if(number <= 2) {
			return true;
		}
		
		for(long i = 2; i < number; i++) {
			if((number % i) == 0) {
				return false;
			}
		}
		
		return true;
	}
}

