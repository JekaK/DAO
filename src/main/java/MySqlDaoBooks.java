import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugeniy Krukun on 22.05.2016.
 */
public class MySqlDaoBooks extends AbstractJDBSDao implements BooksDAO {
    private final Connection connection;

    public MySqlDaoBooks(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(Book book) {
        String s = getCreateQuery();
        try {
            PreparedStatement statement = connection.prepareStatement(s);
            statement.setString(1, book.getAuthor());
            statement.setString(2, book.getTitle());
            statement.setFloat(3, book.getPrice());
            statement.setString(4, book.getPublisher());
            statement.setString(5, book.getOwner());
            statement.setString(6, book.getDescription());
            statement.setInt(7, book.getState());
            statement.setFloat(8, book.getRating());
            statement.setBoolean(9, book.getTrade());
            statement.setString(10, book.getLanguage());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Book read(int id) throws SQLException {
        String sql = getReadQuery();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet set = statement.executeQuery();
        set.next();

        Book book = new Book();
        book.setID(set.getInt("ID"));
        book.setRating(set.getFloat("Rating"));
        book.setAuthor(set.getString("Author"));
        book.setDescription(set.getString("Description"));
        book.setLanguage(set.getString("Language"));
        book.setOwner(set.getString("Owner"));
        book.setPrice(set.getFloat("Price"));
        book.setPublisher(set.getString("Publisher"));
        book.setState(set.getInt("State"));
        book.setTitle(set.getString("Title"));
        book.setTrade(set.getBoolean("Trade"));
        return book;
    }

    @Override
    public boolean update(Book book) {
        String sql = getUpdateQuery();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, book.getAuthor());
            statement.setString(2, book.getTitle());
            statement.setFloat(3, book.getPrice());
            statement.setString(4, book.getPublisher());
            statement.setString(5, book.getOwner());
            statement.setString(6, book.getDescription());
            statement.setInt(7, book.getState());
            statement.setFloat(8, book.getRating());
            statement.setBoolean(9, book.getTrade());
            statement.setString(10, book.getLanguage());
            statement.setInt(11, book.getID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public void delete(Book book) throws SQLException {
        String sql = getDeleteQuery();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, book.getAuthor());
        statement.setString(2, book.getTitle());
        statement.setFloat(3, book.getPrice());
        statement.setString(4, book.getPublisher());
        statement.setString(5, book.getOwner());
        statement.setString(6, book.getDescription());
        statement.setInt(7, book.getState());
        statement.setFloat(8, book.getRating());
        statement.setBoolean(9, book.getTrade());
        statement.setString(10, book.getLanguage());
        statement.execute();
    }

    @Override
    public List<Book> getAll() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM mydb.books;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Book book = new Book();
            book.setID(resultSet.getInt("ID"));
            book.setRating(resultSet.getFloat("Rating"));
            book.setAuthor(resultSet.getString("Author"));
            book.setDescription(resultSet.getString("Description"));
            book.setLanguage(resultSet.getString("Language"));
            book.setOwner(resultSet.getString("Owner"));
            book.setPrice(resultSet.getFloat("Price"));
            book.setPublisher(resultSet.getString("Publisher"));
            book.setState(resultSet.getInt("State"));
            book.setTitle(resultSet.getString("Title"));
            book.setTrade(resultSet.getBoolean("Trade"));
            books.add(book);
        }
        return books;
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO mydb.books (Author,Title,Price,Publisher,Owner,Description,State,Rating,Trade,Language) VALUES (?,?,?,?,?,?,?,?,?,?);";
    }

    @Override
    public String getReadQuery() {
        return "SELECT * FROM mydb.books WHERE id = ?;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE mydb.books\n" +
                "SET Author=?,Title=?,Price = ?,Publisher=?,Owner=?,Description=?,State=?,Rating = ?,Trade = ?,Language = ?\n" +
                "WHERE ID=?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM mydb.books WHERE Author=? AND Title=? AND Price = ? AND Publisher=? AND Owner=? AND Description=? AND State=? AND Rating = ? AND Trade = ? AND Language = ?;";
    }
}
