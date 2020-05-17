package ir.alirezaiyan.dagger.base.di;

import android.app.Application;

import ir.alirezaiyan.dagger.auth.di.AuthenticationComponent;
import ir.alirezaiyan.dagger.base.di.scope.BaseScope;
import ir.alirezaiyan.dagger.core.di.CoreComponent;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/16/2020 1:25 PM.
 */

@BaseScope
@Component(modules = {AppModule.class}, dependencies = {CoreComponent.class, AuthenticationComponent.class})
public interface AppComponent {

    OkHttpClient okHttpClient();
    Retrofit retrofit();


    @Component.Factory
    interface Factory {
        AppComponent create(CoreComponent coreComponent, AuthenticationComponent authenticationComponent);
    }
    void inject(Application application);
}