package com.talabat.splash.core.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvideApplicationContextFactory implements Factory<Context> {
    private final ApplicationModule module;

    public ApplicationModule_ProvideApplicationContextFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideApplicationContextFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideApplicationContextFactory(applicationModule);
    }

    public static Context provideApplicationContext(ApplicationModule applicationModule) {
        return (Context) Preconditions.checkNotNullFromProvides(applicationModule.provideApplicationContext());
    }

    public Context get() {
        return provideApplicationContext(this.module);
    }
}
