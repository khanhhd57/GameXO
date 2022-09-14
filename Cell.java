
public enum Cell {
	EMPTY(" "),
	CROSS("X"),
	NOUGHT("O");
	
	private final String label;
	
	private Cell(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return label;
	}
}
