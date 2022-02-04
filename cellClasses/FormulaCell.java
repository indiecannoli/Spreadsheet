package textExcel;

import java.util.ArrayList;

public class FormulaCell extends RealCell{
	
	private String[] arr;
	private Spreadsheet sheet;
	
	public FormulaCell(String in, Spreadsheet sheet) {
		super(in);
		String arrContents = in.substring(2, in.indexOf(")"));
		this.arr = arrContents.split(" ");
		this.sheet = sheet;
	}
	
	public double getDoubleValue() {
		
		//initializing
		String pos0 = arr[0];
		
		
		//check if start of arr is SUM or AVG, split following cells
		if (pos0.equalsIgnoreCase("sum")){
			return SUM(arr[1].split("-"));
		}
		if (pos0.equalsIgnoreCase("avg")){
			return AVG(arr[1].split("-"));
		}
		
		double val = checkCell(pos0);
		for (int i = 1; i < arr.length; i += 2) {
				
				//set val for operation and the term that follows
				String op = arr[i];
				String term = arr[i+1];
				
				//standard operations
				if (op.equals("+")) {
					val += checkCell(term);
				}
				if (op.equals("-")) {
					val -= checkCell(term);
				}
				if (op.equals("*")) {
					val *= checkCell(term);
				}
				if (op.equals("/")) {
					val /= checkCell(term);
				}
				/////////////////////
		}
		return val;
	}
	 
	// evaluates total sum of cell space
	private double SUM(String[] x) {
		double sum = 0;
		SpreadsheetLocation loc1 = new SpreadsheetLocation(x[0]);
		SpreadsheetLocation loc2 = new SpreadsheetLocation(x[1]);
		for (int r = loc1.getRow(); r <= loc2.getRow(); r++) {
			for (int c = loc1.getCol(); c <= loc2.getCol(); c++) {
				sum += ((RealCell) sheet.getCell(new SpreadsheetLocation(r, c))).getDoubleValue();
			}
		}
		return sum;
	}
	
	// evaluates average of cell space
	private double AVG(String[] x) {
		int count = 0;
		SpreadsheetLocation loc1 = new SpreadsheetLocation(x[0]);
		SpreadsheetLocation loc2 = new SpreadsheetLocation(x[1]);
		count = (loc2.getRow() - loc1.getRow() + 1) * (loc2.getCol() - loc1.getCol() + 1);
		return SUM(x) / count;
	}
	
	
	//checks for cell reference, if not cell then parses value
	private double checkCell(String str) {
		str = str.toUpperCase();
		if ((str.charAt(0)>='A')&&(str.charAt(0)<='Z')){
			return ((RealCell) sheet.getCell(new SpreadsheetLocation(str))).getDoubleValue();
 		}
		return Double.parseDouble(str);
	}
	
	
	public String abbreviatedCellText() {
		return String.format("%-10.10s", getDoubleValue() + "");
	}
	
	
}
