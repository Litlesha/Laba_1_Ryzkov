import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StylistRepo implements StylistRepository{
    @Override
    public void Insert(Stylist stylist) throws SQLException {
        String string = String.format("INSERT INTO STYLIST(ID_STYLIST,NAME,SURNAME) VALUES (%s,%s,%s)",
                stylist.getID_STYLIST(),stylist.getNAME(),stylist.getSURNAME());
        Statement stmt = this.getStatement(this.connectToDB());
        stmt.execute(string);
        stmt.close();
    }

    @Override
    public void Delete(Stylist stylist) throws SQLException {
        String string = String.format("DELETE  FROM STYLIST where ID_STYLIST = %s" , stylist.getID_STYLIST());
        Statement stmt = this.getStatement(this.connectToDB());
        stmt.execute(string);
        stmt.close();
    }

    @Override
    public void Update(Stylist stylist, int id) throws SQLException {
        String string = String.format("UPDATE STYLIST SET ID_STYLIST = %s, NAME = '%s'," +
                        " SURNAME = '%s' WHERE ID_STYLIST = %s" ,
                stylist.getID_STYLIST(),
                stylist.getNAME(),
                stylist.getSURNAME(),
                stylist.getID_STYLIST());

        Statement stmt = this.getStatement(this.connectToDB());
        stmt.execute(string);
        stmt.close();

    }

    @Override
    public List<Stylist> getList() throws SQLException {
        Statement stmt = this.getStatement(this.connectToDB());
        ResultSet rs = stmt.executeQuery("SELECT st.ID_STYLIST, st.SURNAME, st.NAME FROM \"Ryzkov_Labs\".STYLIST AS st");

        List<Stylist> stylists = new ArrayList<>();
        while(rs.next()) {
            Stylist tmpStylist = new Stylist(rs.getInt("Stylist.ID_STYLIST"),
                    rs.getString("Stylist.SURNAME"),
                    rs.getString("Stylist.NAME"));
            stylists.add(tmpStylist);
        }
        this.closeConnection(stmt);

        return stylists;
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

