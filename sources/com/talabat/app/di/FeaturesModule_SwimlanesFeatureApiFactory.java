package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.darkstores.swimlanes.domain.SwimlanesFeatureApi;
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
public final class FeaturesModule_SwimlanesFeatureApiFactory implements Factory<SwimlanesFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_SwimlanesFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_SwimlanesFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_SwimlanesFeatureApiFactory(provider);
    }

    public static SwimlanesFeatureApi swimlanesFeatureApi(Map<Class<?>, Api> map) {
        return (SwimlanesFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.swimlanesFeatureApi(map));
    }

    public SwimlanesFeatureApi get() {
        return swimlanesFeatureApi(this.coreApisProvider.get());
    }
}
