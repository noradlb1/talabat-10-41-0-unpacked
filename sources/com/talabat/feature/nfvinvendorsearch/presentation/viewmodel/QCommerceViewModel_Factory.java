package com.talabat.feature.nfvinvendorsearch.presentation.viewmodel;

import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoreCartEventStreamHandler;
import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoresCartMethodCallHandler;
import com.talabat.feature.darkstoresflutter.domain.usecase.NavigateToCheckoutUseCase;
import com.talabat.feature.nfvinvendorsearch.presentation.handler.QCommerceMethodHandler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class QCommerceViewModel_Factory implements Factory<QCommerceViewModel> {
    private final Provider<DarkstoreCartEventStreamHandler> darkstoreCartEventStreamHandlerProvider;
    private final Provider<DarkstoresCartMethodCallHandler> darkstoresCartMethodCallHandlerProvider;
    private final Provider<DarkstoresNavigator> darkstoresNavigatorProvider;
    private final Provider<NavigateToCheckoutUseCase> navigateToCheckoutProvider;
    private final Provider<QCommerceMethodHandler> qCommerceMethodHandlerProvider;

    public QCommerceViewModel_Factory(Provider<QCommerceMethodHandler> provider, Provider<DarkstoresNavigator> provider2, Provider<DarkstoreCartEventStreamHandler> provider3, Provider<DarkstoresCartMethodCallHandler> provider4, Provider<NavigateToCheckoutUseCase> provider5) {
        this.qCommerceMethodHandlerProvider = provider;
        this.darkstoresNavigatorProvider = provider2;
        this.darkstoreCartEventStreamHandlerProvider = provider3;
        this.darkstoresCartMethodCallHandlerProvider = provider4;
        this.navigateToCheckoutProvider = provider5;
    }

    public static QCommerceViewModel_Factory create(Provider<QCommerceMethodHandler> provider, Provider<DarkstoresNavigator> provider2, Provider<DarkstoreCartEventStreamHandler> provider3, Provider<DarkstoresCartMethodCallHandler> provider4, Provider<NavigateToCheckoutUseCase> provider5) {
        return new QCommerceViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static QCommerceViewModel newInstance(QCommerceMethodHandler qCommerceMethodHandler, DarkstoresNavigator darkstoresNavigator, DarkstoreCartEventStreamHandler darkstoreCartEventStreamHandler, DarkstoresCartMethodCallHandler darkstoresCartMethodCallHandler, NavigateToCheckoutUseCase navigateToCheckoutUseCase) {
        return new QCommerceViewModel(qCommerceMethodHandler, darkstoresNavigator, darkstoreCartEventStreamHandler, darkstoresCartMethodCallHandler, navigateToCheckoutUseCase);
    }

    public QCommerceViewModel get() {
        return newInstance(this.qCommerceMethodHandlerProvider.get(), this.darkstoresNavigatorProvider.get(), this.darkstoreCartEventStreamHandlerProvider.get(), this.darkstoresCartMethodCallHandlerProvider.get(), this.navigateToCheckoutProvider.get());
    }
}
