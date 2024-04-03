package com.talabat.feature.cancellationpolicy.di;

import com.talabat.feature.cancellationpolicy.remote.CancellationPolicyApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class HelpCenterNetworkModule_ProvideCancellationApiFactory implements Factory<CancellationPolicyApi> {
    private final Provider<String> baseUrlProvider;

    public HelpCenterNetworkModule_ProvideCancellationApiFactory(Provider<String> provider) {
        this.baseUrlProvider = provider;
    }

    public static HelpCenterNetworkModule_ProvideCancellationApiFactory create(Provider<String> provider) {
        return new HelpCenterNetworkModule_ProvideCancellationApiFactory(provider);
    }

    public static CancellationPolicyApi provideCancellationApi(String str) {
        return (CancellationPolicyApi) Preconditions.checkNotNullFromProvides(HelpCenterNetworkModule.INSTANCE.provideCancellationApi(str));
    }

    public CancellationPolicyApi get() {
        return provideCancellationApi(this.baseUrlProvider.get());
    }
}
