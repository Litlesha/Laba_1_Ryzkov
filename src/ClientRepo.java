import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepo implements ClientRepository{
    @Override
    public void Insert(Client client) throws SQLException {
        StylistRepo stylistRepo = new StylistRepo();
        stylistRepo.Insert(client.getStylist());
        String string = String.format("INSERT INTO CLIENT(ID_CLIENT,SURNAME,NAME, ID_STYLIST) VALUES (%s, %s, %s,%S)",
                client.getID_CLIENT(),
                client.getSURNAME(),
                client.getNAME(),
                client.getStylist().getID_STYLIST());
        Statement stmt = this.getStatement(this.connectToDB());
        stmt.execute(string);
        stmt.close();
    }

    @Override
    public void Delete(Client client) throws SQLException {
        String string = String.format("DELETE  FROM CLIENT where ID_CLIENT = %s" , client.getID_CLIENT());
        Statement stmt = this.getStatement(this.connectToDB());
        stmt.execute(string);
        stmt.close();
    }

    @Override
    public void Update(Client client, int id) throws SQLException {
        String string = String.format("UPDATE CLIENT SET ID_CLIENT = %s,SURNAME ='%S' ,NAME = '%s'," +
                        " ID_STYLIST = %s WHERE ID_CLIENT = %s" ,
                client.getID_CLIENT(),
                client.getSURNAME(),
                client.getNAME(),
                client.getStylist().getID_STYLIST(),
                id);
        Statement stmt = this.getStatement(this.connectToDB());
        stmt.execute(string);
        stmt.close();

    }

    @Override
    public List<Client> getList() throws SQLException {
        Statement stmt = this.getStatement(this.connectToDB());
        ResultSet rs = stmt.executeQuery("SELECT cl.ID_CLIENT,cl.SURNAME ,cl.NAME, cl.ID_STYLIST, st.ID_STYLIST,st.SURNAME, st.NAME FROM \"Ryzkov_Labs\".CLIENT AS cl JOIN \"Ryzkov_Labs\".STYLIST AS st ON cl.ID_STYLIST = st.ID_STYLIST");
        List<Client> clients = new ArrayList<>();
        while(rs.next()) {
            clients.add(new Client(rs.getInt("ID_CLIENT"),
                    rs.getString("SURNAME"),
                    rs.getString("NAME"),
                    new Stylist(rs.getInt("Stylist.ID_STYLIST"),
                             rs.getString("Stylist.SURNAME")
                            ,rs.getString("Stylist.NAME"))));
        }
        this.closeConnection(stmt);

        return clients;
    }

    @Override
    public Connection connectToDB() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","root","");
        if (conn==null) {
            System.out.println("Error with connection with DataBase!");
            System.exit(0);
        }
        return conn;
    }

    @Override
    public Statement getStatement(Connection conn) throws SQLException {
        return conn.createStatement();
    }
    public void closeConnection(Statement stmt) throws SQLException {
        stmt.close();
    }
    }

