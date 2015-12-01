import info.gridworld.grid.Location;

public class ZBug extends BoxBug {
	
	private int lineNum;
	
	public ZBug(int length) {
		
		super(length);
		
		setDirection(90);
		
		lineNum = 1;
		
	}
	
	public void act() {
		
		if(lineNum <= 3 && getCount() < getLength()) {
			
			if(canMove()) {
			
				move();
				
				setCount(getCount() + 1);
				
			}
			
		} else if(lineNum == 2) {
			
			setDirection(90);
			
			setCount(0);
			
			lineNum++;
			
		} else if(lineNum == 1) {
			
			setDirection(225);
			
			setCount(0);
			
			lineNum++;
			
		}

	}

}
