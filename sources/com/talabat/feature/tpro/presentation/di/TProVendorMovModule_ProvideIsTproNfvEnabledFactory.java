package com.talabat.feature.tpro.presentation.di;

import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class TProVendorMovModule_ProvideIsTproNfvEnabledFactory implements Factory<Boolean> {
    private final Provider<ISubscriptionsFeatureFlagsRepository> flagsRepositoryProvider;

    public TProVendorMovModule_ProvideIsTproNfvEnabledFactory(Provider<ISubscriptionsFeatureFlagsRepository> provider) {
        this.flagsRepositoryProvider = provider;
    }

    public static TProVendorMovModule_ProvideIsTproNfvEnabledFactory create(Provider<ISubscriptionsFeatureFlagsRepository> provider) {
        return new TProVendorMovModule_ProvideIsTproNfvEnabledFactory(provider);
    }

    public static boolean provideIsTproNfvEnabled(ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        return TProVendorMovModule.INSTANCE.provideIsTproNfvEnabled(iSubscriptionsFeatureFlagsRepository);
    }

    public Boolean get() {
        return Boolean.valueOf(provideIsTproNfvEnabled(this.flagsRepositoryProvider.get()));
    }
}
