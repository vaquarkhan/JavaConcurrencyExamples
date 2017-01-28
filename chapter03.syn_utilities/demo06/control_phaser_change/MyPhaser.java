package demo06.control_phaser_change;

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser {

	@Override
	protected boolean onAdvance(int phase, int registeredParties) {
		switch (phase) {
			case 0 :
				return studentsArrived();
			case 1:
				return finishFirstExercise();
			case 2:
				return finishSecondExercise();
			case 3:
				return finishExam();
			default:
				return true;
		}
		
//		return super.onAdvance(phase, registeredParties);
	}

	private boolean studentsArrived() {
		System.out.printf("Phaser: The exam are going to start. The students are ready.\n");
		System.out.printf("Phaser: We have %d students.\n",getRegisteredParties());
		return false;
	}
	
	private boolean finishFirstExercise() {
		System.out.printf("Phaser: All the students has finished the first exercise.\n");
		System.out.printf("Phaser: It's turn for the second one.\n");
		return false;
	}
	
	private boolean finishSecondExercise() {
		System.out.printf("Phaser: All the students has finished the second exercise.\n");
		System.out.printf("Phaser: It's turn for the third one.\n");
		return false;
	}
	
	private boolean finishExam() {
		System.out.printf("Phaser: All the students has finished the exam.\n");
		System.out.printf("Phaser: Thank you for your time.\n");
		return true;
	}
}

