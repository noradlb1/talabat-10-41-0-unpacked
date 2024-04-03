package com.talabat.app.di;

import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreImplLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.flutter.secrets.domain.FlutterSecretsCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_FlutterChannelsCoreLibApiFactory implements Factory<FlutterChannelsCoreLibApi> {
    private final Provider<DispatcherCoreLibApi> dispatcherCoreLibApiProvider;
    private final Provider<FlutterChannelsCoreImplLibApi> flutterChannelsCoreImplLibApiProvider;
    private final Provider<FlutterSecretsCoreLibApi> flutterSecretsCoreLibApiProvider;
    private final CoreLibsModule module;
    private final Provider<ObservabilityCoreLibApi> observabilityCoreLibApiProvider;

    public CoreLibsModule_FlutterChannelsCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<FlutterChannelsCoreImplLibApi> provider, Provider<FlutterSecretsCoreLibApi> provider2, Provider<DispatcherCoreLibApi> provider3, Provider<ObservabilityCoreLibApi> provider4) {
        this.module = coreLibsModule;
        this.flutterChannelsCoreImplLibApiProvider = provider;
        this.flutterSecretsCoreLibApiProvider = provider2;
        this.dispatcherCoreLibApiProvider = provider3;
        this.observabilityCoreLibApiProvider = provider4;
    }

    public static CoreLibsModule_FlutterChannelsCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<FlutterChannelsCoreImplLibApi> provider, Provider<FlutterSecretsCoreLibApi> provider2, Provider<DispatcherCoreLibApi> provider3, Provider<ObservabilityCoreLibApi> provider4) {
        return new CoreLibsModule_FlutterChannelsCoreLibApiFactory(coreLibsModule, provider, provider2, provider3, provider4);
    }

    public static FlutterChannelsCoreLibApi flutterChannelsCoreLibApi(CoreLibsModule coreLibsModule, FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi, FlutterSecretsCoreLibApi flutterSecretsCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
        return (FlutterChannelsCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.flutterChannelsCoreLibApi(flutterChannelsCoreImplLibApi, flutterSecretsCoreLibApi, dispatcherCoreLibApi, observabilityCoreLibApi));
    }

    public FlutterChannelsCoreLibApi get() {
        return flutterChannelsCoreLibApi(this.module, this.flutterChannelsCoreImplLibApiProvider.get(), this.flutterSecretsCoreLibApiProvider.get(), this.dispatcherCoreLibApiProvider.get(), this.observabilityCoreLibApiProvider.get());
    }
}
