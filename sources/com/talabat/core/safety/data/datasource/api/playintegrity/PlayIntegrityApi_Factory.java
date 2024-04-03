package com.talabat.core.safety.data.datasource.api.playintegrity;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PlayIntegrityApi_Factory implements Factory<PlayIntegrityApi> {
    private final Provider<Context> contextProvider;

    public PlayIntegrityApi_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static PlayIntegrityApi_Factory create(Provider<Context> provider) {
        return new PlayIntegrityApi_Factory(provider);
    }

    public static PlayIntegrityApi newInstance(Context context) {
        return new PlayIntegrityApi(context);
    }

    public PlayIntegrityApi get() {
        return newInstance(this.contextProvider.get());
    }
}
