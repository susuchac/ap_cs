
import java.util.*;

public class VisiCalc {

	public static void main(String[] args) {

		Spreadsheet grid = new Spreadsheet();

		Scanner console = new Scanner(System.in);

		while (true) {

			System.out.print("Enter a command: ");

			String command = console.nextLine();

			if (command.equals("quit")) { // goodbye if quit

				System.out.print("Cheerio!");

				break;

			} else if (command.equals("print")) { // print if command is equal to print

				grid.print();

			} else {

				String abc = "ABCDEFG";

				if (command.contains("clear")) { // check if command contains clear

					if (command.length() > "clear".length()) { // clear one cell only

						int col = 0;

						int row = 0;

						for (int i = 0; i < abc.length(); i++) {

							if (command.charAt(6) == abc.charAt(i)) { // 6 is the index after "clear "

								col = i;

								row = 0;

								try {

									row = Integer.parseInt(command.substring(7)) - 1;

								} catch (Exception e) {

									row = Integer.parseInt(command.substring(1, command.indexOf("=") - 1)) - 1;

								}

							}

						}

						grid.clear(row, col);

					} else { // clear the whole spreadsheet

						grid.clear();

					}

				}

				String input = command.substring(command.indexOf("=") + 2, command.length());

				String name = "";

				if (command.length() == 2) { // single-digit row number

					name = command.substring(0, 2);

				} else if (command.length() == 3) { // double-digit row number

					name = command.substring(0, 3);

				}

				for (int i = 0; i < abc.length(); i++) {

					if (command.charAt(0) == abc.charAt(i)) {

						int col = i;

						int row = 0;

						try { // check if command contains "="

							row = Integer.parseInt(command.substring(1, command.indexOf("=") - 1)) - 1;

						} catch (Exception e) { // command is calling for value in cell

							row = Integer.parseInt(command.substring(1)) - 1;

						}

						if (command.length() == 2 || command.length() == 3) { // return value of cell

							System.out.print(name + " = ");

							grid.returnCellValue(row, col);

						} else { // set value of cell

							try { // try setting number cell

								grid.setNumValue(row, col, input);

							} catch (Exception e) {

								if (input.contains("/")) { // check if command contains "/"

									if (input.contains("(")	&& input.contains(")")) { // check if command is formula

										grid.setFormulaValue(row, col, input);

									} else { // else command is date

										grid.setDateValue(row, col, input);

									}

								} else if (input.contains("(") && input.contains(")")) { // check if command is formula

									grid.setFormulaValue(row, col, input);

								} else { // else command is string

									grid.setStringValue(row, col, input);

								}

							}

						}

					}

				}

			}

		}

	}

}
