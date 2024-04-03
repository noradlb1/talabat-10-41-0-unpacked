package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.incentiveautoapplydiscounts.domain.di.IncentiveAutoApplyDiscountsFeatureApi;
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
public final class FeaturesModule_IncentiveAutoApplyDiscountsFeatureApiFactory implements Factory<IncentiveAutoApplyDiscountsFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_IncentiveAutoApplyDiscountsFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_IncentiveAutoApplyDiscountsFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_IncentiveAutoApplyDiscountsFeatureApiFactory(provider);
    }

    public static IncentiveAutoApplyDiscountsFeatureApi incentiveAutoApplyDiscountsFeatureApi(Map<Class<?>, Api> map) {
        return (IncentiveAutoApplyDiscountsFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.incentiveAutoApplyDiscountsFeatureApi(map));
    }

    public IncentiveAutoApplyDiscountsFeatureApi get() {
        return incentiveAutoApplyDiscountsFeatureApi(this.coreApisProvider.get());
    }
}
