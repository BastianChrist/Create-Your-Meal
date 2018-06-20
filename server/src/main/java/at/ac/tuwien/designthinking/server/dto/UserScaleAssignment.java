package at.ac.tuwien.designthinking.server.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserScaleAssignment {

    @Id
    private Integer Id;

    private Integer scale_one;

    private Integer scale_two;

    private Integer scale_three;

    private Integer scale_four;

    private Integer scale_five;

    private Integer scale_six;

    private Integer userId;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getScale_one() {
        return scale_one;
    }

    public void setScale_one(Integer scale_one) {
        this.scale_one = scale_one;
    }

    public Integer getScale_two() {
        return scale_two;
    }

    public void setScale_two(Integer scale_two) {
        this.scale_two = scale_two;
    }

    public Integer getScale_three() {
        return scale_three;
    }

    public void setScale_three(Integer scale_three) {
        this.scale_three = scale_three;
    }

    public Integer getScale_four() {
        return scale_four;
    }

    public void setScale_four(Integer scale_four) {
        this.scale_four = scale_four;
    }

    public Integer getScale_five() {
        return scale_five;
    }

    public void setScale_five(Integer scale_five) {
        this.scale_five = scale_five;
    }

    public Integer getScale_six() {
        return scale_six;
    }

    public void setScale_six(Integer scale_six) {
        this.scale_six = scale_six;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
