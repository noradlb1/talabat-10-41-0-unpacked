package com.talabat.homescreen.orderstatus.ui;

import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.homescreen.orderstatus.ui.OrderStatusViewComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerOrderStatusViewComponent {

    public static final class Factory implements OrderStatusViewComponent.Factory {
        private Factory() {
        }

        public OrderStatusViewComponent create(NavigationCoreLibApi navigationCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new OrderStatusViewComponentImpl(navigationCoreLibApi, observabilityCoreLibApi);
        }
    }

    public static final class OrderStatusViewComponentImpl implements OrderStatusViewComponent {
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final OrderStatusViewComponentImpl orderStatusViewComponentImpl;

        private OrderStatusViewComponentImpl(NavigationCoreLibApi navigationCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2) {
            this.orderStatusViewComponentImpl = this;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
        }

        private OrderStatusView injectOrderStatusView(OrderStatusView orderStatusView) {
            OrderStatusView_MembersInjector.injectObservabilityManager(orderStatusView, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            OrderStatusView_MembersInjector.injectNavigator(orderStatusView, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            return orderStatusView;
        }

        public void inject(OrderStatusView orderStatusView) {
            injectOrderStatusView(orderStatusView);
        }
    }

    private DaggerOrderStatusViewComponent() {
    }

    public static OrderStatusViewComponent.Factory factory() {
        return new Factory();
    }
}
