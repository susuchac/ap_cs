public class DateCell extends Cell {

	private String value;

	private String val;

	public DateCell(String value) {

		super(value);

		this.value = value;

		val = value;
		
		if (val.substring(0, val.indexOf("/")).length() < 2) { // check if num digits in month is less than 2

			val = 0 + val; // add a 0 to the beginning of months

			if (val.substring(val.indexOf("/") + 1, val.lastIndexOf("/")).length() < 2) { // check if num digits in days is less than 2

				val = val.substring(0, val.indexOf("/") + 1) + 0 + val.substring(val.indexOf("/") + 1); // add a 0 to beginning of month and a 0 to beginning of days

			}

		}

	}
	
	public String returnValue() {

		return align(val); // return centered val

	}
	
	public String getVal() {
		
		return val;
		
	}

	public String toString() {

		return value;

	}

}
