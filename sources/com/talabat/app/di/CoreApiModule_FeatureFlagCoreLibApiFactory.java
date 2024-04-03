package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_FeatureFlagCoreLibApiFactory implements Factory<Api> {
    private final Provider<FeatureFlagCoreLibApi> featureFlagCoreLibApiProvider;

    public CoreApiModule_FeatureFlagCoreLibApiFactory(Provider<FeatureFlagCoreLibApi> provider) {
        this.featureFlagCoreLibApiProvider = provider;
    }

    public static CoreApiModule_FeatureFlagCoreLibApiFactory create(Provider<FeatureFlagCoreLibApi> provider) {
        return new CoreApiModule_FeatureFlagCoreLibApiFactory(provider);
    }

    public static Api featureFlagCoreLibApi(FeatureFlagCoreLibApi featureFlagCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.featureFlagCoreLibApi(featureFlagCoreLibApi));
    }

    public Api get() {
        return featureFlagCoreLibApi(this.featureFlagCoreLibApiProvider.get());
    }
}
