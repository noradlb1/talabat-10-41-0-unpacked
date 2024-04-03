package com.talabat.feature.pickup.data.di;

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
public final class PickupFeatureModule_ProvideSharedPrefsFactory implements Factory<SharedPreferences> {
    private final Provider<Context> contextProvider;

    public PickupFeatureModule_ProvideSharedPrefsFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static PickupFeatureModule_ProvideSharedPrefsFactory create(Provider<Context> provider) {
        return new PickupFeatureModule_ProvideSharedPrefsFactory(provider);
    }

    public static SharedPreferences provideSharedPrefs(Context context) {
        return (SharedPreferences) Preconditions.checkNotNullFromProvides(PickupFeatureModule.INSTANCE.provideSharedPrefs(context));
    }

    public SharedPreferences get() {
        return provideSharedPrefs(this.contextProvider.get());
    }
}
