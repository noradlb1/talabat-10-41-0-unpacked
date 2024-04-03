package com.talabat.feature.cancellationpolicy.di;

import com.talabat.feature.cancellationpolicy.remote.CancellationPolicyApi;
import com.talabat.feature.cancellationpolicy.remote.CancellationPolicyService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HelpCenterNetworkModule_ProvideCancellationServiceFactory implements Factory<CancellationPolicyService> {
    private final Provider<CancellationPolicyApi> cancellationPolicyApiProvider;

    public HelpCenterNetworkModule_ProvideCancellationServiceFactory(Provider<CancellationPolicyApi> provider) {
        this.cancellationPolicyApiProvider = provider;
    }

    public static HelpCenterNetworkModule_ProvideCancellationServiceFactory create(Provider<CancellationPolicyApi> provider) {
        return new HelpCenterNetworkModule_ProvideCancellationServiceFactory(provider);
    }

    public static CancellationPolicyService provideCancellationService(CancellationPolicyApi cancellationPolicyApi) {
        return (CancellationPolicyService) Preconditions.checkNotNullFromProvides(HelpCenterNetworkModule.INSTANCE.provideCancellationService(cancellationPolicyApi));
    }

    public CancellationPolicyService get() {
        return provideCancellationService(this.cancellationPolicyApiProvider.get());
    }
}
