package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.rewards.domain.RewardsFeatureApi;
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
public final class FeaturesModule_RewardsFeatureApiFactory implements Factory<RewardsFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_RewardsFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_RewardsFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_RewardsFeatureApiFactory(provider);
    }

    public static RewardsFeatureApi rewardsFeatureApi(Map<Class<?>, Api> map) {
        return (RewardsFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.rewardsFeatureApi(map));
    }

    public RewardsFeatureApi get() {
        return rewardsFeatureApi(this.coreApisProvider.get());
    }
}
