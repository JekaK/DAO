import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Eugeniy Krukun on 22.05.2016.
 */
public interface DAOFactory {

    public Connection getConnection() throws SQLException;
    public BooksDAO getBookDao(Connection connection);
    public UsersDAO getUsersDao(Connection connection);
}
