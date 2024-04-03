package com.talabat.feature.activecarts.domain.usecase;

import com.talabat.feature.activecarts.domain.repository.ActiveCartRepository;
import com.talabat.feature.darkstorescartlist.domain.usecase.IsMultiBasketEnabledUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetQCommerceCartListUseCaseImpl_Factory implements Factory<GetQCommerceCartListUseCaseImpl> {
    private final Provider<ActiveCartRepository> activeCartRepositoryProvider;
    private final Provider<IsMultiBasketEnabledUseCase> isMultiBasketEnabledProvider;

    public GetQCommerceCartListUseCaseImpl_Factory(Provider<IsMultiBasketEnabledUseCase> provider, Provider<ActiveCartRepository> provider2) {
        this.isMultiBasketEnabledProvider = provider;
        this.activeCartRepositoryProvider = provider2;
    }

    public static GetQCommerceCartListUseCaseImpl_Factory create(Provider<IsMultiBasketEnabledUseCase> provider, Provider<ActiveCartRepository> provider2) {
        return new GetQCommerceCartListUseCaseImpl_Factory(provider, provider2);
    }

    public static GetQCommerceCartListUseCaseImpl newInstance(IsMultiBasketEnabledUseCase isMultiBasketEnabledUseCase, ActiveCartRepository activeCartRepository) {
        return new GetQCommerceCartListUseCaseImpl(isMultiBasketEnabledUseCase, activeCartRepository);
    }

    public GetQCommerceCartListUseCaseImpl get() {
        return newInstance(this.isMultiBasketEnabledProvider.get(), this.activeCartRepositoryProvider.get());
    }
}
