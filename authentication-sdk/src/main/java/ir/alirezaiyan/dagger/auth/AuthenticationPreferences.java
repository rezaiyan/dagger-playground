package ir.alirezaiyan.dagger.auth;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/14/2020 12:53 AM.
 */
public class AuthenticationPreferences {

    private SharedPreferences preferences;
    private SharedPreferences cache;

    @Inject
    public AuthenticationPreferences(Context context) {
        preferences = context.getSharedPreferences("daggerCache", Context.MODE_PRIVATE);
        cache = context.getSharedPreferences("ir.alirezaiyan.dagger.cache", Context.MODE_PRIVATE);
    }

    void clear(){
        preferences.edit().clear().apply();
        cache.edit().clear().apply();
    }

}
