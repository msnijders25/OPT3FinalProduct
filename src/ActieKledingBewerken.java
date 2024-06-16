import java.util.ArrayList;
import java.util.Scanner; //

public class ActieKledingBewerken implements IActie {
    private IKleding kleding;

    public ActieKledingBewerken(IKleding kleding) {
        this.kleding = kleding;

    }

    @Override
    public void voerUit() {
        ArrayList<IKleding> kledingItems = DataSeeder.getInstance().getAlleKleding();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Voer de nieuwe prijs in voor " + kleding.getNaam() + ": ");
        double nieuwePrijs = scanner.nextDouble();

        for (IKleding item : kledingItems) {
            if (item.getNaam().equals(kleding.getNaam())) {
                item.setPrijs(nieuwePrijs);
                System.out.println(kleding.getNaam() + " heeft nu een nieuwe prijs: " + nieuwePrijs);
                return;
            }
        }

        System.out.println("ERROR: " + kleding.getNaam() + " zit niet in de database.");
    }
}