package com.talabat.core.pinless.checkout.data;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.pinless.checkout.domain.PinlessCheckoutCoreLibApi;
import com.talabat.core.pinless.checkout.domain.PinlessCheckoutDomainModule;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/pinless/checkout/data/PinlessCheckoutCoreLibComponent;", "Lcom/talabat/core/pinless/checkout/domain/PinlessCheckoutCoreLibApi;", "Factory", "com_talabat_core_pinless-checkout_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {TrackingCoreLibApi.class, ContextCoreLibApi.class}, modules = {PinlessCheckoutDataModule.class, PinlessCheckoutDomainModule.class})
public interface PinlessCheckoutCoreLibComponent extends PinlessCheckoutCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/core/pinless/checkout/data/PinlessCheckoutCoreLibComponent$Factory;", "", "create", "Lcom/talabat/core/pinless/checkout/data/PinlessCheckoutCoreLibComponent;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "com_talabat_core_pinless-checkout_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        PinlessCheckoutCoreLibComponent create(@NotNull ContextCoreLibApi contextCoreLibApi, @NotNull TrackingCoreLibApi trackingCoreLibApi);
    }
}
