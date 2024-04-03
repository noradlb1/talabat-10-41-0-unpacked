package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorFeatureApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class FeaturesModule_CampaignMigratorFeatureApiFactory implements Factory<CampaignMigratorFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_CampaignMigratorFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static CampaignMigratorFeatureApi campaignMigratorFeatureApi(Map<Class<?>, Api> map) {
        return (CampaignMigratorFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.campaignMigratorFeatureApi(map));
    }

    public static FeaturesModule_CampaignMigratorFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_CampaignMigratorFeatureApiFactory(provider);
    }

    public CampaignMigratorFeatureApi get() {
        return campaignMigratorFeatureApi(this.coreApisProvider.get());
    }
}
