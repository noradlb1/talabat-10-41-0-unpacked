package com.talabat.feature.tmart.growth.domain.dto;

import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b \b\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0010HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J}\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010,\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0010HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00060"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthTrackingInfo;", "", "branchId", "", "branchName", "cuisines", "", "deliveryTime", "isDarkstore", "", "voucherId", "title", "vendorId", "vendorStatus", "vendorStatusType", "verticalType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getBranchId", "()Ljava/lang/String;", "getBranchName", "getCuisines", "()Ljava/util/List;", "getDeliveryTime", "()Z", "getTitle", "getVendorId", "getVendorStatus", "getVendorStatusType", "getVerticalType", "()I", "getVoucherId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthTrackingInfo {
    @NotNull
    private final String branchId;
    @NotNull
    private final String branchName;
    @NotNull
    private final List<String> cuisines;
    @NotNull
    private final String deliveryTime;
    private final boolean isDarkstore;
    @NotNull
    private final String title;
    @NotNull
    private final String vendorId;
    @NotNull
    private final String vendorStatus;
    @NotNull
    private final String vendorStatusType;
    private final int verticalType;
    @NotNull
    private final String voucherId;

    public TMartGrowthTrackingInfo(@NotNull String str, @NotNull String str2, @NotNull List<String> list, @NotNull String str3, boolean z11, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, int i11) {
        Intrinsics.checkNotNullParameter(str, "branchId");
        Intrinsics.checkNotNullParameter(str2, "branchName");
        Intrinsics.checkNotNullParameter(list, "cuisines");
        Intrinsics.checkNotNullParameter(str3, "deliveryTime");
        Intrinsics.checkNotNullParameter(str4, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        Intrinsics.checkNotNullParameter(str5, "title");
        Intrinsics.checkNotNullParameter(str6, "vendorId");
        Intrinsics.checkNotNullParameter(str7, "vendorStatus");
        Intrinsics.checkNotNullParameter(str8, "vendorStatusType");
        this.branchId = str;
        this.branchName = str2;
        this.cuisines = list;
        this.deliveryTime = str3;
        this.isDarkstore = z11;
        this.voucherId = str4;
        this.title = str5;
        this.vendorId = str6;
        this.vendorStatus = str7;
        this.vendorStatusType = str8;
        this.verticalType = i11;
    }

    public static /* synthetic */ TMartGrowthTrackingInfo copy$default(TMartGrowthTrackingInfo tMartGrowthTrackingInfo, String str, String str2, List list, String str3, boolean z11, String str4, String str5, String str6, String str7, String str8, int i11, int i12, Object obj) {
        TMartGrowthTrackingInfo tMartGrowthTrackingInfo2 = tMartGrowthTrackingInfo;
        int i13 = i12;
        return tMartGrowthTrackingInfo.copy((i13 & 1) != 0 ? tMartGrowthTrackingInfo2.branchId : str, (i13 & 2) != 0 ? tMartGrowthTrackingInfo2.branchName : str2, (i13 & 4) != 0 ? tMartGrowthTrackingInfo2.cuisines : list, (i13 & 8) != 0 ? tMartGrowthTrackingInfo2.deliveryTime : str3, (i13 & 16) != 0 ? tMartGrowthTrackingInfo2.isDarkstore : z11, (i13 & 32) != 0 ? tMartGrowthTrackingInfo2.voucherId : str4, (i13 & 64) != 0 ? tMartGrowthTrackingInfo2.title : str5, (i13 & 128) != 0 ? tMartGrowthTrackingInfo2.vendorId : str6, (i13 & 256) != 0 ? tMartGrowthTrackingInfo2.vendorStatus : str7, (i13 & 512) != 0 ? tMartGrowthTrackingInfo2.vendorStatusType : str8, (i13 & 1024) != 0 ? tMartGrowthTrackingInfo2.verticalType : i11);
    }

    @NotNull
    public final String component1() {
        return this.branchId;
    }

    @NotNull
    public final String component10() {
        return this.vendorStatusType;
    }

    public final int component11() {
        return this.verticalType;
    }

    @NotNull
    public final String component2() {
        return this.branchName;
    }

    @NotNull
    public final List<String> component3() {
        return this.cuisines;
    }

    @NotNull
    public final String component4() {
        return this.deliveryTime;
    }

    public final boolean component5() {
        return this.isDarkstore;
    }

    @NotNull
    public final String component6() {
        return this.voucherId;
    }

    @NotNull
    public final String component7() {
        return this.title;
    }

    @NotNull
    public final String component8() {
        return this.vendorId;
    }

    @NotNull
    public final String component9() {
        return this.vendorStatus;
    }

    @NotNull
    public final TMartGrowthTrackingInfo copy(@NotNull String str, @NotNull String str2, @NotNull List<String> list, @NotNull String str3, boolean z11, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, int i11) {
        Intrinsics.checkNotNullParameter(str, "branchId");
        Intrinsics.checkNotNullParameter(str2, "branchName");
        List<String> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "cuisines");
        String str9 = str3;
        Intrinsics.checkNotNullParameter(str9, "deliveryTime");
        String str10 = str4;
        Intrinsics.checkNotNullParameter(str10, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        String str11 = str5;
        Intrinsics.checkNotNullParameter(str11, "title");
        String str12 = str6;
        Intrinsics.checkNotNullParameter(str12, "vendorId");
        String str13 = str7;
        Intrinsics.checkNotNullParameter(str13, "vendorStatus");
        String str14 = str8;
        Intrinsics.checkNotNullParameter(str14, "vendorStatusType");
        return new TMartGrowthTrackingInfo(str, str2, list2, str9, z11, str10, str11, str12, str13, str14, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TMartGrowthTrackingInfo)) {
            return false;
        }
        TMartGrowthTrackingInfo tMartGrowthTrackingInfo = (TMartGrowthTrackingInfo) obj;
        return Intrinsics.areEqual((Object) this.branchId, (Object) tMartGrowthTrackingInfo.branchId) && Intrinsics.areEqual((Object) this.branchName, (Object) tMartGrowthTrackingInfo.branchName) && Intrinsics.areEqual((Object) this.cuisines, (Object) tMartGrowthTrackingInfo.cuisines) && Intrinsics.areEqual((Object) this.deliveryTime, (Object) tMartGrowthTrackingInfo.deliveryTime) && this.isDarkstore == tMartGrowthTrackingInfo.isDarkstore && Intrinsics.areEqual((Object) this.voucherId, (Object) tMartGrowthTrackingInfo.voucherId) && Intrinsics.areEqual((Object) this.title, (Object) tMartGrowthTrackingInfo.title) && Intrinsics.areEqual((Object) this.vendorId, (Object) tMartGrowthTrackingInfo.vendorId) && Intrinsics.areEqual((Object) this.vendorStatus, (Object) tMartGrowthTrackingInfo.vendorStatus) && Intrinsics.areEqual((Object) this.vendorStatusType, (Object) tMartGrowthTrackingInfo.vendorStatusType) && this.verticalType == tMartGrowthTrackingInfo.verticalType;
    }

    @NotNull
    public final String getBranchId() {
        return this.branchId;
    }

    @NotNull
    public final String getBranchName() {
        return this.branchName;
    }

    @NotNull
    public final List<String> getCuisines() {
        return this.cuisines;
    }

    @NotNull
    public final String getDeliveryTime() {
        return this.deliveryTime;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getVendorId() {
        return this.vendorId;
    }

    @NotNull
    public final String getVendorStatus() {
        return this.vendorStatus;
    }

    @NotNull
    public final String getVendorStatusType() {
        return this.vendorStatusType;
    }

    public final int getVerticalType() {
        return this.verticalType;
    }

    @NotNull
    public final String getVoucherId() {
        return this.voucherId;
    }

    public int hashCode() {
        int hashCode = ((((((this.branchId.hashCode() * 31) + this.branchName.hashCode()) * 31) + this.cuisines.hashCode()) * 31) + this.deliveryTime.hashCode()) * 31;
        boolean z11 = this.isDarkstore;
        if (z11) {
            z11 = true;
        }
        return ((((((((((((hashCode + (z11 ? 1 : 0)) * 31) + this.voucherId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.vendorId.hashCode()) * 31) + this.vendorStatus.hashCode()) * 31) + this.vendorStatusType.hashCode()) * 31) + this.verticalType;
    }

    public final boolean isDarkstore() {
        return this.isDarkstore;
    }

    @NotNull
    public String toString() {
        String str = this.branchId;
        String str2 = this.branchName;
        List<String> list = this.cuisines;
        String str3 = this.deliveryTime;
        boolean z11 = this.isDarkstore;
        String str4 = this.voucherId;
        String str5 = this.title;
        String str6 = this.vendorId;
        String str7 = this.vendorStatus;
        String str8 = this.vendorStatusType;
        int i11 = this.verticalType;
        return "TMartGrowthTrackingInfo(branchId=" + str + ", branchName=" + str2 + ", cuisines=" + list + ", deliveryTime=" + str3 + ", isDarkstore=" + z11 + ", voucherId=" + str4 + ", title=" + str5 + ", vendorId=" + str6 + ", vendorStatus=" + str7 + ", vendorStatusType=" + str8 + ", verticalType=" + i11 + ")";
    }
}
