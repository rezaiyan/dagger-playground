package ir.alirezaiyan.dagger.core.di;

import android.app.Application;
import android.content.Context;

import ir.alirezaiyan.dagger.core.CoreApplication;
import ir.alirezaiyan.dagger.core.di.scope.CoreScope;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/14/2020 6:10 PM.
 */
@Singleton
@CoreScope
@Component(modules = CoreModule.class)
public interface CoreComponent {

    Context context();

    @Named("core") Retrofit retrofit();

    @Named("core") OkHttpClient okHttpClient();

    @Component.Factory
    interface Factory{
        CoreComponent create(@BindsInstance Application application);
    }
    void inject(CoreApplication application);
}
