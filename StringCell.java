public class StringCell extends Cell {

	private String value;

	private String val;

	public StringCell(String value) {

		super(value);

		this.value = value;

		val = value.substring(1, value.length() - 1); // cuts off quotations at beginning and end of string


	}

	public String returnValue() {

		return align(val);

	}
	
	public String getVal() {
		
		return val;
		
	}

	public String toString() {

		return value; // returns cell value

	}

}