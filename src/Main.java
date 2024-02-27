import java.sql.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws SQLException {
        ClientRepository clientsRepo = new ClientRepo();
        StylistRepository stylistsRepo = new StylistRepo();

        List<Client> clients = clientsRepo.getList();
        List<Stylist> stylists = stylistsRepo.getList();


        for (Client client : clients) {
            DBPrint.printClientStylist(client); // Print information about client-stylist

        }
    }
}
