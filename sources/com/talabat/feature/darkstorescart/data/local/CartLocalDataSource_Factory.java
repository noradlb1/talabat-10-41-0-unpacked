package com.talabat.feature.darkstorescart.data.local;

import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartLocalDataSource_Factory implements Factory<CartLocalDataSource> {
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public CartLocalDataSource_Factory(Provider<SharedPreferences> provider) {
        this.sharedPreferencesProvider = provider;
    }

    public static CartLocalDataSource_Factory create(Provider<SharedPreferences> provider) {
        return new CartLocalDataSource_Factory(provider);
    }

    public static CartLocalDataSource newInstance(SharedPreferences sharedPreferences) {
        return new CartLocalDataSource(sharedPreferences);
    }

    public CartLocalDataSource get() {
        return newInstance(this.sharedPreferencesProvider.get());
    }
}
