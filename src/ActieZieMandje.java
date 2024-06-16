public class ActieZieMandje implements IActie {
    private Account account;

    public ActieZieMandje(Account account) {
        this.account = account;
        System.out.println("ActieZieMandje Geinitialiseerd met account: " + account);
    }

    @Override
    public void voerUit() {
        System.out.println("Mandje in ActieZieMandje: " + account.getMandje());
        MandjeMenu mandjeMenu = new MandjeMenu(this.account);
        mandjeMenu.toonMenu();
    }
}
