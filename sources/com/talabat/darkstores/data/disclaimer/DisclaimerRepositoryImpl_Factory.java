package com.talabat.darkstores.data.disclaimer;

import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DisclaimerRepositoryImpl_Factory implements Factory<DisclaimerRepositoryImpl> {
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public DisclaimerRepositoryImpl_Factory(Provider<SharedPreferences> provider) {
        this.sharedPreferencesProvider = provider;
    }

    public static DisclaimerRepositoryImpl_Factory create(Provider<SharedPreferences> provider) {
        return new DisclaimerRepositoryImpl_Factory(provider);
    }

    public static DisclaimerRepositoryImpl newInstance(SharedPreferences sharedPreferences) {
        return new DisclaimerRepositoryImpl(sharedPreferences);
    }

    public DisclaimerRepositoryImpl get() {
        return newInstance(this.sharedPreferencesProvider.get());
    }
}
