package ir.alirezaiyan.dagger.auth.di;

import ir.alirezaiyan.dagger.auth.CredentialInterceptor;
import ir.alirezaiyan.dagger.auth.RefreshTokenInterceptor;
import ir.alirezaiyan.dagger.core.di.CoreComponent;
import ir.alirezaiyan.dagger.core.di.scope.SubModuleScope;

import dagger.Component;

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/15/2020 6:48 PM.
 */
@SubModuleScope
@Component(modules = {AuthenticationModule.class}, dependencies = CoreComponent.class)
public interface AuthenticationComponent {

    CredentialInterceptor credentialInterceptor();

    RefreshTokenInterceptor refreshTokenInterceptor();

    @Component.Factory
    interface Factory{
        AuthenticationComponent create(CoreComponent coreComponent);
    }

}
