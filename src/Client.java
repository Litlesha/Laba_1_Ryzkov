public class Client {
    private int id_Client;
    private String Name;
    private String Surname;

    public int getId_Client() {
        return id_Client;
    }

    public void setId_Client(int id_Client) {
        this.id_Client = id_Client;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public Client(int id_Client, String name, String surname) {
        this.id_Client = id_Client;
        Name = name;
        Surname = surname;
    }
}
