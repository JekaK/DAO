import java.sql.SQLException;
import java.util.List;

/**
 * Created by Eugeniy Krukun on 22.05.2016.
 */
public interface UsersDAO {
    public boolean create(User user) throws SQLException;
    public User read(int key) throws SQLException;
    public boolean update(User user);
    public void delete(User user);
    public List<User> getAll() throws SQLException;
}
