package com.talabat.feature.activecarts.domain.channel;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.activecarts.domain.usecase.GetCartListUseCase;
import com.talabat.feature.activecarts.domain.usecase.GetQCommerceCartListUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ActiveCartsMethodCallHandlerImpl_Factory implements Factory<ActiveCartsMethodCallHandlerImpl> {
    private final Provider<GetCartListUseCase> getBasketListProvider;
    private final Provider<GetQCommerceCartListUseCase> getQCommerceCartListProvider;
    private final Provider<RxSchedulersFactory> rxSchedulersFactoryProvider;

    public ActiveCartsMethodCallHandlerImpl_Factory(Provider<GetCartListUseCase> provider, Provider<GetQCommerceCartListUseCase> provider2, Provider<RxSchedulersFactory> provider3) {
        this.getBasketListProvider = provider;
        this.getQCommerceCartListProvider = provider2;
        this.rxSchedulersFactoryProvider = provider3;
    }

    public static ActiveCartsMethodCallHandlerImpl_Factory create(Provider<GetCartListUseCase> provider, Provider<GetQCommerceCartListUseCase> provider2, Provider<RxSchedulersFactory> provider3) {
        return new ActiveCartsMethodCallHandlerImpl_Factory(provider, provider2, provider3);
    }

    public static ActiveCartsMethodCallHandlerImpl newInstance(GetCartListUseCase getCartListUseCase, GetQCommerceCartListUseCase getQCommerceCartListUseCase, RxSchedulersFactory rxSchedulersFactory) {
        return new ActiveCartsMethodCallHandlerImpl(getCartListUseCase, getQCommerceCartListUseCase, rxSchedulersFactory);
    }

    public ActiveCartsMethodCallHandlerImpl get() {
        return newInstance(this.getBasketListProvider.get(), this.getQCommerceCartListProvider.get(), this.rxSchedulersFactoryProvider.get());
    }
}
