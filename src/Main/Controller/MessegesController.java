package Main.Controller;

import Main.Models.Discipline;
import Main.Models.Messeges;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MessegesController {
    public static void getAllMesseges() throws SQLException, ClassNotFoundException {

        Messeges messeges = new Messeges();

        System.out.println("№ | дата создания | путь к файлу | текст | название | user id");
        System.out.println("-----------------");

        ArrayList<Messeges> array = messeges.getAll();

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i).getId() + " | " + array.get(i).getTitle());
        }
    }

    public static void addMesseges() throws SQLException, ClassNotFoundException {
        Discipline discipline = new Discipline();
        Scanner input = new Scanner(System.in);

        getAllMesseges();
        System.out.println("Введите название новой дисциплины");

        String name = input.nextLine();
        discipline.add(name);
        getAllMesseges();

    }


    public static void updateMesseges() throws SQLException, ClassNotFoundException {

        Discipline discipline = new Discipline();
        Scanner input = new Scanner(System.in);
        getAllMesseges();

        System.out.println("Введите новое название дисциплины");
        String name = input.nextLine();

        System.out.println("Введите номер дисциплины которой надо изменить");
        Integer id = input.nextInt();

        discipline.update(id, name);
        getAllMesseges();

        System.out.println(discipline.show(id));
        System.out.println("№: " +discipline.show(id).getId()+ ") Название: " + discipline.show(id).getName());
    }


    public static void deleteMesseges() throws SQLException, ClassNotFoundException {

        Discipline discipline = new Discipline();
        Scanner input = new Scanner(System.in);
        getAllMesseges();

        getAllMesseges();
        System.out.println("Введите номер дисциплины");
        Integer id = input.nextInt();

        discipline.delete(id);
        getAllMesseges();


    }



}
