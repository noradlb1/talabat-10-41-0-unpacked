package com.talabat.splash.core.di;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvideSharedPreferencesFactory implements Factory<SharedPreferences> {
    private final Provider<Context> contextProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvideSharedPreferencesFactory(ApplicationModule applicationModule, Provider<Context> provider) {
        this.module = applicationModule;
        this.contextProvider = provider;
    }

    public static ApplicationModule_ProvideSharedPreferencesFactory create(ApplicationModule applicationModule, Provider<Context> provider) {
        return new ApplicationModule_ProvideSharedPreferencesFactory(applicationModule, provider);
    }

    public static SharedPreferences provideSharedPreferences(ApplicationModule applicationModule, Context context) {
        return (SharedPreferences) Preconditions.checkNotNullFromProvides(applicationModule.provideSharedPreferences(context));
    }

    public SharedPreferences get() {
        return provideSharedPreferences(this.module, this.contextProvider.get());
    }
}
