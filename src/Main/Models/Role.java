package Main.Models;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import static Main.ConfigDataBase.DataBaseConnection.getDbConnect;
import static Main.ConfigDataBase.ConstDB.*;

public class Role {
    private Integer id;
    private String name;

    public Role() {
    }

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //метод Вывода всех записей в Таблицы
    //Коллекция Мар - вывод ввиде Ассоциативного массива
    public HashMap<Integer, String> allRoles() throws SQLException, ClassNotFoundException, InvocationTargetException {
        String query = "SELECT * FROM Roles";

        //для отправки запросов в БД используется пакет
        Statement statement = getDbConnect().createStatement();
        ResultSet result = statement.executeQuery(query);
        HashMap<Integer, String> array = new HashMap<>();
        while (result.next()) {
            array.put(result.getInt("id"), result.getString("name"));
        }
        return array;
    }

    //метод вывода указанной записи
    public Role oneRole(Integer id) throws SQLException, ClassNotFoundException {
        Role role = new Role();
        String query = "SELECT * FROM " + ROLE_TABLE + " WHERE = " + id;
        Statement statement = getDbConnect().createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            role = new Role(result.getInt("id"), result.getString("name"));
        }
        return role;
    }

    //метод добавления записей
    public void add(String name) throws SQLException, ClassNotFoundException {

        //строка с текстом запроса Добавть запись
        String query = "INSERT INTO " + ROLE_TABLE + " (" + ROLE_TABLE_NAME + ") values ('" + name + "')";

        Statement statement = getDbConnect().createStatement();
        System.out.println(query);
        statement.executeUpdate(query);


    }

    //метод обновления одной записи
    public static void update(Integer id, String name) throws SQLException, ClassNotFoundException {
        String query = "UPDATE " + ROLE_TABLE + " SET " + ROLE_TABLE_NAME + " = '" + name + "' WHERE " + ROLE_TABLE_ID + " = " + id;
        Statement statement = getDbConnect().createStatement();
        System.out.println(query);
        statement.executeUpdate(query);


    }

    //метод удаления одной записи
    public static void delete(Integer id) throws SQLException, ClassNotFoundException {
        String query = "DELETE " + ROLE_TABLE + " WHERE " + ROLE_TABLE_ID + " = " + id;
        Statement statement = getDbConnect().createStatement();
        System.out.println(query);
        statement.executeUpdate(query);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

