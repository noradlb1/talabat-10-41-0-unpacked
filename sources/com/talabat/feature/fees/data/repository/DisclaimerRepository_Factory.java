package com.talabat.feature.fees.data.repository;

import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class DisclaimerRepository_Factory implements Factory<DisclaimerRepository> {
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public DisclaimerRepository_Factory(Provider<SharedPreferences> provider) {
        this.sharedPreferencesProvider = provider;
    }

    public static DisclaimerRepository_Factory create(Provider<SharedPreferences> provider) {
        return new DisclaimerRepository_Factory(provider);
    }

    public static DisclaimerRepository newInstance(SharedPreferences sharedPreferences) {
        return new DisclaimerRepository(sharedPreferences);
    }

    public DisclaimerRepository get() {
        return newInstance(this.sharedPreferencesProvider.get());
    }
}
