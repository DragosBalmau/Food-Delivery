package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Command {

    private String ID;
    private Deliveryman deliveryman = new Deliveryman();
    private User user = new User();
    private Restaurant restaurant = new Restaurant();

    private List<Product> products = new ArrayList();
    private String productsList;

    public Command(String string, String resultSetString, String setString, String s) {}

    public Command(String ID, Deliveryman deliveryman, User user) {
        this.ID = ID;
        this.deliveryman = deliveryman;
        this.user = user;
    }

    public Command(String ID, String deliverymanID, String userID) {
        this.ID = ID;
        this.user.setID(userID);
        this.deliveryman.setID(deliverymanID);
    }

    public Command(String productsList, User user, Restaurant restaurant, Deliveryman deliveryman) {
        this.deliveryman = deliveryman;
        this.user = user;
        this.restaurant = restaurant;
        this.productsList = productsList;
    }

    public void orderCommand() {
        this.products = products.stream().sorted().collect(Collectors.toList());
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Deliveryman getDeliveryman() {
        return deliveryman;
    }

    public void setDeliveryman(Deliveryman deliveryman) {
        this.deliveryman = deliveryman;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        return "Models.Command{" +
                "ID='" + ID + '\'' +
                ", deliveryman=" + deliveryman +
                ", user=" + user +
                ", products=" + products +
                '}';
    }
}
