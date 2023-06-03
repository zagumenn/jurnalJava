package Main.Controller;

import Main.Models.Discipline;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DisciplineController extends Discipline {

    public DisciplineController() throws SQLException, ClassNotFoundException {
    }

    public static void getTest() throws SQLException, ClassNotFoundException {
        Discipline discipline = new Discipline();

        System.out.println("� | ����������");
        System.out.println("-----------------");
        ArrayList<Discipline> array = discipline.getTestDisciplines();

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i).getId() + " | " + array.get(i).getName());
        }

    }

    public static void getAllDisciplines() throws SQLException, ClassNotFoundException {

        Discipline discipline = new Discipline();

        System.out.println("� | ����������");
        System.out.println("-----------------");

        ArrayList<Discipline> array = discipline.getAll();

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i).getId() + " | " + array.get(i).getName());
        }
    }

    public static void addDiscipline() throws SQLException, ClassNotFoundException {
        Discipline discipline = new Discipline();
        Scanner input = new Scanner(System.in);

        getAllDisciplines();
        System.out.println("������� �������� ����� ����������");

        String name = input.nextLine();
        discipline.add(name);
        getAllDisciplines();

    }


    public static void updateDiscipline() throws SQLException, ClassNotFoundException {

        Discipline discipline = new Discipline();
        Scanner input = new Scanner(System.in);
        getAllDisciplines();

        System.out.println("������� ����� �������� ����������");
        String name = input.nextLine();

        System.out.println("������� ����� ���������� ������� ���� ��������");
        Integer id = input.nextInt();

        discipline.update(id, name);
        getAllDisciplines();

        System.out.println(discipline.show(id));
        System.out.println("�: " +discipline.show(id).getId()+ ") ��������: " + discipline.show(id).getName());
    }


    public static void deleteDisciplines() throws SQLException, ClassNotFoundException {

        Discipline discipline = new Discipline();
        Scanner input = new Scanner(System.in);
        getAllDisciplines();

        getAllDisciplines();
        System.out.println("������� ����� ����������");
        Integer id = input.nextInt();

        discipline.delete(id);
        getAllDisciplines();


    }
    public  static  void  getOneDiscipline() throws SQLException, ClassNotFoundException {
        Discipline discipline = new Discipline();
        Scanner input =new Scanner(System.in);

        getAllDisciplines();
        System.out.println("������� ����� ����������");
        Integer id = input.nextInt();

        System.out.println(discipline.show(id));
        System.out.println("�: " +discipline.show(id).getId()+ ") ��������: " + discipline.show(id).getName());

    }
}









