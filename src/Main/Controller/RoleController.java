package Main.Controller;

import Main.Models.Role;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;

public class RoleController extends Role {

    public static void getAllRoles() throws SQLException, ClassNotFoundException, InvocationTargetException {
        Role role = new Role();

        System.out.println("Все роли пользователей в журнале");
        System.out.println(" Имя роли");
        System.out.println("----------------------------------");
        role.allRoles().forEach((Integer id, String name) ->
        {
            System.out.println(id + " " + name);
        });

    }

    public static void addRole() throws SQLException, ClassNotFoundException {

        Role role = new Role();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name ROLE");
        input.nextLine();
        String name = input.nextLine();
        role.add(name);


    }

    public static void updateRole() throws SQLException, ClassNotFoundException {
        Role role = new Role();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter new name ROLE");
        String newName = input.nextLine();

        System.out.println("№ ID ROLE");
        Integer id = input.nextInt();

        role.update(id, newName);
    }
    public static void deleteRole() throws SQLException, ClassNotFoundException {
        Role role = new Role();
        Scanner input = new Scanner(System.in);

        System.out.println("Select the № id ROLE of the role to be removed");
        Integer id = input.nextInt();

        role.delete(id);




    }
    public static void getOneRole(Integer id) throws SQLException, ClassNotFoundException {
        Role role = new Role();
        System.out.println("№ name ROLE");
        System.out.println(role.oneRole(id).getId() + "" + role.oneRole(id).getName());
        System.out.println();
    }
}



