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

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014H\u0016R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/subscriptions/data/tracking/events/TProOrderStatusFlagsEvent;", "Lcom/talabat/feature/subscriptions/data/tracking/events/TProEvent;", "shopType", "", "isTmartFlag", "", "isNFVFlag", "isFlagEnabledForVendor", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "Ljava/lang/Integer;", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOrderStatusFlagsEvent extends TProEvent {
    @Nullable
    private final Boolean isFlagEnabledForVendor;
    @Nullable
    private final Boolean isNFVFlag;
    @Nullable
    private final Boolean isTmartFlag;
    @Nullable
    private final Integer shopType;

    public TProOrderStatusFlagsEvent(@Nullable Integer num, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3) {
        this.shopType = num;
        this.isTmartFlag = bool;
        this.isNFVFlag = bool2;
        this.isFlagEnabledForVendor = bool3;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("dataPointName", "GetTProOrderStatusUseCase -> isFlagEnabledForVendor");
        Object obj = this.shopType;
        Object obj2 = "null";
        if (obj == null) {
            obj = obj2;
        }
        pairArr[1] = TuplesKt.to("shopType", obj);
        Object obj3 = this.isTmartFlag;
        if (obj3 == null) {
            obj3 = obj2;
        }
        pairArr[2] = TuplesKt.to("isTmartFlag", obj3);
        Object obj4 = this.isNFVFlag;
        if (obj4 == null) {
            obj4 = obj2;
        }
        pairArr[3] = TuplesKt.to("isNFVFlag", obj4);
        Object obj5 = this.isFlagEnabledForVendor;
        if (obj5 != null) {
            obj2 = obj5;
        }
        pairArr[4] = TuplesKt.to("isFlagEnabledForVendor", obj2);
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
