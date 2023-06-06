package Main.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static Main.ConfigDataBase.ConstDB.*;
import static Main.ConfigDataBase.DataBaseConnection.getDbConnect;

public class Messages {

    //поля данных
    private Integer id;
    private Integer user_id;
    private Integer user_Recipient_Id;
    private String dateOfCreation;

    private String pathFile;
    private String text;
    private String title;


    //конструкторы
    public Messages() {
    }

    public Messages(
            Integer id,
            Integer user_id,
            Integer user_Recipient_Id,
            String title,
            String text,
            String dateOfCreation,
            String pathFile) throws SQLException, ClassNotFoundException {
        this.id = id;
        this.dateOfCreation = dateOfCreation;
        this.user_Recipient_Id = user_Recipient_Id;
        this.pathFile = pathFile;
        this.text = text;
        this.title = title;
        this.user_id = user_id;

    }

    public  ArrayList<Messages> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Messages> messages = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_MESSEGES ;

        Statement statement = getDbConnect().createStatement();

        ResultSet result = statement.executeQuery(query);

        while (result.next()) {

            messages.add(new Messages(result.getInt("id"),
                    result.getInt("user_id"),
                    result.getInt(TABLE_MESSEGES_USER_RECIPIENT_ID),
                    result.getString(TABLE_MESSEGES_TITLE),
                    result.getString(TABLE_MESSEGES_TEXT),
                    result.getString(TABLE_MESSEGES_PATH_FILE),
                    result.getString(TABLE_MESSEGES_DATE_OF_CREATION)
            ));

        }
        return messages;
    }

    public void add(Integer users_Recipient_Id, Integer id, Integer user_Id, String dateOfCreation, String pathFile, String title, String text ) throws SQLException, ClassNotFoundException {

        String query = "INSERT INTO " + TABLE_MESSEGES + " ("+ TABLE_MESSEGES_USER_RECIPIENT_ID + ","
                + TABLE_MESSEGES_ID + ","
                + TABLE_MESSEGES_DATE_OF_CREATION + ","
                + TABLE_MESSEGES_PATH_FILE + ","
                + TABLE_MESSEGES_TITLE + ","
                + TABLE_MESSEGES_TEXT + ","
                + TABLE_MESSEGES_USER_ID+ ") VALUES ("
                + users_Recipient_Id + ",'" + id + ",'" + dateOfCreation + "','" + pathFile + "','"+  title + "','" + text + "','"+ user_Id +"')";
        System.out.println(query);

        Statement statement = getDbConnect() .createStatement();

        statement.executeUpdate(query);
    }
    //обновить
    public void update(Integer users_Recipient_Id, Integer id, Integer user_Id, String dateOfCreation, String pathFile, String title, String text ) throws SQLException, ClassNotFoundException {
        String query = "UPDATE " + TABLE_MESSEGES + " ("+ TABLE_MESSEGES_USER_RECIPIENT_ID + ","
                + TABLE_MESSEGES_ID + ","
                + TABLE_MESSEGES_DATE_OF_CREATION + ","
                + TABLE_MESSEGES_PATH_FILE + ","
                + TABLE_MESSEGES_TITLE + ","
                + TABLE_MESSEGES_TEXT + ","
                + TABLE_MESSEGES_USER_ID+ ") VALUES ("
                + users_Recipient_Id + ",'" + id + ",'" + dateOfCreation + "','" + pathFile + "','"+  title + "','" + text + "','"+ user_Id +"')";
        System.out.println(query);

        Statement statement = getDbConnect() .createStatement();

        statement.executeUpdate(query);
    }
    //удалить


    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public Integer getUser_Recipient_Id() {
        return user_Recipient_Id;
    }

    public Integer getId() {
        return id;
    }

    public String getPathFile() {
        return pathFile;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
