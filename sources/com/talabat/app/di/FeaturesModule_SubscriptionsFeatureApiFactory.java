package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
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
public final class FeaturesModule_SubscriptionsFeatureApiFactory implements Factory<SubscriptionsFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_SubscriptionsFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_SubscriptionsFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_SubscriptionsFeatureApiFactory(provider);
    }

    public static SubscriptionsFeatureApi subscriptionsFeatureApi(Map<Class<?>, Api> map) {
        return (SubscriptionsFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.subscriptionsFeatureApi(map));
    }

    public SubscriptionsFeatureApi get() {
        return subscriptionsFeatureApi(this.coreApisProvider.get());
    }
}
