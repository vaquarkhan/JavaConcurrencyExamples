package demo07_multiconditions_lock;

public class Producer implements Runnable {
	private FileMock mock;

	private Buffer buffer;

	public Producer(FileMock mock, Buffer buffer) {
		this.mock = mock;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		buffer.setPendingLines(true);
		// 
		while (mock.hasMoreLines()) {
			String line = mock.getLine();
			buffer.insert(line);	// 
		}
		
		//
		buffer.setPendingLines(false);
	}

}
