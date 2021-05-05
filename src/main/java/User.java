import java.util.ArrayList;
import java.util.List;

public class User implements WritableCSV{

    protected String firstName;
    protected String lastName;
    protected String ID;
    protected String password;
    protected Location location;
    protected String cardID;
    protected String telephoneNumber;
    protected String email; //TODO add this atribute into constructor and in reader methods

    private double balance;
    private List<Product> basket = new ArrayList();
    private List<Command> commandsHistory = new ArrayList();

    public User() {}

    public User(String firstName, String lastName, String ID, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.password = password;
    }

    //TODO conversie String to Location
    public User(String firstName, String lastName, String ID, String password, String location, String cardID, String telephoneNumber, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.password = password;
        this.cardID = cardID;
        this.telephoneNumber = telephoneNumber;

    }

    public void addToBasket(Product product) {
        this.basket.add(product);
    }

    public List<Product> getBasket() {
        return basket;
    }

    public void setBasket(List<Product> basket) {
        this.basket = basket;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Command> getCommandsHistory() {
        return commandsHistory;
    }

    public void setCommandsHistory(List<Command> commandsHistory) {
        this.commandsHistory = commandsHistory;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ID='" + ID + '\'' +
                ", password='" + password + '\'' +
                ", location=" + location +
                ", cardID='" + cardID + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", balance=" + balance +
                ", commandsHistory=" + commandsHistory +
                '}';
    }

    public String dataCSV() {
        return firstName + ',' +
                lastName + ',' +
                ID + ',' +
                password + ',' +
                location + ',' +
                cardID + ',' +
                telephoneNumber + ',' +
                balance;
    }
}
