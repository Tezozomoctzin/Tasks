package strings1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import by.gsu.epamlab.Constants;

public class Runner {

	public static void main(String[] args) {
		File file = new File("src/in.csv");
		Scanner input = null;
		String line;
		String[] splitLine;
		int lineElement;
		int errorLines = 0;
		double summ = 0;
		double determinedElement;
		boolean firstElementNegative = false;
		StringBuilder output = new StringBuilder();
		StringBuilder errorsLine = new StringBuilder();
		try {
			input = new Scanner(file);
			while(input.hasNext()){
				line = input.nextLine();
				if(line.length() != 0){
					splitLine = line.split(";");
					try{
						lineElement = (int) Math.floor(Double.parseDouble(splitLine[0]));
						if(lineElement >= 0){
							try{
								determinedElement = Double.parseDouble(splitLine[lineElement]);	
								summ += determinedElement;
								if( output.length() > 0)
								{
									if(determinedElement >=0){
										output.append(Constants.PLUS);
									}else{
										output.append(Constants.MINUS);
									}
								}else{
									if(!(determinedElement >= 0)){
										firstElementNegative = true;
									}
								}
								output.append(Math.abs(determinedElement));
							}catch (RuntimeException e){
								errorLines++;
							}
						}else{
							errorLines++;
						}
					}catch (IllegalArgumentException e){
						errorLines++;
					}								
				}else{
					errorLines++;
				}
			}
			if(firstElementNegative){
				output.insert(0, "-");
			}
			output.insert(0, "result(");
			output.append(")");
			output.append(Constants.EQUALS);
			output.append(String.format("%.2f", summ));
			errorsLine.ensureCapacity(output.capacity());
			errorsLine.append(Constants.EQUALS);
			errorsLine.insert(0, "error-lines");
			errorsLine.append(String.format("%d",errorLines));
			System.out.println(output.toString());
			System.out.println(errorsLine.toString());
		} catch (FileNotFoundException e) {
			System.out.println("File not found\n");
			e.printStackTrace();
		}finally{
			if(input != null){
				input.close();
			}
		}
	}

}
