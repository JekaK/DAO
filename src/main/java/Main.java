import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.net.URI;
import java.sql.*;

/**
 * Created by Eugeniy Krukun on 22.05.2016.
 */
public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    public static void main(String[] args) throws SQLException {


        MySqlDaoFactory factory = new MySqlDaoFactory();
        MySqlDaoUsers users = new MySqlDaoUsers(factory.getConnection());

        User user = users.read(11);
        users.delete(user);
    }
}
