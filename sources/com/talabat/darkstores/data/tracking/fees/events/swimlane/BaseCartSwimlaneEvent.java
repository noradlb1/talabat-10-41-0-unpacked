package com.talabat.darkstores.data.tracking.fees.events.swimlane;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.darkstores.feature.cart.CartSwimlane;
import datamodels.CustomerInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\u000e\u0010\u000b\u001a\u00020\u0004*\u0004\u0018\u00010\u0004H\u0004R\u001a\u0010\f\u001a\u00020\u00048\u0004X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0004X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0004X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/talabat/darkstores/data/tracking/fees/events/swimlane/BaseCartSwimlaneEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "Lcom/talabat/core/tracking/domain/PlatformName;", "platform", "", "featureName", "", "", "attributes", "", "platforms", "a", "vendorId", "Ljava/lang/String;", "getVendorId", "()Ljava/lang/String;", "Lcom/talabat/darkstores/feature/cart/CartSwimlane;", "swimlane", "Lcom/talabat/darkstores/feature/cart/CartSwimlane;", "getSwimlane", "()Lcom/talabat/darkstores/feature/cart/CartSwimlane;", "Ldatamodels/CustomerInfo;", "customerInfo", "Ldatamodels/CustomerInfo;", "getCustomerInfo", "()Ldatamodels/CustomerInfo;", "<init>", "(Ljava/lang/String;Lcom/talabat/darkstores/feature/cart/CartSwimlane;Ldatamodels/CustomerInfo;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public abstract class BaseCartSwimlaneEvent extends TalabatEvent {
    @Nullable
    private final CustomerInfo customerInfo;
    @NotNull
    private final CartSwimlane swimlane;
    @NotNull
    private final String vendorId;

    public BaseCartSwimlaneEvent(@NotNull String str, @NotNull CartSwimlane cartSwimlane, @Nullable CustomerInfo customerInfo2) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(cartSwimlane, "swimlane");
        this.vendorId = str;
        this.swimlane = cartSwimlane;
        this.customerInfo = customerInfo2;
    }

    @NotNull
    public final String a(@Nullable String str) {
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            str = null;
        }
        return str == null ? "N/A" : str;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        String str;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Pair[] pairArr = new Pair[10];
        pairArr[0] = TuplesKt.to("screenName", "basket");
        pairArr[1] = TuplesKt.to("shopId", this.vendorId);
        CustomerInfo customerInfo2 = this.customerInfo;
        if (customerInfo2 != null) {
            str = Integer.valueOf(customerInfo2.f13850id).toString();
        } else {
            str = null;
        }
        pairArr[2] = TuplesKt.to("customerCode", a(str));
        pairArr[3] = TuplesKt.to("swimlaneTitle", a(this.swimlane.getTitle()));
        pairArr[4] = TuplesKt.to("swimlaneTitleList", a(CollectionsKt___CollectionsKt.joinToString$default(this.swimlane.getSwimlane().getTracking().getSupportedTitleList(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)));
        pairArr[5] = TuplesKt.to("swimlaneTotal", Integer.valueOf(this.swimlane.getSwimlane().getTracking().getSupportedTitleList().size()));
        pairArr[6] = TuplesKt.to("swimlaneVariation", a(this.swimlane.getSwimlane().getTracking().getSwimlaneId()));
        pairArr[7] = TuplesKt.to("swimlanePosition", 1);
        pairArr[8] = TuplesKt.to("swimlaneLength", Integer.valueOf(this.swimlane.getProducts().size()));
        pairArr[9] = TuplesKt.to("swimlaneRequestId", a(this.swimlane.getSwimlane().getRequestId()));
        return MapsKt__MapsKt.mapOf(pairArr);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "darkstores";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }
}
