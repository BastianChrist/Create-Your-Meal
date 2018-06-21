package at.ac.tuwien.designthinking.server.dto;

import java.util.List;

/**
 * Created by schurli on 17.06.18.
 */
public class Context {

    private String type;

    private boolean isWarm;

    private Integer maxCookTime;

    private List<Scale> scales;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isWarm() {
        return isWarm;
    }

    public void setWarm(boolean warm) {
        isWarm = warm;
    }

    public Integer getMaxCookTime() {
        return maxCookTime;
    }

    public void setMaxCookTime(Integer maxCookTime) {
        this.maxCookTime = maxCookTime;
    }

    public void setScales(List<Scale> scales) {
        this.scales = scales;
    }

    public List<Scale> getScales() {

        return scales;
    }
}
