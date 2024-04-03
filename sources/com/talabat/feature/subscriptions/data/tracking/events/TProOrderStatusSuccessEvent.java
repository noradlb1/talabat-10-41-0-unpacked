package com.talabat.feature.subscriptions.data.tracking.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012H\u0016R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/subscriptions/data/tracking/events/TProOrderStatusSuccessEvent;", "Lcom/talabat/feature/subscriptions/data/tracking/events/TProEvent;", "tProOrderStatus", "Lcom/talabat/feature/subscriptions/domain/model/TProOrderStatus;", "tProMov", "", "shouldUpdateCart", "", "(Lcom/talabat/feature/subscriptions/domain/model/TProOrderStatus;Ljava/lang/String;Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOrderStatusSuccessEvent extends TProEvent {
    @Nullable
    private final Boolean shouldUpdateCart;
    @Nullable
    private final String tProMov;
    @NotNull
    private final TProOrderStatus tProOrderStatus;

    public TProOrderStatusSuccessEvent(@NotNull TProOrderStatus tProOrderStatus2, @Nullable String str, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(tProOrderStatus2, "tProOrderStatus");
        this.tProOrderStatus = tProOrderStatus2;
        this.tProMov = str;
        this.shouldUpdateCart = bool;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Pair[] pairArr = new Pair[5];
        boolean z11 = false;
        pairArr[0] = TuplesKt.to("dataPointName", "GetTProOrderStatusUseCase -> valid order status");
        Boolean bool = this.shouldUpdateCart;
        String str = "null";
        if (bool == null) {
            bool = str;
        }
        pairArr[1] = TuplesKt.to("shouldUpdateCart", bool);
        if (this.tProOrderStatus.isFreeDelivery() && this.tProOrderStatus.isFreeDeliveryEligibleVendor()) {
            z11 = true;
        }
        pairArr[2] = TuplesKt.to("setFreeDelivery", Boolean.valueOf(z11));
        pairArr[3] = TuplesKt.to("tProOrderStatus", this.tProOrderStatus.toString());
        String str2 = this.tProMov;
        if (str2 != null) {
            str = str2;
        }
        pairArr[4] = TuplesKt.to("tproMov", str);
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
