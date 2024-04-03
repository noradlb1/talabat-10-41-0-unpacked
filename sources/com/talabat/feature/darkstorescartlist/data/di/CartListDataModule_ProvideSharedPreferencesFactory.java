package com.talabat.feature.darkstorescartlist.data.di;

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
public final class CartListDataModule_ProvideSharedPreferencesFactory implements Factory<SharedPreferences> {
    private final Provider<Context> contextProvider;
    private final CartListDataModule module;

    public CartListDataModule_ProvideSharedPreferencesFactory(CartListDataModule cartListDataModule, Provider<Context> provider) {
        this.module = cartListDataModule;
        this.contextProvider = provider;
    }

    public static CartListDataModule_ProvideSharedPreferencesFactory create(CartListDataModule cartListDataModule, Provider<Context> provider) {
        return new CartListDataModule_ProvideSharedPreferencesFactory(cartListDataModule, provider);
    }

    public static SharedPreferences provideSharedPreferences(CartListDataModule cartListDataModule, Context context) {
        return (SharedPreferences) Preconditions.checkNotNullFromProvides(cartListDataModule.provideSharedPreferences(context));
    }

    public SharedPreferences get() {
        return provideSharedPreferences(this.module, this.contextProvider.get());
    }
}
