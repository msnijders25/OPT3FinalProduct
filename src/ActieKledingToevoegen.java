import java.util.ArrayList;

public class ActieKledingToevoegen implements IActie {
    private IKleding kleding;

    public ActieKledingToevoegen(IKleding kleding) {
        this.kleding = kleding;
        voerUit();
    }

    @Override
    public void voerUit() {
        ArrayList<IKleding> shirts = DataSeeder.getInstance().getShirts();
        for (IKleding shirt : shirts) {
            if (shirt.getNaam().equals(kleding.getNaam())) {
                System.out.println(kleding.getNaam() + " bestaat al in de database. Kan niet toevoegen.");
                return;
            }
        }

        shirts.add(kleding);
        System.out.println(kleding.getNaam() + " is succesvol toegevoegd aan de database.");
    }
}