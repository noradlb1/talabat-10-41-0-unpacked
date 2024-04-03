package com.talabat.darkstores.di;

import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.darkstores.di.CartFragmentComponent;
import com.talabat.darkstores.feature.cart.CartFragment;
import com.talabat.darkstores.feature.cart.CartFragment_MembersInjector;
import com.talabat.darkstores.feature.cart.views.CartProgressView;
import com.talabat.darkstores.feature.cart.views.CartProgressView_MembersInjector;
import com.talabat.darkstores.feature.cart.views.DeliveryTierBottomSheetViewModelFactory;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerCartFragmentComponent {

    public static final class CartFragmentComponentImpl implements CartFragmentComponent {
        private final CartFragmentComponentImpl cartFragmentComponentImpl;
        private final CustomerCoreLibApi customerCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final SubscriptionsFeatureApi subscriptionsFeatureApi;

        private CartFragmentComponentImpl(CustomerCoreLibApi customerCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.cartFragmentComponentImpl = this;
            this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            this.customerCoreLibApi = customerCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        private CartFragment injectCartFragment(CartFragment cartFragment) {
            CartFragment_MembersInjector.injectSubscriptionsFlagsRepo(cartFragment, (ISubscriptionsFeatureFlagsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsFeatureFlagRepository()));
            CartFragment_MembersInjector.injectCustomerRepository(cartFragment, (CustomerRepository) Preconditions.checkNotNullFromComponent(this.customerCoreLibApi.getRepository()));
            return cartFragment;
        }

        private CartProgressView injectCartProgressView(CartProgressView cartProgressView) {
            CartProgressView_MembersInjector.injectViewModelFactory(cartProgressView, new DeliveryTierBottomSheetViewModelFactory());
            CartProgressView_MembersInjector.injectSubscriptionsFlagsRepo(cartProgressView, (ISubscriptionsFeatureFlagsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsFeatureFlagRepository()));
            CartProgressView_MembersInjector.injectCustomerRepository(cartProgressView, (CustomerRepository) Preconditions.checkNotNullFromComponent(this.customerCoreLibApi.getRepository()));
            CartProgressView_MembersInjector.injectTalabatFeatureFlag(cartProgressView, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return cartProgressView;
        }

        public void inject(CartFragment cartFragment) {
            injectCartFragment(cartFragment);
        }

        public void inject(CartProgressView cartProgressView) {
            injectCartProgressView(cartProgressView);
        }
    }

    public static final class Factory implements CartFragmentComponent.Factory {
        private Factory() {
        }

        public CartFragmentComponent create(SubscriptionsFeatureApi subscriptionsFeatureApi, CustomerCoreLibApi customerCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(subscriptionsFeatureApi);
            Preconditions.checkNotNull(customerCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new CartFragmentComponentImpl(customerCoreLibApi, subscriptionsFeatureApi, featureFlagCoreLibApi);
        }
    }

    private DaggerCartFragmentComponent() {
    }

    public static CartFragmentComponent.Factory factory() {
        return new Factory();
    }
}
