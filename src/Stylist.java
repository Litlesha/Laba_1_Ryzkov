public class Stylist {
 private int id_Stylist;
 private String Name;
 private String Surname;

    public Stylist(int id_stylist, String name, String surname) {
        this.id_Stylist = id_stylist;
        Name = name;
        Surname = surname;
    }

    public int getId_stylist() {
        return id_Stylist;
    }

    public void setId_stylist(int id_stylist) {
        this.id_Stylist = id_stylist;
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
}
