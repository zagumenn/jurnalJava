package Main.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static Main.ConfigDataBase.ConstDB.*;
import static Main.ConfigDataBase.DataBaseConnection.getDbConnect;

public class Discipline {
    //���� ������
    private Integer id;
    private String name;

    //������������
    public Discipline() throws SQLException, ClassNotFoundException {
    }

    public Discipline(
            Integer id,
            String name
    ) throws SQLException, ClassNotFoundException {
        this.id=id;
        this.name=name;

    }


        //������
        //����� ������� � ������� ArrayList<>
        //������

        //�������� ���������  ArrayList<>
        public ArrayList<Discipline> getTestDisciplines() throws SQLException, ClassNotFoundException {
            Discipline disc1 = new Discipline(1, "����������");
            Discipline disc2 = new Discipline(2, "������");
            Discipline disc3 = new Discipline(3, "����������");
            ArrayList<Discipline> disciplines = new ArrayList<>();
            disciplines.add(disc1);
            disciplines.add(disc2);
            disciplines.add(disc3);
            disciplines.add(new Discipline(4, "�����������"));
            disciplines.add(new Discipline(5, "���������� ����"));

            return disciplines;
        }

        public  ArrayList<Discipline> getAll() throws SQLException, ClassNotFoundException {
            ArrayList<Discipline> disciplines = new ArrayList<>();
            String query = "SELECT * FROM `Disciplines`";

            Statement statement = getDbConnect().createStatement();

            ResultSet result = statement.executeQuery(query);

            while (result.next()){

                disciplines.add(new Discipline(result.getInt("id"), result.getString("name")));

            }
            return disciplines;

    }
       //��������
        public void add(String nameMesseges) throws SQLException, ClassNotFoundException {
            String query =  "INSERT INTO " + TABLE_DISC + " ("+ TABLE_DISC_NAME + ") VALUES ('"+ nameMesseges +"')";

            Statement statement = getDbConnect().createStatement();

            statement.executeUpdate(query);

    }
    //��������
    public void update(Integer id,String newName) throws SQLException, ClassNotFoundException {
                    statement("UPDATE " + TABLE_DISC + " SET "+
                            TABLE_DISC_NAME + " = " +
                            "'"+newName + "' WHERE " +
                            TABLE_DISC_ID + " = " + id);



    }
    //�������
    public void delete(Integer id) throws SQLException, ClassNotFoundException {
        statement("DELETE FROM "+ TABLE_DISC + " WHERE " + TABLE_DISC_ID+ " = " + id);


    }

    //����� ����� ������


    public Discipline show(Integer id) throws SQLException, ClassNotFoundException {

        String query = "SELECT * FROM " + TABLE_DISC + " WHERE " + TABLE_DISC_ID + " = " + id;
        Statement statement = getDbConnect().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        Discipline discipline = null;


        while (resultSet.next()) {
            discipline = new Discipline(resultSet.getInt("id"), resultSet.getString("name"));


        }
        return discipline;
    }
    //����� ����������� � �� � �������� �������
    static void  statement(String query) throws SQLException, ClassNotFoundException {
        Statement statement = getDbConnect().createStatement();
        statement.executeUpdate(query);
    }

    //�������
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //�������
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
