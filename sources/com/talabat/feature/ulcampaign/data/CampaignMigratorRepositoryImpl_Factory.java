package com.talabat.feature.ulcampaign.data;

import com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CampaignMigratorRepositoryImpl_Factory implements Factory<CampaignMigratorRepositoryImpl> {
    private final Provider<CampaignMigratorObservability> observabilityProvider;
    private final Provider<CampaignMigratorSharedPreferences> sharedPreferencesManagerProvider;

    public CampaignMigratorRepositoryImpl_Factory(Provider<CampaignMigratorObservability> provider, Provider<CampaignMigratorSharedPreferences> provider2) {
        this.observabilityProvider = provider;
        this.sharedPreferencesManagerProvider = provider2;
    }

    public static CampaignMigratorRepositoryImpl_Factory create(Provider<CampaignMigratorObservability> provider, Provider<CampaignMigratorSharedPreferences> provider2) {
        return new CampaignMigratorRepositoryImpl_Factory(provider, provider2);
    }

    public static CampaignMigratorRepositoryImpl newInstance(CampaignMigratorObservability campaignMigratorObservability, CampaignMigratorSharedPreferences campaignMigratorSharedPreferences) {
        return new CampaignMigratorRepositoryImpl(campaignMigratorObservability, campaignMigratorSharedPreferences);
    }

    public CampaignMigratorRepositoryImpl get() {
        return newInstance(this.observabilityProvider.get(), this.sharedPreferencesManagerProvider.get());
    }
}
