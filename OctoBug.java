import info.gridworld.actor.Bug;

public class OctoBug extends Bug {
	
	private int length;
	
	private int count;

	public OctoBug(int length) {
		
		this.length = length;
		
		count = 0;
		
	}

	public void act() {
		
		if (count < length && canMove()) {
			
			move();
			
			count++;
			
		} else {
			
			turn();
			
			count = 0;
			
		}

	}
	
}
