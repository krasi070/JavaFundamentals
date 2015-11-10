import java.time.Period;

public class Computer extends ElectronicsProduct{

    public Computer(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction, Period.ofMonths(24));
    }

    @Override
    public double getPrice() throws Exception {
        if (super.getQuantity() > 1000) {
            return super.getPrice() * 0.95;
        } else {
            return super.getPrice();
        }
    }
}
