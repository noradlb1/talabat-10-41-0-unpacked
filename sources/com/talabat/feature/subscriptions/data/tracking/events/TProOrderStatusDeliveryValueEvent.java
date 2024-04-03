package com.talabat.feature.subscriptions.data.tracking.events;

import com.talabat.core.tracking.domain.PlatformName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014H\u0016R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/subscriptions/data/tracking/events/TProOrderStatusDeliveryValueEvent;", "Lcom/talabat/feature/subscriptions/data/tracking/events/TProEvent;", "hasDeliveryValue", "", "cartDeliveryCharges", "", "cartCalculatedDeliveryCharges", "restaurantDeliveryCharges", "(Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "Ljava/lang/Float;", "Ljava/lang/Boolean;", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOrderStatusDeliveryValueEvent extends TProEvent {
    @Nullable
    private final Float cartCalculatedDeliveryCharges;
    @Nullable
    private final Float cartDeliveryCharges;
    @Nullable
    private final Boolean hasDeliveryValue;
    @Nullable
    private final Float restaurantDeliveryCharges;

    public TProOrderStatusDeliveryValueEvent(@Nullable Boolean bool, @Nullable Float f11, @Nullable Float f12, @Nullable Float f13) {
        this.hasDeliveryValue = bool;
        this.cartDeliveryCharges = f11;
        this.cartCalculatedDeliveryCharges = f12;
        this.restaurantDeliveryCharges = f13;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("dataPointName", "GetTProOrderStatusUseCase -> checkDeliveryValue");
        Object obj = this.cartDeliveryCharges;
        Object obj2 = "null";
        if (obj == null) {
            obj = obj2;
        }
        pairArr[1] = TuplesKt.to("cartDeliveryCharges", obj);
        Object obj3 = this.cartCalculatedDeliveryCharges;
        if (obj3 == null) {
            obj3 = obj2;
        }
        pairArr[2] = TuplesKt.to("cartCalculatedDeliveryCharges", obj3);
        Object obj4 = this.restaurantDeliveryCharges;
        if (obj4 == null) {
            obj4 = obj2;
        }
        pairArr[3] = TuplesKt.to("restaurantDeliveryCharges", obj4);
        Object obj5 = this.hasDeliveryValue;
        if (obj5 != null) {
            obj2 = obj5;
        }
        pairArr[4] = TuplesKt.to("hasDeliveryValue", obj2);
        return MapsKt__MapsKt.mutableMapOf(pairArr);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "tpro";
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "tpro_order_status";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.NEW_RELIC);
    }
}
