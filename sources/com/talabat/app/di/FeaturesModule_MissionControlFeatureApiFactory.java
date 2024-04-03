package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.mission.control.domain.MissionControlFeatureApi;
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
public final class FeaturesModule_MissionControlFeatureApiFactory implements Factory<MissionControlFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_MissionControlFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_MissionControlFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_MissionControlFeatureApiFactory(provider);
    }

    public static MissionControlFeatureApi missionControlFeatureApi(Map<Class<?>, Api> map) {
        return (MissionControlFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.missionControlFeatureApi(map));
    }

    public MissionControlFeatureApi get() {
        return missionControlFeatureApi(this.coreApisProvider.get());
    }
}
