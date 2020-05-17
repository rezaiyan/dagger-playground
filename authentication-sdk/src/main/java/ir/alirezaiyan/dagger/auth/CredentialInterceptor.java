package ir.alirezaiyan.dagger.auth;

import ir.alirezaiyan.dagger.auth.data.AuthenticationApi;
import ir.alirezaiyan.dagger.auth.model.DeviceIdentifier;
import ir.alirezaiyan.dagger.auth.model.User;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Response;
import retrofit2.Call;

public class CredentialInterceptor implements Interceptor {

    private AuthenticationManager authenticationManager;
    private DeviceIdentifier deviceIdentifier;
    private AuthenticationApi api;
    private AuthenticationNotification notification;

    @Inject
    public CredentialInterceptor(AuthenticationManager authenticationManager,
                                 DeviceIdentifier deviceIdentifier,
                                 AuthenticationApi api,
                                 AuthenticationNotification notification) {
        this.authenticationManager = authenticationManager;
        this.deviceIdentifier = deviceIdentifier;
        this.api = api;
        this.notification = notification;
    }

    private Call<User> tempUserCall;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        if (response.code() == 401 && authenticationManager.isUserSignIn()){
            authenticationManager.invalidate();

            if (tempUserCall == null){
                tempUserCall = api.requestTempUser(deviceIdentifier.androidId);
                tempUserCall.execute();
            }else if (!tempUserCall.isExecuted()){
                tempUserCall.execute();
            }
            notification.show();
        }
        return response;
    }
}
