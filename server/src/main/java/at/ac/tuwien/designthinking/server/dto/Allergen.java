package at.ac.tuwien.designthinking.server.dto;

/**
 * Created by schurli on 17.06.18.
 */
public class Allergen {

    private int ID;
    private String name;
    private String code;


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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
