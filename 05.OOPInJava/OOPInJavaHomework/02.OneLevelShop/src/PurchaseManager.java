import exceptions.AgeRestrictionException;
import exceptions.OutOfMoneyException;
import exceptions.OutOfStockException;
import exceptions.ProductExpiredException;

import java.util.Calendar;

public class PurchaseManager {
    public static void processPurchase(Customer customer, Product product) throws Exception {

        if(product.getQuantity() <= 0) {
            throw new OutOfStockException("The product is out of stock!");
        }

        if (product instanceof FoodProduct) {
            if (0 >= ((FoodProduct) product).getExpirationDate().compareTo(Calendar.getInstance().getTime())) {
                throw new ProductExpiredException("The product has expired!");
            }
        }

        if (product.getPrice() > customer.getBalance()) {
            throw new OutOfMoneyException("You do not have enough money to buy this product!");
        }

        if ((product.getAgeRestriction() == AgeRestriction.Teenager && customer.getAge() < 13) ||
                (product.getAgeRestriction() == AgeRestriction.Adult && customer.getAge() < 18)) {
            throw new AgeRestrictionException("You are too young to buy this product!");
        }

        product.setQuantity(product.getQuantity() - 1);
        customer.setBalance(customer.getBalance() - product.getPrice());
        System.out.printf("%s bought %s for %.2f$.\n", customer.getName(), product.getName(), product.getPrice());
    }
}
