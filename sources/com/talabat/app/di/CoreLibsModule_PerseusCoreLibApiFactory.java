package com.talabat.app.di;

import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.perseus.domain.TalabatPerseusCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_PerseusCoreLibApiFactory implements Factory<TalabatPerseusCoreLibApi> {
    private final Provider<ConfigurationRemoteCoreLibApi> configurationRemoteCoreLibApiProvider;
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final Provider<DispatcherCoreLibApi> dispatcherCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_PerseusCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ConfigurationRemoteCoreLibApi> provider, Provider<ContextCoreLibApi> provider2, Provider<DispatcherCoreLibApi> provider3) {
        this.module = coreLibsModule;
        this.configurationRemoteCoreLibApiProvider = provider;
        this.contextCoreLibApiProvider = provider2;
        this.dispatcherCoreLibApiProvider = provider3;
    }

    public static CoreLibsModule_PerseusCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ConfigurationRemoteCoreLibApi> provider, Provider<ContextCoreLibApi> provider2, Provider<DispatcherCoreLibApi> provider3) {
        return new CoreLibsModule_PerseusCoreLibApiFactory(coreLibsModule, provider, provider2, provider3);
    }

    public static TalabatPerseusCoreLibApi perseusCoreLibApi(CoreLibsModule coreLibsModule, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi) {
        return (TalabatPerseusCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.perseusCoreLibApi(configurationRemoteCoreLibApi, contextCoreLibApi, dispatcherCoreLibApi));
    }

    public TalabatPerseusCoreLibApi get() {
        return perseusCoreLibApi(this.module, this.configurationRemoteCoreLibApiProvider.get(), this.contextCoreLibApiProvider.get(), this.dispatcherCoreLibApiProvider.get());
    }
}
