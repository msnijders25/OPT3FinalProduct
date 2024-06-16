import java.util.ArrayList;

class Currency implements ICurrency {
    private Double koers;
    private String name;


    public Currency(Double koers, String name) {
        this.koers = koers;
        this.name = name;

    }

    @Override
    public Double getKoers() {
        return koers;
    }

    @Override
    public String getName() {
        return name;
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