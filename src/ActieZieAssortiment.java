import java.util.*;

public class ActieZieAssortiment implements IActie, ObserverPrijzen {

    private Map<String, ArrayList<IKleding>> kledingMap = new HashMap<>();

    public ActieZieAssortiment() {
        kledingMap.put("1", DataSeeder.getInstance().getHoodies());
        kledingMap.put("2", DataSeeder.getInstance().getShirts());
        kledingMap.put("3", DataSeeder.getInstance().getBroeken());
    }
    private void toonKleding(ArrayList<IKleding> kledingLijst, String categorieNaam) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        KlantAdminMenuBewerk admin = new KlantAdminMenuBewerk("bb");
        System.out.println(categorieNaam + ":");
        for (int i = 0; i < kledingLijst.size(); i++) {
            IKleding kleding = kledingLijst.get(i);
            System.out.println((i + 1) + ". " + kleding.getNaam() + " - Prijs: " + kleding.getPrijs());
        }
        System.out.println();


        System.out.print("Kies een item door het nummer in te voeren (of 0 om terug te gaan): ");
        int keuze = scanner.nextInt();
        scanner.nextLine();

        if (keuze >= 1 && keuze <= kledingLijst.size()) {
            IKleding gekozenKleding = kledingLijst.get(keuze - 1);
            System.out.println("Je hebt " + gekozenKleding.getNaam() + " gekozen.");

            if (account.getCountry() instanceof Country.NL) {
                admin.initializeMenuOptiesBewerk(gekozenKleding);
            } else {

                System.out.println("Error: Functionaliteit nog niet toegepast");
            }

        } else if (keuze == 0) {
            System.out.println("Terug naar het vorige menu.");
        } else {
            System.out.println("Ongeldige keuze. Probeer opnieuw.");
        }
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
            Scanner scanner = new Scanner(System.in);
            String keuze = scanner.nextLine();

            ArrayList<IKleding> kledingLijst = kledingMap.get(keuze);
            if (kledingLijst != null) {
                toonKleding(kledingLijst, "Categorie"); // Categorie dynamisch bepalen?
            } else if (keuze.equals("4")) {
                return; // Terug naar het vorige menu
            } else {
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
            }
        }
    }

    @Override
    public void update(List<Prijs> prijzen) {

    }
}