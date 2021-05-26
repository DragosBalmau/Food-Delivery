package Repositories;

import Database.SqlConfig;
import Models.Command;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandsRepository {

    public void insertCommands() {

        String command1 = "INSERT INTO food_delivery.commands (products, user_id_fk, restaurant_name_fk, deliverymen_id_fk) "
                + "VALUES ('mere, pere, banane', 1, 'Presto', 1);";
        String command2 = "INSERT INTO food_delivery.commands (products, user_id_fk, restaurant_name_fk, deliverymen_id_fk)"
                + " VALUES ('pizza', 2, 'Mc', 1);";
        String command3 = "INSERT INTO food_delivery.commands (products, user_id_fk, restaurant_name_fk, deliverymen_id_fk)"
                + " VALUES ('wrap pui', 3, 'KFC', 2);";
        String command4 = "INSERT INTO food_delivery.commands (products, user_id_fk, restaurant_name_fk, deliverymen_id_fk) "
                + "VALUES ('burger', 1, 'Presto', 3);";
        Connection connection = SqlConfig.getDataBaseConnection();

        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(command1);
            statement.executeUpdate();
            System.out.println("Added command");
            statement = connection.prepareStatement(command2);
            statement.executeUpdate();
            System.out.println("Added command");
            statement = connection.prepareStatement(command3);
            statement.executeUpdate();
            System.out.println("Added command");
            statement = connection.prepareStatement(command4);
            statement.executeUpdate();
            System.out.println("Added command");
        } catch (SQLException exception) {
            System.err.println("");
        }
    }

    public Command getCommandById(int id) {
        String sql = "SELECT * FROM commands WHERE id=?";
        Connection connection = SqlConfig.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Command command = new Command(resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5));
                int ID = resultSet.getInt(1);
                command.setID(String.valueOf(ID));
                return command;
            }

        } catch (SQLException exception) {
            System.err.println("Could not get command");
        }
        return null;
    }

    public List<Command> getAllCommands() {
        String sql = "SELECT * FROM commands";
        Connection connection = SqlConfig.getDataBaseConnection();
        List<Command> allCommands = new ArrayList<Command>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Command command = new Command(resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5));
                int ID = resultSet.getInt(1);
                command.setID(String.valueOf(ID));
                allCommands.add(command);
            }

        } catch (SQLException exception) {
            System.err.println("Could not get commands");
        }
        return allCommands;
    }

    public void updateCommandsProdusctsById(String productsList, int id) {
        String sql = "UPDATE commands SET products=? WHERE id=?";
        Connection connection = SqlConfig.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, productsList);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

            System.out.println("Updated command's products with id " + id);

        } catch (SQLException exception) {
            System.err.println("Error while updating command's products with id " + id);
        }
    }

    public void deleteCommandById(int id) {

        String sql = "DELETE FROM commands WHERE id = ?";
        Connection connection = SqlConfig.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Deleted command with id: " + id);

        } catch (SQLException exception) {
            System.err.println("Error while deleting command with id " + id + " " + exception.getErrorCode());
        }
    }

}
