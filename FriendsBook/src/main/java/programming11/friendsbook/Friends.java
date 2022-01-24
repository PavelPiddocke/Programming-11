package programming11.friendsbook;

public class Friends {

    //Name, age, gender, city, status
    private String friendName;
    private Integer age = 0;
    private String gender = "";
    private String city = "";
    private String friendStatus = "";
    //image
    //private File imageFile;

    //Constructors

    public Friends(String name, Integer age, String gender, String city, String friendStatus) {
        this.friendName = name;
        this.age = age;
        this.gender = gender;
        this.city = city;
        this.friendStatus = friendStatus;
    }

    //Methods



    //Getters and Setters


    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String name) {
        this.friendName = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFriendStatus() {
        return friendStatus;
    }

    public void setFriendStatus(String friendStatus) {
        this.friendStatus = friendStatus;
    }
}
