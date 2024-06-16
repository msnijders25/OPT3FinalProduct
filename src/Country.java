public class Country {
    protected String name;
    protected Language language;
    protected Currency currency;

    public Country(String name, Language language, Currency currency) {
        this.name = name;
        this.language = language;
        this.currency = currency;
    }

    public Language getLanguage() {
        return language;
    }

    public Currency getCurrency() {
        return currency;
    }

    public static class UK extends Country {
        public UK(Language english, Currency.POUND currency) {
            super("United Kingdom", english, currency);
        }
    }

    public static class NL extends Country {
        public NL(Language dutch, Currency.EURO currency) {
            super("Netherlands", dutch, currency);
        }
    }

    public static class US extends Country {
        public US(Language english, Currency.DOLLAR currency) {
            super("United States", english, currency);
        }
    }
}