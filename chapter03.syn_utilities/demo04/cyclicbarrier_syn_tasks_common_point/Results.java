package demo04.cyclicbarrier_syn_tasks_common_point;

public class Results {

	rivate int data[];

	public Results(int size) {
		data = new int[size];
	}

	public void setData(int position, int value) {
		data[position] = value;
	}

	public int[] getData() {
		return data;
	}
}
