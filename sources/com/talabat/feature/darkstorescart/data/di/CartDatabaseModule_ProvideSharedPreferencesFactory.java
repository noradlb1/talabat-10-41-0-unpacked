package com.talabat.feature.darkstorescart.data.di;

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
public final class CartDatabaseModule_ProvideSharedPreferencesFactory implements Factory<SharedPreferences> {
    private final Provider<Context> contextProvider;

    public CartDatabaseModule_ProvideSharedPreferencesFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static CartDatabaseModule_ProvideSharedPreferencesFactory create(Provider<Context> provider) {
        return new CartDatabaseModule_ProvideSharedPreferencesFactory(provider);
    }

    public static SharedPreferences provideSharedPreferences(Context context) {
        return (SharedPreferences) Preconditions.checkNotNullFromProvides(CartDatabaseModule.INSTANCE.provideSharedPreferences(context));
    }

    public SharedPreferences get() {
        return provideSharedPreferences(this.contextProvider.get());
    }
}
