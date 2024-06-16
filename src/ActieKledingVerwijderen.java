import java.util.ArrayList;

public class ActieKledingVerwijderen implements IActie {
    private String kledingNaam;

    public ActieKledingVerwijderen(String kledingNaam) {
        this.kledingNaam = kledingNaam;

    }

    @Override
    public void voerUit() {
        ArrayList<IKleding> shirts = DataSeeder.getInstance().getShirts();
        IKleding shirtToRemove = null;

        for (IKleding shirt : shirts) {
            if (shirt.getNaam().equals(kledingNaam)) {
                shirtToRemove = shirt;
                break;
            }
        }

        if (shirtToRemove != null) {
            shirts.remove(shirtToRemove);
            System.out.println(kledingNaam + " is succesvol verwijderd uit de database.");
        } else {
            System.out.println(kledingNaam + " kon niet worden gevonden in de database. Verwijdering mislukt.");
        }
    }
}
