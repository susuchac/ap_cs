public class NumberCell extends Cell {

	private String value;

	private double val;

	public NumberCell(String value) {

		super(value);

		this.value = value;

		val = Double.parseDouble(value); // val is double form of value

	}

	public String returnValue() {

		return align(Double.toString(val)); // return string value of double value variable val

	}
	
	public String getVal() {
		
		return Double.toString(val);
		
	}

	public String toString() {

		return value; // return cell value

	}

}
