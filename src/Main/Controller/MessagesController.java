package Main.Controller;

import Main.Models.Messages;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MessagesController extends Messages {




    public static void getAllMessages() throws SQLException, ClassNotFoundException {

        Messages messages = new Messages();

        System.out.println("��� ���������");
        System.out.println("� | ���� �������� | ���� � ����� | ����� | �������� | user id");
        System.out.println("---------------------------------------------------------------");

        ArrayList<Messages> arrayMessages = messages.getAll();



        for (int i = 0; i < arrayMessages.size(); i++) {
            Messages messages1 = arrayMessages.get(i);
            System.out.println(arrayMessages.get(i).getId() + " | " +
                    messages1.getId() + " | " +
                    messages1.getUser_id() + " | " +
                    messages1.getUser_Recipient_Id() + " | " +
                    messages1.getTitle()  + " | " +
                    messages1.getText() + " | " +
                    messages1.getPathFile() + " | " +
                    messages1.getDateOfCreation());


        }


    }

    public static void addMessages() throws SQLException, ClassNotFoundException {
        Messages messages = new Messages();
        Scanner input = new Scanner(System.in);
        getAllMessages();

        System.out.println("������� id");
        Integer id = input.nextInt();
        System.out.println("������� ������");
        Integer dataCreation = input.nextInt();
        System.out.println("�������� ����");
        Integer pathFile = input.nextInt();
        System.out.println("������� ���������");
        String title = input.nextLine();
        System.out.println("������� �����");
        String text = input.nextLine();
        System.out.println("������� id ������������");
        Integer user_Id = input.nextInt();


       //messages.add(user_Id, id, dataCreation, pathFile, title, text );
            getAllMessages();

    }


    public static void updateMessages() throws SQLException, ClassNotFoundException {

        Messages messegas  = new Messages();
        Scanner input = new Scanner(System.in);

        System.out.println("������� ����� ���������");
        String title1 = input.nextLine();
        System.out.println("������� id ������������");
        Integer user_Id1 = input.nextInt();


        //messegas.add(title1,  user_Id1);
    }

   


    /*public static void deleteMessages() throws SQLException, ClassNotFoundException {

        Discipline discipline = new Discipline();
        Scanner input = new Scanner(System.in);
        getAllMessegas();

        getAllMessegas();
        System.out.println("������� ����� ����������");
        Integer id = input.nextInt();

        discipline.delete(id);
        getAllMessegas();


    }*/

    private static void getAllMessegas() {
    }


}
