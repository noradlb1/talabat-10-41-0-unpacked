package com.talabat.darkstores.data.tracking.fees.events.swimlane;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.darkstores.feature.cart.CartSwimlane;
import datamodels.CustomerInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/data/tracking/fees/events/swimlane/CartSwimlaneSwipedEvent;", "Lcom/talabat/darkstores/data/tracking/fees/events/swimlane/BaseCartSwimlaneEvent;", "vendorId", "", "swimlane", "Lcom/talabat/darkstores/feature/cart/CartSwimlane;", "customerInfo", "Ldatamodels/CustomerInfo;", "productIndex", "", "(Ljava/lang/String;Lcom/talabat/darkstores/feature/cart/CartSwimlane;Ldatamodels/CustomerInfo;I)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "name", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartSwimlaneSwipedEvent extends BaseCartSwimlaneEvent {
    private final int productIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartSwimlaneSwipedEvent(@NotNull String str, @NotNull CartSwimlane cartSwimlane, @Nullable CustomerInfo customerInfo, int i11) {
        super(str, cartSwimlane, customerInfo);
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(cartSwimlane, "swimlane");
        this.productIndex = i11;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Map<String, Object> mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("swimlaneTilesDisplayed", Integer.valueOf(this.productIndex + 1)));
        mutableMapOf.putAll(super.attributes(platformName));
        return mutableMapOf;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return SwimlaneTrackingConstantsKt.EVENT_SWIMLANE_SWIPED;
    }
}
