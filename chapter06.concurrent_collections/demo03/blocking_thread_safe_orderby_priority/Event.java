package demo03.blocking_thread_safe_orderby_priority;

/**
 * Comparable
 */
public class Event implements Comparable<Event> {
	private int thread;

	private int priority;

	public Event(int thread, int priority) {
		this.thread = thread;
		this.priority = priority;
	}

	@Override
	public int compareTo(Event e) {
		if (this.priority > e.getPriority()) {
			return -1;
		} else if (this.priority < e.getPriority()) {
			return 1;
		} else {
			return 0;
		}
	}

	public int getThread() {
		return thread;
	}

	public int getPriority() {
		return priority;
	}

}
