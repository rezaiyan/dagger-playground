package ir.alirezaiyan.dagger.auth;

import ir.alirezaiyan.dagger.auth.data.AuthenticationApi;
import ir.alirezaiyan.dagger.auth.model.DeviceIdentifier;
import ir.alirezaiyan.dagger.auth.model.User;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/14/2020 2:24 AM.
 */
public class RefreshTokenInterceptor implements Interceptor {

    private AuthenticationManager authenticationManager;
    private DeviceIdentifier deviceIdentifier;
    private  AuthenticationApi api;

    @Inject
    public RefreshTokenInterceptor(AuthenticationManager authenticationManager,
                                   DeviceIdentifier deviceIdentifier,
                                   AuthenticationApi api) {
        this.authenticationManager = authenticationManager;
        this.deviceIdentifier = deviceIdentifier;
        this.api = api;

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        User user = authenticationManager.getSignedInUser();
        if (user.isValid()){
            if (user.isExpired()){
                retrofit2.Response<User> response = api.refreshToken(user.refreshToken).execute();
                if (response.isSuccessful() && response.body() != null){
                    User newUser = response.body();
                    authenticationManager.updateUser(newUser);
                }
            }
        }
        Headers.Builder builder = request.headers().newBuilder();

        user = authenticationManager.getSignedInUser();
        if (user.isValid()){
            builder.add("Authorization", "Bearer " + user.accessToken);
        }

        request = request.newBuilder().headers(builder.build()).build();

        return chain.proceed(request);
    }

}
