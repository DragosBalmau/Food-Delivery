import java.io.IOException;
import java.util.Scanner;
import Database.InitializeTables;

public class Main {
    public static void main(String[] args) throws IOException {

        Service service = new Service();
        service.clearLogFile();

        Scanner input = new Scanner(System.in);
        System.out.println("1.Stage 2 -> CSVs\n" +
                "2.Database\n" +
                "3.Exit\n");
        switch (Integer.parseInt(input.nextLine())) {
            case 1 -> {
                service.loadData();
                while (true) {
                    System.out.println("1.Create an user\n" +
                            "2.Add an restaurant\n" +
                            "3.Create a deliveryman account\n" +
                            "4.List all users\n" +
                            "5.List all deliverymen\n" +
                            "6.List all restaurants\n" +
                            "7.List all commands\n" +
                            "8.Exit\n");
                    switch (Integer.parseInt(input.nextLine())) {
                        case 1 -> service.createUser();
                        case 2 -> service.createDeliveryman();
                        case 3 -> service.createRestaurant();
                        case 4 -> service.listUsers();
                        case 5 -> service.listDeliverymen();
                        case 6 -> service.listRestaurants();
                        case 7 -> service.listCommands();
                        case 8 -> {
                            return;
                        }

                    }
                }
            }
            case 2 -> {
                InitializeTables.setUpDb();
                service.insertUsersInDB();
                service.updateUserInDB();
                service.deleteUserInDB();

                service.insertRestaurantsInDB();
                service.updateRestaurantInDB();
                service.deleteRestaurantInDB();

                service.insertDeliveymenInDB();
                service.updateDeliverymanInDB();
                service.deleteDeliverymanInDB();

                service.insertCommandsInDB();
                service.updateCommandsInDB();
                service.deleteCommandsInDB();
            }
            case 3 -> {
                return;
            }

        }

    }
}
