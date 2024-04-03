package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.bnplcore.domain.BnplCoreFeatureApi;
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
public final class FeaturesModule_BnplCoreFeatureApiFactory implements Factory<BnplCoreFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_BnplCoreFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static BnplCoreFeatureApi bnplCoreFeatureApi(Map<Class<?>, Api> map) {
        return (BnplCoreFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.bnplCoreFeatureApi(map));
    }

    public static FeaturesModule_BnplCoreFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_BnplCoreFeatureApiFactory(provider);
    }

    public BnplCoreFeatureApi get() {
        return bnplCoreFeatureApi(this.coreApisProvider.get());
    }
}
