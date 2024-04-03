package com.talabat.feature.ulcampaign.data;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CampaignMigratorObservabilityImpl_Factory implements Factory<CampaignMigratorObservabilityImpl> {
    private final Provider<IObservabilityManager> observabilityProvider;

    public CampaignMigratorObservabilityImpl_Factory(Provider<IObservabilityManager> provider) {
        this.observabilityProvider = provider;
    }

    public static CampaignMigratorObservabilityImpl_Factory create(Provider<IObservabilityManager> provider) {
        return new CampaignMigratorObservabilityImpl_Factory(provider);
    }

    public static CampaignMigratorObservabilityImpl newInstance(IObservabilityManager iObservabilityManager) {
        return new CampaignMigratorObservabilityImpl(iObservabilityManager);
    }

    public CampaignMigratorObservabilityImpl get() {
        return newInstance(this.observabilityProvider.get());
    }
}
