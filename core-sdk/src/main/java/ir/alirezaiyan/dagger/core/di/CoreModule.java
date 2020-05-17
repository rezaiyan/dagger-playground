package ir.alirezaiyan.dagger.core.di;

import android.app.Application;
import android.content.Context;

import ir.alirezaiyan.dagger.core.BuildConfig;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/14/2020 1:19 AM.
 */
@Module
class CoreModule {
    @Provides Context context(Application application){
        return application.getApplicationContext();
    }

    @Provides
    @Named("core")
    Retrofit retrofit(){
        return new Retrofit.Builder()
            .baseUrl("https://alirezaiyan.ir")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    @Provides
    @Singleton
    @Named("core")
    OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient().newBuilder()
            .addInterceptor(loggingInterceptor)
            .build();
    }

    @Provides
    HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(
            BuildConfig.DEBUG ?
                HttpLoggingInterceptor.Level.NONE : HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

}
