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

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/subscriptions/data/tracking/events/TProOrderStatusEvent;", "Lcom/talabat/feature/subscriptions/data/tracking/events/TProEvent;", "dataPointName", "", "tproMov", "setFreeDelivery", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getDataPointName", "()Ljava/lang/String;", "getSetFreeDelivery", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTproMov", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOrderStatusEvent extends TProEvent {
    @NotNull
    private final String dataPointName;
    @Nullable
    private final Boolean setFreeDelivery;
    @Nullable
    private final String tproMov;

    public TProOrderStatusEvent(@NotNull String str, @Nullable String str2, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "dataPointName");
        this.dataPointName = str;
        this.tproMov = str2;
        this.setFreeDelivery = bool;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("dataPointName", this.dataPointName);
        Object obj = this.tproMov;
        Object obj2 = "null";
        if (obj == null) {
            obj = obj2;
        }
        pairArr[1] = TuplesKt.to("tproMov", obj);
        Object obj3 = this.setFreeDelivery;
        if (obj3 != null) {
            obj2 = obj3;
        }
        pairArr[2] = TuplesKt.to("setFreeDelivery", obj2);
        return MapsKt__MapsKt.mutableMapOf(pairArr);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "tpro";
    }

    @NotNull
    public final String getDataPointName() {
        return this.dataPointName;
    }

    @Nullable
    public final Boolean getSetFreeDelivery() {
        return this.setFreeDelivery;
    }

    @Nullable
    public final String getTproMov() {
        return this.tproMov;
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
