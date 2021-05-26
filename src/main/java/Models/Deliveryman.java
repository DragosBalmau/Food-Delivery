package Models;

import java.util.ArrayList;
import java.util.List;

public class Deliveryman extends User {

    private String vehicleType;
    List<Command> commandHistory = new ArrayList();
    private int rating = 0;

    public Deliveryman() {}

    public Deliveryman(String firstName, String lastName, String ID, String password) {
        super(firstName, lastName, ID, password);
    }

    public Deliveryman(String firstName, String lastName, String ID, String password, String location, String cardID, String telephoneNumber, double balance, String vehicleType, int rating) {
        super(firstName, lastName, ID, password, location, cardID, telephoneNumber, balance);
        this.vehicleType = vehicleType;
        this.rating = rating;
    }

    public Deliveryman(String firstName, String lastName, String password, String location, String cardID, String telephoneNumber, double balance, String vehicleType, int rating) {
        super(firstName, lastName, password, location, cardID, telephoneNumber, balance);
        this.vehicleType = vehicleType;
        this.rating = rating;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public List<Command> getCommandHistory() {
        return commandHistory;
    }

    public void setCommandHistory(List<Command> commandHistory) {
        this.commandHistory = commandHistory;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Models.Deliveryman{" +
                "vehicleType='" + vehicleType + '\'' +
                ", rating=" + rating +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ID='" + ID + '\'' +
                ", password='" + password + '\'' +
                ", location=" + location +
                ", cardID='" + cardID + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public String dataCSV() {
        return
                vehicleType + ',' +
                        rating + ',' +
                        firstName + ',' +
                        lastName + ',' +
                        ID + ',' +
                        password + ',' +
                        location + ',' +
                        cardID + ',' +
                        telephoneNumber + ',' +
                        email;
    }

}
