package com.talabat.di.home;

import com.talabat.HomeScreenMap;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.core.pinless.checkout.domain.PinlessCheckoutCoreLibApi;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.location.domain.di.LocationCoreLibApi;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/di/home/HomeScreenMapFragmentComponent;", "", "inject", "", "target", "Lcom/talabat/HomeScreenMap;", "Factory", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {CustomerCoreLibApi.class, LocationCoreLibApi.class, MapsCoreLibApi.class, MutableConfigurationLocalCoreLibApi.class, MutableConfigurationRemoteCoreLibApi.class, ParserCoreLibApi.class, PinlessCheckoutCoreLibApi.class, SecretCoreLibApi.class, SubscriptionsFeatureApi.class, FeatureFlagCoreLibApi.class, DeepLinkCoreLibApi.class, NavigationCoreLibApi.class})
public interface HomeScreenMapFragmentComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001Jh\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH&¨\u0006\u001c"}, d2 = {"Lcom/talabat/di/home/HomeScreenMapFragmentComponent$Factory;", "", "create", "Lcom/talabat/di/home/HomeScreenMapFragmentComponent;", "customerCoreLibApi", "Lcom/talabat/customer/domain/di/CustomerCoreLibApi;", "locationCoreLibApi", "Lcom/talabat/location/domain/di/LocationCoreLibApi;", "mapsCoreLibApi", "Lcom/talabat/maps/domain/di/MapsCoreLibApi;", "mutableConfigurationLocalCoreLibApi", "Lcom/talabat/configuration/di/MutableConfigurationLocalCoreLibApi;", "mutableConfigurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/MutableConfigurationRemoteCoreLibApi;", "parserCoreLibApi", "Lcom/talabat/core/parser/domain/ParserCoreLibApi;", "pinlessCheckoutCoreLibApi", "Lcom/talabat/core/pinless/checkout/domain/PinlessCheckoutCoreLibApi;", "secretCoreLibApi", "Lcom/talabat/authentication/aaa/di/SecretCoreLibApi;", "subscriptionsFeatureApi", "Lcom/talabat/feature/subscriptions/domain/di/SubscriptionsFeatureApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "navigationCoreLibApi", "Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        HomeScreenMapFragmentComponent create(@NotNull CustomerCoreLibApi customerCoreLibApi, @NotNull LocationCoreLibApi locationCoreLibApi, @NotNull MapsCoreLibApi mapsCoreLibApi, @NotNull MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi, @NotNull MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi, @NotNull ParserCoreLibApi parserCoreLibApi, @NotNull PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi, @NotNull SecretCoreLibApi secretCoreLibApi, @NotNull SubscriptionsFeatureApi subscriptionsFeatureApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull DeepLinkCoreLibApi deepLinkCoreLibApi, @NotNull NavigationCoreLibApi navigationCoreLibApi);
    }

    void inject(@NotNull HomeScreenMap homeScreenMap);
}
