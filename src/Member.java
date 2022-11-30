import java.util.ArrayList;

public class Member {
    private String firstname;
    private String lastname;
    private String sex;
    private String memberId;

    private boolean vehicleOwner;

    private boolean spaceOwner;

    public boolean isSpaceOwner() {
        return spaceOwner;
    }

    public void setSpaceOwner(boolean spaceOwner) {
        this.spaceOwner = spaceOwner;
    }

    public Member(String firstname, String lastname, String sex, boolean vehicleOwner) {
        this.firstname = firstname;
        this.lastname = lastname;
        setSex(sex);
        setMemberId(createRandomId());
        this.vehicleOwner = vehicleOwner;
        this.spaceOwner = false;
    }

    //Setters and Getters

    public String getSex() {
        return sex;
    }

    public boolean isVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(boolean vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMemberId(String memberId) {
        if (memberId.length() < 6 || memberId.length() > 10) {
            this.memberId = "UNGÜLTIG";
        } else {
            this.memberId = memberId;
        }

    }

    private String createRandomId(){
        StringBuilder newMemberId = new StringBuilder("MG-");
        int i = 0;
        while (i < 4){
            int id = (int)Math.floor(Math.random() * 10);
            newMemberId.append(id);
            i++;
        }
        return newMemberId.toString();
    }

    /*
    asdfasdfasdf String formatted = String.format("%03d", num); https://stackoverflow.com/questions/275711/add-leading-zeroes-to-number-in-java
     */


    public void setSex(String sex) {
        ArrayList<String> sexes = new ArrayList<>();
        sexes.add("m");
        sexes.add("w");
        sexes.add("d");
        for (String x : sexes) {
            if (sex.equals(x)) {
                this.sex = sex;
                return;
            }
        }
        this.sex = "-";
    }

    //Alle Infos ausgeben
    public void printMember() {
        System.out.println(getFirstname() + " " + getLastname() + ", " + getSex() + ", " + getMemberId() + " " + isSpaceOwner());
    }


}