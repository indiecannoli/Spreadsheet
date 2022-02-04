package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
    private int col;
    private int row;
    
	public SpreadsheetLocation(String cellName) 
    {
        // TODO: Fill this out with your own code
    	cellName = cellName.toUpperCase();
    	this.col = cellName.charAt(0) - 65;
    	this.row = Integer.parseInt(cellName.substring(1)) - 1;
    }
	
	public SpreadsheetLocation(int r, int c) {
		this.row = r;
		this.col = c;
	}
    
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return this.row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return this.col;
    }
    
   
    
    

}
