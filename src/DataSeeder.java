import java.util.ArrayList;

class DataSeeder {
    private static DataSeeder instance = null;
    private ArrayList<IMenu> menus;
    private ArrayList<IMenu> adminMenus;

    private ArrayList<IKleding> hoodies;
    private ArrayList<IKleding> broeken;
    private ArrayList<IKleding> shirts;

    private ArrayList<IKleding> alleKleding;






    private DataSeeder() {
        adminMenus = new ArrayList<>();
        menus = new ArrayList<>();
        hoodies = new ArrayList<>();
        broeken = new ArrayList<>();
        shirts = new ArrayList<>();
        alleKleding = new ArrayList<>();
        seedData();
    }

    public static DataSeeder getInstance() {
        if (instance == null) {
            instance = new DataSeeder();
        }
        return instance;
    }

    private void seedData() {
        // Seed Menus




        hoodies.add(new Kleding(new Prijs(50, new Currency.EURO()),   "Nike",50) {
        });
        hoodies.add(new Kleding(new Prijs(60, new Currency.DOLLAR()),   "Adidas",60));

        broeken.add(new Kleding(new Prijs(40, new Currency.EURO()),   "Levi's", 40));
        broeken.add(new Kleding(new Prijs(45, new Currency.DOLLAR()), "Wrangler", 30));

        shirts.add(new Kleding(new Prijs(20, new Currency.EURO()),   "H&M", 50));
        shirts.add(new Kleding(new Prijs(25, new Currency.DOLLAR()), "Zara",40));
        alleKleding.addAll(shirts);
        alleKleding.addAll(hoodies);
        alleKleding.addAll(broeken);



    }


    public ArrayList<IKleding> getAlleKleding() {
        return alleKleding;
    }
    public ArrayList<IKleding> getHoodies() {
        return hoodies;
    }

    public ArrayList<IKleding> getBroeken() {
        return broeken;
    }

    public ArrayList<IKleding> getShirts() {
        return shirts;
    }
}