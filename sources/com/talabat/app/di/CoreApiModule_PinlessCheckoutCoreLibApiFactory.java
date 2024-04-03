package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.pinless.checkout.domain.PinlessCheckoutCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_PinlessCheckoutCoreLibApiFactory implements Factory<Api> {
    private final Provider<PinlessCheckoutCoreLibApi> pinlessCheckoutCoreLibApiProvider;

    public CoreApiModule_PinlessCheckoutCoreLibApiFactory(Provider<PinlessCheckoutCoreLibApi> provider) {
        this.pinlessCheckoutCoreLibApiProvider = provider;
    }

    public static CoreApiModule_PinlessCheckoutCoreLibApiFactory create(Provider<PinlessCheckoutCoreLibApi> provider) {
        return new CoreApiModule_PinlessCheckoutCoreLibApiFactory(provider);
    }

    public static Api pinlessCheckoutCoreLibApi(PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.pinlessCheckoutCoreLibApi(pinlessCheckoutCoreLibApi));
    }

    public Api get() {
        return pinlessCheckoutCoreLibApi(this.pinlessCheckoutCoreLibApiProvider.get());
    }
}
