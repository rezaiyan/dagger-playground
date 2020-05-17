package ir.alirezaiyan.dagger.core;

import android.app.Application;

import ir.alirezaiyan.dagger.core.di.CoreComponent;
import ir.alirezaiyan.dagger.core.di.DaggerCoreComponent;

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/13/2020 10:10 PM.
 */
public class CoreApplication extends Application {

    protected CoreComponent coreComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        coreComponent = DaggerCoreComponent.factory().create(this);
        coreComponent.inject(this);
    }

}
