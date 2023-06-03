package Main.Controller;

import Main.Models.User;

import java.sql.SQLException;
import java.util.Scanner;

public class UsersControler extends User {


    public static void getAllUsers() throws SQLException, ClassNotFoundException {
        User users = new User();
        System.out.println("Все пользователи в журнале");
        System.out.println("№ | РОЛЬ | ИМЯ | ЛОГИН | ПАРОЛЬ |");
        System.out.println("-----------------------------------");
        for(int i = 0; i< users.getAll().length; i++){
            System.out.println(users.getAll()[i].getIdUser() + " "
                    + users.getAll()[i].getRoleId() + " | "
                    + users.getAll()[i].getNameUser() + " | "
                    + users.getAll()[i].getLoginUser() + " | "
                    + users.getAll()[i].getPasswordUser() + " | "
        );
        }
    }
    public static  void addUsers() throws SQLException, ClassNotFoundException {
        User user = new User();
        Scanner input = new Scanner(System.in);

        System.out.println("Введите Имя пользователя");
        String name = input.nextLine();
        System.out.println("Введите пароль");
        String password = input.nextLine();
        System.out.println("Ввдетите логин");
        String login = input.nextLine();
        System.out.println("Введите id пользователя");
        Integer roleId = input.nextInt();


        user.add(roleId, name, login, password);
    }

    public static  void updateUsers() throws SQLException, ClassNotFoundException {
        User user = new User();
        Scanner input = new Scanner(System.in);
        System.out.println("Введите Имя пользователя");
        String name = input.nextLine();
        System.out.println("Введите новый пароль");
        String password = input.nextLine();
        System.out.println("Ввдетите новый логин");
        String login = input.nextLine();
        System.out.println("Введите id пользователя");
        Integer roleId = input.nextInt();

        user.update(roleId, name, login, password);
    }
}
