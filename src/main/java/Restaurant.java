import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;
    private String telephoneNumber;
    private Location location;
    private List<Product> products = new ArrayList();

    public Restaurant(String name, String telephoneNumber, Location location) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", location=" + location +
                ", products=" + products +
                '}';
    }
}
