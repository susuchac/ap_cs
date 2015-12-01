
import java.util.ArrayList;

import javax.swing.JOptionPane;

import info.gridworld.grid.BoundedGrid;

import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class SudokuWorld extends World<Piece> {

	private SudokuGame game;
	private boolean win;

	public SudokuWorld(int rows, int cols) {

		super(new BoundedGrid<Piece>(rows, cols));

		game = new SudokuGame(getGrid());

		fillLockedPieces();

	}

	public static void main(String[] args) {

		SudokuWorld world = new SudokuWorld(9, 9);

		world.show();

	}

	public void fillLockedPieces() {

		LockedPiece p1 = new LockedPiece(9);

		Location l1 = new Location(0, 0);

		getGrid().put(l1, p1);

		LockedPiece p2 = new LockedPiece(3);

		Location l2 = new Location(0, 4);

		getGrid().put(l2, p2);

		LockedPiece p3 = new LockedPiece(3);

		Location l3 = new Location(1, 0);

		getGrid().put(l3, p3);

		LockedPiece p4 = new LockedPiece(4);

		Location l4 = new Location(1, 1);

		getGrid().put(l4, p4);

		LockedPiece p5 = new LockedPiece(7);

		Location l5 = new Location(1, 6);

		getGrid().put(l5, p5);

		LockedPiece p6 = new LockedPiece(5);

		Location l6 = new Location(1, 8);

		getGrid().put(l6, p6);

		LockedPiece p7 = new LockedPiece(2);

		Location l7 = new Location(2, 1);

		getGrid().put(l7, p7);

		LockedPiece p8 = new LockedPiece(1);

		Location l8 = new Location(2, 4);

		getGrid().put(l8, p8);

		LockedPiece p9 = new LockedPiece(6);

		Location l9 = new Location(2, 7);

		getGrid().put(l9, p9);

		
		 
		LockedPiece p10 = new LockedPiece(5);
		
		Location l10 = new Location(3, 0);
		
		getGrid().put(l10, p10);
		
		LockedPiece p11 = new LockedPiece(8);
		
		Location l11 = new Location(3, 3);
		
		getGrid().put(l11, p11);
		
		LockedPiece p12 = new LockedPiece(6);
		
		Location l12 = new Location(3, 8);
		
		getGrid().put(l12, p12);
		
		LockedPiece p13 = new LockedPiece(4);
		
		Location l13 = new Location(4, 0);
		
		getGrid().put(l13, p13);
		 
		LockedPiece p14 = new LockedPiece(9);
		
		Location l14 = new Location(4, 2);
		
		getGrid().put(l14, p14);
		
		LockedPiece p15 = new LockedPiece(7);
		
		Location l15 = new Location(4, 7);
		
		getGrid().put(l15, p15);
		
		LockedPiece p16 = new LockedPiece(1);
		
		Location l16 = new Location(5, 1);
		
		getGrid().put(l16, p16);
		
		LockedPiece p17 = new LockedPiece(3);
		
		Location l17 = new Location(5, 2);
		
		getGrid().put(l17, p17);
		
		LockedPiece p18 = new LockedPiece(5);
		
		Location l18 = new Location(5, 3);
		 
		getGrid().put(l18, p18);
		
		LockedPiece p19 = new LockedPiece(7);
		
		Location l19 = new Location(5, 4);
		
		getGrid().put(l19, p19);
		
		LockedPiece p20 = new LockedPiece(2);
		
		Location l20 = new Location(5, 6);
		
		getGrid().put(l20, p20);
		
		LockedPiece p21 = new LockedPiece(6);
		
		Location l21 = new Location(6, 1);
		
		getGrid().put(l21, p21);
		
		LockedPiece p22 = new LockedPiece(3);
		
		Location l22 = new Location(6, 5);
		
		getGrid().put(l22, p22);
		
		LockedPiece p23 = new LockedPiece(8);
		 
		Location l23 = new Location(6, 6);
		
		getGrid().put(l23, p23);
		
		LockedPiece p24 = new LockedPiece(4);
		
		Location l24 = new Location(6, 8);
		
		getGrid().put(l24, p24);
		
		LockedPiece p25 = new LockedPiece(4);
		
		Location l25 = new Location(7, 2);
		
		getGrid().put(l25, p25);
		
		LockedPiece p26 = new LockedPiece(1);
		
		Location l26 = new Location(7, 3);
		
		getGrid().put(l26, p26);
		
		LockedPiece p27 = new LockedPiece(6);
		
		Location l27 = new Location(7, 4);
		
		getGrid().put(l27, p27);
		
		LockedPiece p28 = new LockedPiece(2);
		
		Location l28 = new Location(7, 5);
		
		getGrid().put(l28, p28);
		
		LockedPiece p29 = new LockedPiece(5);
		
		Location l29 = new Location(7, 7);
		
		getGrid().put(l29, p29);
		

	}

	public boolean locationClicked(Location loc) {
		
		if (getGrid().getOccupiedLocations().size() == 81 && checkRows() && checkBoxes()) {
				JOptionPane.showMessageDialog(null, "CONGRATULATIONS! :D");
				return false;
		} else if (getGrid().get(loc) instanceof LockedPiece) {
		
		} else if(getGrid().get(loc) instanceof Piece){
			String value = JOptionPane.showInputDialog("Enter 0 to remove.");
			int input = 0;
			try{
				input = Integer.parseInt(value);
			} catch(Exception e) {
				throw new IllegalArgumentException();
			}
			if(input == 0) {
				getGrid().remove(loc);
			} else {
				JOptionPane.showMessageDialog(null, "Invalid input");
			}
			
		} else {

			String value = JOptionPane.showInputDialog("Input a number between 1 and 9");
			int input = 0;
			try{
				input = Integer.parseInt(value);
			} catch(Exception e) {
				throw new IllegalArgumentException();
			}

			if(input >= 1 && input <= 9) {

				Piece p = new Piece(input);

				getGrid().put(loc, p);

			} else {
				
				JOptionPane.showMessageDialog(null, "Invalid input");
			}

		}

		return true;

	}
	
	public boolean checkRows() {
		for(int i = 0; i < getGrid().getNumRows(); i++) {
			int total = 0;
			for(int j = 0; j < getGrid().getNumCols(); j++) {
				Location loc = new Location(i, j);
				Piece p = getGrid().get(loc);
				total += p.getNumber();
			}
			if(total != 45) {
				return false;
			}
		}
		
		return true;
	}
	public boolean checkBox(int r1, int r2, int c1, int c2) {
		ArrayList<Integer> box = new ArrayList<Integer>();
		for(int i = r1; i < r2; i++) {
			for(int j = c1; j < c2; j++) {
				Location loc = new Location(i, j);
				box.add(getGrid().get(loc).getNumber());
			}
		}
		int total = 0;
		for(int i : box) {
			total += i;
		}
		if(total != 45) {
			return false;
		}

		return true;
	}
	public boolean checkBoxes() {
		boolean sum1 = checkBox(0, 3, 0, 3);
		boolean sum2 = checkBox(0, 3, 3, 6);
		boolean sum3 = checkBox(0, 3, 6, 9);
		boolean sum4 = checkBox(3, 6, 0, 3);
		boolean sum5 = checkBox(3, 6, 3, 6);
		boolean sum6 = checkBox(3, 6, 6, 9);
		boolean sum7 = checkBox(6, 9, 0, 3);
		boolean sum8 = checkBox(6, 9, 3, 6);
		boolean sum9 = checkBox(6, 9, 6, 9);
		if(sum1 == true && sum2 == true && sum3 == true && sum4 == true && sum5 == true 
				&& sum6 == true && sum7 == true && sum8 == true && sum9 == true) {
			return true;
		}
		return false;
			
	}


}