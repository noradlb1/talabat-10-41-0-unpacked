package com.talabat.app.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_FeatureFlagCoreLibApiFactory implements Factory<FeatureFlagCoreLibApi> {
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_FeatureFlagCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        this.module = coreLibsModule;
        this.contextCoreLibApiProvider = provider;
    }

    public static CoreLibsModule_FeatureFlagCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        return new CoreLibsModule_FeatureFlagCoreLibApiFactory(coreLibsModule, provider);
    }

    public static FeatureFlagCoreLibApi featureFlagCoreLibApi(CoreLibsModule coreLibsModule, ContextCoreLibApi contextCoreLibApi) {
        return (FeatureFlagCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.featureFlagCoreLibApi(contextCoreLibApi));
    }

    public FeatureFlagCoreLibApi get() {
        return featureFlagCoreLibApi(this.module, this.contextCoreLibApiProvider.get());
    }
}
