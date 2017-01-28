package demo01_synchronizedmethod.solution;

public class Main {

	public static void main(String[] args) {
		Account account = new Account();
		// 
		account.setBalance(1000);

		// Company
		Company company = new Company(account);
		Thread companyThread = new Thread(company);

		// Bank
		Bank bank = new Bank(account);
		Thread bankThread = new Thread(bank);

		System.out.printf("Account : Initial Balance: %f\n", account.getBalance());

		companyThread.start();
		bankThread.start();

		try {
			companyThread.join();
			bankThread.join();
			System.out.printf("Account : Final Balance: %f\n", account.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 	Account : Initial Balance: 1000.000000
		Account : Final Balance: 1000.000000
	 */
}
