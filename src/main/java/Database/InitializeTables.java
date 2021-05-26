package Database;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitializeTables {

    public static void setUpDb() {

        String createTableUsers =
                "create table if not exists users(" +
                "    id               int auto_increment primary key," +
                "    first_name       varchar(20)      not null," +
                "    last_name        varchar(20)      not null," +
                "    password         varchar(20)      not null," +
                "    location         varchar(50)      null," +
                "    card_id          varchar(16)      null," +
                "    telephone_number varchar(12)      null," +
                "    email            varchar(30)      null," +
                "    balance          double default 0 null" +
                ");";

        String createTableDeliverymen =
                "create table if not exists deliverymen(" +
                "    id               int auto_increment primary key," +
                "    first_name       varchar(20)      not null," +
                "    last_name        varchar(20)      not null," +
                "    password         varchar(20)      not null," +
                "    location         varchar(20)      null," +
                "    card_id          varchar(16)      null," +
                "    telephone_number varchar(12)      null," +
                "    email            varchar(20)      null," +
                "    balance          double default 0 null," +
                "    vehicle_type     varchar(20)      not null," +
                "    rating           int    default 0 null" +
                ");";

        String createTableRestaurants =
                "create table if not exists restaurants(" +
                "    name             varchar(20) not null primary key," +
                "    telephone_number varchar(12) not null," +
                "    location         varchar(50) not null" +
                ");";


        String createTableCommands =
            "create table if not exists commands(" +
            "    id                 int auto_increment primary key," +
            "    products           varchar(200) not null," +
            "    user_id_fk         int          not null," +
            "    restaurant_name_fk varchar(20)  not null," +
            "    deliverymen_id_fk  int          not null," +
            "    constraint commands_deliverymen_fk foreign key (deliverymen_id_fk) references deliverymen (id)," +
            "    constraint commands_restaurants_fk foreign key (restaurant_name_fk) references restaurants (name)," +
            "    constraint commands_users_fk foreign key (user_id_fk) references users (id)" +
            ");";

        Connection dataBaseConnection = SqlConfig.getDataBaseConnection();

        try {
            Statement statement = dataBaseConnection.createStatement();
            statement.execute(createTableUsers);
            System.out.println("Successfully created table users");
            statement.execute(createTableDeliverymen);
            System.out.println("Successfully created table deliverymen");
            statement.execute(createTableRestaurants);
            System.out.println("Successfully created table restaurants");
            statement.execute(createTableCommands);
        System.out.println("Successfully created table commands");
        } catch (SQLException exception) {
            System.err.println("Could not create table");
        }
    }

    private InitializeTables() { }
}