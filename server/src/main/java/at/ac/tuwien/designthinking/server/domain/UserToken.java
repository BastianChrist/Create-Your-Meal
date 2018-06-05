package at.ac.tuwien.designthinking.server.domain;

/**
 * Created by Georg Edlinger on 31.05.18.
 */
public class UserToken {

    private String user;
    private String token;


    public UserToken(String user){
        this.user=user;
        this.token= user;
    }

    public String getToken() {
        return token;
    }

    public String getUser() {
        return user;
    }



}
