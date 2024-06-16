import java.util.ArrayList;
import java.util.Scanner;

class ActieKledingBewerkenVoorraad implements IActie {

        private IKleding kleding;

public ActieKledingBewerkenVoorraad(IKleding kleding) {
        this.kleding = kleding;

        }

@Override
public void voerUit() {
        ArrayList<IKleding> kledingItems = DataSeeder.getInstance().getAlleKleding();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Voer de nieuwe voorraad in voor " + kleding.getNaam() + ": ");
        int nieuweVoorraad = scanner.nextInt();

        for (IKleding item : kledingItems) {
        if (item.getNaam().equals(kleding.getNaam())) {
        item.setVoorraad(nieuweVoorraad);
        System.out.println(kleding.getNaam() + " Voorraad is nu: " + nieuweVoorraad);
        return;
        }
        }

        System.out.println("ERROR: " + kleding.getNaam() + " zit niet in de database.");
        }
        }