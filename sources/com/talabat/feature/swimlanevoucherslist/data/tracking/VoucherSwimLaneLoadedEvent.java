package com.talabat.feature.swimlanevoucherslist.data.tracking;

import com.facebook.internal.security.CertificateUtil;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B/\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÂ\u0003J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007HÂ\u0003J9\u0010\u000e\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0016\u0010\u0018\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0003H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/swimlanevoucherslist/data/tracking/VoucherSwimLaneLoadedEvent;", "Lcom/talabat/feature/swimlanevoucherslist/data/tracking/VoucherSwimLaneEvent;", "info", "", "", "screenName", "voucherTitles", "", "(Ljava/util/Map;Ljava/lang/String;Ljava/util/List;)V", "getScreenName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "name", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "titlesList", "titles", "toString", "uniqueAttributes", "com_talabat_feature_customer-vouchers-swimlane_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherSwimLaneLoadedEvent extends VoucherSwimLaneEvent {
    @NotNull
    private final Map<String, String> info;
    @NotNull
    private final String screenName;
    @NotNull
    private final List<String> voucherTitles;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoucherSwimLaneLoadedEvent(@NotNull Map<String, String> map, @NotNull String str, @NotNull List<String> list) {
        super(map, str, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(map, CustomerInfoLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(list, "voucherTitles");
        this.info = map;
        this.screenName = str;
        this.voucherTitles = list;
    }

    private final Map<String, String> component1() {
        return this.info;
    }

    private final List<String> component3() {
        return this.voucherTitles;
    }

    public static /* synthetic */ VoucherSwimLaneLoadedEvent copy$default(VoucherSwimLaneLoadedEvent voucherSwimLaneLoadedEvent, Map<String, String> map, String str, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            map = voucherSwimLaneLoadedEvent.info;
        }
        if ((i11 & 2) != 0) {
            str = voucherSwimLaneLoadedEvent.screenName;
        }
        if ((i11 & 4) != 0) {
            list = voucherSwimLaneLoadedEvent.voucherTitles;
        }
        return voucherSwimLaneLoadedEvent.copy(map, str, list);
    }

    private final String titlesList(List<String> list) {
        Iterable iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        int i11 = 0;
        for (Object next : iterable) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(i12 + CertificateUtil.DELIMITER + ((String) next));
            i11 = i12;
        }
        return CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, VoucherSwimLaneLoadedEvent$titlesList$2.INSTANCE, 30, (Object) null);
    }

    @NotNull
    public final String component2() {
        return this.screenName;
    }

    @NotNull
    public final VoucherSwimLaneLoadedEvent copy(@NotNull Map<String, String> map, @NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(map, CustomerInfoLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(list, "voucherTitles");
        return new VoucherSwimLaneLoadedEvent(map, str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoucherSwimLaneLoadedEvent)) {
            return false;
        }
        VoucherSwimLaneLoadedEvent voucherSwimLaneLoadedEvent = (VoucherSwimLaneLoadedEvent) obj;
        return Intrinsics.areEqual((Object) this.info, (Object) voucherSwimLaneLoadedEvent.info) && Intrinsics.areEqual((Object) this.screenName, (Object) voucherSwimLaneLoadedEvent.screenName) && Intrinsics.areEqual((Object) this.voucherTitles, (Object) voucherSwimLaneLoadedEvent.voucherTitles);
    }

    @NotNull
    public final String getScreenName() {
        return this.screenName;
    }

    public int hashCode() {
        return (((this.info.hashCode() * 31) + this.screenName.hashCode()) * 31) + this.voucherTitles.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "voucher_swimlane_loaded";
    }

    @NotNull
    public String toString() {
        Map<String, String> map = this.info;
        String str = this.screenName;
        List<String> list = this.voucherTitles;
        return "VoucherSwimLaneLoadedEvent(info=" + map + ", screenName=" + str + ", voucherTitles=" + list + ")";
    }

    @NotNull
    public Map<String, Object> uniqueAttributes() {
        return MapsKt__MapsJVMKt.mapOf(TuplesKt.to("swimlaneTitleList", titlesList(this.voucherTitles)));
    }
}
