public class Customer {
    private String name;
    private int age;
    private double balance;

    public Customer(String name, int age, double balance) {
        this.name = name;
        this.age = age;
        this.balance = balance;
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

    public int getAge() throws Exception {
        if (this.age < 0) {
            throw new Exception("Given age was negative!");
        } else {
            return this.age;
        }
    }

    public void setAge(int age) throws Exception {
        if (age < 0) {
            throw new Exception("Age cannot be negative!");
        } else {
            this.age = age;
        }
    }

    public double getBalance() throws Exception {
        if (this.balance < 0) {
            this.balance = 0;
        }
        return this.balance;
    }

    public void setBalance(double balance) throws Exception {
        if (balance < 0) {
            throw new Exception("Balance cannot be negative!");
        } else {
            this.balance = balance;
        }
    }
}
