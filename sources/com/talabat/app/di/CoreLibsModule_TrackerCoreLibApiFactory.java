package com.talabat.app.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.hms.base.domain.HmsBaseCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.perseus.domain.TalabatPerseusCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_TrackerCoreLibApiFactory implements Factory<TrackingCoreLibApi> {
    private final Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final Provider<FeatureFlagCoreLibApi> featureFlagCoreLibApiProvider;
    private final Provider<GmsBaseCoreLibApi> gmsBaseCoreLibApiProvider;
    private final Provider<HmsBaseCoreLibApi> hmsBaseCoreLibApiProvider;
    private final CoreLibsModule module;
    private final Provider<ObservabilityCoreLibApi> observabilityCoreLibApiProvider;
    private final Provider<TalabatPerseusCoreLibApi> talabatPerseusCoreLibApiProvider;

    public CoreLibsModule_TrackerCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ConfigurationLocalCoreLibApi> provider, Provider<ContextCoreLibApi> provider2, Provider<FeatureFlagCoreLibApi> provider3, Provider<GmsBaseCoreLibApi> provider4, Provider<HmsBaseCoreLibApi> provider5, Provider<ObservabilityCoreLibApi> provider6, Provider<TalabatPerseusCoreLibApi> provider7) {
        this.module = coreLibsModule;
        this.configurationLocalCoreLibApiProvider = provider;
        this.contextCoreLibApiProvider = provider2;
        this.featureFlagCoreLibApiProvider = provider3;
        this.gmsBaseCoreLibApiProvider = provider4;
        this.hmsBaseCoreLibApiProvider = provider5;
        this.observabilityCoreLibApiProvider = provider6;
        this.talabatPerseusCoreLibApiProvider = provider7;
    }

    public static CoreLibsModule_TrackerCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ConfigurationLocalCoreLibApi> provider, Provider<ContextCoreLibApi> provider2, Provider<FeatureFlagCoreLibApi> provider3, Provider<GmsBaseCoreLibApi> provider4, Provider<HmsBaseCoreLibApi> provider5, Provider<ObservabilityCoreLibApi> provider6, Provider<TalabatPerseusCoreLibApi> provider7) {
        return new CoreLibsModule_TrackerCoreLibApiFactory(coreLibsModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static TrackingCoreLibApi trackerCoreLibApi(CoreLibsModule coreLibsModule, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, GmsBaseCoreLibApi gmsBaseCoreLibApi, HmsBaseCoreLibApi hmsBaseCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, TalabatPerseusCoreLibApi talabatPerseusCoreLibApi) {
        return (TrackingCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.trackerCoreLibApi(configurationLocalCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, gmsBaseCoreLibApi, hmsBaseCoreLibApi, observabilityCoreLibApi, talabatPerseusCoreLibApi));
    }

    public TrackingCoreLibApi get() {
        return trackerCoreLibApi(this.module, this.configurationLocalCoreLibApiProvider.get(), this.contextCoreLibApiProvider.get(), this.featureFlagCoreLibApiProvider.get(), this.gmsBaseCoreLibApiProvider.get(), this.hmsBaseCoreLibApiProvider.get(), this.observabilityCoreLibApiProvider.get(), this.talabatPerseusCoreLibApiProvider.get());
    }
}
