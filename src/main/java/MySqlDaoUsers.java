import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugeniy Krukun on 22.05.2016.
 */
public class MySqlDaoUsers extends AbstractJDBSDao implements UsersDAO {
    private final Connection connection;

    public MySqlDaoUsers(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO mydb.users (Name,Surname,Email,Password,Rating,Status,Country) VALUES (?,?,?,?,?,?,?);";
    }

    @Override
    public String getReadQuery() {
        return "SELECT * FROM mydb.users WHERE id = ?;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE mydb.users\n" +
                "SET Name=?,Surname=?,Email=?,Password=?,Rating=?,Status=?,Country=?\n" +
                "WHERE ID=?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM mydb.users WHERE Name=? AND Surname=? AND Email=? AND Password=? AND Rating=? AND Status=? AND Country=?";
    }

    @Override
    public boolean create(User user) {
        String sql = getCreateQuery();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setFloat(5, user.getRating());
            preparedStatement.setInt(6, user.getStatus());
            preparedStatement.setString(7, user.getCountry());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public User read(int id) throws SQLException {
        String sql = getReadQuery();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet set = statement.executeQuery();
        set.next();

        User user = new User();
        user.setID(set.getInt("ID"));
        user.setName(set.getString("Name"));
        user.setSurname(set.getString("Surname"));
        user.setRating(set.getFloat("Rating"));
        user.setStatus(set.getInt("Status"));
        user.setCountry(set.getString("Country"));
        user.setEmail(set.getString("Email"));
        user.setPassword(set.getString("Password"));
        return user;
    }

    @Override
    public boolean update(User user) {
        String sql = getUpdateQuery();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setFloat(5, user.getRating());
            statement.setInt(6, user.getStatus());
            statement.setString(7, user.getCountry());
            statement.setInt(8,user.getID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM mydb.users";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet set = statement.executeQuery();
        while (set.next()) {
            User user = new User();
            user.setID(set.getInt("ID"));
            user.setName(set.getString("Name"));
            user.setSurname(set.getString("Surname"));
            user.setRating(set.getFloat("Rating"));
            user.setStatus(set.getInt("Status"));
            user.setCountry(set.getString("Country"));
            user.setEmail(set.getString("Email"));
            user.setPassword(set.getString("Password"));
            users.add(user);
        }
        return users;
    }
}
