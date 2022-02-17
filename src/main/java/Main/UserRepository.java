package Main;

import User.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static config.DataBaseConfig.DatabaseConfig.*;

public class UserRepository {


    Connection connection;


    public List<User> init() {
        List<User> users = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DB_USER, USER, PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("password"), resultSet.getBoolean("authorization")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
