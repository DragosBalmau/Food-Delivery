package Repositories;
import Database.SqlConfig;
import Models.Deliveryman;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliverymanRepository {
    public void insertDeliverymen() {

        String deliveryman1 = "INSERT INTO food_delivery.deliverymen (first_name, last_name, password, location, card_id, telephone_number, email, balance, vehicle_type, rating) "
                + " VALUES ('Victor', 'Pletosu', '123456parola', 'Bucuresti', '1232341234', '0770390118', 'vico@email.com', 90, 'trotineta', 1);";
        String deliveryman2 = "INSERT INTO food_delivery.deliverymen (first_name, last_name, password, location, card_id, telephone_number, email, balance, vehicle_type, rating) "
                + " VALUES ('Tipy', 'PeYoutube', 'parolaCCNA2', 'Bucuresti', '09090090', '0987654434', 'test@test.com', 0, 'cupejosu', 3);";
        String deliveryman3 = "INSERT INTO food_delivery.deliverymen (first_name, last_name, password, location, card_id, telephone_number, email, balance, vehicle_type, rating) "
                + "VALUES ('Alex', 'Alexandru', '4234878hjhg', 'Bucuresti', '757575757', '0987654321', 'dragan@ccna.com', 0.004, 'masina', 5);";
        String deliveryman4 = "INSERT INTO food_delivery.deliverymen (first_name, last_name, password, location, card_id, telephone_number, email, balance, vehicle_type, rating) "
                + "VALUES ('Alex', 'Alexandru', '42348723hjhg', 'Bucuresti', '75755757', '0987654321', 'dragan@ccna.com', 0.004, 'masina', 5);";
        Connection connection = SqlConfig.getDataBaseConnection();

        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(deliveryman1);
            statement.executeUpdate();
            System.out.println("Added deliveryman");

            statement = connection.prepareStatement(deliveryman2);
            statement.executeUpdate();
            System.out.println("Added deliveryman");

            statement = connection.prepareStatement(deliveryman3);
            statement.executeUpdate();
            System.out.println("Added deliveryman");

            statement = connection.prepareStatement(deliveryman4);
            statement.executeUpdate();
            System.out.println("Added deliveryman");

        } catch (SQLException exception) {
            System.err.println("Cannot insert into table " + exception.getErrorCode());
        }
    }

    public Deliveryman getDeliverymanById(int id) {
        String sql = "SELECT * FROM deliverymen WHERE id=?";
        Connection connection = SqlConfig.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Deliveryman deliveryman = new Deliveryman(resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7), resultSet.getDouble(8),
                        resultSet.getString(9), resultSet.getInt(10));
                int ID = resultSet.getInt(1);
                deliveryman.setID(String.valueOf(ID));
                return deliveryman;
            }

        } catch (SQLException exception) {
            System.err.println("Could not get deliveryman");
        }
        return null;
    }

    public List<Deliveryman> getAllDeliverymen() {
        String sql = "SELECT * FROM deliverymen";
        Connection connection = SqlConfig.getDataBaseConnection();
        List<Deliveryman> allDeliverymen = new ArrayList<Deliveryman>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Deliveryman currentDeliveryman = new Deliveryman(resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7), resultSet.getDouble(8),
                        resultSet.getString(9), resultSet.getInt(10));
                int id = resultSet.getInt(1);
                currentDeliveryman.setID(String.valueOf(id));
                allDeliverymen.add(currentDeliveryman);
            }

        } catch (SQLException exception) {
            System.err.println("Could not get deliveryman");
        }
        return allDeliverymen;
    }

    public void updateDeliverymanFirstNameById(String newFirstName, int id) {
        String sql = "UPDATE deliverymen SET first_name=? WHERE id=?";
        Connection connection = SqlConfig.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newFirstName);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

            System.out.println("Updated name of deliveryman with id " + id);

        } catch (SQLException exception) {
            System.err.println("Error while updating deliveryman with id " + id);
        }
    }

    public void deleteDeliverymanById(int id) {

        String sql = "DELETE FROM deliverymen WHERE id = ?";
        Connection connection = SqlConfig.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Deleted deliveryman with id: " + id);

        } catch (SQLException exception) {
            System.err.println("Error while deleting deliveryman with id " + id + " " + exception.getErrorCode());
        }
    }
}
