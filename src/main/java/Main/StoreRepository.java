package Main;

import Tool.*;
import User.User;
import config.DataBaseConfig.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreRepository {


    Connection connection;


    public List<User> init() {

        List<User> users = new ArrayList<>();
        List<String> coloumn = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DatabaseConfig.DB_Storage, DatabaseConfig.USER, DatabaseConfig.PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement("SHOW COLUMNS FROM tool");
            /*ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("password"), resultSet.getBoolean("authorization")));
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<Tools> getList(String string) {

        List<Tools> toolList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(string);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getString("geometry").contains("DEGREE")) {
                    toolList.add(new Drill(resultSet.getInt("id"), resultSet.getString("toolcode"),
                            resultSet.getDouble("diameter"), resultSet.getDouble("length"),
                            ToolMaterial.valueOf(resultSet.getString("material").toString()),
                            resultSet.getBoolean("coated"), resultSet.getString("description"),
                            resultSet.getBoolean("critic"),
                            DrillGeometry.valueOf(resultSet.getString("geometry").toString()),
                            resultSet.getInt("numberof_edge"), resultSet.getInt("minquantity"),
                            resultSet.getInt("quantity")));
                } else {
                    toolList.add(new Cutter(resultSet.getInt("id"), resultSet.getString("toolcode"),
                            resultSet.getDouble("diameter"), resultSet.getDouble("length"),
                            ToolMaterial.valueOf(resultSet.getString("material").toString()),
                            resultSet.getBoolean("coated"), resultSet.getString("description"),
                            resultSet.getBoolean("critic"),
                            CutterGeometry.valueOf(resultSet.getString("geometry").toString()),
                            resultSet.getInt("numberof_edge"), resultSet.getInt("minquantity"),
                            resultSet.getInt("quantity")));
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toolList;
    }

    public List<String> getMenu(String string) {
        List<String> menus = new ArrayList<>();
        try {

            PreparedStatement prstatement = connection.prepareStatement(string);
            ResultSet resultSet = prstatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            for (int i = 2; i <= resultSetMetaData.getColumnCount(); i++) {
                if (string.contains("tool") && i != 8 && i != 11 && i != 12) {
                    menus.add(resultSetMetaData.getColumnName(i));
                } else if (string.contains("product") && i <= 7) {
                    menus.add(resultSetMetaData.getColumnName(i));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menus;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
