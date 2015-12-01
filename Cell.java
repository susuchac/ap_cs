public class Cell {

	private String value;
	
	private String val;

	public Cell(String value) {

		this.value = value;
		
		val = value;

	}

	public String toString() {

		return "<empty>"; // returns value of empty cell

	}

	public String returnValue() {

		return value;

	}
	
	public String getValue() {
		
		return value;
		
	}
	
	public String getVal() {
		
		return val;
		
	}

	public String align(String val) { // aligns cell value in the center of cell

		int cellLength = 12;

		int numSpaces = 0;

		if (val == " ") {

			return val;

		} else if (val.length() > 12) {

			return val.substring(0, 11) + ">";

		} else {

			if (val.length() < cellLength) {

				String spaces = "";

				numSpaces = (cellLength - val.length()) / 2;

				for (int i = 0; i < numSpaces; i++) {

					spaces += " ";

				}

				if ((cellLength - val.length()) % 2 == 0) {

					return spaces + val + spaces;

				} else {

					return spaces + val + spaces + " ";

				}

			}

		}

		return val;

	}

	public String stringForPrinting() {

		return " ";

	}

}
