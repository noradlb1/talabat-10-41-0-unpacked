package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetTProVendorMovUseCase_Factory implements Factory<GetTProVendorMovUseCase> {
    private final Provider<ISubscriptionsRepository> repositoryProvider;

    public GetTProVendorMovUseCase_Factory(Provider<ISubscriptionsRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static GetTProVendorMovUseCase_Factory create(Provider<ISubscriptionsRepository> provider) {
        return new GetTProVendorMovUseCase_Factory(provider);
    }

    public static GetTProVendorMovUseCase newInstance(ISubscriptionsRepository iSubscriptionsRepository) {
        return new GetTProVendorMovUseCase(iSubscriptionsRepository);
    }

    public GetTProVendorMovUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
