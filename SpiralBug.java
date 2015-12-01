public class SpiralBug extends BoxBug {

	public SpiralBug(int length) {

		super(length);

	}

	public void act() {

		if (getCount() < getLength() && canMove()) {

			move();

			setCount(getCount() + 1);

		} else {

			turn();
			
			turn();

			setCount(0);
			
			setLength(getLength() + 1);

		}

	}

}
