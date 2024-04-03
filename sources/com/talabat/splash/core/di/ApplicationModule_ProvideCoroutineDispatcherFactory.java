package com.talabat.splash.core.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvideCoroutineDispatcherFactory implements Factory<CoroutineDispatcher> {
    private final ApplicationModule module;

    public ApplicationModule_ProvideCoroutineDispatcherFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideCoroutineDispatcherFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideCoroutineDispatcherFactory(applicationModule);
    }

    public static CoroutineDispatcher provideCoroutineDispatcher(ApplicationModule applicationModule) {
        return (CoroutineDispatcher) Preconditions.checkNotNullFromProvides(applicationModule.provideCoroutineDispatcher());
    }

    public CoroutineDispatcher get() {
        return provideCoroutineDispatcher(this.module);
    }
}
