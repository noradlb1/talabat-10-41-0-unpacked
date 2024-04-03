package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.pickup.domain.PickupFeatureApi;
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
public final class FeaturesModule_PickupFeatureApiFactory implements Factory<PickupFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_PickupFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_PickupFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_PickupFeatureApiFactory(provider);
    }

    public static PickupFeatureApi pickupFeatureApi(Map<Class<?>, Api> map) {
        return (PickupFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.pickupFeatureApi(map));
    }

    public PickupFeatureApi get() {
        return pickupFeatureApi(this.coreApisProvider.get());
    }
}
