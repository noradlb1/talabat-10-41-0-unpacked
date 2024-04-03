package com.talabat.authentication.token.data.local.impl;

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
public final class LegacyTokenLocalDataSourceImpl_Factory implements Factory<LegacyTokenLocalDataSourceImpl> {
    private final Provider<Context> contextProvider;
    private final Provider<Gson> gsonProvider;

    public LegacyTokenLocalDataSourceImpl_Factory(Provider<Context> provider, Provider<Gson> provider2) {
        this.contextProvider = provider;
        this.gsonProvider = provider2;
    }

    public static LegacyTokenLocalDataSourceImpl_Factory create(Provider<Context> provider, Provider<Gson> provider2) {
        return new LegacyTokenLocalDataSourceImpl_Factory(provider, provider2);
    }

    public static LegacyTokenLocalDataSourceImpl newInstance(Context context, Gson gson) {
        return new LegacyTokenLocalDataSourceImpl(context, gson);
    }

    public LegacyTokenLocalDataSourceImpl get() {
        return newInstance(this.contextProvider.get(), this.gsonProvider.get());
    }
}
