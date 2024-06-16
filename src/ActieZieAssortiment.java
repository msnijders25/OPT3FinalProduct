import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActieZieAssortiment implements IActie, ObserverPrijzen {

    private Scanner scanner = new Scanner(System.in);

    public ActieZieAssortiment() {
        this.scanner =  new Scanner(System.in);
    }

    @Override
    public void voerUit() {
        while (true) {
            System.out.println("Kies een optie:");
            System.out.println("1. Toon Hoodies");
            System.out.println("2. Toon Shirts");
            System.out.println("3. Toon Broeken");
            System.out.println("4. Terug");

            System.out.print("Voer uw keuze in: ");
            String keuze = scanner.nextLine();

            switch (keuze) {
                case "1":
                    toonKleding(DataSeeder.getInstance().getHoodies(), "Hoodies");
                    break;
                case "2":
                    toonKleding(DataSeeder.getInstance().getShirts(), "Shirts");
                    break;
                case "3":
                    toonKleding(DataSeeder.getInstance().getBroeken(), "Broeken");
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
                    break;
            }
        }
    }

    private void toonKleding(ArrayList<IKleding> kledingLijst, String categorieNaam) {
        Account account = new Account();
        KlantAdminMenuBewerk admin = new KlantAdminMenuBewerk("bb");
        System.out.println(categorieNaam + ":");
        for (int i = 0; i < kledingLijst.size(); i++) {
            IKleding kleding = kledingLijst.get(i);
            System.out.println((i + 1) + ". " + kleding.getNaam());
        }
        System.out.println();

        System.out.print("Kies een item door het nummer in te voeren (of 0 om terug te gaan): ");
        int keuze = scanner.nextInt();
        scanner.nextLine();//Voor het voorkomen infinite loop

        if (keuze >= 1 && keuze <= kledingLijst.size()) {
            IKleding gekozenKleding = kledingLijst.get(keuze - 1);
            System.out.println("Je hebt " + gekozenKleding.getNaam() + " gekozen.");
            admin.initializeMenuOptiesBewerk(gekozenKleding);
        } else if (keuze == 0) {
            System.out.println("Terug naar het vorige menu.");
        } else {
            System.out.println("Ongeldige keuze. Probeer opnieuw.");
        }
    }

    @Override
    public void update(List<Prijs> prijzen) {

    }
}
