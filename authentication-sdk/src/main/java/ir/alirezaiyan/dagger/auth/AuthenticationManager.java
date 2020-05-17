package ir.alirezaiyan.dagger.auth;

import ir.alirezaiyan.dagger.auth.model.User;

import javax.inject.Inject;

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/14/2020 12:57 AM.
 */
public class AuthenticationManager {

    private final String loginKey = "Login";
    private AuthenticationPreferences preferences;

    @Inject
    public AuthenticationManager(AuthenticationPreferences preferences) {
        this.preferences = preferences;
    }

    boolean isUserSignIn() {
        return true;
    }

    User getSignedInUser() {
            return new User();
    }

    void updateUser(User user) {
    }

    void invalidate() {
        preferences.clear();
    }

}
