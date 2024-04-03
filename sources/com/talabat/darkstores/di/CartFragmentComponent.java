package com.talabat.darkstores.di;

import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.darkstores.feature.cart.CartFragment;
import com.talabat.darkstores.feature.cart.views.CartProgressView;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/di/CartFragmentComponent;", "", "inject", "", "target", "Lcom/talabat/darkstores/feature/cart/CartFragment;", "Lcom/talabat/darkstores/feature/cart/views/CartProgressView;", "Factory", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {CustomerCoreLibApi.class, SubscriptionsFeatureApi.class, FeatureFlagCoreLibApi.class}, modules = {DeliveryTierBottomSheetViewModelModule.class})
public interface CartFragmentComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/di/CartFragmentComponent$Factory;", "", "create", "Lcom/talabat/darkstores/di/CartFragmentComponent;", "subscriptionsFeatureApi", "Lcom/talabat/feature/subscriptions/domain/di/SubscriptionsFeatureApi;", "customerCoreLibApi", "Lcom/talabat/customer/domain/di/CustomerCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        CartFragmentComponent create(@NotNull SubscriptionsFeatureApi subscriptionsFeatureApi, @NotNull CustomerCoreLibApi customerCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi);
    }

    void inject(@NotNull CartFragment cartFragment);

    void inject(@NotNull CartProgressView cartProgressView);
}
