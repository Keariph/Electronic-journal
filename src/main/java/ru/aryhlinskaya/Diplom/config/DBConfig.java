package ru.aryhlinskaya.Diplom.config;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.*;
@Component
public class DBConfig {
    Connection connection;
    String url = "jdbc:postgresql://localhost:5432/Diplom";
    String login = "postgres";
    String password = "qwert";
    public DBConfig(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, login, password);
        }
        catch (SQLException | ClassNotFoundException ex) {
        }
    }

    public List<Map<String, Object>> query(String sql)  {
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        Map<String, Object> row = null;
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            Integer columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                row = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnName(i), resultSet.getObject(i));
                }
                resultList.add(row);
            }
            statement.close();
            return resultList;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void update(String sql){
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String sql){
        try(Statement statement = connection.createStatement()){
            statement.execute(sql);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
