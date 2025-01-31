package designPattern_2;

public class Dispenser5Lei implements DispenseChain{
    private DispenseChain chain;
    private ATMResources lei5BanknoteNr;

    public Dispenser5Lei(ATMResources lei5BanknoteNr)
    {
        this.lei5BanknoteNr = lei5BanknoteNr;
    }

    @Override
    public void setNextChain(DispenseChain nextChain)
    {
        this.chain = nextChain;
    }

    @Override
    public boolean dispense(Currency currency)
    {
        boolean ok= false;
        int num = 0;
        if(currency.getAmount() >= 5)
        {
            num = Math.min(currency.getAmount() / 5, lei5BanknoteNr.getBanknoteNr() );
            int remainder = currency.getAmount() - (num * 5);
            if (remainder != 0)
            {
                ok= false;
            }
            else
            {
                ok=true;
            }
        }
        if (ok && num!=0)
        {
            System.out.println("Primeste " + num + (num == 1 ? " bancnota" : " bancnote") + " de 5 lei ");
            lei5BanknoteNr.substractBanknoteNr(num);
        }
        return ok;

    }
}

