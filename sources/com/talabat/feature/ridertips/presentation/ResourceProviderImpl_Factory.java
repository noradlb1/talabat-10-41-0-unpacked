package com.talabat.feature.ridertips.presentation;

import android.content.res.Resources;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ResourceProviderImpl_Factory implements Factory<ResourceProviderImpl> {
    private final Provider<Resources> resourcesProvider;

    public ResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.resourcesProvider = provider;
    }

    public static ResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new ResourceProviderImpl_Factory(provider);
    }

    public static ResourceProviderImpl newInstance(Resources resources) {
        return new ResourceProviderImpl(resources);
    }

    public ResourceProviderImpl get() {
        return newInstance(this.resourcesProvider.get());
    }
}
