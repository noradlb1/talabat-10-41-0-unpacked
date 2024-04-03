package com.talabat.feature.cancellationpolicy.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CancellationPolicyService_Factory implements Factory<CancellationPolicyService> {
    private final Provider<CancellationPolicyApi> apiProvider;

    public CancellationPolicyService_Factory(Provider<CancellationPolicyApi> provider) {
        this.apiProvider = provider;
    }

    public static CancellationPolicyService_Factory create(Provider<CancellationPolicyApi> provider) {
        return new CancellationPolicyService_Factory(provider);
    }

    public static CancellationPolicyService newInstance(CancellationPolicyApi cancellationPolicyApi) {
        return new CancellationPolicyService(cancellationPolicyApi);
    }

    public CancellationPolicyService get() {
        return newInstance(this.apiProvider.get());
    }
}
