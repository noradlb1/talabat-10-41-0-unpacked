package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.ridertips.domain.RiderTipFeatureApi;
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
public final class FeaturesModule_RiderTipFeatureApiFactory implements Factory<RiderTipFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_RiderTipFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_RiderTipFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_RiderTipFeatureApiFactory(provider);
    }

    public static RiderTipFeatureApi riderTipFeatureApi(Map<Class<?>, Api> map) {
        return (RiderTipFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.riderTipFeatureApi(map));
    }

    public RiderTipFeatureApi get() {
        return riderTipFeatureApi(this.coreApisProvider.get());
    }
}
