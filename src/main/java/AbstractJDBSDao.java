/**
 * Created by Eugeniy Krukun on 22.05.2016.
 */
public abstract class AbstractJDBSDao {
    public abstract String getCreateQuery();

    public abstract String getReadQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();
}
