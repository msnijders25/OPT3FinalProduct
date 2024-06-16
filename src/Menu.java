
import java.util.ArrayList;
import java.util.Scanner;

abstract class Menu implements IMenu {
    public ArrayList<Menukeuze> opties;
    String naam;

    public Menu(String naam) {
        this.naam = naam;
        this.opties = new ArrayList<>();
         // Initialize menu options once during construction
    }

    protected abstract void initializeMenuOpties();

    public void voegOptieToe(Menukeuze optie) {
        this.opties.add(optie);
    }

    public void toonMenu() {
        initializeMenuOpties();
        for (Menukeuze optie : opties) {
            System.out.println(optie.getIndex() + ". " + optie.getTekst());
        }
    }

    public void handleMenu(Scanner scanner) {
        while (true) {

            toonMenu();
            System.out.print("Voer uw keuze in: ");
            try {
                int keuze = Integer.parseInt(scanner.nextLine());
                kiesOptie(keuze);
                if (isTerugOptie(keuze)) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ongeldige invoer. Voer a.u.b. een getal in.");
            }
        }
    }

    private boolean isTerugOptie(int index) {
        for (Menukeuze optie : opties) {
            if (optie.getIndex() == index && optie.isTerug()) {
                return true;
            }
        }
        return false;
    }

    public void kiesOptie(int index) {
        for (Menukeuze optie : opties) {
            if (optie.getIndex() == index) {
                if (optie.getActie() != null) {
                    optie.getActie().voerUit();
                }
                break;
            }
        }
    }
}

class ActieVoegKortingMandje {
    private double prijs;
    private double nieuwePrijs;

    ActieVoegKortingMandje(double prijs) {
        this.prijs = prijs;
    }

    public double getNieuwePrijs() {
        return nieuwePrijs;
    }
    public void voerActieUit(Account account) {
        Korting korting = account.getKorting();
        if (korting != null) {
            double kortingPercentage = korting.getKorting();
            this.nieuwePrijs = prijs * (1 - kortingPercentage);
        } else {
            this.nieuwePrijs = prijs;
        }
    }
}

class MandjeMenu extends Menu {
    public Account account;
    Scanner scanner = new Scanner(System.in);

    public MandjeMenu(Account account) {
        super("Mandje Menu");
        this.account = account;
        System.out.println("MandjeMenu geinitaliseerd: " + account);
        System.out.println("Account's mandje: " + account.getMandje());
        ;
    }

    @Override
    protected void initializeMenuOpties() {
        Mandje mandje = account.getMandje();
        ArrayList<IKleding> items = mandje.getItems();

        if (mandje.isEmpty()) {
            System.out.println("Het mandje is leeg.");
            return;
        }

        int i = 1;
        for (IKleding kleding : items) {
            voegOptieToe(new Menukeuze(i, "Verwijder " + kleding + " uit mandje", new ActieVerwijderKledingUitMandje(kleding, account)));
            i++;
            voegOptieToe(new Menukeuze(i, "Verander hoeveelheid van " + kleding, new ActieVeranderHoeveelheid(kleding, account)));
            i++;
            voegOptieToe(new Menukeuze(i, "Bekijk details van " + kleding, new ActieBekijkDetails(kleding, account)));
            i++;
        }

        voegOptieToe(new Menukeuze(i, "Plaats bestelling", new ActiePlaatsBestelling(account)));
        i++;

        voegOptieToe(new Menukeuze(i, "Terug", true));
    }
        @Override
        public void toonMenu() {
            initializeMenuOpties();

            ArrayList<IKleding> items = account.getMandje().getItems();
            double totaalPrijs = 0;
            for (IKleding kleding : items) {
                totaalPrijs += kleding.getPrijs().getWaarde();
            }
            System.out.println("Totale prijs: " + totaalPrijs);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Wilt u een korting toepassen? (Y/N)");
            String antwoord = scanner.nextLine().trim().toUpperCase();

            if (antwoord.equals("Y")) {
                ActieVoegKortingMandje actieKorting = new ActieVoegKortingMandje(totaalPrijs);
                actieKorting.voerActieUit(account);
                double nieuwePrijs = actieKorting.getNieuwePrijs();
                System.out.println("Nieuwe prijs na korting: " + nieuwePrijs);
            } else {
                System.out.println("Geen korting toegepast. Totale prijs blijft: " + totaalPrijs);
            }
        }
    }





class ActieVerwijderKledingUitMandje implements  IActie {
    private IKleding kleding;
    public Account account;

    public ActieVerwijderKledingUitMandje(Kleding kleding, Account account) {
        this.kleding = kleding;
        this.account = account;
    }

    public ActieVerwijderKledingUitMandje(IKleding kleding, Account account) {
        this.kleding = kleding;
        this.account = account;
    }
    @Override
    public void voerUit() {
        this.account.getMandje().verwijderKleding(kleding);
        System.out.println(kleding + " is verwijderd uit het mandje.");
    }



}
class KlantAccountMenu extends Menu {
    public Account account;

    public KlantAccountMenu(String naam, Account account) {
        super(naam);
        this.account = account;
        System.out.println("KlantAccountMenu initialized with account: " + account);
    }

    @Override
    protected void initializeMenuOpties() {
        voegOptieToe(new Menukeuze(1, "Zie Assortiment", new ActieZieAssortimentKlant(account)));
        voegOptieToe(new Menukeuze(2, "Open Mandje", new ActieZieMandje(account)));
        voegOptieToe(new Menukeuze(3, "Zie Bestellingen", false));
        voegOptieToe(new Menukeuze(4, "Verander Koers", false));
        voegOptieToe(new Menukeuze(5, "Verander Taal", false));
        voegOptieToe(new Menukeuze(9, "Terug", true));
    }
}

class KlantAdminMenu  extends Menu implements IMenu {

    public KlantAdminMenu(String naam) {
        super(naam);
    }

    @Override
    protected void initializeMenuOpties() {
        voegOptieToe(new Menukeuze(1, "Zie Assortiment", new ActieZieAssortiment()));
        voegOptieToe(new Menukeuze(2, "Voeg een Sale toe", false));
        voegOptieToe(new Menukeuze(9, "Terug", true));
        voegOptieToe(new Menukeuze(5, "BewerkPrijs", false));

    }

}
class KlantAdminMenuBewerk extends Menu {

    public KlantAdminMenuBewerk(String naam) {
        super(naam);
    }

    @Override
    protected void initializeMenuOpties() {
    }

    protected void initializeMenuOptiesBewerk(IKleding kleding) {
        // Clear any existing options to prevent duplication
        this.opties.clear();
        voegOptieToe(new Menukeuze(1, "BewerkPrijs",  new ActieKledingBewerken(kleding)));
        voegOptieToe(new Menukeuze(2, "BewerkVoorraad", new ActieKledingBewerkenVoorraad(kleding)));
        voegOptieToe(new Menukeuze(3, "BewerkVoorraad", false));
        voegOptieToe(new Menukeuze(9, "Terug", true));
        handleMenu(new Scanner(System.in));
    }
}
