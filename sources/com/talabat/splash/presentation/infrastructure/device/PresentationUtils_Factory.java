package com.talabat.splash.presentation.infrastructure.device;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PresentationUtils_Factory implements Factory<PresentationUtils> {
    private final Provider<Context> contextProvider;

    public PresentationUtils_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static PresentationUtils_Factory create(Provider<Context> provider) {
        return new PresentationUtils_Factory(provider);
    }

    public static PresentationUtils newInstance(Context context) {
        return new PresentationUtils(context);
    }

    public PresentationUtils get() {
        return newInstance(this.contextProvider.get());
    }
}
