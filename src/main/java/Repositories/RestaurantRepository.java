package Repositories;
import Database.SqlConfig;
import Models.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {

    public void insertRestaurants() {

        String restaurant1 = "INSERT INTO food_delivery.restaurants (name, telephone_number, location) "
                + "VALUES ('Presto', '0744332211', 'Bucuresti');";
        String restaurant2 = "INSERT INTO food_delivery.restaurants (name, telephone_number, location) "
                + "VALUES ('Mc', '0770380118', 'Bucuresti');";
        String restaurant3 = "INSERT INTO food_delivery.restaurants (name, telephone_number, location) "
                + "VALUES ('KFC', '0777777778', 'Bucuresti');";
        Connection connection = SqlConfig.getDataBaseConnection();

        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(restaurant1);
            statement.executeUpdate();
            System.out.println("Added restaurant");
            statement = connection.prepareStatement(restaurant2);
            statement.executeUpdate();
            System.out.println("Added restaurant");
            statement = connection.prepareStatement(restaurant3);
            statement.executeUpdate();
            System.out.println("Added restaurant");
        } catch (SQLException exception) {
            System.err.println("Cannot insert into table " + exception.getErrorCode());
        }
    }

    public Restaurant getRestaurantByName(String name) {
        String sql = "SELECT * FROM restaurants WHERE name=?";
        Connection connection = SqlConfig.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Restaurant(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
            }

        } catch (SQLException exception) {
            System.err.println("Could not get restaurant");
        }
        return null;
    }

    public List<Restaurant> getAllRestaurants() {
        String sql = "SELECT * FROM users";
        Connection connection = SqlConfig.getDataBaseConnection();
        List<Restaurant> allRestaurants = new ArrayList<Restaurant>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Restaurant currentRestaurant = new Restaurant(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
                allRestaurants.add(currentRestaurant);
            }

        } catch (SQLException exception) {
            System.err.println("Could not get users");
        }
        return allRestaurants;
    }

    public void updateRestaurantTelephoneNumberById(String telephoneNumber, String name) {
        String sql = "UPDATE restaurants SET telephone_number=? WHERE name=?";
        Connection connection = SqlConfig.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, telephoneNumber);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();

            System.out.println("Updated telephone number of restaurant with name " + telephoneNumber);

        } catch (SQLException exception) {
            System.err.println("Error while updating restaurant with telephone number " + telephoneNumber);
        }
    }

    public void deleteRestaurantByName(String name) {

        String sql = "DELETE FROM restaurants WHERE name = ?";
        Connection connection = SqlConfig.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println("Deleted restaurant with name: " + name);

        } catch (SQLException exception) {
            System.err.println("Error while deleting restaurant with name " + name + " " + exception.getErrorCode());
        }
    }


}
