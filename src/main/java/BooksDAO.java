import java.sql.SQLException;
import java.util.List;

/**
 * Created by Eugeniy Krukun on 22.05.2016.
 */
public interface BooksDAO {
    public boolean create(Book book);
    public Book read(int key) throws SQLException;
    public boolean update(Book book);
    public void delete(Book book) throws SQLException;
    public List<Book> getAll() throws SQLException;
}
