package com.talabat.feature.activecarts.domain.usecase;

import com.talabat.feature.activecarts.domain.mapper.ActiveCartInfoMapper;
import com.talabat.feature.activecarts.domain.repository.ActiveCartRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetCartListUseCaseImpl_Factory implements Factory<GetCartListUseCaseImpl> {
    private final Provider<ActiveCartRepository> activeCartRepositoryProvider;
    private final Provider<GetFoodCartUseCase> getFoodCartProvider;
    private final Provider<GetQCommerceCartListUseCase> getQCommerceCartListProvider;
    private final Provider<ActiveCartInfoMapper> mapActiveCartProvider;

    public GetCartListUseCaseImpl_Factory(Provider<GetFoodCartUseCase> provider, Provider<GetQCommerceCartListUseCase> provider2, Provider<ActiveCartInfoMapper> provider3, Provider<ActiveCartRepository> provider4) {
        this.getFoodCartProvider = provider;
        this.getQCommerceCartListProvider = provider2;
        this.mapActiveCartProvider = provider3;
        this.activeCartRepositoryProvider = provider4;
    }

    public static GetCartListUseCaseImpl_Factory create(Provider<GetFoodCartUseCase> provider, Provider<GetQCommerceCartListUseCase> provider2, Provider<ActiveCartInfoMapper> provider3, Provider<ActiveCartRepository> provider4) {
        return new GetCartListUseCaseImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static GetCartListUseCaseImpl newInstance(GetFoodCartUseCase getFoodCartUseCase, GetQCommerceCartListUseCase getQCommerceCartListUseCase, ActiveCartInfoMapper activeCartInfoMapper, ActiveCartRepository activeCartRepository) {
        return new GetCartListUseCaseImpl(getFoodCartUseCase, getQCommerceCartListUseCase, activeCartInfoMapper, activeCartRepository);
    }

    public GetCartListUseCaseImpl get() {
        return newInstance(this.getFoodCartProvider.get(), this.getQCommerceCartListProvider.get(), this.mapActiveCartProvider.get(), this.activeCartRepositoryProvider.get());
    }
}
