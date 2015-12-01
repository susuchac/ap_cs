public class FormulaCell extends Cell {

	private String value;

	private String val;

	private Spreadsheet grid;

	public FormulaCell(String value, Spreadsheet grid) {

		super(value);

		this.value = value;

		val = (value.substring(1, value.length() - 1)).trim(); // set val to value with the parentheses and extra whitespace cut off

		this.grid = grid;

	}

	public String returnValue() {

		String[] equation = val.split("\\s+"); // create string array split at each whitespace
		
		double result = 0;

		if (val.contains("sum") || val.contains("avg")) {

			String abc = "ABCDEFG";
			
			int col1 = 0;
	
			int row1 = 0;
	
			for (int j = 0; j < abc.length(); j++) {
				
				for (int k = 0; k < equation[1].length(); k++) {
	
					if (equation[1].charAt(k) == abc.charAt(j)) {
	
						col1 = j;
	
						row1 = Integer.parseInt(equation[1].substring(1, equation[1].length()))-1;
	
					}
	
				}
			
			}
				
			int col2 = 0;
				
			int row2 = 0;
	
			for (int j = 0; j < abc.length(); j++) {
					
				for (int k = 0; k < equation[3].length(); k++) {
						
					if (equation[3].charAt(k) == abc.charAt(j)) {
							
						col2 = j;
							
						row2 = Integer.parseInt(equation[3].substring(1, equation[3].length()))-1;
							
					}
						
				}
					
			}
			
			int r = Math.abs(row1 - row2) + 1;
			
			int c = Math.abs(col1 - col2) + 1;
			
			for(int k = 0; k < r; k++) {
				
				for(int j = 0; j < c; j++) {
						
					result += Double.parseDouble(grid.getCell(k, j).getValue());
						
				}
					
			}
				
			if(val.contains("avg")) {
				
				int cells = (row2 + 1) * (col2 + 1);
					
				result = result / cells;
				
			}
			
		} else {
			
			try {

				result = Double.parseDouble(equation[0]); // result is double parse of first value in array equation

				for (int i = 0; i < equation.length; i += 2) { // increment	 every number, skip over operators

					if (equation[i].equals("*")) { // check if multiplication

						result *= Double.parseDouble(equation[i + 1]);

					} else if (equation[i].equals("/")) { // check if division

						result /= Double.parseDouble(equation[i + 1]);

					} else if (equation[i].equals("+")) { // check if addition

						result += Double.parseDouble(equation[i + 1]);

					} else if (equation[i].equals("-")) { // check if subtraction

						result -= Double.parseDouble(equation[i + 1]);

					}

				}

			} catch (NumberFormatException e) { // double format exception

				for (int i = 0; i < equation.length; i+=2) {

					String abc = "ABCDEFG";

					int col = 0;

					int row = 0;

					for (int j = 0; j < abc.length(); j++) {

						for (int k = 0; k < equation[i].length(); k++) {

							if (equation[i].charAt(k) == abc.charAt(j)) {

								col = j;

								row = Integer.parseInt(equation[i].substring(1, equation[i].length()))-1;

							}

						}

					}

					if (i == 0) { // set result to first value in equation parsed to a double

						if (equation[i].matches("[A-G][1-10]") || equation[i].contains("A") || equation[i].contains("B") || equation[i].contains("C") || 
								equation[i].contains("D") || equation[i].contains("E") || equation[i].contains("F") || equation[i].contains("G")) {

							try { // if cell reference contains number

								result = Double.parseDouble(grid.getCell(row,col).getValue());

							} catch (NumberFormatException n) { // if cell reference contains formula

								int c = 0;

								int r = 0;

								String v = grid.getCell(row, col).getValue().substring(1,grid.getCell(row, col).getValue().length() - 1).trim();

								String[] eq = v.split("\\s+");

								for (int t = 0; t < eq.length; t += 2) {

									if (t == 0) {

										for (int j = 0; j < abc.length(); j++) {

											for (int k = 0; k < eq[t].length(); k++) {

												if (eq[t].charAt(k) == abc.charAt(j)) {

													c = j;

													r = Integer.parseInt(eq[t].substring(1, eq[t].length())) - 1;

												}

											}

										}

										result = Double.parseDouble(grid.getCell(r, c).getValue());

									} else {

										if (t < equation.length - 1) {

											while (t < equation.length - 1) {

												int h = 1;

												while (h < equation.length - 1) {

													try {

														double d = Double.parseDouble(equation[h + 1]);

														if (equation[h].equals("*")) { // check if multiplication

															result *= d;

														} else if (equation[h].equals("/")) { // check if division

															result /= d;

														} else if (equation[h].equals("+")) { // check if addition

															result += d;

														} else if (equation[h].equals("-")) { // check if subtraction

															result -= d;

														}

													} catch (NumberFormatException g) {

														if (equation[h].equals("*")) { // check if multiplication

															result *= Double.parseDouble(grid.getCell(row,col).getValue());

														} else if (equation[h].equals("/")) { // check if division

															result /= Double.parseDouble(grid.getCell(row,col).getValue());

														} else if (equation[h].equals("+")) { // check if addition

															result += Double.parseDouble(grid.getCell(row,col).getValue());

														} else if (equation[h].equals("-")) { // check if subtraction

															result -= Double.parseDouble(grid.getCell(row,col).getValue());

														}

													}

													h += 2;

												}

												t += 2;

											}

										} else {

											for (int h = 1; h < equation.length; h += 2) { // increment every number, skip over operators

												if (equation[h + 1].matches("[1-10]")) {

													if (equation[h].equals("*")) { // check if multiplication

														result *= Double.parseDouble(equation[h + 1]);

													} else if (equation[h].equals("/")) { // check if division

														result /= Double.parseDouble(equation[h + 1]);

													} else if (equation[h].equals("+")) { // check if addition

														result += Double.parseDouble(equation[h + 1]);

													} else if (equation[h].equals("-")) { // check if subtraction

														result -= Double.parseDouble(equation[h + 1]);

													}

												} else {

													if (equation[h].equals("*")) { // check if multiplication

														result *= Double.parseDouble(grid.getCell(row,col).getValue());

													} else if (equation[h].equals("/")) { // check if division

														result /= Double.parseDouble(grid.getCell(row,col).getValue());

													} else if (equation[h].equals("+")) { // check if addition

														result += Double.parseDouble(grid.getCell(row,col).getValue());

													} else if (equation[h].equals("-")) { // check if subtraction
														
														result -= Double.parseDouble(grid.getCell(row,col).getValue());

													}

												}

											}

										}

									}

								}

							}

						} else {

							result = Double.parseDouble(equation[i]);

						}
						
					} else {
						
						if(i < equation.length-1) {
							
							while(i < equation.length-1) {
							
								int h = 1;
								
								while(h < equation.length-1) {

									try {
										
										double d = Double.parseDouble(equation[h+1]);
	
										if (equation[h].equals("*")) { // check if multiplication
											
											result *= d;
		
										} else if (equation[h].equals("/")) { // check if division
	
											result /= d;
		
										} else if (equation[h].equals("+")) { // check if addition
	
											result += d;
		
										} else if (equation[h].equals("-")) { // check if subtraction
											
											result -= d;
		
										}
		
									} catch(NumberFormatException g) {
										
										try {
											
											double d = Double.parseDouble(grid.getCell(row, col).getValue());

											if (equation[h].equals("*")) { // check if multiplication
			
												result *= d;
			
											} else if (equation[h].equals("/")) { // check if division
			
												result /= d;
			
											} else if (equation[h].equals("+")) { // check if addition
			
												result += d;
			
											} else if (equation[h].equals("-")) { // check if subtraction
			
												result -= d;
			
											}
											
										} catch(NumberFormatException n) {
											
											
											
										}

										}
															
									h+=2;
	
								}

								i+=2;
								
							}
							
						} else {
	
							for (int h = 1; h < equation.length; h += 2) { // increment every number, skip over operators
	
								if (equation[h + 1].matches("[1-10]")) {
	
									if (equation[h].equals("*")) { // check if multiplication
	
										result *= Double.parseDouble(equation[h + 1]);
	
									} else if (equation[h].equals("/")) { // check if division
	
										result /= Double.parseDouble(equation[h + 1]);
	
									} else if (equation[h].equals("+")) { // check if addition
	
										result += Double.parseDouble(equation[h + 1]);
	
									} else if (equation[h].equals("-")) { // check if subtraction
	
										result -= Double.parseDouble(equation[h + 1]);
	
									}
	
								} else {
	
									if (equation[h].equals("*")) { // check if multiplication
	
										result *= Double.parseDouble(grid.getCell(row,col).getValue());
	
									} else if (equation[h].equals("/")) { // check if division
	
										result /= Double.parseDouble(grid.getCell(row,col).getValue());
	
									} else if (equation[h].equals("+")) { // check if addition
	
										result += Double.parseDouble(grid.getCell(row,col).getValue());
	
									} else if (equation[h].equals("-")) { // check if subtraction
										
										result -= Double.parseDouble(grid.getCell(row,col).getValue());
	
									}
	
								}
								
							}

						}

					}
					
				}

			}
			
		}
		
		val = Double.toString(result);

		return align(Double.toString(result)); // center val
		
	}

	public String toString() {

		return value;

	}

}
