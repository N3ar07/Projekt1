package projekt3.copy;

public class TheoryTraining extends Training {
    private Admin trainer;

    public TheoryTraining(int day, int month, int year, String description, Admin trainer) {
        super(day, month, year, description);
        if (trainer != null) {
            this.trainer = trainer;
        } else {
            throw new IllegalArgumentException("Ein Trainer muss zugewiesen werden.");
        }
    }

    public Admin getTrainer() {
        return trainer;
    }

    public void setTrainer(Admin trainer) {
        if (trainer != null) {
            this.trainer = trainer;
        } else {
            throw new IllegalArgumentException("Ein gültiger Trainer muss zugewiesen werden.");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Theorie-Training am " + getDay() + "." + getMonth() + "." + getYear());
        System.out.println("Beschreibung: " + getDescription());
        System.out.println("Trainer: " + trainer.getVorName() + " " + trainer.getNachName());
    }
}