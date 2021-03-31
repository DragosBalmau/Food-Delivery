import java.util.ArrayList;
import java.util.List;

public class Deliveryman extends User{

    private String vehicleType;
    List<Command> commandHistory = new ArrayList();
    private int rating = 0;

    public Deliveryman(String firstName, String lastName, String ID, String password) {
        super(firstName, lastName, ID, password);
    }

}
