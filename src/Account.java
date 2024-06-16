import java.util.ArrayList;

public class Account {
    private Country country;
    private Mandje mandje = new Mandje();
    ArrayList<Bestelling> bestellingen = new ArrayList<>();
    public Account(Country country) {
        this.country = country;
        this.mandje = new Mandje();
        System.out.println("Account created with mandje: " + mandje);
    }

    public Account(Mandje mandje) {
    this.mandje = mandje;
        System.out.println("Account created with mandje: " + mandje);
    }

    public Account() {

    }
    public void addBestelling(IKleding kleding) {
        Bestelling  bestelling = new Bestelling(kleding);
        bestellingen.add(bestelling);
    }


    public Country getCountry() {
        return country;
    }

    public Mandje getMandje() {
        return mandje;
    }
}