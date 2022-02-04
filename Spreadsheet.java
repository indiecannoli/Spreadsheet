package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] sheet;

	//spreadsheet constructor
	public Spreadsheet() {
		sheet = new Cell[20][12];
		for (int r = 0; r < sheet.length; r++){
			for (int c = 0; c < sheet[r].length; c++) {
				sheet[r][c] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		//initialize output grid
		String output = "";
				
		//create array
		String[] commandArr = command.split(" ", 3);
		
		if (command.equals("")) {
			return "";
		}
		
		//input assignment to location
		if (commandArr.length == 3) {
			SpreadsheetLocation loc = new SpreadsheetLocation(commandArr[0]);
			int row = loc.getRow();
			int col = loc.getCol();
			String letter1 = commandArr[2].substring(0,1);
			
			//checks for string value with ""
			if (letter1.equals("\"")) {
				sheet[row][col] = new TextCell(commandArr[2]);
				output = getGridText();
			
			//checks for % sign
			} else if (commandArr[2].substring(commandArr[2].length() - 1, commandArr[2].length()).equals("%")){
				sheet[row][col] = new PercentCell(commandArr[2]);
				output = getGridText();
			
			//checks for formula input starting with (
			} else if (letter1.equals("(")) {
				sheet[row][col] = new FormulaCell(commandArr[2], this);//check if -this- is correct
				output = getGridText();
				
			//if not anything else, then value cell
			} else {
				sheet[row][col] = new ValueCell(commandArr[2]);
				output = getGridText();
			}
		}
		
		//clear cell
		if (commandArr.length == 2) {
			SpreadsheetLocation loc = new SpreadsheetLocation(commandArr[1]);
			sheet[loc.getRow()][loc.getCol()] = new EmptyCell();
			output = getGridText();
			
		}
		
		//clear grid
		if (commandArr.length == 1) {
			if (commandArr[0].toLowerCase().equals("clear")) {
				for (int r = 0; r < sheet.length; r++){
					for (int c = 0; c < sheet[r].length; c++) {
						sheet[r][c] = new EmptyCell();
					}
				}
				output = getGridText();
			} else { 
				//cell inspection for specific location
				SpreadsheetLocation loc = new SpreadsheetLocation(commandArr[0]);
				output = getCell(loc).fullCellText();
			}
		}
		
		return output;
		
		//String printMe = getGridText();
		//return printMe;
	}
	

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return sheet.length;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		if (sheet.length <= 0) {
			return 0;
		}
		return sheet[0].length;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		//header with chars
		String output = "   ";
		for (int h = 0; h < sheet[0].length; h++)
		{
			output += String.format("|%-10c", (char)(h + 65));
		}
		output += "|";
		
		//rest of rows and columns
		for (int r = 0; r < sheet.length; r++) {
			output += "\n";
			output += String.format("%-3s", r + 1);
			for (int c = 0; c < sheet[r].length; c++) {
				output += "|" + sheet[r][c].abbreviatedCellText();
			}
			output += "|";
		}
		output += "\n";
		return output;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

