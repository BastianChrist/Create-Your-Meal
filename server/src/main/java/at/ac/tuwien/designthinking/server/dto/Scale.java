package at.ac.tuwien.designthinking.server.dto;

/**
 * Created by schurli on 21.06.18.
 */
public class Scale {

    int weight;
    int number;

    public Scale(int number, int weight){
        this.number=number;
        this.weight=weight;
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
