package com.talabat.feature.pickup.data.entity;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bA\b\b\u0018\u00002\u00020\u0001B×\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\"\u001a\u00020\u0005¢\u0006\u0002\u0010#J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0011HÆ\u0003J\t\u0010D\u001a\u00020\u0011HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0018HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u001fHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\u000f\u0010V\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\u0005HÆ\u0003J\t\u0010Z\u001a\u00020\u000fHÆ\u0003J\u0002\u0010[\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\"\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\\\u001a\u00020\u00112\b\u0010]\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010^\u001a\u00020\u0003HÖ\u0001J\t\u0010_\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u00100R\u0016\u0010\u0012\u001a\u00020\u00118\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u00100R\u0016\u0010\u001e\u001a\u00020\u001f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010'R\u0016\u0010\"\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010'R\u0016\u0010\u0015\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010'R\u0016\u0010\u0017\u001a\u00020\u00188\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0016\u0010\u0019\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010%R\u0016\u0010\u001a\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%R\u0016\u0010\u001b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010'R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010%R\u0016\u0010\u001c\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010'R\u0016\u0010\u001d\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010%R\u0018\u0010 \u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010%R\u0018\u0010!\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010%¨\u0006`"}, d2 = {"Lcom/talabat/feature/pickup/data/entity/PickupDto;", "", "chainId", "", "allOrderDiscountText", "", "chainLogo", "chainName", "cuisines", "", "Lcom/talabat/feature/pickup/data/entity/PickupCuisineDto;", "totalRating", "cuisinesText", "discountText", "distance", "Lcom/talabat/feature/pickup/data/entity/Distance;", "isDiscountAvailable", "", "isNewVendor", "moreDiscounts", "pickupMinutes", "pickupTimeText", "priceTag", "rating", "", "ratingText", "statusText", "statusType", "vendorId", "vendorName", "latLng", "Lcom/talabat/feature/pickup/data/entity/LatLngDto;", "voucherCode", "voucherDisplayText", "pickupDiscountText", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/pickup/data/entity/Distance;ZZIILjava/lang/String;IDLjava/lang/String;Ljava/lang/String;IILjava/lang/String;Lcom/talabat/feature/pickup/data/entity/LatLngDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAllOrderDiscountText", "()Ljava/lang/String;", "getChainId", "()I", "getChainLogo", "getChainName", "getCuisines", "()Ljava/util/List;", "getCuisinesText", "getDiscountText", "getDistance", "()Lcom/talabat/feature/pickup/data/entity/Distance;", "()Z", "getLatLng", "()Lcom/talabat/feature/pickup/data/entity/LatLngDto;", "getMoreDiscounts", "getPickupDiscountText", "getPickupMinutes", "getPickupTimeText", "getPriceTag", "getRating", "()D", "getRatingText", "getStatusText", "getStatusType", "getTotalRating", "getVendorId", "getVendorName", "getVoucherCode", "getVoucherDisplayText", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupDto {
    @SerializedName("all_order_discount_text")
    @NotNull
    private final String allOrderDiscountText;
    @SerializedName("chain_id")
    private final int chainId;
    @SerializedName("chain_logo")
    @NotNull
    private final String chainLogo;
    @SerializedName("chain_name")
    @NotNull
    private final String chainName;
    @SerializedName("cuisines")
    @NotNull
    private final List<PickupCuisineDto> cuisines;
    @SerializedName("cuisines_text")
    @NotNull
    private final String cuisinesText;
    @SerializedName("discount_text")
    @NotNull
    private final String discountText;
    @SerializedName("distance")
    @NotNull
    private final Distance distance;
    @SerializedName("is_discount_available")
    private final boolean isDiscountAvailable;
    @SerializedName("is_new_vendor")
    private final boolean isNewVendor;
    @SerializedName("vendor_location")
    @NotNull
    private final LatLngDto latLng;
    @SerializedName("more_discounts")
    private final int moreDiscounts;
    @SerializedName("pickup_discount_text")
    @NotNull
    private final String pickupDiscountText;
    @SerializedName("pickup_minutes")
    private final int pickupMinutes;
    @SerializedName("pickup_time_text")
    @NotNull
    private final String pickupTimeText;
    @SerializedName("price_tag")
    private final int priceTag;
    @SerializedName("rating")
    private final double rating;
    @SerializedName("rating_text")
    @NotNull
    private final String ratingText;
    @SerializedName("status_text")
    @NotNull
    private final String statusText;
    @SerializedName("status_type")
    private final int statusType;
    @SerializedName("ratings_total")
    @NotNull
    private final String totalRating;
    @SerializedName("vendor_id")
    private final int vendorId;
    @SerializedName("vendor_name")
    @NotNull
    private final String vendorName;
    @SerializedName("pickup_voucher_code")
    @Nullable
    private final String voucherCode;
    @SerializedName("pickup_voucher_text")
    @Nullable
    private final String voucherDisplayText;

    public PickupDto(int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<PickupCuisineDto> list, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull Distance distance2, boolean z11, boolean z12, int i12, int i13, @NotNull String str7, int i14, double d11, @NotNull String str8, @NotNull String str9, int i15, int i16, @NotNull String str10, @NotNull LatLngDto latLngDto, @Nullable String str11, @Nullable String str12, @NotNull String str13) {
        String str14 = str;
        String str15 = str2;
        String str16 = str3;
        List<PickupCuisineDto> list2 = list;
        String str17 = str4;
        String str18 = str5;
        String str19 = str6;
        Distance distance3 = distance2;
        String str20 = str7;
        String str21 = str8;
        String str22 = str9;
        String str23 = str10;
        LatLngDto latLngDto2 = latLngDto;
        String str24 = str13;
        Intrinsics.checkNotNullParameter(str14, "allOrderDiscountText");
        Intrinsics.checkNotNullParameter(str15, "chainLogo");
        Intrinsics.checkNotNullParameter(str16, "chainName");
        Intrinsics.checkNotNullParameter(list2, "cuisines");
        Intrinsics.checkNotNullParameter(str17, "totalRating");
        Intrinsics.checkNotNullParameter(str18, "cuisinesText");
        Intrinsics.checkNotNullParameter(str19, "discountText");
        Intrinsics.checkNotNullParameter(distance3, "distance");
        Intrinsics.checkNotNullParameter(str20, "pickupTimeText");
        Intrinsics.checkNotNullParameter(str21, "ratingText");
        Intrinsics.checkNotNullParameter(str22, "statusText");
        Intrinsics.checkNotNullParameter(str23, "vendorName");
        Intrinsics.checkNotNullParameter(latLngDto2, Param.LAT_LNG);
        Intrinsics.checkNotNullParameter(str24, "pickupDiscountText");
        this.chainId = i11;
        this.allOrderDiscountText = str14;
        this.chainLogo = str15;
        this.chainName = str16;
        this.cuisines = list2;
        this.totalRating = str17;
        this.cuisinesText = str18;
        this.discountText = str19;
        this.distance = distance3;
        this.isDiscountAvailable = z11;
        this.isNewVendor = z12;
        this.moreDiscounts = i12;
        this.pickupMinutes = i13;
        this.pickupTimeText = str20;
        this.priceTag = i14;
        this.rating = d11;
        this.ratingText = str21;
        this.statusText = str22;
        this.statusType = i15;
        this.vendorId = i16;
        this.vendorName = str23;
        this.latLng = latLngDto2;
        this.voucherCode = str11;
        this.voucherDisplayText = str12;
        this.pickupDiscountText = str24;
    }

    public static /* synthetic */ PickupDto copy$default(PickupDto pickupDto, int i11, String str, String str2, String str3, List list, String str4, String str5, String str6, Distance distance2, boolean z11, boolean z12, int i12, int i13, String str7, int i14, double d11, String str8, String str9, int i15, int i16, String str10, LatLngDto latLngDto, String str11, String str12, String str13, int i17, Object obj) {
        PickupDto pickupDto2 = pickupDto;
        int i18 = i17;
        return pickupDto.copy((i18 & 1) != 0 ? pickupDto2.chainId : i11, (i18 & 2) != 0 ? pickupDto2.allOrderDiscountText : str, (i18 & 4) != 0 ? pickupDto2.chainLogo : str2, (i18 & 8) != 0 ? pickupDto2.chainName : str3, (i18 & 16) != 0 ? pickupDto2.cuisines : list, (i18 & 32) != 0 ? pickupDto2.totalRating : str4, (i18 & 64) != 0 ? pickupDto2.cuisinesText : str5, (i18 & 128) != 0 ? pickupDto2.discountText : str6, (i18 & 256) != 0 ? pickupDto2.distance : distance2, (i18 & 512) != 0 ? pickupDto2.isDiscountAvailable : z11, (i18 & 1024) != 0 ? pickupDto2.isNewVendor : z12, (i18 & 2048) != 0 ? pickupDto2.moreDiscounts : i12, (i18 & 4096) != 0 ? pickupDto2.pickupMinutes : i13, (i18 & 8192) != 0 ? pickupDto2.pickupTimeText : str7, (i18 & 16384) != 0 ? pickupDto2.priceTag : i14, (i18 & 32768) != 0 ? pickupDto2.rating : d11, (i18 & 65536) != 0 ? pickupDto2.ratingText : str8, (131072 & i18) != 0 ? pickupDto2.statusText : str9, (i18 & 262144) != 0 ? pickupDto2.statusType : i15, (i18 & 524288) != 0 ? pickupDto2.vendorId : i16, (i18 & 1048576) != 0 ? pickupDto2.vendorName : str10, (i18 & 2097152) != 0 ? pickupDto2.latLng : latLngDto, (i18 & 4194304) != 0 ? pickupDto2.voucherCode : str11, (i18 & 8388608) != 0 ? pickupDto2.voucherDisplayText : str12, (i18 & 16777216) != 0 ? pickupDto2.pickupDiscountText : str13);
    }

    public final int component1() {
        return this.chainId;
    }

    public final boolean component10() {
        return this.isDiscountAvailable;
    }

    public final boolean component11() {
        return this.isNewVendor;
    }

    public final int component12() {
        return this.moreDiscounts;
    }

    public final int component13() {
        return this.pickupMinutes;
    }

    @NotNull
    public final String component14() {
        return this.pickupTimeText;
    }

    public final int component15() {
        return this.priceTag;
    }

    public final double component16() {
        return this.rating;
    }

    @NotNull
    public final String component17() {
        return this.ratingText;
    }

    @NotNull
    public final String component18() {
        return this.statusText;
    }

    public final int component19() {
        return this.statusType;
    }

    @NotNull
    public final String component2() {
        return this.allOrderDiscountText;
    }

    public final int component20() {
        return this.vendorId;
    }

    @NotNull
    public final String component21() {
        return this.vendorName;
    }

    @NotNull
    public final LatLngDto component22() {
        return this.latLng;
    }

    @Nullable
    public final String component23() {
        return this.voucherCode;
    }

    @Nullable
    public final String component24() {
        return this.voucherDisplayText;
    }

    @NotNull
    public final String component25() {
        return this.pickupDiscountText;
    }

    @NotNull
    public final String component3() {
        return this.chainLogo;
    }

    @NotNull
    public final String component4() {
        return this.chainName;
    }

    @NotNull
    public final List<PickupCuisineDto> component5() {
        return this.cuisines;
    }

    @NotNull
    public final String component6() {
        return this.totalRating;
    }

    @NotNull
    public final String component7() {
        return this.cuisinesText;
    }

    @NotNull
    public final String component8() {
        return this.discountText;
    }

    @NotNull
    public final Distance component9() {
        return this.distance;
    }

    @NotNull
    public final PickupDto copy(int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<PickupCuisineDto> list, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull Distance distance2, boolean z11, boolean z12, int i12, int i13, @NotNull String str7, int i14, double d11, @NotNull String str8, @NotNull String str9, int i15, int i16, @NotNull String str10, @NotNull LatLngDto latLngDto, @Nullable String str11, @Nullable String str12, @NotNull String str13) {
        int i17 = i11;
        Intrinsics.checkNotNullParameter(str, "allOrderDiscountText");
        Intrinsics.checkNotNullParameter(str2, "chainLogo");
        Intrinsics.checkNotNullParameter(str3, "chainName");
        Intrinsics.checkNotNullParameter(list, "cuisines");
        Intrinsics.checkNotNullParameter(str4, "totalRating");
        Intrinsics.checkNotNullParameter(str5, "cuisinesText");
        Intrinsics.checkNotNullParameter(str6, "discountText");
        Intrinsics.checkNotNullParameter(distance2, "distance");
        Intrinsics.checkNotNullParameter(str7, "pickupTimeText");
        Intrinsics.checkNotNullParameter(str8, "ratingText");
        Intrinsics.checkNotNullParameter(str9, "statusText");
        Intrinsics.checkNotNullParameter(str10, "vendorName");
        Intrinsics.checkNotNullParameter(latLngDto, Param.LAT_LNG);
        Intrinsics.checkNotNullParameter(str13, "pickupDiscountText");
        return new PickupDto(i11, str, str2, str3, list, str4, str5, str6, distance2, z11, z12, i12, i13, str7, i14, d11, str8, str9, i15, i16, str10, latLngDto, str11, str12, str13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PickupDto)) {
            return false;
        }
        PickupDto pickupDto = (PickupDto) obj;
        return this.chainId == pickupDto.chainId && Intrinsics.areEqual((Object) this.allOrderDiscountText, (Object) pickupDto.allOrderDiscountText) && Intrinsics.areEqual((Object) this.chainLogo, (Object) pickupDto.chainLogo) && Intrinsics.areEqual((Object) this.chainName, (Object) pickupDto.chainName) && Intrinsics.areEqual((Object) this.cuisines, (Object) pickupDto.cuisines) && Intrinsics.areEqual((Object) this.totalRating, (Object) pickupDto.totalRating) && Intrinsics.areEqual((Object) this.cuisinesText, (Object) pickupDto.cuisinesText) && Intrinsics.areEqual((Object) this.discountText, (Object) pickupDto.discountText) && Intrinsics.areEqual((Object) this.distance, (Object) pickupDto.distance) && this.isDiscountAvailable == pickupDto.isDiscountAvailable && this.isNewVendor == pickupDto.isNewVendor && this.moreDiscounts == pickupDto.moreDiscounts && this.pickupMinutes == pickupDto.pickupMinutes && Intrinsics.areEqual((Object) this.pickupTimeText, (Object) pickupDto.pickupTimeText) && this.priceTag == pickupDto.priceTag && Intrinsics.areEqual((Object) Double.valueOf(this.rating), (Object) Double.valueOf(pickupDto.rating)) && Intrinsics.areEqual((Object) this.ratingText, (Object) pickupDto.ratingText) && Intrinsics.areEqual((Object) this.statusText, (Object) pickupDto.statusText) && this.statusType == pickupDto.statusType && this.vendorId == pickupDto.vendorId && Intrinsics.areEqual((Object) this.vendorName, (Object) pickupDto.vendorName) && Intrinsics.areEqual((Object) this.latLng, (Object) pickupDto.latLng) && Intrinsics.areEqual((Object) this.voucherCode, (Object) pickupDto.voucherCode) && Intrinsics.areEqual((Object) this.voucherDisplayText, (Object) pickupDto.voucherDisplayText) && Intrinsics.areEqual((Object) this.pickupDiscountText, (Object) pickupDto.pickupDiscountText);
    }

    @NotNull
    public final String getAllOrderDiscountText() {
        return this.allOrderDiscountText;
    }

    public final int getChainId() {
        return this.chainId;
    }

    @NotNull
    public final String getChainLogo() {
        return this.chainLogo;
    }

    @NotNull
    public final String getChainName() {
        return this.chainName;
    }

    @NotNull
    public final List<PickupCuisineDto> getCuisines() {
        return this.cuisines;
    }

    @NotNull
    public final String getCuisinesText() {
        return this.cuisinesText;
    }

    @NotNull
    public final String getDiscountText() {
        return this.discountText;
    }

    @NotNull
    public final Distance getDistance() {
        return this.distance;
    }

    @NotNull
    public final LatLngDto getLatLng() {
        return this.latLng;
    }

    public final int getMoreDiscounts() {
        return this.moreDiscounts;
    }

    @NotNull
    public final String getPickupDiscountText() {
        return this.pickupDiscountText;
    }

    public final int getPickupMinutes() {
        return this.pickupMinutes;
    }

    @NotNull
    public final String getPickupTimeText() {
        return this.pickupTimeText;
    }

    public final int getPriceTag() {
        return this.priceTag;
    }

    public final double getRating() {
        return this.rating;
    }

    @NotNull
    public final String getRatingText() {
        return this.ratingText;
    }

    @NotNull
    public final String getStatusText() {
        return this.statusText;
    }

    public final int getStatusType() {
        return this.statusType;
    }

    @NotNull
    public final String getTotalRating() {
        return this.totalRating;
    }

    public final int getVendorId() {
        return this.vendorId;
    }

    @NotNull
    public final String getVendorName() {
        return this.vendorName;
    }

    @Nullable
    public final String getVoucherCode() {
        return this.voucherCode;
    }

    @Nullable
    public final String getVoucherDisplayText() {
        return this.voucherDisplayText;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.chainId * 31) + this.allOrderDiscountText.hashCode()) * 31) + this.chainLogo.hashCode()) * 31) + this.chainName.hashCode()) * 31) + this.cuisines.hashCode()) * 31) + this.totalRating.hashCode()) * 31) + this.cuisinesText.hashCode()) * 31) + this.discountText.hashCode()) * 31) + this.distance.hashCode()) * 31;
        boolean z11 = this.isDiscountAvailable;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.isNewVendor;
        if (!z13) {
            z12 = z13;
        }
        int hashCode2 = (((((((((((((((((((((((i11 + (z12 ? 1 : 0)) * 31) + this.moreDiscounts) * 31) + this.pickupMinutes) * 31) + this.pickupTimeText.hashCode()) * 31) + this.priceTag) * 31) + Double.doubleToLongBits(this.rating)) * 31) + this.ratingText.hashCode()) * 31) + this.statusText.hashCode()) * 31) + this.statusType) * 31) + this.vendorId) * 31) + this.vendorName.hashCode()) * 31) + this.latLng.hashCode()) * 31;
        String str = this.voucherCode;
        int i12 = 0;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.voucherDisplayText;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return ((hashCode3 + i12) * 31) + this.pickupDiscountText.hashCode();
    }

    public final boolean isDiscountAvailable() {
        return this.isDiscountAvailable;
    }

    public final boolean isNewVendor() {
        return this.isNewVendor;
    }

    @NotNull
    public String toString() {
        int i11 = this.chainId;
        String str = this.allOrderDiscountText;
        String str2 = this.chainLogo;
        String str3 = this.chainName;
        List<PickupCuisineDto> list = this.cuisines;
        String str4 = this.totalRating;
        String str5 = this.cuisinesText;
        String str6 = this.discountText;
        Distance distance2 = this.distance;
        boolean z11 = this.isDiscountAvailable;
        boolean z12 = this.isNewVendor;
        int i12 = this.moreDiscounts;
        int i13 = this.pickupMinutes;
        String str7 = this.pickupTimeText;
        int i14 = this.priceTag;
        double d11 = this.rating;
        String str8 = this.ratingText;
        String str9 = this.statusText;
        int i15 = this.statusType;
        int i16 = this.vendorId;
        String str10 = this.vendorName;
        LatLngDto latLngDto = this.latLng;
        String str11 = this.voucherCode;
        String str12 = this.voucherDisplayText;
        String str13 = this.pickupDiscountText;
        return "PickupDto(chainId=" + i11 + ", allOrderDiscountText=" + str + ", chainLogo=" + str2 + ", chainName=" + str3 + ", cuisines=" + list + ", totalRating=" + str4 + ", cuisinesText=" + str5 + ", discountText=" + str6 + ", distance=" + distance2 + ", isDiscountAvailable=" + z11 + ", isNewVendor=" + z12 + ", moreDiscounts=" + i12 + ", pickupMinutes=" + i13 + ", pickupTimeText=" + str7 + ", priceTag=" + i14 + ", rating=" + d11 + ", ratingText=" + str8 + ", statusText=" + str9 + ", statusType=" + i15 + ", vendorId=" + i16 + ", vendorName=" + str10 + ", latLng=" + latLngDto + ", voucherCode=" + str11 + ", voucherDisplayText=" + str12 + ", pickupDiscountText=" + str13 + ")";
    }
}
