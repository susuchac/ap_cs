import info.gridworld.actor.ActorWorld;

import info.gridworld.grid.UnboundedGrid;

public class Runner {

	public static void main(String[] args) {
		
		//ActorWorld world = new ActorWorld();
		
		ActorWorld world = new ActorWorld(new WrappedGrid(10, 10));

		//ActorWorld world = new ActorWorld(new UnboundedGrid());

		world.add(new BoxBug(4));

		//world.add(new OctoBug(3));

		//world.add(new CircleBug(3));
		
		//world.add(new SpiralBug(2));
		
		//world.add(new ZBug(3));
		
		//int[] ary = {1, 2, 3, 4};
		
		//world.add(new DancingBug(ary));
		
		//world.add(new ChameleonCritter());
		
		//world.add(new CrabCritter());

		//world.add(new TrackerCritter());
		
		world.show();

	}

}
