package com.talabat.homescreen.orderstatus.ui;

import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class OrderStatusView_MembersInjector implements MembersInjector<OrderStatusView> {
    private final Provider<Navigator> navigatorProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public OrderStatusView_MembersInjector(Provider<IObservabilityManager> provider, Provider<Navigator> provider2) {
        this.observabilityManagerProvider = provider;
        this.navigatorProvider = provider2;
    }

    public static MembersInjector<OrderStatusView> create(Provider<IObservabilityManager> provider, Provider<Navigator> provider2) {
        return new OrderStatusView_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.homescreen.orderstatus.ui.OrderStatusView.navigator")
    public static void injectNavigator(OrderStatusView orderStatusView, Navigator navigator) {
        orderStatusView.navigator = navigator;
    }

    @InjectedFieldSignature("com.talabat.homescreen.orderstatus.ui.OrderStatusView.observabilityManager")
    public static void injectObservabilityManager(OrderStatusView orderStatusView, IObservabilityManager iObservabilityManager) {
        orderStatusView.observabilityManager = iObservabilityManager;
    }

    public void injectMembers(OrderStatusView orderStatusView) {
        injectObservabilityManager(orderStatusView, this.observabilityManagerProvider.get());
        injectNavigator(orderStatusView, this.navigatorProvider.get());
    }
}
