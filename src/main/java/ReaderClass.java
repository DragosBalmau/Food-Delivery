import java.util.Scanner;

public class ReaderClass {

    private Scanner input = new Scanner(System.in);

    public User readCreateUser() {

        System.out.println("First name: ");
        String firstName = this.input.nextLine();
        System.out.println("\nLast name: ");
        String lastName = this.input.nextLine();
        System.out.println("\nID: ");
        String ID = this.input.nextLine();
        System.out.println("\nPassword: ");
        String password = this.input.nextLine();

        return new User(firstName, lastName, ID, password);

    }

    public Location readLocation() {

        System.out.println("Street: ");
        String street = this.input.nextLine();
        System.out.println("\nStreet number: ");
        String streetNumber = this.input.nextLine();
        System.out.println("\nCity: ");
        String city = this.input.nextLine();
        System.out.println("\nZip code: ");
        String zipCode = this.input.nextLine();

        return new Location(street, Integer.parseInt(streetNumber), city, zipCode);

    }

    public Restaurant readCreateRestaurant() {

        System.out.println("Name of the Restaurant: ");
        String name = this.input.nextLine();
        System.out.println("\nTelephone number: ");
        String telephoneNumber = this.input.nextLine();
        System.out.println("\nLocation: ");
        String location = this.input.nextLine();

        return new Restaurant(name, telephoneNumber, readLocation());

    }

    public Deliveryman readCreateDeliveryman() {

        System.out.println("First name: ");
        String firstName = this.input.nextLine();
        System.out.println("\nLast name: ");
        String lastName = this.input.nextLine();
        System.out.println("\nID: ");
        String ID = this.input.nextLine();
        System.out.println("\nPassword: ");
        String password = this.input.nextLine();

        return new Deliveryman(firstName, lastName, ID, password);

    }


}
