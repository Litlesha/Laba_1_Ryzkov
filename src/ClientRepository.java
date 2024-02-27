import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface ClientRepository {
    void Insert(Client client) throws SQLException;
    void Delete(Client client) throws SQLException;
    void Update(Client client, int id) throws SQLException;

    List<Client> getList() throws  SQLException;
    Connection connectToDB() throws SQLException;
    Statement getStatement(Connection conn) throws SQLException;
}
