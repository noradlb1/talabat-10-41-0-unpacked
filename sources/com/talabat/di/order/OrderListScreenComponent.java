package com.talabat.di.order;

import com.talabat.OrderListScreen;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.di.cart.CartUtilityModule;
import com.talabat.feature.foodcart2.domain.di.FoodCartFeatureApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/di/order/OrderListScreenComponent;", "", "inject", "", "target", "Lcom/talabat/OrderListScreen;", "Factory", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationLocalCoreLibApi.class, ConfigurationRemoteCoreLibApi.class, FeatureFlagCoreLibApi.class, ExperimentCoreLibApi.class, FoodCartFeatureApi.class, DeepLinkCoreLibApi.class}, modules = {CartUtilityModule.class})
public interface OrderListScreenComponent {

    @Component.Factory
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/talabat/di/order/OrderListScreenComponent$Factory;", "", "create", "Lcom/talabat/di/order/OrderListScreenComponent;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "experimentCoreLibApi", "Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "foodCartFeatureApi", "Lcom/talabat/feature/foodcart2/domain/di/FoodCartFeatureApi;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        OrderListScreenComponent create(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull ExperimentCoreLibApi experimentCoreLibApi, @NotNull FoodCartFeatureApi foodCartFeatureApi, @NotNull DeepLinkCoreLibApi deepLinkCoreLibApi);
    }

    void inject(@NotNull OrderListScreen orderListScreen);
}
