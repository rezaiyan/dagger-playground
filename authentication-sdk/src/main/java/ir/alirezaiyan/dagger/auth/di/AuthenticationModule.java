package ir.alirezaiyan.dagger.auth.di;

import ir.alirezaiyan.dagger.auth.data.AuthenticationApi;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/14/2020 1:09 AM.
 */
@Module
public class AuthenticationModule {

    @Provides
    AuthenticationApi authenticationApi(@Named("core") Retrofit retrofit){
        return retrofit.create(AuthenticationApi.class);
    }
}
