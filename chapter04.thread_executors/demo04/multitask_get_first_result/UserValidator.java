package demo04.multitask_get_first_result;

import java.util.Random;
import java.util.concurrent.TimeUnit;
public class UserValidator {
	private String name;

	public UserValidator(String name) {
		this.name = name;
	}
	public boolean validate(String name, String password) {
		Random random = new Random();

		try {
			Long duration = (long) (Math.random() * 10);
			System.out.printf("Validator %s: Validating a user during %d seconds\n", this.name, duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			return false;
		}
		return random.nextBoolean();
	}
	
	public String getName() {
		return name;
	}
}
