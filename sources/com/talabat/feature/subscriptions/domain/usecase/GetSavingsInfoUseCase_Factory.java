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
public final class GetSavingsInfoUseCase_Factory implements Factory<GetSavingsInfoUseCase> {
    private final Provider<ISubscriptionsRepository> repositoryProvider;

    public GetSavingsInfoUseCase_Factory(Provider<ISubscriptionsRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static GetSavingsInfoUseCase_Factory create(Provider<ISubscriptionsRepository> provider) {
        return new GetSavingsInfoUseCase_Factory(provider);
    }

    public static GetSavingsInfoUseCase newInstance(ISubscriptionsRepository iSubscriptionsRepository) {
        return new GetSavingsInfoUseCase(iSubscriptionsRepository);
    }

    public GetSavingsInfoUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
