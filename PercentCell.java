package textExcel;

public class PercentCell extends RealCell{
	
	private double doubleVal;
	
	public PercentCell(String in) {
		super(in);
		String text = in.substring(0, in.length() - 1);
		double ret = Double.parseDouble(text);
		this.doubleVal = ret/100.0;
	}
	
	public double getDoubleValue() {
		return doubleVal; 
	}
	
	public String abbreviatedCellText() {
		String val = (doubleVal * 100.0) + "";
		val = val.substring(0, val.indexOf(".")) + "%";
		return String.format("%-10s", val);
	} 
	
	public  String fullCellText() {
		return doubleVal + "";
	}	

}
