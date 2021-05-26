import Models.Deliveryman;
import Models.Location;
import Models.Restaurant;
import Models.User;

import java.util.Scanner;

public class ReaderClass {

    private Scanner input = new Scanner(System.in);

    public User readCreateUser() {

        System.out.println("First name: ");
        String firstName = this.input.nextLine();
        System.out.println("Last name: ");
        String lastName = this.input.nextLine();
        System.out.println("ID: ");
        String ID = this.input.nextLine();
        System.out.println("Password: ");
        String password = this.input.nextLine();

        return new User(firstName, lastName, ID, password);

    }

    public Location readLocation() {

        System.out.println("Street: ");
        String street = this.input.nextLine();
        System.out.println("Street number: ");
        String streetNumber = this.input.nextLine();
        System.out.println("City: ");
        String city = this.input.nextLine();
        System.out.println("Zip code: ");
        String zipCode = this.input.nextLine();

        return new Location(street, Integer.parseInt(streetNumber), city, zipCode);

    }

    public Restaurant readCreateRestaurant() {

        System.out.println("Name of the Models.Restaurant: ");
        String name = this.input.nextLine();
        System.out.println("Telephone number: ");
        String telephoneNumber = this.input.nextLine();
        System.out.println("Models.Location: ");
        String location = this.input.nextLine();

        return new Restaurant(name, telephoneNumber, readLocation());

    }

    public Deliveryman readCreateDeliveryman() {

        System.out.println("First name: ");
        String firstName = this.input.nextLine();
        System.out.println("Last name: ");
        String lastName = this.input.nextLine();
        System.out.println("ID: ");
        String ID = this.input.nextLine();
        System.out.println("Password: ");
        String password = this.input.nextLine();

        return new Deliveryman(firstName, lastName, ID, password);

    }


}
