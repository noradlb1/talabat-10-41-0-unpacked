package com.talabat.feature.ulcampaign.domain.usecase;

import com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VoucherCampaignCacheUseCase_Factory implements Factory<VoucherCampaignCacheUseCase> {
    private final Provider<CampaignMigratorSharedPreferences> campaignMigratorSharedPreferencesProvider;

    public VoucherCampaignCacheUseCase_Factory(Provider<CampaignMigratorSharedPreferences> provider) {
        this.campaignMigratorSharedPreferencesProvider = provider;
    }

    public static VoucherCampaignCacheUseCase_Factory create(Provider<CampaignMigratorSharedPreferences> provider) {
        return new VoucherCampaignCacheUseCase_Factory(provider);
    }

    public static VoucherCampaignCacheUseCase newInstance(CampaignMigratorSharedPreferences campaignMigratorSharedPreferences) {
        return new VoucherCampaignCacheUseCase(campaignMigratorSharedPreferences);
    }

    public VoucherCampaignCacheUseCase get() {
        return newInstance(this.campaignMigratorSharedPreferencesProvider.get());
    }
}
