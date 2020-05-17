package ir.alirezaiyan.dagger.base;


import ir.alirezaiyan.dagger.auth.di.AuthenticationComponent;
import ir.alirezaiyan.dagger.auth.di.DaggerAuthenticationComponent;
import ir.alirezaiyan.dagger.base.di.AppComponent;
import ir.alirezaiyan.dagger.base.di.AppComponentProvider;
import ir.alirezaiyan.dagger.base.di.DaggerAppComponent;
import ir.alirezaiyan.dagger.core.CoreApplication;

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/14/2020 9:33 PM.
 */
public class BaseApplication extends CoreApplication implements AppComponentProvider {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        AuthenticationComponent authenticationComponent = DaggerAuthenticationComponent.factory().create(coreComponent);
        appComponent = DaggerAppComponent.factory().create(coreComponent, authenticationComponent);
        appComponent.inject(this);
    }

    @Override
    public AppComponent appComponent() {
        return appComponent;
    }
}
