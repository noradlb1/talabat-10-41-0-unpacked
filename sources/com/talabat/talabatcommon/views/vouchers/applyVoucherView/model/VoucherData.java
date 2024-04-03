package com.talabat.talabatcommon.views.vouchers.applyVoucherView.model;

import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0019J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010*J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0006HÆ\u0003J\t\u0010>\u001a\u00020\bHÆ\u0003J\t\u0010?\u001a\u00020\nHÆ\u0003J\t\u0010@\u001a\u00020\bHÆ\u0003J\t\u0010A\u001a\u00020\bHÆ\u0003J\t\u0010B\u001a\u00020\u000eHÆ\u0003J\t\u0010C\u001a\u00020\u0010HÆ\u0003JÈ\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010EJ\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020\u0006HÖ\u0001J\t\u0010J\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b1\u00102¨\u0006K"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;", "", "id", "", "title", "pointsCost", "", "discountValue", "", "discountType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/DiscountType;", "maxDiscountCap", "minOrderValue", "bounds", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/Bounds;", "voucherOptionType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;", "tag", "validTil", "termsAndConditions", "deepLink", "description", "voucherCode", "campaignReferenceId", "redeemedVouchersCount", "(Ljava/lang/String;Ljava/lang/String;IFLcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/DiscountType;FFLcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/Bounds;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getBounds", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/Bounds;", "getCampaignReferenceId", "()Ljava/lang/String;", "getDeepLink", "getDescription", "getDiscountType", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/DiscountType;", "getDiscountValue", "()F", "getId", "getMaxDiscountCap", "getMinOrderValue", "getPointsCost", "()I", "getRedeemedVouchersCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTag", "getTermsAndConditions", "getTitle", "getValidTil", "getVoucherCode", "getVoucherOptionType", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;IFLcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/DiscountType;FFLcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/Bounds;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherData {
    @NotNull
    private final Bounds bounds;
    @Nullable
    private final String campaignReferenceId;
    @Nullable
    private final String deepLink;
    @Nullable
    private final String description;
    @NotNull
    private final DiscountType discountType;
    private final float discountValue;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f11768id;
    private final float maxDiscountCap;
    private final float minOrderValue;
    private final int pointsCost;
    @Nullable
    private final Integer redeemedVouchersCount;
    @Nullable
    private final String tag;
    @Nullable
    private final String termsAndConditions;
    @NotNull
    private final String title;
    @Nullable
    private final String validTil;
    @Nullable
    private final String voucherCode;
    @NotNull
    private final VoucherOptionType voucherOptionType;

    public VoucherData() {
        this((String) null, (String) null, 0, 0.0f, (DiscountType) null, 0.0f, 0.0f, (Bounds) null, (VoucherOptionType) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, 131071, (DefaultConstructorMarker) null);
    }

    public VoucherData(@NotNull String str, @NotNull String str2, int i11, float f11, @NotNull DiscountType discountType2, float f12, float f13, @NotNull Bounds bounds2, @NotNull VoucherOptionType voucherOptionType2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable Integer num) {
        VoucherOptionType voucherOptionType3 = voucherOptionType2;
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(discountType2, "discountType");
        Intrinsics.checkNotNullParameter(bounds2, Param.BOUNDS);
        Intrinsics.checkNotNullParameter(voucherOptionType3, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        this.f11768id = str;
        this.title = str2;
        this.pointsCost = i11;
        this.discountValue = f11;
        this.discountType = discountType2;
        this.maxDiscountCap = f12;
        this.minOrderValue = f13;
        this.bounds = bounds2;
        this.voucherOptionType = voucherOptionType3;
        this.tag = str3;
        this.validTil = str4;
        this.termsAndConditions = str5;
        this.deepLink = str6;
        this.description = str7;
        this.voucherCode = str8;
        this.campaignReferenceId = str9;
        this.redeemedVouchersCount = num;
    }

    public static /* synthetic */ VoucherData copy$default(VoucherData voucherData, String str, String str2, int i11, float f11, DiscountType discountType2, float f12, float f13, Bounds bounds2, VoucherOptionType voucherOptionType2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, int i12, Object obj) {
        VoucherData voucherData2 = voucherData;
        int i13 = i12;
        return voucherData.copy((i13 & 1) != 0 ? voucherData2.f11768id : str, (i13 & 2) != 0 ? voucherData2.title : str2, (i13 & 4) != 0 ? voucherData2.pointsCost : i11, (i13 & 8) != 0 ? voucherData2.discountValue : f11, (i13 & 16) != 0 ? voucherData2.discountType : discountType2, (i13 & 32) != 0 ? voucherData2.maxDiscountCap : f12, (i13 & 64) != 0 ? voucherData2.minOrderValue : f13, (i13 & 128) != 0 ? voucherData2.bounds : bounds2, (i13 & 256) != 0 ? voucherData2.voucherOptionType : voucherOptionType2, (i13 & 512) != 0 ? voucherData2.tag : str3, (i13 & 1024) != 0 ? voucherData2.validTil : str4, (i13 & 2048) != 0 ? voucherData2.termsAndConditions : str5, (i13 & 4096) != 0 ? voucherData2.deepLink : str6, (i13 & 8192) != 0 ? voucherData2.description : str7, (i13 & 16384) != 0 ? voucherData2.voucherCode : str8, (i13 & 32768) != 0 ? voucherData2.campaignReferenceId : str9, (i13 & 65536) != 0 ? voucherData2.redeemedVouchersCount : num);
    }

    @NotNull
    public final String component1() {
        return this.f11768id;
    }

    @Nullable
    public final String component10() {
        return this.tag;
    }

    @Nullable
    public final String component11() {
        return this.validTil;
    }

    @Nullable
    public final String component12() {
        return this.termsAndConditions;
    }

    @Nullable
    public final String component13() {
        return this.deepLink;
    }

    @Nullable
    public final String component14() {
        return this.description;
    }

    @Nullable
    public final String component15() {
        return this.voucherCode;
    }

    @Nullable
    public final String component16() {
        return this.campaignReferenceId;
    }

    @Nullable
    public final Integer component17() {
        return this.redeemedVouchersCount;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.pointsCost;
    }

    public final float component4() {
        return this.discountValue;
    }

    @NotNull
    public final DiscountType component5() {
        return this.discountType;
    }

    public final float component6() {
        return this.maxDiscountCap;
    }

    public final float component7() {
        return this.minOrderValue;
    }

    @NotNull
    public final Bounds component8() {
        return this.bounds;
    }

    @NotNull
    public final VoucherOptionType component9() {
        return this.voucherOptionType;
    }

    @NotNull
    public final VoucherData copy(@NotNull String str, @NotNull String str2, int i11, float f11, @NotNull DiscountType discountType2, float f12, float f13, @NotNull Bounds bounds2, @NotNull VoucherOptionType voucherOptionType2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable Integer num) {
        String str10 = str;
        Intrinsics.checkNotNullParameter(str10, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(discountType2, "discountType");
        Intrinsics.checkNotNullParameter(bounds2, Param.BOUNDS);
        Intrinsics.checkNotNullParameter(voucherOptionType2, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        return new VoucherData(str10, str2, i11, f11, discountType2, f12, f13, bounds2, voucherOptionType2, str3, str4, str5, str6, str7, str8, str9, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoucherData)) {
            return false;
        }
        VoucherData voucherData = (VoucherData) obj;
        return Intrinsics.areEqual((Object) this.f11768id, (Object) voucherData.f11768id) && Intrinsics.areEqual((Object) this.title, (Object) voucherData.title) && this.pointsCost == voucherData.pointsCost && Intrinsics.areEqual((Object) Float.valueOf(this.discountValue), (Object) Float.valueOf(voucherData.discountValue)) && this.discountType == voucherData.discountType && Intrinsics.areEqual((Object) Float.valueOf(this.maxDiscountCap), (Object) Float.valueOf(voucherData.maxDiscountCap)) && Intrinsics.areEqual((Object) Float.valueOf(this.minOrderValue), (Object) Float.valueOf(voucherData.minOrderValue)) && Intrinsics.areEqual((Object) this.bounds, (Object) voucherData.bounds) && this.voucherOptionType == voucherData.voucherOptionType && Intrinsics.areEqual((Object) this.tag, (Object) voucherData.tag) && Intrinsics.areEqual((Object) this.validTil, (Object) voucherData.validTil) && Intrinsics.areEqual((Object) this.termsAndConditions, (Object) voucherData.termsAndConditions) && Intrinsics.areEqual((Object) this.deepLink, (Object) voucherData.deepLink) && Intrinsics.areEqual((Object) this.description, (Object) voucherData.description) && Intrinsics.areEqual((Object) this.voucherCode, (Object) voucherData.voucherCode) && Intrinsics.areEqual((Object) this.campaignReferenceId, (Object) voucherData.campaignReferenceId) && Intrinsics.areEqual((Object) this.redeemedVouchersCount, (Object) voucherData.redeemedVouchersCount);
    }

    @NotNull
    public final Bounds getBounds() {
        return this.bounds;
    }

    @Nullable
    public final String getCampaignReferenceId() {
        return this.campaignReferenceId;
    }

    @Nullable
    public final String getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final DiscountType getDiscountType() {
        return this.discountType;
    }

    public final float getDiscountValue() {
        return this.discountValue;
    }

    @NotNull
    public final String getId() {
        return this.f11768id;
    }

    public final float getMaxDiscountCap() {
        return this.maxDiscountCap;
    }

    public final float getMinOrderValue() {
        return this.minOrderValue;
    }

    public final int getPointsCost() {
        return this.pointsCost;
    }

    @Nullable
    public final Integer getRedeemedVouchersCount() {
        return this.redeemedVouchersCount;
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }

    @Nullable
    public final String getTermsAndConditions() {
        return this.termsAndConditions;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getValidTil() {
        return this.validTil;
    }

    @Nullable
    public final String getVoucherCode() {
        return this.voucherCode;
    }

    @NotNull
    public final VoucherOptionType getVoucherOptionType() {
        return this.voucherOptionType;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.f11768id.hashCode() * 31) + this.title.hashCode()) * 31) + this.pointsCost) * 31) + Float.floatToIntBits(this.discountValue)) * 31) + this.discountType.hashCode()) * 31) + Float.floatToIntBits(this.maxDiscountCap)) * 31) + Float.floatToIntBits(this.minOrderValue)) * 31) + this.bounds.hashCode()) * 31) + this.voucherOptionType.hashCode()) * 31;
        String str = this.tag;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.validTil;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.termsAndConditions;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.deepLink;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.description;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.voucherCode;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.campaignReferenceId;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num = this.redeemedVouchersCount;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode8 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.f11768id;
        String str2 = this.title;
        int i11 = this.pointsCost;
        float f11 = this.discountValue;
        DiscountType discountType2 = this.discountType;
        float f12 = this.maxDiscountCap;
        float f13 = this.minOrderValue;
        Bounds bounds2 = this.bounds;
        VoucherOptionType voucherOptionType2 = this.voucherOptionType;
        String str3 = this.tag;
        String str4 = this.validTil;
        String str5 = this.termsAndConditions;
        String str6 = this.deepLink;
        String str7 = this.description;
        String str8 = this.voucherCode;
        String str9 = this.campaignReferenceId;
        Integer num = this.redeemedVouchersCount;
        return "VoucherData(id=" + str + ", title=" + str2 + ", pointsCost=" + i11 + ", discountValue=" + f11 + ", discountType=" + discountType2 + ", maxDiscountCap=" + f12 + ", minOrderValue=" + f13 + ", bounds=" + bounds2 + ", voucherOptionType=" + voucherOptionType2 + ", tag=" + str3 + ", validTil=" + str4 + ", termsAndConditions=" + str5 + ", deepLink=" + str6 + ", description=" + str7 + ", voucherCode=" + str8 + ", campaignReferenceId=" + str9 + ", redeemedVouchersCount=" + num + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VoucherData(java.lang.String r19, java.lang.String r20, int r21, float r22, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType r23, float r24, float r25, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds r26, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.Integer r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
        /*
            r18 = this;
            r0 = r36
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            kotlin.jvm.internal.StringCompanionObject r1 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r1 = com.talabat.talabatcommon.extentions.StringUtils.empty(r1)
            goto L_0x000f
        L_0x000d:
            r1 = r19
        L_0x000f:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x001a
            kotlin.jvm.internal.StringCompanionObject r2 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r2 = com.talabat.talabatcommon.extentions.StringUtils.empty(r2)
            goto L_0x001c
        L_0x001a:
            r2 = r20
        L_0x001c:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0027
            kotlin.jvm.internal.IntCompanionObject r3 = kotlin.jvm.internal.IntCompanionObject.INSTANCE
            int r3 = com.talabat.talabatcommon.extentions.IntKt.orZero((kotlin.jvm.internal.IntCompanionObject) r3)
            goto L_0x0029
        L_0x0027:
            r3 = r21
        L_0x0029:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0034
            kotlin.jvm.internal.FloatCompanionObject r4 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            float r4 = com.talabat.talabatcommon.extentions.FloatKt.orZero((kotlin.jvm.internal.FloatCompanionObject) r4)
            goto L_0x0036
        L_0x0034:
            r4 = r22
        L_0x0036:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x003d
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType r5 = com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType.NONE
            goto L_0x003f
        L_0x003d:
            r5 = r23
        L_0x003f:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x004a
            kotlin.jvm.internal.FloatCompanionObject r6 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            float r6 = com.talabat.talabatcommon.extentions.FloatKt.orZero((kotlin.jvm.internal.FloatCompanionObject) r6)
            goto L_0x004c
        L_0x004a:
            r6 = r24
        L_0x004c:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0057
            kotlin.jvm.internal.FloatCompanionObject r7 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            float r7 = com.talabat.talabatcommon.extentions.FloatKt.orZero((kotlin.jvm.internal.FloatCompanionObject) r7)
            goto L_0x0059
        L_0x0057:
            r7 = r25
        L_0x0059:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x007e
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds r8 = new com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds
            java.util.List r9 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            java.util.List r10 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r11 = 0
            r12 = 0
            r13 = 12
            r14 = 0
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r11
            r23 = r12
            r24 = r13
            r25 = r14
            r19.<init>(r20, r21, r22, r23, r24, r25)
            goto L_0x0080
        L_0x007e:
            r8 = r26
        L_0x0080:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0087
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType r9 = com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType.NONE
            goto L_0x0089
        L_0x0087:
            r9 = r27
        L_0x0089:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x008f
            r10 = 0
            goto L_0x0091
        L_0x008f:
            r10 = r28
        L_0x0091:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0097
            r12 = 0
            goto L_0x0099
        L_0x0097:
            r12 = r29
        L_0x0099:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x009f
            r13 = 0
            goto L_0x00a1
        L_0x009f:
            r13 = r30
        L_0x00a1:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x00a7
            r14 = 0
            goto L_0x00a9
        L_0x00a7:
            r14 = r31
        L_0x00a9:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x00af
            r15 = 0
            goto L_0x00b1
        L_0x00af:
            r15 = r32
        L_0x00b1:
            r11 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r11 == 0) goto L_0x00b7
            r11 = 0
            goto L_0x00b9
        L_0x00b7:
            r11 = r33
        L_0x00b9:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x00c3
            r16 = 0
            goto L_0x00c5
        L_0x00c3:
            r16 = r34
        L_0x00c5:
            r17 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x00cd
            r0 = 0
            goto L_0x00cf
        L_0x00cd:
            r0 = r35
        L_0x00cf:
            r19 = r18
            r20 = r1
            r21 = r2
            r22 = r3
            r23 = r4
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r8
            r28 = r9
            r29 = r10
            r30 = r12
            r31 = r13
            r32 = r14
            r33 = r15
            r34 = r11
            r35 = r16
            r36 = r0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData.<init>(java.lang.String, java.lang.String, int, float, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType, float, float, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
