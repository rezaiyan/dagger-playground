package ir.alirezaiyan.dagger.core.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/8/2020 3:28 PM.
 * Usage: App lifecycle
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface SubModuleScope {}
