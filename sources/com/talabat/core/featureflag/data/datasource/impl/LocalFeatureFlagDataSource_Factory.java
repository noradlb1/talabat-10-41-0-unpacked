package com.talabat.core.featureflag.data.datasource.impl;

import android.content.Context;
import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LocalFeatureFlagDataSource_Factory implements Factory<LocalFeatureFlagDataSource> {
    private final Provider<Context> contextProvider;
    private final Provider<Gson> gsonProvider;

    public LocalFeatureFlagDataSource_Factory(Provider<Context> provider, Provider<Gson> provider2) {
        this.contextProvider = provider;
        this.gsonProvider = provider2;
    }

    public static LocalFeatureFlagDataSource_Factory create(Provider<Context> provider, Provider<Gson> provider2) {
        return new LocalFeatureFlagDataSource_Factory(provider, provider2);
    }

    public static LocalFeatureFlagDataSource newInstance(Context context, Gson gson) {
        return new LocalFeatureFlagDataSource(context, gson);
    }

    public LocalFeatureFlagDataSource get() {
        return newInstance(this.contextProvider.get(), this.gsonProvider.get());
    }
}
