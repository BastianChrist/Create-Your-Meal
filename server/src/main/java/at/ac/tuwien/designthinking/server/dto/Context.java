package at.ac.tuwien.designthinking.server.dto;

/**
 * Created by schurli on 17.06.18.
 */
public class Context {

    private String type;

    private boolean isWarm;

    private Integer maxCookTime;

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
}
