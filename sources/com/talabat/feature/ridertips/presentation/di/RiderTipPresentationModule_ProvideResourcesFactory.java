package com.talabat.feature.ridertips.presentation.di;

import android.content.Context;
import android.content.res.Resources;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class RiderTipPresentationModule_ProvideResourcesFactory implements Factory<Resources> {
    private final Provider<Context> contextProvider;

    public RiderTipPresentationModule_ProvideResourcesFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static RiderTipPresentationModule_ProvideResourcesFactory create(Provider<Context> provider) {
        return new RiderTipPresentationModule_ProvideResourcesFactory(provider);
    }

    public static Resources provideResources(Context context) {
        return (Resources) Preconditions.checkNotNullFromProvides(RiderTipPresentationModule.INSTANCE.provideResources(context));
    }

    public Resources get() {
        return provideResources(this.contextProvider.get());
    }
}
