import java.util.ArrayList;

public class Bestelling {
    String ID;
    private ArrayList<IKleding> items;

    public Bestelling() {
        items = new ArrayList<>();
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
        // Logic to view details of the item
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
                System.out.println("- " + kleding);
            }
            mandje.getItems().clear();
        }
    }
}
