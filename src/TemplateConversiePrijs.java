import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SubjectPrijzen {
    private List<ObserverPrijzen> observers = new ArrayList<>();

    public void addObserver(ObserverPrijzen observer) {
        observers.add(observer);
    }

    public void removeObserver(ObserverPrijzen observer) {
        observers.remove(observer);
    }

    public void notifyObservers(List<Prijs> prijzen) {
        for (ObserverPrijzen observer : observers) {
            observer.update(prijzen);
        }
    }
}


abstract class PrijsProcessorV2 extends SubjectPrijzen {

    Map<Integer, Prijs> prijzenMap;
        ArrayList<IKleding> kleding;
     List<ObserverPrijzen> observers = new ArrayList<>();

        PrijsProcessorV2(ArrayList<IKleding> kleding){
            this.kleding = kleding;
            this.prijzenMap = new HashMap<>();
            int id = 1;
            for(IKleding kleding1 : kleding){
                prijzenMap.put(id, kleding1.getPrijs());
                id++;
            }
        }

    public final void processPrijzen(ArrayList<Prijs> prijzen, Sale sale, ICurrency currency) {
        getPrijzen(prijzen);
        pasValutaToeOpPrijzen(prijzen, currency);
        pasCouponToeOpPrijzen(prijzen, sale);
        bewerkPrijzen(prijzen);
        pasGeëindigdePrijzenToe(prijzen);
        notifyObservers(prijzen);
    }
    public void addObserver(ObserverPrijzen observer) {
        observers.add(observer);
    }
    public void notifyObservers(ArrayList <Prijs>prijs) {
        for (ObserverPrijzen observer : observers) {
            observer.update(prijs);
        }
    }
    protected abstract void getPrijzen(ArrayList<Prijs> prijzen);

    protected abstract void pasValutaToeOpPrijzen(ArrayList<Prijs> prijzen, ICurrency currency);

    protected abstract void pasCouponToeOpPrijzen(ArrayList<Prijs> prijzen, Sale sale);

    protected abstract void bewerkPrijzen(ArrayList<Prijs> prijzen);

    protected abstract void pasGeëindigdePrijzenToe(ArrayList<Prijs> prijzen);
}

class ConcretePrijsProcessor extends PrijsProcessorV2 {
    ConcretePrijsProcessor(ArrayList<IKleding> kleding) {
        super(kleding);
    }


    @Override
    protected void getPrijzen(ArrayList<Prijs> prijzen) {
        prijzen.add(new Prijs(100));
        prijzen.add(new Prijs(200));
        prijzen.add(new Prijs(300));

    }

    @Override
    protected void pasValutaToeOpPrijzen(ArrayList<Prijs> prijzen, ICurrency currency) {
        for (Prijs prijs : prijzen) {
            double bedragInEuro = prijs.getWaarde()/ currency.getKoers();
            prijs.setWaarde(bedragInEuro);
        }
        notifyObservers(prijzen);
    }

    @Override
    protected void pasCouponToeOpPrijzen(ArrayList<Prijs> prijzen, Sale sale) {
        for (Prijs prijs : prijzen) {
            double gekortBedrag = prijs.getWaarde() * 0.95;
            prijs.setWaarde(gekortBedrag);
        }
        notifyObservers(prijzen);
    }

    @Override
    protected void bewerkPrijzen(ArrayList<Prijs> prijzen) {
        for (Prijs prijs : prijzen) {
            if (prijs.getWaarde() > 200) {
                prijs.setWaarde(prijs.getWaarde() * 1.05); // 5% toeslag
            }
        }
        notifyObservers(prijzen);
    }

    @Override
    protected void pasGeëindigdePrijzenToe(ArrayList<Prijs> prijzen) {
        System.out.println("Geëindigde Prijzen:");
        for (Prijs prijs : prijzen) {
            System.out.println(prijs);
        }
    }
}

class ConcretePrijsProcessor2 extends PrijsProcessorV2 {
    ConcretePrijsProcessor2(ArrayList<IKleding> kleding) {
        super(kleding);
    }

    @Override
    protected void getPrijzen(ArrayList<Prijs> prijzen) {
        prijzen.add(new Prijs(150));
        prijzen.add(new Prijs(250));
        prijzen.add(new Prijs(350));
    }

    @Override
    protected void pasValutaToeOpPrijzen(ArrayList<Prijs> prijzen, ICurrency currency) {
        for (Prijs prijs : prijzen) {
            double bedragInEuro = prijs.getWaarde() / currency.getKoers();
            prijs.setWaarde(bedragInEuro);
        }
        notifyObservers(prijzen);
    }

    @Override
    protected void pasCouponToeOpPrijzen(ArrayList<Prijs> prijzen, Sale sale) {
        for (Prijs prijs : prijzen) {
            double gekortBedrag = prijs.getWaarde() * 0.85; // 15% korting
            prijs.setWaarde(gekortBedrag);
        }
        notifyObservers(prijzen);
    }

    @Override
    protected void bewerkPrijzen(ArrayList<Prijs> prijzen) {
        for (Prijs prijs : prijzen) {
            if (prijs.getWaarde() > 250) {
                prijs.setWaarde(prijs.getWaarde() * 1.08); // 8% toeslag
            }
        }
        notifyObservers(prijzen);
    }

    @Override
    protected void pasGeëindigdePrijzenToe(ArrayList<Prijs> prijzen) {
        System.out.println("Geëindigde Prijzen voor Processor 2:");
        for (Prijs prijs : prijzen) {
            System.out.println(prijs);
        }
        notifyObservers(prijzen);
    }
}