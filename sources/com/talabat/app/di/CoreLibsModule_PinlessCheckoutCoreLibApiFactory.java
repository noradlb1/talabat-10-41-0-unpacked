package com.talabat.app.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.pinless.checkout.domain.PinlessCheckoutCoreLibApi;
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
public final class CoreLibsModule_PinlessCheckoutCoreLibApiFactory implements Factory<PinlessCheckoutCoreLibApi> {
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final CoreLibsModule module;
    private final Provider<TrackingCoreLibApi> trackingCoreLibApiProvider;

    public CoreLibsModule_PinlessCheckoutCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider, Provider<TrackingCoreLibApi> provider2) {
        this.module = coreLibsModule;
        this.contextCoreLibApiProvider = provider;
        this.trackingCoreLibApiProvider = provider2;
    }

    public static CoreLibsModule_PinlessCheckoutCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider, Provider<TrackingCoreLibApi> provider2) {
        return new CoreLibsModule_PinlessCheckoutCoreLibApiFactory(coreLibsModule, provider, provider2);
    }

    public static PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi(CoreLibsModule coreLibsModule, ContextCoreLibApi contextCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
        return (PinlessCheckoutCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.pinlessCheckoutCoreLibApi(contextCoreLibApi, trackingCoreLibApi));
    }

    public PinlessCheckoutCoreLibApi get() {
        return pinlessCheckoutCoreLibApi(this.module, this.contextCoreLibApiProvider.get(), this.trackingCoreLibApiProvider.get());
    }
}
