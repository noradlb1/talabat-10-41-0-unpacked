package com.talabat.app.di;

import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.advertisement.google.domain.GoogleAdvertisementCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.perseus.domain.TalabatPerseusCoreLibApi;
import com.talabat.core.safety.domain.SafetyCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_SafetyCoreLibApiFactory implements Factory<SafetyCoreLibApi> {
    private final Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;
    private final Provider<ConfigurationRemoteCoreLibApi> configurationRemoteCoreLibApiProvider;
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final Provider<DispatcherCoreLibApi> dispatcherCoreLibApiProvider;
    private final Provider<GmsBaseCoreLibApi> gmsBaseCoreLibApiProvider;
    private final Provider<GoogleAdvertisementCoreLibApi> googleAdvertisementCoreLibApiProvider;
    private final CoreLibsModule module;
    private final Provider<NetworkCoreLibApi> networkCoreLibApiProvider;
    private final Provider<ObservabilityCoreLibApi> observabilityCoreLibApiProvider;
    private final Provider<SecretCoreLibApi> secretCoreLibApiProvider;
    private final Provider<TalabatPerseusCoreLibApi> talabatPerseusCoreLibApiProvider;

    public CoreLibsModule_SafetyCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ConfigurationLocalCoreLibApi> provider, Provider<ConfigurationRemoteCoreLibApi> provider2, Provider<ContextCoreLibApi> provider3, Provider<GoogleAdvertisementCoreLibApi> provider4, Provider<GmsBaseCoreLibApi> provider5, Provider<DispatcherCoreLibApi> provider6, Provider<NetworkCoreLibApi> provider7, Provider<ObservabilityCoreLibApi> provider8, Provider<SecretCoreLibApi> provider9, Provider<TalabatPerseusCoreLibApi> provider10) {
        this.module = coreLibsModule;
        this.configurationLocalCoreLibApiProvider = provider;
        this.configurationRemoteCoreLibApiProvider = provider2;
        this.contextCoreLibApiProvider = provider3;
        this.googleAdvertisementCoreLibApiProvider = provider4;
        this.gmsBaseCoreLibApiProvider = provider5;
        this.dispatcherCoreLibApiProvider = provider6;
        this.networkCoreLibApiProvider = provider7;
        this.observabilityCoreLibApiProvider = provider8;
        this.secretCoreLibApiProvider = provider9;
        this.talabatPerseusCoreLibApiProvider = provider10;
    }

    public static CoreLibsModule_SafetyCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ConfigurationLocalCoreLibApi> provider, Provider<ConfigurationRemoteCoreLibApi> provider2, Provider<ContextCoreLibApi> provider3, Provider<GoogleAdvertisementCoreLibApi> provider4, Provider<GmsBaseCoreLibApi> provider5, Provider<DispatcherCoreLibApi> provider6, Provider<NetworkCoreLibApi> provider7, Provider<ObservabilityCoreLibApi> provider8, Provider<SecretCoreLibApi> provider9, Provider<TalabatPerseusCoreLibApi> provider10) {
        return new CoreLibsModule_SafetyCoreLibApiFactory(coreLibsModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static SafetyCoreLibApi safetyCoreLibApi(CoreLibsModule coreLibsModule, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, GoogleAdvertisementCoreLibApi googleAdvertisementCoreLibApi, GmsBaseCoreLibApi gmsBaseCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, SecretCoreLibApi secretCoreLibApi, TalabatPerseusCoreLibApi talabatPerseusCoreLibApi) {
        return (SafetyCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.safetyCoreLibApi(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, contextCoreLibApi, googleAdvertisementCoreLibApi, gmsBaseCoreLibApi, dispatcherCoreLibApi, networkCoreLibApi, observabilityCoreLibApi, secretCoreLibApi, talabatPerseusCoreLibApi));
    }

    public SafetyCoreLibApi get() {
        return safetyCoreLibApi(this.module, this.configurationLocalCoreLibApiProvider.get(), this.configurationRemoteCoreLibApiProvider.get(), this.contextCoreLibApiProvider.get(), this.googleAdvertisementCoreLibApiProvider.get(), this.gmsBaseCoreLibApiProvider.get(), this.dispatcherCoreLibApiProvider.get(), this.networkCoreLibApiProvider.get(), this.observabilityCoreLibApiProvider.get(), this.secretCoreLibApiProvider.get(), this.talabatPerseusCoreLibApiProvider.get());
    }
}
