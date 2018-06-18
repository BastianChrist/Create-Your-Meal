package at.ac.tuwien.designthinking.server.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Bastian on 27.05.2018.
 */

@Entity
public class Ingredient {

    @Id
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
