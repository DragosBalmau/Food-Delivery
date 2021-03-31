import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Service service = new Service();

        Scanner input = new Scanner(System.in);
        switch (Integer.parseInt(input.nextLine())) {
            case 1 -> service.createUser();
            case 2 -> service.createRestaurant();
            case 3 -> service.createDeliveryman();
            case 4 -> service.listRestaurants();
            case 5 -> service.listUsers();
            case 6 -> service.listDeliverymen();
        }


    }
}
