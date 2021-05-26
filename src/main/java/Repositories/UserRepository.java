package Repositories;

import Database.SqlConfig;
import Models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public void insertUsers() {

        String user1 = "INSERT INTO food_delivery.users (first_name, last_name, password, location, card_id, telephone_number, email, balance)"
                + " VALUES ('Dragos', 'Balmau', '123456789', 'Arges, Pitesti', '12341234123134', '0754713281', 'dragos@gmail.com', 13)";
        String user2 = "INSERT INTO food_delivery.users (first_name, last_name, password, location, card_id, telephone_number, email, balance)"
                + "VALUES ('Andrei', 'Popescu', '12341234', 'Bucuresti', '1234123412341234', '0711111111', 'test@email.com', 0.34);";
        String user3 = "INSERT INTO food_delivery.users (first_name, last_name, password, location, card_id, telephone_number, email, balance) "
                + "VALUES ('Adrian', 'Ionescu', 'RadiusPa55', 'Baicoi', null, null, null, 0);";
        Connection connection = SqlConfig.getDataBaseConnection();

        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(user1);
            statement.executeUpdate();
            System.out.println("Added user");
            statement = connection.prepareStatement(user2);
            statement.executeUpdate();
            System.out.println("Added user");
            statement = connection.prepareStatement(user3);
            statement.executeUpdate();
            System.out.println("Added user");
        } catch (SQLException exception) {
            System.err.println("Cannot insert into table " + exception.getErrorCode());
        }
    }

    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id=?";
        Connection connection = SqlConfig.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User(resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7), resultSet.getDouble(8));
                int ID = resultSet.getInt(1);
                user.setID(String.valueOf(ID));
                return user;
            }

        } catch (SQLException exception) {
            System.err.println("Could not get user");
        }
        return null;
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        Connection connection = SqlConfig.getDataBaseConnection();
        List<User> allUsers = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User currentUser = new User(resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7), resultSet.getDouble(8));
                int id = resultSet.getInt(1);
                currentUser.setID(String.valueOf(id));
                allUsers.add(currentUser);
            }

        } catch (SQLException exception) {
            System.err.println("Could not get users");
        }
        return allUsers;
    }

    public void updateUserFirstNameById(String newFirstName, int id) {
        String sql = "UPDATE users SET first_name=? WHERE id=?";
        Connection connection = SqlConfig.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newFirstName);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

            System.out.println("Updated name of user with id " + id);

        } catch (SQLException exception) {
            System.err.println("Error while updating user with id " + id);
        }
    }

    public void deleteUserById(int id) {

        String sql = "DELETE FROM users WHERE id = ?";
        Connection connection = SqlConfig.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Deleted user with id: " + id);

        } catch (SQLException exception) {
            System.err.println("Error while deleting user with id " + id + " " + exception.getErrorCode());
        }
    }

}