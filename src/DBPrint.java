public class DBPrint {
    public static void printStylist(Stylist stylist) {
        System.out.println(stylist.getID_STYLIST() + " " +stylist.getSURNAME()+ " "+ stylist.getNAME());
    }
    public static void printClient(Client client) {
        System.out.println(client.getID_CLIENT() + " " + client.getSURNAME()+ " " +
                client.getNAME()+ " " + client.getStylist().getSURNAME() + " " + client.getStylist().getNAME());
    }
    public static void printClientStylist(Client client) {
        System.out.print(client.getID_CLIENT() +" " +client.getSURNAME() +" " + client.getNAME() + " ");
        printStylist(client.getStylist());
    }
}
