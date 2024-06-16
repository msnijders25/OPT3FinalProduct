class Voorraad {
    boolean isErVoorraad;
    int voorraad;

    Voorraad(boolean isErVoorraad, int voorraad) {
        this.isErVoorraad = isErVoorraad;
        this.voorraad = voorraad;
    }

    public void updateVoorraadStatus() {
        isErVoorraad = voorraad > 0;
    }

    public boolean isVoorraadNulOfMinder() {
        return voorraad <= 0;
    }
    public int getVoorraad() {
        return voorraad;
    }

    public void setVoorraad(int voorraad) {
        this.voorraad = voorraad;
    }
}