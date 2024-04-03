package com.talabat.darkstores.di;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresDatabaseModule_ProvideSharedPreferencesFactory implements Factory<SharedPreferences> {
    private final Provider<Context> contextProvider;
    private final DarkstoresDatabaseModule module;

    public DarkstoresDatabaseModule_ProvideSharedPreferencesFactory(DarkstoresDatabaseModule darkstoresDatabaseModule, Provider<Context> provider) {
        this.module = darkstoresDatabaseModule;
        this.contextProvider = provider;
    }

    public static DarkstoresDatabaseModule_ProvideSharedPreferencesFactory create(DarkstoresDatabaseModule darkstoresDatabaseModule, Provider<Context> provider) {
        return new DarkstoresDatabaseModule_ProvideSharedPreferencesFactory(darkstoresDatabaseModule, provider);
    }

    public static SharedPreferences provideSharedPreferences(DarkstoresDatabaseModule darkstoresDatabaseModule, Context context) {
        return (SharedPreferences) Preconditions.checkNotNullFromProvides(darkstoresDatabaseModule.provideSharedPreferences(context));
    }

    public SharedPreferences get() {
        return provideSharedPreferences(this.module, this.contextProvider.get());
    }
}
