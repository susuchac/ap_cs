import java.util.ArrayList;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;


public class WrappedGrid<E> extends BoundedGrid<E> {
	private int rows;
	private int cols;
	public WrappedGrid(int rows, int cols) {
		super(rows, cols);
		this.rows = rows;
		this.cols = cols;
	}
	public Location outToIn(Location loc) {

		int r = loc.getRow();
		int c = loc.getCol();
		int fixRow = 0;
		int fixCol = 0;
		if(r < 0) {
			fixRow = r + rows;
		} else if(r >= rows) {
			fixRow = r % rows;
		} else {
			fixRow = r;
		}
		if(c < 0) {
			fixCol = c + cols;
		} else if(c >= cols) {
			fixCol = c % cols;
		} else {
			fixCol = c;
		}
		Location inLoc = new Location(fixRow, fixCol); 
        return inLoc;
	}
    public ArrayList<Location> getValidAdjacentLocations(Location loc) {
        ArrayList<Location> locs = new ArrayList<Location>();
        int d = Location.NORTH;
        Location valLoc = new Location(0,0);
        for (int i = 0; i < Location.FULL_CIRCLE / Location.HALF_RIGHT; i++) {
            Location neighborLoc = loc.getAdjacentLocation(d);
            //if (isValid(neighborLoc) == false){
            	valLoc = outToIn(neighborLoc);
            //}
            locs.add(valLoc);
            d = d + Location.HALF_RIGHT;
        }
        return locs;
    }

}
