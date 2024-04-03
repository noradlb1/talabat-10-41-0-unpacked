package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.foodcart2.domain.di.FoodCartFeatureApi;
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
public final class FeaturesModule_FoodCartFeatureApiFactory implements Factory<FoodCartFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_FoodCartFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_FoodCartFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_FoodCartFeatureApiFactory(provider);
    }

    public static FoodCartFeatureApi foodCartFeatureApi(Map<Class<?>, Api> map) {
        return (FoodCartFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.foodCartFeatureApi(map));
    }

    public FoodCartFeatureApi get() {
        return foodCartFeatureApi(this.coreApisProvider.get());
    }
}
