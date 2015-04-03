package strings1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.xml.transform.ErrorListener;

import by.gsu.epamlab.Constants;

public class Runner {
	private int errorLines;
	private double summ = 0;
	private StringBuilder output = new StringBuilder();
	private StringBuilder errorsLine = new StringBuilder();
	private boolean isFirstElementNegative = false;

	public static void main(String[] args) {
		Runner run = new Runner();
		File file = new File("src/in.csv");
		Scanner input = null;
		String line;
		String[] splitLine;
		int lineElement;
		try {
			input = new Scanner(file);
			while (input.hasNext()) {
				line = input.nextLine();
				if (line.length() != 0) {
					splitLine = line.split(";");
					lineElement = (int) Math.floor(run
							.parsingTry(((splitLine[0]))));
					run.lineElementHandling(lineElement, splitLine);
				} else {
					run.errorLines++;
				}
			}
			run.appendLines(run.isFirstElementNegative);
			System.out.println(run.output.toString());
			System.out.println(run.errorsLine.toString());
		} catch (FileNotFoundException e) {
			System.out.println("File not found\n");
			e.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}

	public double parsingTry(String str) {
		if (isNumber(str)) {
			return Double.parseDouble(str);
		} else {
			return -1;
		}
	}

	public boolean isNumber(String verify) {
		try {
			Double.parseDouble(verify);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public void lineElementHandling(int lineElement, String[] line) {
		if (lineElement >= 0) {
			try {
				double determinedElement = Double
						.parseDouble(line[lineElement]);
				summ += determinedElement;
				if (output.length() > 0) {
					if (determinedElement >= 0) {
						output.append(Constants.PLUS);
					} else {
						output.append(Constants.MINUS);
					}
				} else {
					if (!(determinedElement >= 0)) {
						isFirstElementNegative = true;
					}
				}
				output.append(Math.abs(determinedElement));
			} catch (RuntimeException e) {
				errorLines++;
			}
		} else {
			errorLines++;
		}
	}

	public void appendLines(boolean flag) {
		if (flag) {
			output.insert(0, "-");
		}
		output.insert(0, "result(");
		output.append(")");
		output.append(Constants.EQUALS);
		output.append(String.format("%.2f", summ));
		errorsLine.ensureCapacity(output.capacity());
		errorsLine.append(Constants.EQUALS);
		errorsLine.insert(0, "error-lines");
		errorsLine.append(String.format("%d", errorLines));
	}

}
