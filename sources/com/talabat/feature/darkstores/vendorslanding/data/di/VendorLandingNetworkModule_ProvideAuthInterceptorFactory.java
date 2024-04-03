package com.talabat.feature.darkstores.vendorslanding.data.di;

import com.talabat.authentication.aaa.secrets.SecretProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.Interceptor;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstores.vendorslanding.data.di.VendorLanding"})
public final class VendorLandingNetworkModule_ProvideAuthInterceptorFactory implements Factory<Interceptor> {
    private final VendorLandingNetworkModule module;
    private final Provider<SecretProvider> secretProvider;

    public VendorLandingNetworkModule_ProvideAuthInterceptorFactory(VendorLandingNetworkModule vendorLandingNetworkModule, Provider<SecretProvider> provider) {
        this.module = vendorLandingNetworkModule;
        this.secretProvider = provider;
    }

    public static VendorLandingNetworkModule_ProvideAuthInterceptorFactory create(VendorLandingNetworkModule vendorLandingNetworkModule, Provider<SecretProvider> provider) {
        return new VendorLandingNetworkModule_ProvideAuthInterceptorFactory(vendorLandingNetworkModule, provider);
    }

    public static Interceptor provideAuthInterceptor(VendorLandingNetworkModule vendorLandingNetworkModule, SecretProvider secretProvider2) {
        return (Interceptor) Preconditions.checkNotNullFromProvides(vendorLandingNetworkModule.provideAuthInterceptor(secretProvider2));
    }

    public Interceptor get() {
        return provideAuthInterceptor(this.module, this.secretProvider.get());
    }
}
