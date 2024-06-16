import java.util.ArrayList;

class Bestelling {
    private static int nextOrderId = 1;
    private int id;
    private ArrayList<IKleding> items;

    public Bestelling(IKleding kleding) {
        this.id = nextOrderId++;
        items = new ArrayList<>();
        items.add(kleding);
    }

    public void voegToe(IKleding kleding) {
        items.add(kleding);
    }

    public void verwijder(IKleding kleding) {
        items.remove(kleding);
    }

    public ArrayList<IKleding> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int getId() {
        return id;
    }
}
class ActieVeranderHoeveelheid implements IActie {
    private IKleding kleding;
    private Account account;

    public ActieVeranderHoeveelheid(IKleding kleding, Account account) {
        this.kleding = kleding;
        this.account = account;
    }

    @Override
    public void voerUit() {
        System.out.println("Hoeveelheid van " + kleding + " veranderen.");
    }
}

 class ActieBekijkDetails implements IActie {
    private IKleding kleding;
    private Account account;

    public ActieBekijkDetails(IKleding kleding, Account account) {
        this.kleding = kleding;
        this.account = account;
    }

    @Override
    public void voerUit() {
        System.out.println("Details van " + kleding + ":");
        System.out.println(kleding);
    }
}

 class ActiePlaatsBestelling implements IActie {
    private Account account;

    public ActiePlaatsBestelling(Account account) {
        this.account = account;
    }

    @Override
    public void voerUit() {
        Mandje mandje = account.getMandje();
        if (mandje.isEmpty()) {
            System.out.println("Het mandje is leeg. Kan geen bestelling plaatsen.");
        } else {
            System.out.println("Bestelling geplaatst met de volgende items:");
            for (IKleding kleding : mandje.getItems()) {
                System.out.println("- " + kleding.getNaam());
                account.addBestelling(kleding);
            }
            mandje.getItems().clear();
        }
    }
}
