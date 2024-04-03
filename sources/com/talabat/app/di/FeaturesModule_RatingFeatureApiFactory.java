package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.rating.domain.RatingFeatureApi;
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
public final class FeaturesModule_RatingFeatureApiFactory implements Factory<RatingFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_RatingFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_RatingFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_RatingFeatureApiFactory(provider);
    }

    public static RatingFeatureApi ratingFeatureApi(Map<Class<?>, Api> map) {
        return (RatingFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.ratingFeatureApi(map));
    }

    public RatingFeatureApi get() {
        return ratingFeatureApi(this.coreApisProvider.get());
    }
}
