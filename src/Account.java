public class Account {
    private Korting korting;
    private Country country;
    private Mandje mandje = new Mandje();

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

    public void setKorting(Korting korting) {
        this.korting = korting;
    }

    public Korting getKorting() {
        return korting;
    }

    public Country getCountry() {
        return country;
    }

    public Mandje getMandje() {
        return mandje;
    }
}