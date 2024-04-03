package com.talabat.darkstores.data.tracking.fees.events.swimlane;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.darkstores.feature.cart.CartSwimlane;
import datamodels.CustomerInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/talabat/darkstores/data/tracking/fees/events/swimlane/CartSwimlaneShownEvent;", "Lcom/talabat/darkstores/data/tracking/fees/events/swimlane/BaseCartSwimlaneEvent;", "vendorId", "", "swimlane", "Lcom/talabat/darkstores/feature/cart/CartSwimlane;", "customerInfo", "Ldatamodels/CustomerInfo;", "(Ljava/lang/String;Lcom/talabat/darkstores/feature/cart/CartSwimlane;Ldatamodels/CustomerInfo;)V", "name", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartSwimlaneShownEvent extends BaseCartSwimlaneEvent {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartSwimlaneShownEvent(@NotNull String str, @NotNull CartSwimlane cartSwimlane, @Nullable CustomerInfo customerInfo) {
        super(str, cartSwimlane, customerInfo);
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(cartSwimlane, "swimlane");
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return SwimlaneTrackingConstantsKt.EVENT_SWIMLANE_SHOWN;
    }
}
