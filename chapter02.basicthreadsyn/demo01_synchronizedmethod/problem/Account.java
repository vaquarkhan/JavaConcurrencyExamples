package demo01_synchronizedmethod.problem;

// 
public class Account {

	// 
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// 
	public void addAmount(double amount) {
		double tmp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		tmp += amount;
		balance = tmp;
		
		System.out.println("::£º" + balance);
	}

	//
	public void subtractAmount(double amount) {
		double tmp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tmp -= amount;
		balance = tmp;
		
	}
}
