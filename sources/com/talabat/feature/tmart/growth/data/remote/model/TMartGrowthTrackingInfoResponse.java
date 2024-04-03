package com.talabat.feature.tmart.growth.data.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001e\b\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u000fHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003Js\u0010(\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\u00032\b\b\u0003\u0010\r\u001a\u00020\u00032\b\b\u0003\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u000fHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006-"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;", "", "branchId", "", "branchName", "cuisines", "", "deliveryTime", "isDarkstore", "", "vendorName", "vendorStatus", "vendorStatusType", "vendorId", "verticalType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getBranchId", "()Ljava/lang/String;", "getBranchName", "getCuisines", "()Ljava/util/List;", "getDeliveryTime", "()Z", "getVendorId", "getVendorName", "getVendorStatus", "getVendorStatusType", "getVerticalType", "()I", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthTrackingInfoResponse {
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
    private final String vendorId;
    @NotNull
    private final String vendorName;
    @NotNull
    private final String vendorStatus;
    @NotNull
    private final String vendorStatusType;
    private final int verticalType;

    public TMartGrowthTrackingInfoResponse(@NotNull @Json(name = "branch_id") String str, @NotNull @Json(name = "branch_name") String str2, @NotNull @Json(name = "cuisines") List<String> list, @NotNull @Json(name = "delivery_time") String str3, @Json(name = "is_darkstore") boolean z11, @NotNull @Json(name = "name") String str4, @NotNull @Json(name = "status") String str5, @NotNull @Json(name = "status_type") String str6, @NotNull @Json(name = "vendor_id") String str7, @Json(name = "vertical_type") int i11) {
        Intrinsics.checkNotNullParameter(str, "branchId");
        Intrinsics.checkNotNullParameter(str2, "branchName");
        Intrinsics.checkNotNullParameter(list, "cuisines");
        Intrinsics.checkNotNullParameter(str3, "deliveryTime");
        Intrinsics.checkNotNullParameter(str4, "vendorName");
        Intrinsics.checkNotNullParameter(str5, "vendorStatus");
        Intrinsics.checkNotNullParameter(str6, "vendorStatusType");
        Intrinsics.checkNotNullParameter(str7, "vendorId");
        this.branchId = str;
        this.branchName = str2;
        this.cuisines = list;
        this.deliveryTime = str3;
        this.isDarkstore = z11;
        this.vendorName = str4;
        this.vendorStatus = str5;
        this.vendorStatusType = str6;
        this.vendorId = str7;
        this.verticalType = i11;
    }

    public static /* synthetic */ TMartGrowthTrackingInfoResponse copy$default(TMartGrowthTrackingInfoResponse tMartGrowthTrackingInfoResponse, String str, String str2, List list, String str3, boolean z11, String str4, String str5, String str6, String str7, int i11, int i12, Object obj) {
        TMartGrowthTrackingInfoResponse tMartGrowthTrackingInfoResponse2 = tMartGrowthTrackingInfoResponse;
        int i13 = i12;
        return tMartGrowthTrackingInfoResponse.copy((i13 & 1) != 0 ? tMartGrowthTrackingInfoResponse2.branchId : str, (i13 & 2) != 0 ? tMartGrowthTrackingInfoResponse2.branchName : str2, (i13 & 4) != 0 ? tMartGrowthTrackingInfoResponse2.cuisines : list, (i13 & 8) != 0 ? tMartGrowthTrackingInfoResponse2.deliveryTime : str3, (i13 & 16) != 0 ? tMartGrowthTrackingInfoResponse2.isDarkstore : z11, (i13 & 32) != 0 ? tMartGrowthTrackingInfoResponse2.vendorName : str4, (i13 & 64) != 0 ? tMartGrowthTrackingInfoResponse2.vendorStatus : str5, (i13 & 128) != 0 ? tMartGrowthTrackingInfoResponse2.vendorStatusType : str6, (i13 & 256) != 0 ? tMartGrowthTrackingInfoResponse2.vendorId : str7, (i13 & 512) != 0 ? tMartGrowthTrackingInfoResponse2.verticalType : i11);
    }

    @NotNull
    public final String component1() {
        return this.branchId;
    }

    public final int component10() {
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
        return this.vendorName;
    }

    @NotNull
    public final String component7() {
        return this.vendorStatus;
    }

    @NotNull
    public final String component8() {
        return this.vendorStatusType;
    }

    @NotNull
    public final String component9() {
        return this.vendorId;
    }

    @NotNull
    public final TMartGrowthTrackingInfoResponse copy(@NotNull @Json(name = "branch_id") String str, @NotNull @Json(name = "branch_name") String str2, @NotNull @Json(name = "cuisines") List<String> list, @NotNull @Json(name = "delivery_time") String str3, @Json(name = "is_darkstore") boolean z11, @NotNull @Json(name = "name") String str4, @NotNull @Json(name = "status") String str5, @NotNull @Json(name = "status_type") String str6, @NotNull @Json(name = "vendor_id") String str7, @Json(name = "vertical_type") int i11) {
        Intrinsics.checkNotNullParameter(str, "branchId");
        Intrinsics.checkNotNullParameter(str2, "branchName");
        Intrinsics.checkNotNullParameter(list, "cuisines");
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str8, "deliveryTime");
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, "vendorName");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, "vendorStatus");
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str11, "vendorStatusType");
        String str12 = str7;
        Intrinsics.checkNotNullParameter(str12, "vendorId");
        return new TMartGrowthTrackingInfoResponse(str, str2, list, str8, z11, str9, str10, str11, str12, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TMartGrowthTrackingInfoResponse)) {
            return false;
        }
        TMartGrowthTrackingInfoResponse tMartGrowthTrackingInfoResponse = (TMartGrowthTrackingInfoResponse) obj;
        return Intrinsics.areEqual((Object) this.branchId, (Object) tMartGrowthTrackingInfoResponse.branchId) && Intrinsics.areEqual((Object) this.branchName, (Object) tMartGrowthTrackingInfoResponse.branchName) && Intrinsics.areEqual((Object) this.cuisines, (Object) tMartGrowthTrackingInfoResponse.cuisines) && Intrinsics.areEqual((Object) this.deliveryTime, (Object) tMartGrowthTrackingInfoResponse.deliveryTime) && this.isDarkstore == tMartGrowthTrackingInfoResponse.isDarkstore && Intrinsics.areEqual((Object) this.vendorName, (Object) tMartGrowthTrackingInfoResponse.vendorName) && Intrinsics.areEqual((Object) this.vendorStatus, (Object) tMartGrowthTrackingInfoResponse.vendorStatus) && Intrinsics.areEqual((Object) this.vendorStatusType, (Object) tMartGrowthTrackingInfoResponse.vendorStatusType) && Intrinsics.areEqual((Object) this.vendorId, (Object) tMartGrowthTrackingInfoResponse.vendorId) && this.verticalType == tMartGrowthTrackingInfoResponse.verticalType;
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
    public final String getVendorId() {
        return this.vendorId;
    }

    @NotNull
    public final String getVendorName() {
        return this.vendorName;
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

    public int hashCode() {
        int hashCode = ((((((this.branchId.hashCode() * 31) + this.branchName.hashCode()) * 31) + this.cuisines.hashCode()) * 31) + this.deliveryTime.hashCode()) * 31;
        boolean z11 = this.isDarkstore;
        if (z11) {
            z11 = true;
        }
        return ((((((((((hashCode + (z11 ? 1 : 0)) * 31) + this.vendorName.hashCode()) * 31) + this.vendorStatus.hashCode()) * 31) + this.vendorStatusType.hashCode()) * 31) + this.vendorId.hashCode()) * 31) + this.verticalType;
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
        String str4 = this.vendorName;
        String str5 = this.vendorStatus;
        String str6 = this.vendorStatusType;
        String str7 = this.vendorId;
        int i11 = this.verticalType;
        return "TMartGrowthTrackingInfoResponse(branchId=" + str + ", branchName=" + str2 + ", cuisines=" + list + ", deliveryTime=" + str3 + ", isDarkstore=" + z11 + ", vendorName=" + str4 + ", vendorStatus=" + str5 + ", vendorStatusType=" + str6 + ", vendorId=" + str7 + ", verticalType=" + i11 + ")";
    }
}
