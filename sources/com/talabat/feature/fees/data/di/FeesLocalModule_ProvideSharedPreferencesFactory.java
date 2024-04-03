package com.talabat.feature.fees.data.di;

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
@QualifierMetadata({"javax.inject.Named"})
public final class FeesLocalModule_ProvideSharedPreferencesFactory implements Factory<SharedPreferences> {
    private final Provider<Context> contextProvider;

    public FeesLocalModule_ProvideSharedPreferencesFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static FeesLocalModule_ProvideSharedPreferencesFactory create(Provider<Context> provider) {
        return new FeesLocalModule_ProvideSharedPreferencesFactory(provider);
    }

    public static SharedPreferences provideSharedPreferences(Context context) {
        return (SharedPreferences) Preconditions.checkNotNullFromProvides(FeesLocalModule.INSTANCE.provideSharedPreferences(context));
    }

    public SharedPreferences get() {
        return provideSharedPreferences(this.contextProvider.get());
    }
}
