package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
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
public final class FeaturesModule_HelpCenterFeatureApiFactory implements Factory<HelpCenterFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_HelpCenterFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_HelpCenterFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_HelpCenterFeatureApiFactory(provider);
    }

    public static HelpCenterFeatureApi helpCenterFeatureApi(Map<Class<?>, Api> map) {
        return (HelpCenterFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.helpCenterFeatureApi(map));
    }

    public HelpCenterFeatureApi get() {
        return helpCenterFeatureApi(this.coreApisProvider.get());
    }
}
