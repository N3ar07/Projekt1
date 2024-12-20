package projekt3.copy;

import java.util.Scanner;

public class Main {

	private static Admin admin;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		admin = new Admin("Max", "Mustermann", 30, "admin123");

		boolean exitProgram = false;
		while (!exitProgram) {
			printMainMenu();
			String input = scanner.nextLine();

			switch (input) {
			case "1":
				playerMenu(scanner);
				break;
			case "2":
				adminMenu(scanner);
				break;
			case "3":
				exitProgram = true;
				System.out.println("Programm wird beendet. Auf Wiedersehen!");
				break;
			default:
				System.out.println("Ungültige Eingabe. Bitte wählen Sie 1, 2 oder 3.");
			}
		}

		scanner.close();
	}

	private static void printMainMenu() {
		System.out.println("\n--- Willkommen im Trainingsplaner ---");
		System.out.println("1. Spieler-Menü");
		System.out.println("2. Admin-Menü");
		System.out.println("3. Programm beenden");
		System.out.print("Eingabe: ");
	}

	private static void playerMenu(Scanner scanner) {
		System.out.println("\n--- Spieler-Menü ---");
		String trainingsListe = admin.listTrainings(admin.getTrainingList());
		System.out.println(trainingsListe);
	}

	private static void adminMenu(Scanner scanner) {
		while (!authenticateAdmin(scanner)) {
			System.out.println("Falsches Passwort! Zugriff verweigert.");
		}

		boolean backToMain = false;
		while (!backToMain) {
			printAdminMenu();
			String input = scanner.nextLine();

			switch (input) {
			case "1":
				managePlayers(scanner);
				break;
			case "2":
				manageTrainings(scanner);
				break;
			case "3":
				System.out.println(admin.listTrainings(admin.getTrainingList()));
				break;
			case "4":
				backToMain = true;
				break;
			default:
				System.out.println("Ungültige Eingabe. Bitte erneut versuchen.");
			}
		}
	}

	private static void printAdminMenu() {
		System.out.println("\n--- Admin-Menü ---");
		System.out.println("1. Spieler-Accounts verwalten");
		System.out.println("2. Trainingspläne verwalten");
		System.out.println("3. Alle Trainingspläne anzeigen");
		System.out.println("4. Zurück zum Hauptmenü");
		System.out.print("Eingabe: ");
	}

	private static boolean authenticateAdmin(Scanner scanner) {
		System.out.print("Bitte Admin-Passwort eingeben: ");
		String inputPassword = scanner.nextLine();
		return admin.checkPassword(inputPassword);
	}

	private static void managePlayers(Scanner scanner) {
		System.out.println("\n--- Spieler-Verwaltung ---");
		System.out.println("1. Spieler erstellen");
		System.out.println("2. Spieler löschen");
		System.out.println("3. Spieler bearbeiten");
		System.out.println("4. Spieler anzeigen");
		System.out.print("Eingabe: ");

		String input = scanner.nextLine();
		switch (input) {
		case "1":
			createPlayer(scanner);
			break;
		case "2":
			deletePlayer(scanner);
			break;
		case "3":
			editPlayer(scanner);
			break;
		case "4":
			admin.listPlayers();
			break;
		default:
			System.out.println("Ungültige Eingabe.");
		}
	}

	private static void createPlayer(Scanner scanner) {
		System.out.print("Vorname: ");
		String vorName = scanner.nextLine();
		System.out.print("Nachname: ");
		String nachName = scanner.nextLine();
		System.out.print("Alter: ");
		int alter = Integer.parseInt(scanner.nextLine());
		System.out.print("Rolle: ");
		String rolle = scanner.nextLine();
		admin.createPlayer(vorName, nachName, alter, rolle);
	}

	private static void deletePlayer(Scanner scanner) {
		System.out.print("Vorname des Spielers: ");
		String vorName = scanner.nextLine();
		System.out.print("Nachname des Spielers: ");
		String nachName = scanner.nextLine();
		admin.deletePlayer(vorName, nachName);
	}

	private static void editPlayer(Scanner scanner) {
		System.out.print("Vorname des Spielers: ");
		String vorName = scanner.nextLine();
		System.out.print("Nachname des Spielers: ");
		String nachName = scanner.nextLine();
		System.out.print("Neue Rolle: ");
		String neueRolle = scanner.nextLine();
		admin.editPlayer(vorName, nachName, neueRolle);
	}

	private static void manageTrainings(Scanner scanner) {
		System.out.println("\n--- Trainings-Verwaltung ---");
		System.out.println("1. Theorie-Training erstellen");
		System.out.println("2. Praxis-Training erstellen");
		System.out.println("3. Trainingsplan löschen");
		System.out.print("Eingabe: ");

		String input = scanner.nextLine();
		switch (input) {
		case "1":
			createTheoryTraining(scanner);
			break;
		case "2":
			createPracticalTraining(scanner);
			break;
		case "3":
			deleteTraining(scanner);
			break;
		default:
			System.out.println("Ungültige Eingabe.");
		}
	}

	private static void createTheoryTraining(Scanner scanner) {
		System.out.print("Beschreibung: ");
		String description = scanner.nextLine();
		int[] date = askForDate(scanner);
		admin.createTraining(new TheoryTraining(date[0], date[1], date[2], description, admin));
	}

	private static void createPracticalTraining(Scanner scanner) {
		System.out.print("Beschreibung: ");
		String description = scanner.nextLine();
		int[] date = askForDate(scanner);
		System.out.println("Spieler auswählen:");
		admin.listPlayers();

		System.out.println("Praxis-Training wurde erstellt.");
	}

	private static void deleteTraining(Scanner scanner) {
		System.out.print("Beschreibung des Trainings: ");
		String description = scanner.nextLine();
		admin.deleteTraining(description);
	}

	private static int[] askForDate(Scanner scanner) {
		while (true) {
			try {
				System.out.print("Tag des Trainings (1-31): ");
				int day = Integer.parseInt(scanner.nextLine());

				System.out.print("Monat des Trainings (1-12): ");
				int month = Integer.parseInt(scanner.nextLine());

				System.out.print("Jahr des Trainings: ");
				int year = Integer.parseInt(scanner.nextLine());

				if (day > 0 && day <= 31 && month > 0 && month <= 12) {
					return new int[] { day, month, year };
				} else {
					System.out.println(
							"Ungültiges Datum. Bitte stellen Sie sicher, dass der Tag zwischen 1-31 und der Monat zwischen 1-12 liegt.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Ungültige Eingabe. Bitte geben Sie Zahlen ein (z. B. 1 für Januar).");
			}
		}
	}
}
