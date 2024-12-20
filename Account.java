package projekt3.copy;

import java.util.List;

public abstract class Account {
	private String vorName;
	private String nachName;
	private int alter;

	public Account(String vorName, String nachName, int alter) {
		this.vorName = vorName;
		this.nachName = nachName;
		this.alter = alter;
	}

	public String getVorName() {
		return vorName;
	}

	public void setVorName(String vorName) {
		this.vorName = vorName;
	}

	public String getNachName() {
		return nachName;
	}

	public void setNachName(String nachName) {
		this.nachName = nachName;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		if (alter > 0) {
			this.alter = alter;
		} else {
			throw new IllegalArgumentException("Das Alter muss positiv sein.");
		}
	}

	public abstract String listTrainings(List<Training> trainings);
}
