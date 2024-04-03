package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.tmart.growth.domain.TMartGrowthFeatureApi;
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
public final class FeaturesModule_TmartGrowthFeatureApiFactory implements Factory<TMartGrowthFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_TmartGrowthFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_TmartGrowthFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_TmartGrowthFeatureApiFactory(provider);
    }

    public static TMartGrowthFeatureApi tmartGrowthFeatureApi(Map<Class<?>, Api> map) {
        return (TMartGrowthFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.tmartGrowthFeatureApi(map));
    }

    public TMartGrowthFeatureApi get() {
        return tmartGrowthFeatureApi(this.coreApisProvider.get());
    }
}
