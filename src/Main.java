public class Main {
    public static void main(String[] args) {

        Club home = new Club("Home", 3);
        home.addMember("Clemens", "Pilz", "m", true);
        home.addMember("Emilia", "Pilz", "w", true);
        home.addMember("Jazia", "Pilz", "f", true);
        home.addMember("Hansi", "Hinterseer", "x", true);
        home.addMember("Hubert", "Goisern", "y", true);
        home.distributeParkingRandom();
        home.getMemberCount();
        home.printClub();
        System.out.println("-----");
        home.searchMember("aha");
        for (Member member : home.searchMember("p")) {
            member.printMember();
        }
        System.out.println("-----");
        home.removeInvalid();
        home.printClub();
        home.removeByLastName("p");
        home.getMemberCount();
        home.printClub();
    }
}