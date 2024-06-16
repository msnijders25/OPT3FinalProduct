import java.util.ArrayList;
import java.util.List;

// Observer interface
interface ObserverPrijzen {
    void update(List<Prijs> prijzen);
}


// A concrete observer that prints the updated prices
class PrijzenPrinter implements ObserverPrijzen {
    private String name;

    public PrijzenPrinter(String name) {
        this.name = name;
    }

    @Override
    public void update(List<Prijs> prijzen) {
        System.out.println(name + " received updated prices:");
        for (Prijs prijs : prijzen) {
            System.out.println(prijs);
        }
    }
}
