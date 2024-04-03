package com.talabat.feature.swimlanevoucherslist.data.tracking;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B#\b\u0004\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003H&R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0001\u0003\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/swimlanevoucherslist/data/tracking/VoucherSwimLaneEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "info", "", "", "screenName", "(Ljava/util/Map;Ljava/lang/String;)V", "attributes", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "uniqueAttributes", "Lcom/talabat/feature/swimlanevoucherslist/data/tracking/VoucherSwimLaneLoadedEvent;", "Lcom/talabat/feature/swimlanevoucherslist/data/tracking/VoucherSwimLaneClickedEvent;", "Lcom/talabat/feature/swimlanevoucherslist/data/tracking/VoucherProductDetailsOpenedEvent;", "com_talabat_feature_customer-vouchers-swimlane_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class VoucherSwimLaneEvent extends TalabatEvent {
    @NotNull
    private final Map<String, String> info;
    @NotNull
    private final String screenName;

    private VoucherSwimLaneEvent(Map<String, String> map, String str) {
        this.info = map;
        this.screenName = str;
    }

    public /* synthetic */ VoucherSwimLaneEvent(Map map, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, str);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.plus(MapsKt__MapsKt.plus(this.info, TuplesKt.to("screenName", this.screenName)), (Map) uniqueAttributes());
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "customer_voucher_swim_lane";
    }

    @NotNull
    public abstract Map<String, Object> uniqueAttributes();
}
