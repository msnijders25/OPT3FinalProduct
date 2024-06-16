class Menukeuze {
    private int index;
    private String tekst;
    private boolean isTerug;
    private IActie actie;

    public Menukeuze(int index, String tekst, IActie actie) {
        this.index = index;
        this.tekst = tekst;
        this.actie = actie;
        this.isTerug = false;
    }


    public Menukeuze(int index, String tekst, boolean isTerug) {
        this(index, tekst, null);
        this.isTerug = isTerug;
    }

    public int getIndex() {
        return index;
    }

    public String getTekst() {
        return tekst;
    }

    public boolean isTerug() {
        return isTerug;
    }

    public IActie getActie() {
        return actie;
    }
}