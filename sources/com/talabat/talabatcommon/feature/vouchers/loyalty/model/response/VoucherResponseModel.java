package com.talabat.talabatcommon.feature.vouchers.loyalty.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bI\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bã\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bHÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010U\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010#Jì\u0001\u0010W\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010XJ\u0013\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\\\u001a\u00020\u0005HÖ\u0001J\t\u0010]\u001a\u00020\u0003HÖ\u0001R \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010(\"\u0004\b*\u0010+R\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010(\"\u0004\b2\u0010+R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010(R\"\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R\"\u0010\r\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b6\u0010-\"\u0004\b7\u0010/R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010(R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010(\"\u0004\b:\u0010+R \u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010(\"\u0004\b<\u0010+R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b=\u0010#\"\u0004\b>\u0010%R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010(R\"\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b@\u0010#\"\u0004\bA\u0010%R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010(R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010(\"\u0004\bD\u0010+¨\u0006^"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VoucherResponseModel;", "", "id", "", "customerId", "", "title", "brandIds", "", "discountValue", "", "discountType", "maxDiscountCap", "minOrderValue", "talabatSharePercentage", "bounds", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BoundsResponse;", "pointsCost", "partnerUrl", "partnerUrlText", "thumbnailURL", "imageURL", "nfpCouponCode", "description", "tag", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BoundsResponse;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBounds", "()Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BoundsResponse;", "setBounds", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BoundsResponse;)V", "getBrandIds", "()Ljava/util/List;", "setBrandIds", "(Ljava/util/List;)V", "getCustomerId", "()Ljava/lang/Integer;", "setCustomerId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDescription", "()Ljava/lang/String;", "getDiscountType", "setDiscountType", "(Ljava/lang/String;)V", "getDiscountValue", "()Ljava/lang/Float;", "setDiscountValue", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getId", "setId", "getImageURL", "getMaxDiscountCap", "setMaxDiscountCap", "getMinOrderValue", "setMinOrderValue", "getNfpCouponCode", "getPartnerUrl", "setPartnerUrl", "getPartnerUrlText", "setPartnerUrlText", "getPointsCost", "setPointsCost", "getTag", "getTalabatSharePercentage", "setTalabatSharePercentage", "getThumbnailURL", "getTitle", "setTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BoundsResponse;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VoucherResponseModel;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherResponseModel {
    @SerializedName("bounds")
    @Nullable
    private BoundsResponse bounds;
    @SerializedName("brandIds")
    @Nullable
    private List<Integer> brandIds;
    @SerializedName("customerId")
    @Nullable
    private Integer customerId;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("discountType")
    @Nullable
    private String discountType;
    @SerializedName("discountValue")
    @Nullable
    private Float discountValue;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private String f61643id;
    @SerializedName("imageURL")
    @Nullable
    private final String imageURL;
    @SerializedName("maxDiscountCap")
    @Nullable
    private Float maxDiscountCap;
    @SerializedName("minOrderValue")
    @Nullable
    private Float minOrderValue;
    @SerializedName("nfpCouponCode")
    @Nullable
    private final String nfpCouponCode;
    @SerializedName("partnerUrl")
    @Nullable
    private String partnerUrl;
    @SerializedName("partnerUrlText")
    @Nullable
    private String partnerUrlText;
    @SerializedName("pointsCost")
    @Nullable
    private Integer pointsCost;
    @SerializedName("tag")
    @Nullable
    private final String tag;
    @SerializedName("talabatSharePercentage")
    @Nullable
    private Integer talabatSharePercentage;
    @SerializedName("thumbnailURL")
    @Nullable
    private final String thumbnailURL;
    @SerializedName("title")
    @Nullable
    private String title;

    public VoucherResponseModel() {
        this((String) null, (Integer) null, (String) null, (List) null, (Float) null, (String) null, (Float) null, (Float) null, (Integer) null, (BoundsResponse) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 262143, (DefaultConstructorMarker) null);
    }

    public VoucherResponseModel(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable List<Integer> list, @Nullable Float f11, @Nullable String str3, @Nullable Float f12, @Nullable Float f13, @Nullable Integer num2, @Nullable BoundsResponse boundsResponse, @Nullable Integer num3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        this.f61643id = str;
        this.customerId = num;
        this.title = str2;
        this.brandIds = list;
        this.discountValue = f11;
        this.discountType = str3;
        this.maxDiscountCap = f12;
        this.minOrderValue = f13;
        this.talabatSharePercentage = num2;
        this.bounds = boundsResponse;
        this.pointsCost = num3;
        this.partnerUrl = str4;
        this.partnerUrlText = str5;
        this.thumbnailURL = str6;
        this.imageURL = str7;
        this.nfpCouponCode = str8;
        this.description = str9;
        this.tag = str10;
    }

    public static /* synthetic */ VoucherResponseModel copy$default(VoucherResponseModel voucherResponseModel, String str, Integer num, String str2, List list, Float f11, String str3, Float f12, Float f13, Integer num2, BoundsResponse boundsResponse, Integer num3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i11, Object obj) {
        VoucherResponseModel voucherResponseModel2 = voucherResponseModel;
        int i12 = i11;
        return voucherResponseModel.copy((i12 & 1) != 0 ? voucherResponseModel2.f61643id : str, (i12 & 2) != 0 ? voucherResponseModel2.customerId : num, (i12 & 4) != 0 ? voucherResponseModel2.title : str2, (i12 & 8) != 0 ? voucherResponseModel2.brandIds : list, (i12 & 16) != 0 ? voucherResponseModel2.discountValue : f11, (i12 & 32) != 0 ? voucherResponseModel2.discountType : str3, (i12 & 64) != 0 ? voucherResponseModel2.maxDiscountCap : f12, (i12 & 128) != 0 ? voucherResponseModel2.minOrderValue : f13, (i12 & 256) != 0 ? voucherResponseModel2.talabatSharePercentage : num2, (i12 & 512) != 0 ? voucherResponseModel2.bounds : boundsResponse, (i12 & 1024) != 0 ? voucherResponseModel2.pointsCost : num3, (i12 & 2048) != 0 ? voucherResponseModel2.partnerUrl : str4, (i12 & 4096) != 0 ? voucherResponseModel2.partnerUrlText : str5, (i12 & 8192) != 0 ? voucherResponseModel2.thumbnailURL : str6, (i12 & 16384) != 0 ? voucherResponseModel2.imageURL : str7, (i12 & 32768) != 0 ? voucherResponseModel2.nfpCouponCode : str8, (i12 & 65536) != 0 ? voucherResponseModel2.description : str9, (i12 & 131072) != 0 ? voucherResponseModel2.tag : str10);
    }

    @Nullable
    public final String component1() {
        return this.f61643id;
    }

    @Nullable
    public final BoundsResponse component10() {
        return this.bounds;
    }

    @Nullable
    public final Integer component11() {
        return this.pointsCost;
    }

    @Nullable
    public final String component12() {
        return this.partnerUrl;
    }

    @Nullable
    public final String component13() {
        return this.partnerUrlText;
    }

    @Nullable
    public final String component14() {
        return this.thumbnailURL;
    }

    @Nullable
    public final String component15() {
        return this.imageURL;
    }

    @Nullable
    public final String component16() {
        return this.nfpCouponCode;
    }

    @Nullable
    public final String component17() {
        return this.description;
    }

    @Nullable
    public final String component18() {
        return this.tag;
    }

    @Nullable
    public final Integer component2() {
        return this.customerId;
    }

    @Nullable
    public final String component3() {
        return this.title;
    }

    @Nullable
    public final List<Integer> component4() {
        return this.brandIds;
    }

    @Nullable
    public final Float component5() {
        return this.discountValue;
    }

    @Nullable
    public final String component6() {
        return this.discountType;
    }

    @Nullable
    public final Float component7() {
        return this.maxDiscountCap;
    }

    @Nullable
    public final Float component8() {
        return this.minOrderValue;
    }

    @Nullable
    public final Integer component9() {
        return this.talabatSharePercentage;
    }

    @NotNull
    public final VoucherResponseModel copy(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable List<Integer> list, @Nullable Float f11, @Nullable String str3, @Nullable Float f12, @Nullable Float f13, @Nullable Integer num2, @Nullable BoundsResponse boundsResponse, @Nullable Integer num3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        return new VoucherResponseModel(str, num, str2, list, f11, str3, f12, f13, num2, boundsResponse, num3, str4, str5, str6, str7, str8, str9, str10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoucherResponseModel)) {
            return false;
        }
        VoucherResponseModel voucherResponseModel = (VoucherResponseModel) obj;
        return Intrinsics.areEqual((Object) this.f61643id, (Object) voucherResponseModel.f61643id) && Intrinsics.areEqual((Object) this.customerId, (Object) voucherResponseModel.customerId) && Intrinsics.areEqual((Object) this.title, (Object) voucherResponseModel.title) && Intrinsics.areEqual((Object) this.brandIds, (Object) voucherResponseModel.brandIds) && Intrinsics.areEqual((Object) this.discountValue, (Object) voucherResponseModel.discountValue) && Intrinsics.areEqual((Object) this.discountType, (Object) voucherResponseModel.discountType) && Intrinsics.areEqual((Object) this.maxDiscountCap, (Object) voucherResponseModel.maxDiscountCap) && Intrinsics.areEqual((Object) this.minOrderValue, (Object) voucherResponseModel.minOrderValue) && Intrinsics.areEqual((Object) this.talabatSharePercentage, (Object) voucherResponseModel.talabatSharePercentage) && Intrinsics.areEqual((Object) this.bounds, (Object) voucherResponseModel.bounds) && Intrinsics.areEqual((Object) this.pointsCost, (Object) voucherResponseModel.pointsCost) && Intrinsics.areEqual((Object) this.partnerUrl, (Object) voucherResponseModel.partnerUrl) && Intrinsics.areEqual((Object) this.partnerUrlText, (Object) voucherResponseModel.partnerUrlText) && Intrinsics.areEqual((Object) this.thumbnailURL, (Object) voucherResponseModel.thumbnailURL) && Intrinsics.areEqual((Object) this.imageURL, (Object) voucherResponseModel.imageURL) && Intrinsics.areEqual((Object) this.nfpCouponCode, (Object) voucherResponseModel.nfpCouponCode) && Intrinsics.areEqual((Object) this.description, (Object) voucherResponseModel.description) && Intrinsics.areEqual((Object) this.tag, (Object) voucherResponseModel.tag);
    }

    @Nullable
    public final BoundsResponse getBounds() {
        return this.bounds;
    }

    @Nullable
    public final List<Integer> getBrandIds() {
        return this.brandIds;
    }

    @Nullable
    public final Integer getCustomerId() {
        return this.customerId;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getDiscountType() {
        return this.discountType;
    }

    @Nullable
    public final Float getDiscountValue() {
        return this.discountValue;
    }

    @Nullable
    public final String getId() {
        return this.f61643id;
    }

    @Nullable
    public final String getImageURL() {
        return this.imageURL;
    }

    @Nullable
    public final Float getMaxDiscountCap() {
        return this.maxDiscountCap;
    }

    @Nullable
    public final Float getMinOrderValue() {
        return this.minOrderValue;
    }

    @Nullable
    public final String getNfpCouponCode() {
        return this.nfpCouponCode;
    }

    @Nullable
    public final String getPartnerUrl() {
        return this.partnerUrl;
    }

    @Nullable
    public final String getPartnerUrlText() {
        return this.partnerUrlText;
    }

    @Nullable
    public final Integer getPointsCost() {
        return this.pointsCost;
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }

    @Nullable
    public final Integer getTalabatSharePercentage() {
        return this.talabatSharePercentage;
    }

    @Nullable
    public final String getThumbnailURL() {
        return this.thumbnailURL;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.f61643id;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.customerId;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.title;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<Integer> list = this.brandIds;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        Float f11 = this.discountValue;
        int hashCode5 = (hashCode4 + (f11 == null ? 0 : f11.hashCode())) * 31;
        String str3 = this.discountType;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Float f12 = this.maxDiscountCap;
        int hashCode7 = (hashCode6 + (f12 == null ? 0 : f12.hashCode())) * 31;
        Float f13 = this.minOrderValue;
        int hashCode8 = (hashCode7 + (f13 == null ? 0 : f13.hashCode())) * 31;
        Integer num2 = this.talabatSharePercentage;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        BoundsResponse boundsResponse = this.bounds;
        int hashCode10 = (hashCode9 + (boundsResponse == null ? 0 : boundsResponse.hashCode())) * 31;
        Integer num3 = this.pointsCost;
        int hashCode11 = (hashCode10 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str4 = this.partnerUrl;
        int hashCode12 = (hashCode11 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.partnerUrlText;
        int hashCode13 = (hashCode12 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.thumbnailURL;
        int hashCode14 = (hashCode13 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.imageURL;
        int hashCode15 = (hashCode14 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.nfpCouponCode;
        int hashCode16 = (hashCode15 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.description;
        int hashCode17 = (hashCode16 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.tag;
        if (str10 != null) {
            i11 = str10.hashCode();
        }
        return hashCode17 + i11;
    }

    public final void setBounds(@Nullable BoundsResponse boundsResponse) {
        this.bounds = boundsResponse;
    }

    public final void setBrandIds(@Nullable List<Integer> list) {
        this.brandIds = list;
    }

    public final void setCustomerId(@Nullable Integer num) {
        this.customerId = num;
    }

    public final void setDiscountType(@Nullable String str) {
        this.discountType = str;
    }

    public final void setDiscountValue(@Nullable Float f11) {
        this.discountValue = f11;
    }

    public final void setId(@Nullable String str) {
        this.f61643id = str;
    }

    public final void setMaxDiscountCap(@Nullable Float f11) {
        this.maxDiscountCap = f11;
    }

    public final void setMinOrderValue(@Nullable Float f11) {
        this.minOrderValue = f11;
    }

    public final void setPartnerUrl(@Nullable String str) {
        this.partnerUrl = str;
    }

    public final void setPartnerUrlText(@Nullable String str) {
        this.partnerUrlText = str;
    }

    public final void setPointsCost(@Nullable Integer num) {
        this.pointsCost = num;
    }

    public final void setTalabatSharePercentage(@Nullable Integer num) {
        this.talabatSharePercentage = num;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @NotNull
    public String toString() {
        String str = this.f61643id;
        Integer num = this.customerId;
        String str2 = this.title;
        List<Integer> list = this.brandIds;
        Float f11 = this.discountValue;
        String str3 = this.discountType;
        Float f12 = this.maxDiscountCap;
        Float f13 = this.minOrderValue;
        Integer num2 = this.talabatSharePercentage;
        BoundsResponse boundsResponse = this.bounds;
        Integer num3 = this.pointsCost;
        String str4 = this.partnerUrl;
        String str5 = this.partnerUrlText;
        String str6 = this.thumbnailURL;
        String str7 = this.imageURL;
        String str8 = this.nfpCouponCode;
        String str9 = this.description;
        String str10 = this.tag;
        return "VoucherResponseModel(id=" + str + ", customerId=" + num + ", title=" + str2 + ", brandIds=" + list + ", discountValue=" + f11 + ", discountType=" + str3 + ", maxDiscountCap=" + f12 + ", minOrderValue=" + f13 + ", talabatSharePercentage=" + num2 + ", bounds=" + boundsResponse + ", pointsCost=" + num3 + ", partnerUrl=" + str4 + ", partnerUrlText=" + str5 + ", thumbnailURL=" + str6 + ", imageURL=" + str7 + ", nfpCouponCode=" + str8 + ", description=" + str9 + ", tag=" + str10 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VoucherResponseModel(java.lang.String r20, java.lang.Integer r21, java.lang.String r22, java.util.List r23, java.lang.Float r24, java.lang.String r25, java.lang.Float r26, java.lang.Float r27, java.lang.Integer r28, com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.BoundsResponse r29, java.lang.Integer r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, int r38, kotlin.jvm.internal.DefaultConstructorMarker r39) {
        /*
            r19 = this;
            r0 = r38
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r20
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r21
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r22
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r23
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r24
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r25
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r26
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r27
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r28
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r29
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r30
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r31
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r32
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r33
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r34
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r35
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r36
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r18
            if (r0 == 0) goto L_0x0099
            r0 = 0
            goto L_0x009b
        L_0x0099:
            r0 = r37
        L_0x009b:
            r20 = r19
            r21 = r1
            r22 = r3
            r23 = r4
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r8
            r28 = r9
            r29 = r10
            r30 = r11
            r31 = r12
            r32 = r13
            r33 = r14
            r34 = r15
            r35 = r2
            r36 = r16
            r37 = r17
            r38 = r0
            r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.VoucherResponseModel.<init>(java.lang.String, java.lang.Integer, java.lang.String, java.util.List, java.lang.Float, java.lang.String, java.lang.Float, java.lang.Float, java.lang.Integer, com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.BoundsResponse, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
