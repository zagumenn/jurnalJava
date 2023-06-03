package Main.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static Main.ConfigDataBase.ConstDB.*;
import static Main.ConfigDataBase.DataBaseConnection.getDbConnect;
import static Main.Models.Discipline.statement;

public class Messeges {

    //поля данных
    private Integer id;
    private Integer dateOfCreation;
    private String pathFile;
    private String text;
    private String title;
    private String user_id;

    //конструкторы
    public Messeges() {
    }

    public Messeges(
            Integer id,
            Integer dateOfCreation,
            String pathFile,
            String text,
            String title,
            String user_id


    ) throws SQLException, ClassNotFoundException {
        this.id = id;
        this.dateOfCreation = dateOfCreation;
        this.pathFile = pathFile;
        this.text = text;
        this.title = title;
        this.user_id = user_id;

    }

    public  ArrayList<Messeges> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Messeges> messeges = new ArrayList<>();
        String query = "SELECT * FROM `Messeges`";

        Statement statement = getDbConnect().createStatement();

        ResultSet result = statement.executeQuery(query);

        while (result.next()) {

            messeges.add(new Messeges(result.getInt("id"), result.getInt("dataOfCreation"), result.getString("pathFile"),
                    result.getString("text"), result.getString("title"), result.getString("user_id")));

        }
        return messeges;
    }

    public void add(String nameMesseges) throws SQLException, ClassNotFoundException {
        String query =  "INSERT INTO " + TABLE_DISC + " ("+ TABLE_DISC_NAME + ") VALUES ('"+ nameMesseges +"')";

        Statement statement = getDbConnect().createStatement();

        statement.executeUpdate(query);

    }
    //обновить
    public void update(Integer id,String newName) throws SQLException, ClassNotFoundException {
        statement("UPDATE " + TABLE_DISC + " SET "+
                TABLE_DISC_NAME + " = " +
                "'"+newName + "' WHERE " +
                TABLE_DISC_ID + " = " + id);
    }
    //удалить
    public void delete(Integer id) throws SQLException, ClassNotFoundException {
        statement("DELETE FROM "+ TABLE_DISC + " WHERE " + TABLE_DISC_ID+ " = " + id);


    }

    public Integer getId() {
        return id;
    }

    public Integer getDateOfCreation () {
            return dateOfCreation;
        }

        public String getPathFile () {
            return pathFile;
        }

        public String getText () {
            return text;
        }

        public String getTitle () {
            return title;
        }

        public String getUser_id () {
            return user_id;
        }


}
