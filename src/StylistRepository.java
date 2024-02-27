import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface StylistRepository {
    void Insert(Stylist stylist) throws SQLException;
    void Delete(Stylist stylist) throws SQLException;
    void Update(Stylist stylist, int id) throws SQLException;

    List<Stylist> getList() throws  SQLException;
    Connection connectToDB() throws SQLException;
    Statement getStatement(Connection conn) throws SQLException;
}
