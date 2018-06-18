package at.ac.tuwien.designthinking.server.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Georg Edlinger on 01.06.18.
 */
@Entity
public class UserAccount implements Serializable {

    @Id
    private int ID;
    private String firstName;
    private String lastName;
    private String profilePicture;
    private String email;
    private String password;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
