package com.talabat.feature.subscriptions.data.tracking.events;

import com.talabat.core.tracking.domain.PlatformName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.AdjustTokens;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\n \u001a*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u001cH\u0016R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/subscriptions/data/tracking/events/TProVendorOrder;", "Lcom/talabat/feature/subscriptions/data/tracking/events/TProEvent;", "userId", "", "orderPice", "", "restaurant", "voucherName", "discount", "isSubscribed", "", "(Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;FZ)V", "getDiscount", "()F", "()Z", "getOrderPice", "getRestaurant", "()Ljava/lang/String;", "getUserId", "getVoucherName", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "name", "kotlin.jvm.PlatformType", "platforms", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProVendorOrder extends TProEvent {
    private final float discount;
    private final boolean isSubscribed;
    private final float orderPice;
    @NotNull
    private final String restaurant;
    @NotNull
    private final String userId;
    @NotNull
    private final String voucherName;

    public TProVendorOrder(@NotNull String str, float f11, @NotNull String str2, @NotNull String str3, float f12, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, "restaurant");
        Intrinsics.checkNotNullParameter(str3, "voucherName");
        this.userId = str;
        this.orderPice = f11;
        this.restaurant = str2;
        this.voucherName = str3;
        this.discount = f12;
        this.isSubscribed = z11;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("user_id", this.userId), TuplesKt.to(TProEvent.ATTR_ORDER_PRICE, Float.valueOf(this.orderPice)), TuplesKt.to("restaurant", this.restaurant), TuplesKt.to("voucher_name", this.voucherName), TuplesKt.to(TProEvent.ATTR_DISCOUNT_AMOUNT, Float.valueOf(this.discount)), TuplesKt.to(TProEvent.ATTR_USER_IS_SUBSCRIBED, Boolean.valueOf(this.isSubscribed)));
    }

    public final float getDiscount() {
        return this.discount;
    }

    public final float getOrderPice() {
        return this.orderPice;
    }

    @NotNull
    public final String getRestaurant() {
        return this.restaurant;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    @NotNull
    public final String getVoucherName() {
        return this.voucherName;
    }

    public final boolean isSubscribed() {
        return this.isSubscribed;
    }

    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        if (platformName == PlatformName.ADJUST) {
            return AdjustTokens.tProVendorOrder();
        }
        return TProEvent.NAME_PRO_ORDER;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsKt.listOf(PlatformName.BRAZE, PlatformName.ADJUST);
    }
}
