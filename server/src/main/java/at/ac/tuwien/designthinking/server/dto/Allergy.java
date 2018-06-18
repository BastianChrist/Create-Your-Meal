package at.ac.tuwien.designthinking.server.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Allergy {

    @Id
    private int ID;

    private String name;

   private int allergenid;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAllergenid() {
        return allergenid;
    }

    public void setAllergenid(int allergenid) {
        this.allergenid = allergenid;
    }
}
