package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.darkstoresscheduleddelivery.domain.DarkstoresScheduledDeliveryFeatureApi;
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
public final class FeaturesModule_DarkstoresScheduledDeliveryFeatureApiFactory implements Factory<DarkstoresScheduledDeliveryFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_DarkstoresScheduledDeliveryFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_DarkstoresScheduledDeliveryFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_DarkstoresScheduledDeliveryFeatureApiFactory(provider);
    }

    public static DarkstoresScheduledDeliveryFeatureApi darkstoresScheduledDeliveryFeatureApi(Map<Class<?>, Api> map) {
        return (DarkstoresScheduledDeliveryFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.darkstoresScheduledDeliveryFeatureApi(map));
    }

    public DarkstoresScheduledDeliveryFeatureApi get() {
        return darkstoresScheduledDeliveryFeatureApi(this.coreApisProvider.get());
    }
}
