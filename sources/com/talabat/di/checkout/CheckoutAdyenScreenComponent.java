package com.talabat.di.checkout;

import com.talabat.Adyen.AdyenCheckoutScreen;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/di/checkout/CheckoutAdyenScreenComponent;", "", "inject", "", "target", "Lcom/talabat/Adyen/AdyenCheckoutScreen;", "Factory", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationLocalCoreLibApi.class, ConfigurationRemoteCoreLibApi.class})
public interface CheckoutAdyenScreenComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/di/checkout/CheckoutAdyenScreenComponent$Factory;", "", "create", "Lcom/talabat/di/checkout/CheckoutAdyenScreenComponent;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        CheckoutAdyenScreenComponent create(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi);
    }

    void inject(@NotNull AdyenCheckoutScreen adyenCheckoutScreen);
}
