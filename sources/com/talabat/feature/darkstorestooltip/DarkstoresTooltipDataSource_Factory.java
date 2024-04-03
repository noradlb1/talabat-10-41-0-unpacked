package com.talabat.feature.darkstorestooltip;

import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresTooltipDataSource_Factory implements Factory<DarkstoresTooltipDataSource> {
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public DarkstoresTooltipDataSource_Factory(Provider<SharedPreferences> provider) {
        this.sharedPreferencesProvider = provider;
    }

    public static DarkstoresTooltipDataSource_Factory create(Provider<SharedPreferences> provider) {
        return new DarkstoresTooltipDataSource_Factory(provider);
    }

    public static DarkstoresTooltipDataSource newInstance(SharedPreferences sharedPreferences) {
        return new DarkstoresTooltipDataSource(sharedPreferences);
    }

    public DarkstoresTooltipDataSource get() {
        return newInstance(this.sharedPreferencesProvider.get());
    }
}
