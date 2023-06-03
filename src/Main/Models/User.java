package Main.Models;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static Main.ConfigDataBase.ConstDB.*;
import static Main.ConfigDataBase.DataBaseConnection.getDbConnect;

public class User {
    private Integer idUser;
    private Integer roleId;
    private String nameUser;
    private String loginUser;
    private String passwordUser;

    public User(Integer idUser,
                Integer roleId,
                String nameUser,
                String loginUser,
                String passwordUser) {

        this.idUser = idUser;
        this.roleId = roleId;
        this.nameUser = nameUser;
        this.loginUser = loginUser;
        this.passwordUser = passwordUser;
    }

    public User() {

    }

    public User[] getAll() throws SQLException, ClassNotFoundException {

        String query = "SELECT * FROM " + TABLE_USERS;
        String sql = "SELECT COUNT(*) AS count FROM 'Users'" + TABLE_USERS;

        Statement statement = getDbConnect().createStatement();
        ResultSet count = statement.executeQuery(sql);
        Integer countUsers = 0;
        while (count.next()) {
            countUsers = count.getInt("count");
        }
        ResultSet result = statement.executeQuery(query);
        int i = 0;
        User[] users = new User[0];
        while (result.next()){
        users[i] = new User(
                result.getInt("id"),
                result.getInt("roleid"),
                result.getString("name"),
                result.getString("login"),
                result.getString("password")
        );
    i++;
    }
    return users;
}
public void add(Integer roleId, String nameUser, String loginUser, String passwordUser) throws SQLException, ClassNotFoundException {

       String query = "INSERT INTO " + TABLE_USERS + " ("+ TABLE_USERS_ROLE_ID + ","
               + TABLE_USERS_NAME + ","
               + TABLE_USERS_LOGIN + ","
               + TABLE_USERS_PASSWORD + ") VALUES ("
               + roleId + ",'" + nameUser + "','" + loginUser + "','"+ passwordUser +"')";
    System.out.println(query);

    Statement statement = getDbConnect() .createStatement();

       statement.executeUpdate(query);

    }

    public void update(Integer roleId, String nameUser, String loginUser, String passwordUser) throws SQLException, ClassNotFoundException {
    String query = "UPDATE " + TABLE_USERS + " ("+ TABLE_USERS_ROLE_ID + ","
            + TABLE_USERS_NAME + ","
            + TABLE_USERS_LOGIN + ","
            + TABLE_USERS_PASSWORD + ") VALUES ("
            + roleId + ",'" + nameUser + "','" + loginUser + "','"+ passwordUser +"')";

    System.out.println(query);

    Statement statement = getDbConnect() .createStatement();

    statement.executeUpdate(query);






}


        public Integer getIdUser () {
            return idUser;
        }

        public Integer getRoleId () {
            return roleId;
        }

        public String getLoginUser () {
            return loginUser;
        }

        public String getNameUser () {
            return nameUser;
        }

        public String getPasswordUser () {
            return passwordUser;
        }
}