import info.gridworld.actor.Bug;

public class DancingBug extends Bug {
	
	private int[] ary;
	
	private int count;

	public DancingBug(int[] ary) {
		
		this.ary = ary;
		
		count = 0;
		
	}
	
	public void act() {
		
		if(count == ary.length ) {
			
			count = 0;
			
		}
		
		for(int i = 0; i <= ary[count]; i++) {
			
			turn();
			
		}
		
		count++;
		
		super.act();
		
	}
	
}
