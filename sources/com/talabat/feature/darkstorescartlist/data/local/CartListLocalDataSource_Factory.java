package com.talabat.feature.darkstorescartlist.data.local;

import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartListLocalDataSource_Factory implements Factory<CartListLocalDataSource> {
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public CartListLocalDataSource_Factory(Provider<SharedPreferences> provider) {
        this.sharedPreferencesProvider = provider;
    }

    public static CartListLocalDataSource_Factory create(Provider<SharedPreferences> provider) {
        return new CartListLocalDataSource_Factory(provider);
    }

    public static CartListLocalDataSource newInstance(SharedPreferences sharedPreferences) {
        return new CartListLocalDataSource(sharedPreferences);
    }

    public CartListLocalDataSource get() {
        return newInstance(this.sharedPreferencesProvider.get());
    }
}
