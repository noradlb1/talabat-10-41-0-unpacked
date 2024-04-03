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
public final class TproPresentationModule_ProvideTProIsBrandUpdatesEnabledFactory implements Factory<Boolean> {
    private final Provider<ISubscriptionsFeatureFlagsRepository> flagsRepositoryProvider;

    public TproPresentationModule_ProvideTProIsBrandUpdatesEnabledFactory(Provider<ISubscriptionsFeatureFlagsRepository> provider) {
        this.flagsRepositoryProvider = provider;
    }

    public static TproPresentationModule_ProvideTProIsBrandUpdatesEnabledFactory create(Provider<ISubscriptionsFeatureFlagsRepository> provider) {
        return new TproPresentationModule_ProvideTProIsBrandUpdatesEnabledFactory(provider);
    }

    public static boolean provideTProIsBrandUpdatesEnabled(ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        return TproPresentationModule.INSTANCE.provideTProIsBrandUpdatesEnabled(iSubscriptionsFeatureFlagsRepository);
    }

    public Boolean get() {
        return Boolean.valueOf(provideTProIsBrandUpdatesEnabled(this.flagsRepositoryProvider.get()));
    }
}
