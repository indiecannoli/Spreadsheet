package textExcel;

public class RealCell implements Cell{
	
	private String in;
	
	public RealCell(String in) {
		this.in = in; 
	}
	
	public String abbreviatedCellText() {
		return String.format("%-10.10s", in);
	}
	public  String fullCellText() {
		return in;
	}	
	
	public double getDoubleValue() {
		return 0.0;
	}

}
