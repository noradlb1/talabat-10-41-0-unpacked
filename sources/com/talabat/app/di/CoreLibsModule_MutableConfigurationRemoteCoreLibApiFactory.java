package com.talabat.app.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_MutableConfigurationRemoteCoreLibApiFactory implements Factory<MutableConfigurationRemoteCoreLibApi> {
    private final Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final Provider<FeatureFlagCoreLibApi> featureFlagCoreLibApiProvider;
    private final CoreLibsModule module;
    private final Provider<NetworkCoreLibApi> networkCoreLibApiProvider;
    private final Provider<ParserCoreLibApi> parserCoreLibApiProvider;

    public CoreLibsModule_MutableConfigurationRemoteCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ConfigurationLocalCoreLibApi> provider, Provider<ContextCoreLibApi> provider2, Provider<FeatureFlagCoreLibApi> provider3, Provider<NetworkCoreLibApi> provider4, Provider<ParserCoreLibApi> provider5) {
        this.module = coreLibsModule;
        this.configurationLocalCoreLibApiProvider = provider;
        this.contextCoreLibApiProvider = provider2;
        this.featureFlagCoreLibApiProvider = provider3;
        this.networkCoreLibApiProvider = provider4;
        this.parserCoreLibApiProvider = provider5;
    }

    public static CoreLibsModule_MutableConfigurationRemoteCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ConfigurationLocalCoreLibApi> provider, Provider<ContextCoreLibApi> provider2, Provider<FeatureFlagCoreLibApi> provider3, Provider<NetworkCoreLibApi> provider4, Provider<ParserCoreLibApi> provider5) {
        return new CoreLibsModule_MutableConfigurationRemoteCoreLibApiFactory(coreLibsModule, provider, provider2, provider3, provider4, provider5);
    }

    public static MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi(CoreLibsModule coreLibsModule, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ParserCoreLibApi parserCoreLibApi) {
        return (MutableConfigurationRemoteCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.mutableConfigurationRemoteCoreLibApi(configurationLocalCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, parserCoreLibApi));
    }

    public MutableConfigurationRemoteCoreLibApi get() {
        return mutableConfigurationRemoteCoreLibApi(this.module, this.configurationLocalCoreLibApiProvider.get(), this.contextCoreLibApiProvider.get(), this.featureFlagCoreLibApiProvider.get(), this.networkCoreLibApiProvider.get(), this.parserCoreLibApiProvider.get());
    }
}
