package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.fees.domain.FeesFeatureApi;
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
public final class FeaturesModule_FeesFeatureApiFactory implements Factory<FeesFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_FeesFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_FeesFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_FeesFeatureApiFactory(provider);
    }

    public static FeesFeatureApi feesFeatureApi(Map<Class<?>, Api> map) {
        return (FeesFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.feesFeatureApi(map));
    }

    public FeesFeatureApi get() {
        return feesFeatureApi(this.coreApisProvider.get());
    }
}
