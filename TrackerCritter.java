import java.util.ArrayList;
import java.util.Random;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;


public class TrackerCritter extends Critter {
	private Location locToTrack;
	
	public TrackerCritter() {
		super();
		
	}
	
	public ArrayList<Actor> getActors() {
		ArrayList<Actor> actors = new ArrayList<Actor>();
		ArrayList<Location> locs = getGrid().getOccupiedLocations();
		for(Location loc : locs) {
			Actor a = getGrid().get(loc);
			if(a != null) {
				actors.add(a);
			}
			
		}
		return actors;
		
	}
	
	public void processActors(ArrayList<Actor> actors) {
		Random r = new Random();
		int a = r.nextInt(actors.size());
		locToTrack = actors.get(a).getLocation();

	}
	
	public ArrayList<Location> getMoveLocations() {
		ArrayList<Location> locs = new ArrayList<Location>();
		ArrayList<Location> adjLocs = getGrid().getEmptyAdjacentLocations(getLocation());
		for(Location l : adjLocs) {
			if(l.getDirectionToward(locToTrack) == getLocation().getDirectionToward(locToTrack)) {
				locs.add(l);
			}
		}
		return locs;
	}

	public Location selecttMoveLocation(ArrayList<Location> loc) {
		for(Location l : loc) {
			if(getLocation().getDirectionToward(locToTrack) == l.getDirectionToward(locToTrack)) {
				return l;
			}
		}
		return getLocation();
	}

	public void makeMove(Location loc) {
		
		setDirection(getLocation().getDirectionToward(locToTrack));

		moveTo(locToTrack);
		
	}

}
