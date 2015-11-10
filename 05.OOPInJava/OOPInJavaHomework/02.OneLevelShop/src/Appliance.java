import java.time.Period;

public class Appliance extends ElectronicsProduct{
    public Appliance(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction, Period.ofMonths(6));
    }

    @Override
    public double getPrice() throws Exception {
        if (super.getQuantity() < 50) {
            return super.getPrice() * 1.05;
        } else {
            return super.getPrice();
        }
    }
}
