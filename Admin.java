package projekt3.copy;

import java.util.ArrayList;
import java.util.List;

public class Admin extends Account {
	
	private String password;

	private ArrayList<Player> playerList;
	private ArrayList<Training> trainingList;

	public Admin(String vorName, String nachName, int alter, String password) {
		super(vorName, nachName, alter);
		this.password = password;
		this.playerList = new ArrayList<>();
		this.trainingList = new ArrayList<>();
	}
	 public List<Training> getTrainingList() {
	        return trainingList;
	    }

	public boolean checkPassword(String inputPassword) {
		return this.password.equals(inputPassword);
	}

	public void createPlayer(String vorName, String nachName, int alter, String rolle) {
		Player newPlayer = new Player(vorName, nachName, alter, rolle);
		playerList.add(newPlayer);
		System.out.println("Spieler-Account für " + vorName + " " + nachName + " wurde erstellt.");
	}

	public void deletePlayer(String vorName, String nachName) {
		for (int i = 0; i < playerList.size(); i++) {
			Player player = playerList.get(i);
			if (player.getVorName().equals(vorName) && player.getNachName().equals(nachName)) {
				playerList.remove(i);
				System.out.println("Spieler-Account für " + vorName + " " + nachName + " wurde gelöscht.");
				return;
			}
		}
		System.out.println("Spieler-Account nicht gefunden.");
	}

	public void editPlayer(String vorName, String nachName, String neueRolle) {
		for (Player player : playerList) {
			if (player.getVorName().equals(vorName) && player.getNachName().equals(nachName)) {
				player.setRolle(neueRolle);
				System.out.println("Spieler-Account für " + vorName + " wurde aktualisiert.");
				return;
			}
		}
		System.out.println("Spieler-Account nicht gefunden.");
	}

	  public void listPlayers() {
	        if (playerList.isEmpty()) {
	            System.out.println("Es gibt keine Spieler-Accounts.");
	        } else {
	            System.out.println("Spieler-Accounts:");
	            for (Player p : playerList) {
	                System.out.println(p.getVorName() + " " + p.getNachName() + " - Rolle: " + p.getRolle());
	            }
	        }
	    }

	    public void createTraining(Training training) {
	        trainingList.add(training);
	        System.out.println("Neuer Trainingsplan wurde hinzugefügt.");
	    }

	    public void deleteTraining(String description) {
	        for (int i = 0; i < trainingList.size(); i++) {
	            if (trainingList.get(i).getDescription().equals(description)) {
	                trainingList.remove(i);
	                System.out.println("Trainingsplan '" + description + "' wurde gelöscht.");
	                return;
	            }
	        }
	        System.out.println("Trainingsplan nicht gefunden.");
	    }

	    public void editTraining(String description, String newDescription) {
	        for (Training training : trainingList) {
	            if (training.getDescription().equals(description)) {
	                training.setDescription(newDescription);
	                System.out.println("Trainingsplan '" + description + "' wurde aktualisiert.");
	                return;
	            }
	        }
	        System.out.println("Trainingsplan nicht gefunden.");
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