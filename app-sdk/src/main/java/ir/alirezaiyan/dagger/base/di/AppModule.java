package ir.alirezaiyan.dagger.base.di;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import ir.alirezaiyan.dagger.auth.CredentialInterceptor;
import ir.alirezaiyan.dagger.auth.RefreshTokenInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/16/2020 8:24 PM.
 */
@Module
class AppModule {

    @Provides
    OkHttpClient okHttpClient(
        @Named("core") Lazy<OkHttpClient> coreOkHttp,
        CredentialInterceptor credentialInterceptor,
        RefreshTokenInterceptor refreshTokenInterceptor) {

        return coreOkHttp.get().newBuilder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .addInterceptor(refreshTokenInterceptor)
            .addInterceptor(credentialInterceptor)
            .build();
    }

    @Provides
    Retrofit retrofit(OkHttpClient client, @Named("core") Retrofit retrofit) {
        return retrofit.newBuilder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    }

}
