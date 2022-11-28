import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Club {
    private String name;
    private ArrayList<Member> members;

    private int parkingSpaces;

    public Club(String name, int parkingSpaces) {
        this.name = name;
        this.members = new ArrayList<Member>();
        this.parkingSpaces = parkingSpaces;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParkingSpaces() {
        return parkingSpaces;
    }
    //Parking

    public void distributeParking() {
        int spaces = getParkingSpaces();
        ArrayList<Member> winners = new ArrayList<>();
        for (Member member : members) {
            if (member.isVehicleOwner()) {
                winners.add(member);
            }
        }

        if (spaces < winners.size()) {
            Collections.shuffle(winners);
            winners = new ArrayList<>(winners.subList(0, spaces));
        }


        for (Member winner : winners) {
            winner.setSpaceOwner(true);
        }
    }

    //Mitgliederverwaltung
    public void addMember(String firstname, String lastname, String sex, boolean vehicleOwner) {
        members.add(new Member(firstname, lastname, sex, vehicleOwner));
    }

    public int getMemberCount() {
        return members.size();
    }

    public int getOwnerCount() {
        int i = 0;
        int v = 0;
        while (i < members.size()) {
            if (members.get(i).isVehicleOwner()) {
                v++;
            }
        }
        return v;
    }

    public void removeMember(int index) {
        if (index < 0 || index >= members.size()) {
            System.out.println("Ungültiger Index");
            return;
        }
        members.remove(index);
    }

    public void purgeMembers() {
        members.clear();
    }

    //Clubinfos ausgeben
    public void printClub() {
        System.out.println("Clubname: " + getName());
        System.out.println("Mitgliederanzahl: " + getMemberCount());
        System.out.println("----------Mitglieder----------");
        for (Member member : members) {
            member.printMember();
        }
    }

    //Mitgliedersuche detailliert
    public ArrayList<Member> searchMember(String searchString) {
        if (searchString == null) {
            System.out.println("Bitte Suchstring eingeben!");
            return null;
        }
        ArrayList<Member> memberList = new ArrayList<Member>();
        for (Member member : members) {
            if (member.getLastname().toLowerCase().startsWith(searchString.toLowerCase())) {
                memberList.add(member);
            }

        }
        return memberList;
    }

    //remove /w iterator
    public void removeInvalid() {
        Iterator<Member> it = members.iterator();
        while (it.hasNext()) {
            Member member = it.next();
            if (member.getMemberId().equals("UNGÜLTIG")) {
                it.remove();
            }
        }

    }

    //remove /w arrow method
    public void removeInvalidAlternative() {
        members.removeIf(member -> member.getMemberId().equals("UNGÜLTIG"));

    }

    public void removeByLastName(String searchString) {
        members.removeAll(searchMember(searchString));
    }


}
