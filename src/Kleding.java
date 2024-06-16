 class Kleding implements  IKleding{
    private  int voorraad;
    private Prijs prijs;
    private String naam;
    private String id;

    public Kleding(Prijs prijs, String naam, int voorraad) {
        this.prijs = prijs;
        this.naam = naam;
        this.voorraad = voorraad;
    }
    public void setVoorraad(int voorraad){
        this.voorraad = voorraad;
    }
    public int getVoorraad(){
        return voorraad;
    }
    public Prijs getPrijs() {
        return prijs;
    }




    public String getNaam() {
        return naam;
    }

     @Override
     public void setPrijs(double nieuwePrijs) {

     }



 }