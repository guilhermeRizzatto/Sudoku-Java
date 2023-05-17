package model;

public class BoardItem {
	
	private Integer number;
	private boolean fix;
	
	public BoardItem(Integer number, boolean fix) {
		super();
		this.number = number;
		this.fix = fix;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public boolean isFix() {
		return fix;
	}
	
	public void setFix(boolean fix) {
		this.fix = fix;
	}
	
	
}
