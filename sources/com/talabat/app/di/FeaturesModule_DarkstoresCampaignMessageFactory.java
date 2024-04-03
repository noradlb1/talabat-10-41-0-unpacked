package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.darkstorescampaignmessage.domain.CampaignMessagingApi;
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
public final class FeaturesModule_DarkstoresCampaignMessageFactory implements Factory<CampaignMessagingApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_DarkstoresCampaignMessageFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_DarkstoresCampaignMessageFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_DarkstoresCampaignMessageFactory(provider);
    }

    public static CampaignMessagingApi darkstoresCampaignMessage(Map<Class<?>, Api> map) {
        return (CampaignMessagingApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.darkstoresCampaignMessage(map));
    }

    public CampaignMessagingApi get() {
        return darkstoresCampaignMessage(this.coreApisProvider.get());
    }
}
