package projekt3.copy;

import java.util.List;

public class Player extends Account {
    private String rolle; 

    public Player(String vorName, String nachName, int alter, String rolle) {
        super(vorName, nachName, alter);
        setRolle(rolle); 
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {

        String[] validRoles = { "trainer", "top", "jng", "mid", "adc", "sup" };
        for (String validRole : validRoles) {
            if (validRole.equalsIgnoreCase(rolle)) {
                this.rolle = rolle.toLowerCase(); 
                return;
            }
        }
        throw new IllegalArgumentException("Ungültige Rolle! Erlaubt sind: trainer, top, jungle, mid, adc, support.");
    }

    @Override
    public String listTrainings(List<Training> trainings) {
        if (trainings.isEmpty()) {
            return "Keine Trainings vorhanden.";
        }

        StringBuilder trainingsListe = new StringBuilder("Trainingsübersicht:\n");
        for (Training training : trainings) {
            trainingsListe.append(training.getDescription())
                          .append(" am ")
                          .append(training.getDay())
                          .append(".")
                          .append(training.getMonth())
                          .append(".")
                          .append(training.getYear())
                          .append("\n");
        }
        return trainingsListe.toString();
    }
}
