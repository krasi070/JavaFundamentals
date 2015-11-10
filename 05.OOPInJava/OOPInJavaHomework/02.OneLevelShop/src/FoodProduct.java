import java.util.Calendar;
import java.util.Date;

public class FoodProduct extends Product implements Expirable {

    public FoodProduct(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction);
    }

    @Override
    public Date getExpirationDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 30);
        return cal.getTime();
    }

    @Override
    public double getPrice() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getExpirationDate().getYear());
        cal.set(Calendar.MONTH, getExpirationDate().getMonth());
        cal.set(Calendar.DATE, getExpirationDate().getDate() - 15);
        if (0 <= this.getExpirationDate().compareTo(cal.getTime())) {
            return super.getPrice() * 0.7;
        } else {
            return super.getPrice();
        }
    }
}
