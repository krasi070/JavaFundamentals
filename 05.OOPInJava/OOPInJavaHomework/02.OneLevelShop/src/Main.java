import exceptions.AgeRestrictionException;
import exceptions.OutOfMoneyException;
import exceptions.OutOfStockException;
import exceptions.ProductExpiredException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product coffee = new FoodProduct("Coffee", 3.00, 20, AgeRestriction.Teenager);
        Product laptop = new Computer("Razer Laptop", 2000.00, 1032, AgeRestriction.None);
        Product vacuumCleaner = new Appliance("MEGA VACUUM CLEANER 5000", 56.99, 10, AgeRestriction.None);
        Product cereal = new FoodProduct("Strawberry Smiggles", 3.99, 35, AgeRestriction.None);
        Product alcohol = new FoodProduct("Just Alcohol", 9.99, 100, AgeRestriction.Adult);
        Product computer = new Computer("ULTRA COMPUTER", 979.99, 18, AgeRestriction.None);
        Product cigar = new FoodProduct("HYPER CIGAR", 80.00, 10, AgeRestriction.Adult);

        Customer morty = new Customer("Morty Smith", 14, 34.67);

        List<Product> productsMortyWantsToBuy = new ArrayList<>();
        productsMortyWantsToBuy.add(coffee);
        productsMortyWantsToBuy.add(vacuumCleaner);
        productsMortyWantsToBuy.add(cereal);
        productsMortyWantsToBuy.add(alcohol);

        for (Product product : productsMortyWantsToBuy) {
            try {
                PurchaseManager.processPurchase(morty, product);
            } catch (AgeRestrictionException e) {
                System.out.println("You are too young to buy this product!");
            } catch (OutOfStockException e) {
                System.out.println("The product is out of stock!");
            } catch (OutOfMoneyException e) {
                System.out.println("You do not have enough money to buy this product!");
            } catch (ProductExpiredException e) {
                System.out.println("The product has expired!");
            } catch (Exception e) {
                System.out.println("There was an error with the bought item!");
            }
        }

        System.out.println("----------------------------------------");

        List<Product> listOfProducts = new ArrayList<>();
        listOfProducts.add(coffee);
        listOfProducts.add(laptop);
        listOfProducts.add(vacuumCleaner);
        listOfProducts.add(cereal);
        listOfProducts.add(alcohol);
        listOfProducts.add(computer);
        listOfProducts.add(cigar);

        listOfProducts.stream()
                .filter(p -> p instanceof FoodProduct)
                .map(p -> ((FoodProduct) p))
                .sorted((p1, p2) -> p1.getExpirationDate().compareTo(p2.getExpirationDate()))
                .limit(1)
                .forEach(p -> {
                    try {
                        System.out.println("Product with soonest date of expiration: " + p.getName());
                    } catch (Exception e) {
                        System.out.println("No name was given to the product with the soonest date of expiration!");
                    }
                });

        System.out.println("----------------------------------------\nAdult items:");

        listOfProducts.stream()
                .filter(p -> p.getAgeRestriction() == AgeRestriction.Adult)
                .sorted((p1, p2) -> p1.getAgeRestriction().compareTo(p2.getAgeRestriction()))
                .forEach(p -> {
                    try {
                        System.out.println(p.getName());
                    } catch (Exception e) {
                        System.out.println("No name was given to this adult product!");
                    }
                });
    }
}
