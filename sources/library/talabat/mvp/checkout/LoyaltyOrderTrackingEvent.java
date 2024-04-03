package library.talabat.mvp.checkout;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.feature.subscriptions.data.tracking.events.TProEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Llibrary/talabat/mvp/checkout/LoyaltyOrderTrackingEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "loyaltyOrderTrackData", "Llibrary/talabat/mvp/checkout/LoyaltyOrderTrackData;", "(Llibrary/talabat/mvp/checkout/LoyaltyOrderTrackData;)V", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyOrderTrackingEvent extends TalabatEvent {
    @NotNull
    private final LoyaltyOrderTrackData loyaltyOrderTrackData;

    public LoyaltyOrderTrackingEvent(@NotNull LoyaltyOrderTrackData loyaltyOrderTrackData2) {
        Intrinsics.checkNotNullParameter(loyaltyOrderTrackData2, "loyaltyOrderTrackData");
        this.loyaltyOrderTrackData = loyaltyOrderTrackData2;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("user_id", Integer.valueOf(this.loyaltyOrderTrackData.getUserId())), TuplesKt.to(TProEvent.ATTR_ORDER_PRICE, Float.valueOf(this.loyaltyOrderTrackData.getOrderPrice())), TuplesKt.to("restaurant", this.loyaltyOrderTrackData.getRestaurant()), TuplesKt.to("voucher_name", this.loyaltyOrderTrackData.getVoucherName()), TuplesKt.to("voucher_amount", Float.valueOf(this.loyaltyOrderTrackData.getVoucherAmount())), TuplesKt.to(TProEvent.ATTR_DISCOUNT_AMOUNT, Float.valueOf(this.loyaltyOrderTrackData.getDiscountAmount())));
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "rewards";
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "app_loyalty_order";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.BRAZE);
    }
}
