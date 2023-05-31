package Main;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;

import static Main.Controller.RoleController.getAllRoles;
import static Main.Controller.RoleController.*;
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException,  InvocationTargetException {
    getAllRoles();
    //ввод одной роли
        addRole();
        updateRole();
        deleteRole();
        Scanner input = new Scanner(System.in);
        Integer id = input.nextInt();
        getOneRole(id);

    }
}
