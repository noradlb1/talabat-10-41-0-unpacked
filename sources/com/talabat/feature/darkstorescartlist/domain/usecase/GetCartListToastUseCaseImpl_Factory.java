package com.talabat.feature.darkstorescartlist.domain.usecase;

import com.talabat.feature.darkstorescartlist.domain.repository.DarkstoresCartListRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetCartListToastUseCaseImpl_Factory implements Factory<GetCartListToastUseCaseImpl> {
    private final Provider<DarkstoresCartListRepository> darkstoresCartListRepositoryProvider;
    private final Provider<IsMultiBasketCommunicationExperimentEnabledUseCase> isMultiBasketCommunicationExperimentEnabledProvider;
    private final Provider<IsMultiBasketEnabledUseCase> isMultiBasketEnabledProvider;

    public GetCartListToastUseCaseImpl_Factory(Provider<IsMultiBasketEnabledUseCase> provider, Provider<DarkstoresCartListRepository> provider2, Provider<IsMultiBasketCommunicationExperimentEnabledUseCase> provider3) {
        this.isMultiBasketEnabledProvider = provider;
        this.darkstoresCartListRepositoryProvider = provider2;
        this.isMultiBasketCommunicationExperimentEnabledProvider = provider3;
    }

    public static GetCartListToastUseCaseImpl_Factory create(Provider<IsMultiBasketEnabledUseCase> provider, Provider<DarkstoresCartListRepository> provider2, Provider<IsMultiBasketCommunicationExperimentEnabledUseCase> provider3) {
        return new GetCartListToastUseCaseImpl_Factory(provider, provider2, provider3);
    }

    public static GetCartListToastUseCaseImpl newInstance(IsMultiBasketEnabledUseCase isMultiBasketEnabledUseCase, DarkstoresCartListRepository darkstoresCartListRepository, IsMultiBasketCommunicationExperimentEnabledUseCase isMultiBasketCommunicationExperimentEnabledUseCase) {
        return new GetCartListToastUseCaseImpl(isMultiBasketEnabledUseCase, darkstoresCartListRepository, isMultiBasketCommunicationExperimentEnabledUseCase);
    }

    public GetCartListToastUseCaseImpl get() {
        return newInstance(this.isMultiBasketEnabledProvider.get(), this.darkstoresCartListRepositoryProvider.get(), this.isMultiBasketCommunicationExperimentEnabledProvider.get());
    }
}
