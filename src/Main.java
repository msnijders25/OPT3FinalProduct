import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainMenu.mainMenu();
    }
}

class MainMenu {
    public static void mainMenu() {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        KlantAdminMenu admin = new KlantAdminMenu("Admin Menu");
        KlantAccountMenu klant = new KlantAccountMenu("Klant Menu", account);

        while (true) {
            System.out.println("Welkom bij het systeem!");
            System.out.println("Maak een keuze uit de onderstaande opties:");
            System.out.println("1. Kies klant account");
            System.out.println("2. Kies admin account");
            System.out.print("Voer uw keuze in (1 of 2): ");

            String keuze = scanner.nextLine();

            switch (keuze) {
                case "1":
                    klant.handleMenu(scanner);
                    break;
                case "2":
                    admin.handleMenu(scanner);
                    break;
                default:
                    System.out.println("Ongeldige keuze, probeer het opnieuw.");
            }
        }
    }
}
