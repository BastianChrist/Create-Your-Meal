package at.ac.tuwien.designthinking.server.dto;

/**
 * Created by Georg Edlinger on 01.06.18.
 */
public class User {


    private int ID;
    private String firstName;
    private String profilePicture;

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName()
    {
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
}
