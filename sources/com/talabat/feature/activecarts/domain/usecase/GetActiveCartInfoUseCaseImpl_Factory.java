package com.talabat.feature.activecarts.domain.usecase;

import com.talabat.feature.activecarts.domain.repository.ActiveCartRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetActiveCartInfoUseCaseImpl_Factory implements Factory<GetActiveCartInfoUseCaseImpl> {
    private final Provider<ActiveCartRepository> activeCartRepositoryProvider;
    private final Provider<GetFoodCartUseCase> getFoodCartProvider;
    private final Provider<GetQCommerceCartListUseCase> getQCommerceCartListProvider;
    private final Provider<TrackCartLoadedEventUseCase> trackCartLoadedProvider;

    public GetActiveCartInfoUseCaseImpl_Factory(Provider<GetFoodCartUseCase> provider, Provider<GetQCommerceCartListUseCase> provider2, Provider<TrackCartLoadedEventUseCase> provider3, Provider<ActiveCartRepository> provider4) {
        this.getFoodCartProvider = provider;
        this.getQCommerceCartListProvider = provider2;
        this.trackCartLoadedProvider = provider3;
        this.activeCartRepositoryProvider = provider4;
    }

    public static GetActiveCartInfoUseCaseImpl_Factory create(Provider<GetFoodCartUseCase> provider, Provider<GetQCommerceCartListUseCase> provider2, Provider<TrackCartLoadedEventUseCase> provider3, Provider<ActiveCartRepository> provider4) {
        return new GetActiveCartInfoUseCaseImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static GetActiveCartInfoUseCaseImpl newInstance(GetFoodCartUseCase getFoodCartUseCase, GetQCommerceCartListUseCase getQCommerceCartListUseCase, TrackCartLoadedEventUseCase trackCartLoadedEventUseCase, ActiveCartRepository activeCartRepository) {
        return new GetActiveCartInfoUseCaseImpl(getFoodCartUseCase, getQCommerceCartListUseCase, trackCartLoadedEventUseCase, activeCartRepository);
    }

    public GetActiveCartInfoUseCaseImpl get() {
        return newInstance(this.getFoodCartProvider.get(), this.getQCommerceCartListProvider.get(), this.trackCartLoadedProvider.get(), this.activeCartRepositoryProvider.get());
    }
}
