package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.di.factory;

import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.di.factory.OrderConfirmationRiderTipViewComponent;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.view.OrderConfirmationRiderTipView;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.view.OrderConfirmationRiderTipView_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerOrderConfirmationRiderTipViewComponent {

    public static final class Factory implements OrderConfirmationRiderTipViewComponent.Factory {
        private Factory() {
        }

        public OrderConfirmationRiderTipViewComponent create(FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new OrderConfirmationRiderTipViewComponentImpl(featureFlagCoreLibApi);
        }
    }

    public static final class OrderConfirmationRiderTipViewComponentImpl implements OrderConfirmationRiderTipViewComponent {
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final OrderConfirmationRiderTipViewComponentImpl orderConfirmationRiderTipViewComponentImpl;

        private OrderConfirmationRiderTipViewComponentImpl(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.orderConfirmationRiderTipViewComponentImpl = this;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        private OrderConfirmationRiderTipView injectOrderConfirmationRiderTipView(OrderConfirmationRiderTipView orderConfirmationRiderTipView) {
            OrderConfirmationRiderTipView_MembersInjector.injectFeatureFlagRepo(orderConfirmationRiderTipView, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return orderConfirmationRiderTipView;
        }

        public void inject(OrderConfirmationRiderTipView orderConfirmationRiderTipView) {
            injectOrderConfirmationRiderTipView(orderConfirmationRiderTipView);
        }
    }

    private DaggerOrderConfirmationRiderTipViewComponent() {
    }

    public static OrderConfirmationRiderTipViewComponent.Factory factory() {
        return new Factory();
    }
}
