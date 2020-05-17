package ir.alirezaiyan.dagger.base.di;

import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/16/2020 12:40 PM.
 */
@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
