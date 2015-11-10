import java.time.Period;

public abstract class ElectronicsProduct extends Product{
    private Period guaranteePeriod;

    public ElectronicsProduct(String name, double price, int quantity, AgeRestriction agerestriction, Period guaranteePeriod) {
        super(name, price, quantity, agerestriction);
        this.guaranteePeriod = guaranteePeriod;
    }

    public Period getGuaranteePeriod() {
        return this.guaranteePeriod;
    }

    public void setGuaranteePeriod(Period guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }
}
