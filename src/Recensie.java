public class Recensie {
    private String recensie;
    private Account account;

    public Recensie(Account account) {
        this.account = account;

    }

    public String getRecensie() {
        return recensie;
    }

    public void setRecensie(String recensie) {
        this.recensie = recensie;
    }}