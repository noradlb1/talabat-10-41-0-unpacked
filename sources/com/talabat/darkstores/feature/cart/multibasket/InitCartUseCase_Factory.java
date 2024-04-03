package com.talabat.darkstores.feature.cart.multibasket;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.domain.common.ApplyDiscountsAndCampaignsUseCase;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import com.talabat.feature.darkstorescartlist.domain.usecase.IsMultiBasketEnabledUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class InitCartUseCase_Factory implements Factory<InitCartUseCase> {
    private final Provider<ApplyDiscountsAndCampaignsUseCase> applyDiscountsAndCampaignsProvider;
    private final Provider<DarkstoresCartRepository> darkstoresCartRepositoryProvider;
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;
    private final Provider<IsMultiBasketEnabledUseCase> isMultiBasketEnabledUseCaseProvider;
    private final Provider<RxSchedulersFactory> rxSchedulersFactoryProvider;

    public InitCartUseCase_Factory(Provider<DarkstoresRepo> provider, Provider<DarkstoresCartRepository> provider2, Provider<IsMultiBasketEnabledUseCase> provider3, Provider<ApplyDiscountsAndCampaignsUseCase> provider4, Provider<RxSchedulersFactory> provider5) {
        this.darkstoresRepoProvider = provider;
        this.darkstoresCartRepositoryProvider = provider2;
        this.isMultiBasketEnabledUseCaseProvider = provider3;
        this.applyDiscountsAndCampaignsProvider = provider4;
        this.rxSchedulersFactoryProvider = provider5;
    }

    public static InitCartUseCase_Factory create(Provider<DarkstoresRepo> provider, Provider<DarkstoresCartRepository> provider2, Provider<IsMultiBasketEnabledUseCase> provider3, Provider<ApplyDiscountsAndCampaignsUseCase> provider4, Provider<RxSchedulersFactory> provider5) {
        return new InitCartUseCase_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static InitCartUseCase newInstance(DarkstoresRepo darkstoresRepo, DarkstoresCartRepository darkstoresCartRepository, IsMultiBasketEnabledUseCase isMultiBasketEnabledUseCase, ApplyDiscountsAndCampaignsUseCase applyDiscountsAndCampaignsUseCase, RxSchedulersFactory rxSchedulersFactory) {
        return new InitCartUseCase(darkstoresRepo, darkstoresCartRepository, isMultiBasketEnabledUseCase, applyDiscountsAndCampaignsUseCase, rxSchedulersFactory);
    }

    public InitCartUseCase get() {
        return newInstance(this.darkstoresRepoProvider.get(), this.darkstoresCartRepositoryProvider.get(), this.isMultiBasketEnabledUseCaseProvider.get(), this.applyDiscountsAndCampaignsProvider.get(), this.rxSchedulersFactoryProvider.get());
    }
}
