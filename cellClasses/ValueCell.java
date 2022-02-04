package textExcel;

public class ValueCell extends RealCell{
	public ValueCell(String in) {
		super(in);
	}
	
	public double getDoubleValue() {
		double text = Double.parseDouble(fullCellText());
		return text; 
	}
	
	public String abbreviatedCellText() {
		return String.format("%-10.10s", getDoubleValue());
	}
}
