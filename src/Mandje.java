import java.util.ArrayList;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

class Mandje implements ObserverPrijzen {

    Korting korting;
    private ArrayList<IKleding> items;
    private ArrayList<MandjeObserver> observers;

    public Mandje() {
        items = new ArrayList<>();
        observers = new ArrayList<>();
        System.out.println("Mandje created with items: " + items);
    }


    public void setKorting(Korting korting) {
        this.korting = korting;
    }

    public Korting getKorting() {
        return korting;
    }
    public void voegKledingToe(IKleding kleding) {
        items.add(kleding);
        notifyObservers();
    }

    public void verwijderKleding(IKleding kleding) {
        items.remove(kleding);
        notifyObservers();
    }

    public void voegObserverToe(MandjeObserver observer) {
        observers.add(observer);
        observer.update(getAantalItems());
    }

    public void verwijderObserver(MandjeObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        int aantalItems = getAantalItems();
        for (MandjeObserver observer : observers) {
            observer.update(aantalItems);
        }
    }

    public int getAantalItems() {
        return items.size();
    }

    public ArrayList<IKleding> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return false; }

    @Override
    public void update(List<Prijs> prijzen) {

    }
}
