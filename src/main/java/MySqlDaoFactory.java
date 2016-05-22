import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Eugeniy Krukun on 22.05.2016.
 */
public class MySqlDaoFactory implements DAOFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    @Override
    public BooksDAO getBookDao(Connection connection) {
        return new MySqlDaoBooks(connection);
    }

    @Override
    public UsersDAO getUsersDao(Connection connection) {
        return new MySqlDaoUsers(connection);
    }
}
