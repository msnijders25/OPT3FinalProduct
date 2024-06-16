import java.util.ArrayList;

class Currency implements ICurrency, Subject {
    private Double koers;
    private String name;
    private ArrayList<Observer> observers;

    public Currency(Double koers, String name) {
        this.koers = koers;
        this.name = name;
        this.observers = new ArrayList<>();
    }

    @Override
    public Double getKoers() {
        return koers;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setKoers(Double koers) {
        this.koers = koers;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public static class EURO extends Currency {
        public EURO() {
            super(0.83, "EURO");
        }
    }

    public static class DOLLAR extends Currency {
        public DOLLAR() {
            super(1.0, "DOLLAR");
        }
    }

    public static class POUND extends Currency {
        public POUND() {
            super(0.72, "POUND");
        }
    }
}