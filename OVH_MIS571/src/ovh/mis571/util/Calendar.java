package ovh.mis571.util;

public class Calendar {
	private int month;
	private double number;

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	public Calendar(int month, double number) {
		super();
		this.month = month;
		this.number = number;
	}

}
