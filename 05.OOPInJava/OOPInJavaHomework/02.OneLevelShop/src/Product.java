enum AgeRestriction {
    None, Teenager, Adult
}

public abstract class Product implements Buyable{
    private String name;
    private double price;
    private int quantity;
    private AgeRestriction ageRestriction;

    public Product(String name, double price, int quantity, AgeRestriction ageRestriction) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ageRestriction = ageRestriction;
    }

    public String getName() throws Exception {
        if (this.name.equals("")) {
            throw new Exception("There was no give name!");
        } else {
            return this.name;
        }
    }

    public void setName(String name) throws Exception {
        if (name.equals("")) {
            throw new Exception("Name cannot be empty!");
        } else {
            this.name = name;
        }
    }

    public double getPrice() throws Exception {
        if (this.price < 0) {
            this.price = 0;
        }
            return this.price;
    }

    public void setPrice(double price) throws Exception {
        if (price < 0) {
            throw new Exception("Price cannot be negative!");
        } else {
            this.price = price;
        }
    }

    public int getQuantity() throws Exception {
        if (this.quantity < 0) {
            throw new Exception("The given quantity cannot be negative!");
        } else {
            return this.quantity;
        }
    }

    public void setQuantity(int quantity) throws Exception {
        if (quantity < 0) {
            throw new Exception("Quantity cannot be negative!");
        } else {
            this.quantity = quantity;
        }

    }

    public AgeRestriction getAgeRestriction() {
        return this.ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }
}
