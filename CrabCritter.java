import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class CrabCritter extends Critter {

	public CrabCritter() {

		super();
		
		setColor(Color.RED);

	}

	public ArrayList<Actor> getActors() {
		
        ArrayList<Actor> actors = new ArrayList<Actor>();
        
        int[] posDirs = {Location.HALF_LEFT, Location.AHEAD, Location.HALF_RIGHT};
        
        for (Location loc : getLocs(posDirs)) {
        	
            Actor a = getGrid().get(loc);
            
            if (a != null)
            	
                actors.add(a);
            
        }

        return actors;

	}

	public ArrayList<Location> getMoveLocations() {
		
        ArrayList<Location> locs = new ArrayList<Location>();
        
        int[] posDirs = {Location.LEFT, Location.RIGHT};
        
        for (Location loc : getLocs(posDirs))
        	
            if (getGrid().get(loc) == null)
            	
                locs.add(loc);

        return locs;
        
	}
	
	public ArrayList<Location> getLocs(int[] directions) {
		
        ArrayList<Location> locs = new ArrayList<Location>();

        Location loc = getLocation();
    
        for (int dir : directions) {
        	
            Location nextLoc = loc.getAdjacentLocation(getDirection() + dir);
            
            if (getGrid().isValid(nextLoc))
            	
                locs.add(nextLoc);
            
        }
        
        return locs;
		
	}

	public void makeMove(Location loc) {
		
		if (loc.equals(getLocation())) {
			
	        double a = Math.random();
	        
	        int i;
	        
	        if (a < 0.5) {
	        	
	            i = Location.LEFT;
	            
			} else {
				
	            i = Location.RIGHT;
	            
	        }
	        
	        setDirection(getDirection() + i);
	            
	    } else {
	    	
	        super.makeMove(loc);
	        
	    }
		
	}

}
