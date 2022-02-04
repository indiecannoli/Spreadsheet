package textExcel;

public class TextCell implements Cell{
	private String text;
	
	public TextCell(String text) { //text taken from command
		this.text = text;
	}
	
	public String fullCellText() {
		return text;
	}
	
	public String abbreviatedCellText() {
		return String.format("%-10.10s", text.substring(1, text.length() - 1));  
		
	}
	

}
