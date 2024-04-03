package com.talabat.darkstores.domain.presearch;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetPreSearchSwimlaneUseCaseImpl_Factory implements Factory<GetPreSearchSwimlaneUseCaseImpl> {
    private final Provider<DiscoveryRepo> discoveryRepoProvider;

    public GetPreSearchSwimlaneUseCaseImpl_Factory(Provider<DiscoveryRepo> provider) {
        this.discoveryRepoProvider = provider;
    }

    public static GetPreSearchSwimlaneUseCaseImpl_Factory create(Provider<DiscoveryRepo> provider) {
        return new GetPreSearchSwimlaneUseCaseImpl_Factory(provider);
    }

    public static GetPreSearchSwimlaneUseCaseImpl newInstance(DiscoveryRepo discoveryRepo) {
        return new GetPreSearchSwimlaneUseCaseImpl(discoveryRepo);
    }

    public GetPreSearchSwimlaneUseCaseImpl get() {
        return newInstance(this.discoveryRepoProvider.get());
    }
}
