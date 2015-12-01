public class Spreadsheet {

	private Cell[][] grid;

	public Spreadsheet() {

		grid = new Cell[10][7]; // 10 by 7 grid spreadsheet

		for (int i = 0; i < grid.length; i++) {

			for (int j = 0; j < grid[0].length; j++) {

				grid[i][j] = new Cell("            "); // fill cells with 12 spaces

			}

		}

	}

	public void print() {

		System.out.println("            |     A      |     B      |     C      |     D      |     E      |     F      |     G      |");

		System.out.println("------------+------------+------------+------------+------------+------------+------------+------------+");

		for (int i = 0; i < grid.length; i++) {

			int k = i + 1; // printing row numbers

			if (k >= 10) { // if row number is double-digit number

				System.out.print("      " + k + "    |");

			} else { // if row number is single-digit number

				System.out.print("      " + k + "     |");

			}

			for (int j = 0; j < grid[0].length; j++) { // printing value in cell plus "|"

				System.out.print(grid[i][j].returnValue() + "|");

			}

			System.out.println();

			System.out.println("------------+------------+------------+------------+------------+------------+------------+------------+");

		}

	}

	public void clear(int row, int col) { // clears a single cell, set value of cell equal to 12 spaces

		grid[row][col] = new Cell("            ");

	}

	public void clear() { // clears all cells, sets value of each cell to 12 spaces

		grid = new Cell[10][7];

		for (int i = 0; i < grid.length; i++) {

			for (int j = 0; j < grid[0].length; j++) {

				grid[i][j] = new Cell("            ");

			}

		}

	}

	public void returnCellValue(int row, int col) { // returns original cell value

		System.out.println(grid[row][col]);

	}

	public void setNumValue(int row, int col, String value) { // set number cell

		grid[row][col] = new NumberCell(value);

	}

	public void setStringValue(int row, int col, String input) { // set string cell

		grid[row][col] = new StringCell(input);

	}

	public void setDateValue(int row, int col, String input) { // set date cell

		grid[row][col] = new DateCell(input);

	}

	public void setFormulaValue(int row, int col, String input) { // set formula cell
		
		grid[row][col] = new FormulaCell(input, this);

	}

	public Cell getCell(int row, int col) {

		return grid[row][col];

	}

}
