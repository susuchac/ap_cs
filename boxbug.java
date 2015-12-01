import info.gridworld.actor.Bug;

public class BoxBug extends Bug {

	private int length;

	private int count;

	public BoxBug(int length) {

		this.length = length;

		count = 0;

	}

	public void act() {

		if (count < length && canMove()) {

			move();

			count++;

		} else {

			turn();

			turn();

			count = 0;

		}

	}

	public int getLength() {

		return length;

	}

	public int getCount() {

		return count;

	}

	public void setLength(int n) {

		length = n;

	}

	public void setCount(int n) {

		count = n;

	}

	/*
	 * 
	 * 
	 * 
	 * 1a. My BoxBug class extends the __Bug__ class.
	 * 
	 * 
	 * 
	 * 1b. My BoxBug class has __2__ new instance variables.
	 * 
	 * 
	 * 
	 * They are: ___length and numSteps___
	 * 
	 * 
	 * 
	 * 1c. My BoxBug class overrides the __act__ method
	 */

}
