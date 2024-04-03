package com.talabat.feature.ridertips.presentation.di;

import android.content.res.Resources;
import com.talabat.feature.ridertips.presentation.IResourceProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RiderTipPresentationModule_ProvideResourceProviderFactory implements Factory<IResourceProvider> {
    private final Provider<Resources> resourcesProvider;

    public RiderTipPresentationModule_ProvideResourceProviderFactory(Provider<Resources> provider) {
        this.resourcesProvider = provider;
    }

    public static RiderTipPresentationModule_ProvideResourceProviderFactory create(Provider<Resources> provider) {
        return new RiderTipPresentationModule_ProvideResourceProviderFactory(provider);
    }

    public static IResourceProvider provideResourceProvider(Resources resources) {
        return (IResourceProvider) Preconditions.checkNotNullFromProvides(RiderTipPresentationModule.INSTANCE.provideResourceProvider(resources));
    }

    public IResourceProvider get() {
        return provideResourceProvider(this.resourcesProvider.get());
    }
}
