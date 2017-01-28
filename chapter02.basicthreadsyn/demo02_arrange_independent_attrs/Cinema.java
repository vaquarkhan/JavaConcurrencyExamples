package demo02_arrange_independent_attrs;

// 
public class Cinema {
	// 
	private long vacanciesCinema1;
	private long vacanciesCinema2;

	/**
	 * controlCinema1 vacanciesCinema1
	 * controlCinema2 vacanciesCinema2
	 */
	private final Object controlCinema1, controlCinema2;

	public Cinema() {
		controlCinema1 = new Object();
		controlCinema2 = new Object();

		vacanciesCinema1 = 20;
		vacanciesCinema2 = 20;
	}

	/**
	 * Cinema1
	 */
	public boolean sellTickets1(int number) {
		synchronized (controlCinema1) {
			if (number < vacanciesCinema1) {
				vacanciesCinema1 -= number;
				return true;
			}

			return false;
		}
	}

	/**
	 * Cinema2
	 */
	public boolean sellTickets2(int number) {
		synchronized (controlCinema2) {
			if (number < vacanciesCinema2) {
				vacanciesCinema2 -= number;
				return true;
			}

			return false;
		}
	}

	/**
	 * Cinema1
	 */
	public boolean returnTickets1(int number) {
		synchronized (controlCinema1) {
			vacanciesCinema1 += number;
			return true;
		}
	}

	/**
	 * Cinema2
	 */
	public boolean returnTickets2(int number) {
		synchronized (controlCinema2) {
			vacanciesCinema2 += number;
			return true;
		}
	}

	public long getVacanciesCinema1() {
		return vacanciesCinema1;
	}

	public long getVacanciesCinema2() {
		return vacanciesCinema2;
	}

}
