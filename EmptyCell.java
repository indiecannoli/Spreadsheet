package textExcel;

public class EmptyCell implements Cell{
	public String abbreviatedCellText()
	{
		// text for spreadsheet cell display, must be exactly length 10
		return String.format("%10s", "");
	}
	public String fullCellText()
	{
		// text for individual cell inspection, not truncated or padded
		return ""; 
	}

}
