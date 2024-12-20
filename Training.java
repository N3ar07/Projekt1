package projekt3.copy;

public abstract class Training {

	private int day;
	private int month;
	private int year;
	private String description;

	public Training(int day, int month, int year, String description) {
		if (isValidDate(day, month, year)) {
			this.day = day;
			this.month = month;
			this.year = year;
		} else {
			throw new IllegalArgumentException("Ungültiges Datum!");
		}
		this.description = description;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private boolean isValidDate(int day, int month, int year) {
		if (month < 1 || month > 12 || day < 1 || day > 31) {

			return false;
		}
		return true;
	}

	public abstract void displayDetails();
}
