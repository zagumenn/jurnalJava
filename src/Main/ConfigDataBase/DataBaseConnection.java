package Main.ConfigDataBase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnection extends Connect {
    //используем библиотеку для работы с базами данных CONNECTION
    static Connection dbConnect;

    //подключаем драйвер
//Метод вывода результат подключения к базе данных
    public static Connection getDbConnect() throws SQLException, ClassNotFoundException {
//        String connectorString = "jdbc:mysql://"+host+"/"+nameDB+"";
        String connectorString = "jdbc:mysql://192.168.3.211:3306/rybin1_jurYPAT";
        //подключаю драйвер
        Class.forName("com.mysql.cj.jdbc.Driver");
        //само подключение через метод
        dbConnect = DriverManager.getConnection(connectorString, userNameDB, passwordDB);
        System.out.println("Успешное подключение к Базе Данных!!!");
        return dbConnect;
    }
}
