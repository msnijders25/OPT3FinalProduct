class Prijs implements Observer {
    private double waarde;
    private Currency currency;

    public Prijs(double waarde, Currency currency) {
        this.waarde = waarde;
        this.currency = currency;
        this.currency.addObserver(this);
    }

    public Prijs(int waarde) {
        this.waarde =waarde;
    }

    public double getWaarde() {
        return waarde * currency.getKoers();
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public void update() {
        System.out.println("De waarde van de prijs is bijgewerkt: " + this);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", getWaarde(), currency.getName());
    }

    public void setWaarde(double nieuwePrijs) {
        this.waarde =nieuwePrijs;
    }
}