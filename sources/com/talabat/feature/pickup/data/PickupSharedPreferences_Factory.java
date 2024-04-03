package com.talabat.feature.pickup.data;

import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PickupSharedPreferences_Factory implements Factory<PickupSharedPreferences> {
    private final Provider<SharedPreferences> prefsProvider;

    public PickupSharedPreferences_Factory(Provider<SharedPreferences> provider) {
        this.prefsProvider = provider;
    }

    public static PickupSharedPreferences_Factory create(Provider<SharedPreferences> provider) {
        return new PickupSharedPreferences_Factory(provider);
    }

    public static PickupSharedPreferences newInstance(SharedPreferences sharedPreferences) {
        return new PickupSharedPreferences(sharedPreferences);
    }

    public PickupSharedPreferences get() {
        return newInstance(this.prefsProvider.get());
    }
}
