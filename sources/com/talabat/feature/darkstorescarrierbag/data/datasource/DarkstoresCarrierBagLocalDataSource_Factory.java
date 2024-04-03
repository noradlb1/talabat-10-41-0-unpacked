package com.talabat.feature.darkstorescarrierbag.data.datasource;

import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresCarrierBagLocalDataSource_Factory implements Factory<DarkstoresCarrierBagLocalDataSource> {
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public DarkstoresCarrierBagLocalDataSource_Factory(Provider<SharedPreferences> provider) {
        this.sharedPreferencesProvider = provider;
    }

    public static DarkstoresCarrierBagLocalDataSource_Factory create(Provider<SharedPreferences> provider) {
        return new DarkstoresCarrierBagLocalDataSource_Factory(provider);
    }

    public static DarkstoresCarrierBagLocalDataSource newInstance(SharedPreferences sharedPreferences) {
        return new DarkstoresCarrierBagLocalDataSource(sharedPreferences);
    }

    public DarkstoresCarrierBagLocalDataSource get() {
        return newInstance(this.sharedPreferencesProvider.get());
    }
}
