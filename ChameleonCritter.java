import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class ChameleonCritter extends Critter {

	public ChameleonCritter() {

		super();
		
		setColor(Color.GREEN);

	}

	public void processActors(ArrayList<Actor> actors) {

		if (actors.size() > 0) {

			Random randomGenerator = new Random();

			int i = randomGenerator.nextInt(actors.size());

			Actor a = actors.get(i);

			setColor(a.getColor());

		}

	}

	public void makeMove(Location loc) {

		setDirection(getLocation().getDirectionToward(loc));

		super.makeMove(loc);

	}

}
