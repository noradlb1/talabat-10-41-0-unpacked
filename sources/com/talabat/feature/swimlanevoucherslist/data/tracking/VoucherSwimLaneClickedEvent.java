package com.talabat.feature.swimlanevoucherslist.data.tracking;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B1\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\tJ\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÂ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÂ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÂ\u0003J=\u0010\u0010\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0003H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/swimlanevoucherslist/data/tracking/VoucherSwimLaneClickedEvent;", "Lcom/talabat/feature/swimlanevoucherslist/data/tracking/VoucherSwimLaneEvent;", "info", "", "", "screenName", "voucherPosition", "", "voucherName", "(Ljava/util/Map;Ljava/lang/String;ILjava/lang/String;)V", "getScreenName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "name", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "toString", "uniqueAttributes", "com_talabat_feature_customer-vouchers-swimlane_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherSwimLaneClickedEvent extends VoucherSwimLaneEvent {
    @NotNull
    private final Map<String, String> info;
    @NotNull
    private final String screenName;
    @NotNull
    private final String voucherName;
    private final int voucherPosition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoucherSwimLaneClickedEvent(@NotNull Map<String, String> map, @NotNull String str, int i11, @NotNull String str2) {
        super(map, str, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(map, CustomerInfoLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "voucherName");
        this.info = map;
        this.screenName = str;
        this.voucherPosition = i11;
        this.voucherName = str2;
    }

    private final Map<String, String> component1() {
        return this.info;
    }

    private final int component3() {
        return this.voucherPosition;
    }

    private final String component4() {
        return this.voucherName;
    }

    public static /* synthetic */ VoucherSwimLaneClickedEvent copy$default(VoucherSwimLaneClickedEvent voucherSwimLaneClickedEvent, Map<String, String> map, String str, int i11, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            map = voucherSwimLaneClickedEvent.info;
        }
        if ((i12 & 2) != 0) {
            str = voucherSwimLaneClickedEvent.screenName;
        }
        if ((i12 & 4) != 0) {
            i11 = voucherSwimLaneClickedEvent.voucherPosition;
        }
        if ((i12 & 8) != 0) {
            str2 = voucherSwimLaneClickedEvent.voucherName;
        }
        return voucherSwimLaneClickedEvent.copy(map, str, i11, str2);
    }

    @NotNull
    public final String component2() {
        return this.screenName;
    }

    @NotNull
    public final VoucherSwimLaneClickedEvent copy(@NotNull Map<String, String> map, @NotNull String str, int i11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(map, CustomerInfoLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "voucherName");
        return new VoucherSwimLaneClickedEvent(map, str, i11, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoucherSwimLaneClickedEvent)) {
            return false;
        }
        VoucherSwimLaneClickedEvent voucherSwimLaneClickedEvent = (VoucherSwimLaneClickedEvent) obj;
        return Intrinsics.areEqual((Object) this.info, (Object) voucherSwimLaneClickedEvent.info) && Intrinsics.areEqual((Object) this.screenName, (Object) voucherSwimLaneClickedEvent.screenName) && this.voucherPosition == voucherSwimLaneClickedEvent.voucherPosition && Intrinsics.areEqual((Object) this.voucherName, (Object) voucherSwimLaneClickedEvent.voucherName);
    }

    @NotNull
    public final String getScreenName() {
        return this.screenName;
    }

    public int hashCode() {
        return (((((this.info.hashCode() * 31) + this.screenName.hashCode()) * 31) + this.voucherPosition) * 31) + this.voucherName.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "voucher_swimlane_clicked";
    }

    @NotNull
    public String toString() {
        Map<String, String> map = this.info;
        String str = this.screenName;
        int i11 = this.voucherPosition;
        String str2 = this.voucherName;
        return "VoucherSwimLaneClickedEvent(info=" + map + ", screenName=" + str + ", voucherPosition=" + i11 + ", voucherName=" + str2 + ")";
    }

    @NotNull
    public Map<String, Object> uniqueAttributes() {
        return MapsKt__MapsKt.mapOf(TuplesKt.to("voucherPosition", Integer.valueOf(this.voucherPosition)), TuplesKt.to("voucherName", this.voucherName));
    }
}
