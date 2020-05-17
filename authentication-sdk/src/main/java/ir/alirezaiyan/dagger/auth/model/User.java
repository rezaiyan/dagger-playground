package ir.alirezaiyan.dagger.auth.model;

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/14/2020 6:18 PM.
 */
public class User {
    public String accessToken;
    public String refreshToken;
    private long expiresIn;

    public User() {
    }

    public boolean isValid(){
       return accessToken != null;
    }

    public boolean isExpired() {
        return (expiresIn - System.currentTimeMillis()) < 10;
    }
}
