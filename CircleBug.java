public class CircleBug extends BoxBug {

	public CircleBug(int length) {

		super(length);

	}

	public void act() {

		if (getCount() < getLength() && canMove()) {

			move();

			setCount(getCount() + 1);

		} else {

			turn();

			setCount(0);

		}

	}

}
