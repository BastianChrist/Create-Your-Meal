package at.ac.tuwien.designthinking.server.dto;

import javax.persistence.*;

@Entity
public class UserAllergies {
    @Id
    private int ID;

    private int userId;
    private int allergyId;
    private String dateAdded;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAllergyId() {
        return allergyId;
    }

    public void setAllergyId(int allergyId) {
        this.allergyId = allergyId;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

}
