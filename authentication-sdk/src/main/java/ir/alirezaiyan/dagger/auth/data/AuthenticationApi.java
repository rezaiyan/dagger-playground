package ir.alirezaiyan.dagger.auth.data;

import ir.alirezaiyan.dagger.auth.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/14/2020 6:31 PM.
 */
public interface AuthenticationApi {

    @FormUrlEncoded
    @POST("/oauth/token")
    Call<User> refreshToken(@Field("refresh_token") String refreshToken);

    @GET("/user")
    Call<User> requestTempUser(@Query("uuid") String uuid);

}
