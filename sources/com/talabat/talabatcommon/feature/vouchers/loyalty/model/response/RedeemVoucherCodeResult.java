package com.talabat.talabatcommon.feature.vouchers.loyalty.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.asm.Advice;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B¹\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010>\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010?\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÂ\u0001\u0010B\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\u0014HÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001R \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010!R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\"\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b)\u0010#\"\u0004\b*\u0010%R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001b¨\u0006I"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/RedeemVoucherCodeResult;", "", "customerVoucherId", "", "title", "discountType", "discountValue", "", "maxDiscountCap", "minOrderValue", "bounds", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BoundsResponse;", "thumbnailURL", "description", "termsAndConditions", "validTillDate", "deeplink", "tag", "campaignReferenceId", "redeemedVouchersCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BoundsResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getBounds", "()Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BoundsResponse;", "setBounds", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BoundsResponse;)V", "getCampaignReferenceId", "()Ljava/lang/String;", "getCustomerVoucherId", "getDeeplink", "getDescription", "getDiscountType", "setDiscountType", "(Ljava/lang/String;)V", "getDiscountValue", "()Ljava/lang/Float;", "setDiscountValue", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getMaxDiscountCap", "setMaxDiscountCap", "getMinOrderValue", "setMinOrderValue", "getRedeemedVouchersCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTag", "getTermsAndConditions", "getThumbnailURL", "getTitle", "getValidTillDate", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BoundsResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/RedeemVoucherCodeResult;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemVoucherCodeResult {
    @SerializedName("bounds")
    @Nullable
    private BoundsResponse bounds;
    @SerializedName("campaignReferenceId")
    @Nullable
    private final String campaignReferenceId;
    @SerializedName("customerVoucherId")
    @Nullable
    private final String customerVoucherId;
    @SerializedName("deeplink")
    @Nullable
    private final String deeplink;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("discountType")
    @Nullable
    private String discountType;
    @SerializedName("discountValue")
    @Nullable
    private Float discountValue;
    @SerializedName("maxDiscountCap")
    @Nullable
    private Float maxDiscountCap;
    @SerializedName("minOrderValue")
    @Nullable
    private Float minOrderValue;
    @SerializedName("redeemedVouchersCount")
    @Nullable
    private final Integer redeemedVouchersCount;
    @SerializedName("tag")
    @Nullable
    private final String tag;
    @SerializedName("termsAndConditions")
    @Nullable
    private final String termsAndConditions;
    @SerializedName("thumbnailURL")
    @Nullable
    private final String thumbnailURL;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("validTillDate")
    @Nullable
    private final String validTillDate;

    public RedeemVoucherCodeResult() {
        this((String) null, (String) null, (String) null, (Float) null, (Float) null, (Float) null, (BoundsResponse) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, Advice.MethodSizeHandler.UNDEFINED_SIZE, (DefaultConstructorMarker) null);
    }

    public RedeemVoucherCodeResult(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Float f11, @Nullable Float f12, @Nullable Float f13, @Nullable BoundsResponse boundsResponse, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable Integer num) {
        this.customerVoucherId = str;
        this.title = str2;
        this.discountType = str3;
        this.discountValue = f11;
        this.maxDiscountCap = f12;
        this.minOrderValue = f13;
        this.bounds = boundsResponse;
        this.thumbnailURL = str4;
        this.description = str5;
        this.termsAndConditions = str6;
        this.validTillDate = str7;
        this.deeplink = str8;
        this.tag = str9;
        this.campaignReferenceId = str10;
        this.redeemedVouchersCount = num;
    }

    public static /* synthetic */ RedeemVoucherCodeResult copy$default(RedeemVoucherCodeResult redeemVoucherCodeResult, String str, String str2, String str3, Float f11, Float f12, Float f13, BoundsResponse boundsResponse, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Integer num, int i11, Object obj) {
        RedeemVoucherCodeResult redeemVoucherCodeResult2 = redeemVoucherCodeResult;
        int i12 = i11;
        return redeemVoucherCodeResult.copy((i12 & 1) != 0 ? redeemVoucherCodeResult2.customerVoucherId : str, (i12 & 2) != 0 ? redeemVoucherCodeResult2.title : str2, (i12 & 4) != 0 ? redeemVoucherCodeResult2.discountType : str3, (i12 & 8) != 0 ? redeemVoucherCodeResult2.discountValue : f11, (i12 & 16) != 0 ? redeemVoucherCodeResult2.maxDiscountCap : f12, (i12 & 32) != 0 ? redeemVoucherCodeResult2.minOrderValue : f13, (i12 & 64) != 0 ? redeemVoucherCodeResult2.bounds : boundsResponse, (i12 & 128) != 0 ? redeemVoucherCodeResult2.thumbnailURL : str4, (i12 & 256) != 0 ? redeemVoucherCodeResult2.description : str5, (i12 & 512) != 0 ? redeemVoucherCodeResult2.termsAndConditions : str6, (i12 & 1024) != 0 ? redeemVoucherCodeResult2.validTillDate : str7, (i12 & 2048) != 0 ? redeemVoucherCodeResult2.deeplink : str8, (i12 & 4096) != 0 ? redeemVoucherCodeResult2.tag : str9, (i12 & 8192) != 0 ? redeemVoucherCodeResult2.campaignReferenceId : str10, (i12 & 16384) != 0 ? redeemVoucherCodeResult2.redeemedVouchersCount : num);
    }

    @Nullable
    public final String component1() {
        return this.customerVoucherId;
    }

    @Nullable
    public final String component10() {
        return this.termsAndConditions;
    }

    @Nullable
    public final String component11() {
        return this.validTillDate;
    }

    @Nullable
    public final String component12() {
        return this.deeplink;
    }

    @Nullable
    public final String component13() {
        return this.tag;
    }

    @Nullable
    public final String component14() {
        return this.campaignReferenceId;
    }

    @Nullable
    public final Integer component15() {
        return this.redeemedVouchersCount;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.discountType;
    }

    @Nullable
    public final Float component4() {
        return this.discountValue;
    }

    @Nullable
    public final Float component5() {
        return this.maxDiscountCap;
    }

    @Nullable
    public final Float component6() {
        return this.minOrderValue;
    }

    @Nullable
    public final BoundsResponse component7() {
        return this.bounds;
    }

    @Nullable
    public final String component8() {
        return this.thumbnailURL;
    }

    @Nullable
    public final String component9() {
        return this.description;
    }

    @NotNull
    public final RedeemVoucherCodeResult copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Float f11, @Nullable Float f12, @Nullable Float f13, @Nullable BoundsResponse boundsResponse, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable Integer num) {
        return new RedeemVoucherCodeResult(str, str2, str3, f11, f12, f13, boundsResponse, str4, str5, str6, str7, str8, str9, str10, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedeemVoucherCodeResult)) {
            return false;
        }
        RedeemVoucherCodeResult redeemVoucherCodeResult = (RedeemVoucherCodeResult) obj;
        return Intrinsics.areEqual((Object) this.customerVoucherId, (Object) redeemVoucherCodeResult.customerVoucherId) && Intrinsics.areEqual((Object) this.title, (Object) redeemVoucherCodeResult.title) && Intrinsics.areEqual((Object) this.discountType, (Object) redeemVoucherCodeResult.discountType) && Intrinsics.areEqual((Object) this.discountValue, (Object) redeemVoucherCodeResult.discountValue) && Intrinsics.areEqual((Object) this.maxDiscountCap, (Object) redeemVoucherCodeResult.maxDiscountCap) && Intrinsics.areEqual((Object) this.minOrderValue, (Object) redeemVoucherCodeResult.minOrderValue) && Intrinsics.areEqual((Object) this.bounds, (Object) redeemVoucherCodeResult.bounds) && Intrinsics.areEqual((Object) this.thumbnailURL, (Object) redeemVoucherCodeResult.thumbnailURL) && Intrinsics.areEqual((Object) this.description, (Object) redeemVoucherCodeResult.description) && Intrinsics.areEqual((Object) this.termsAndConditions, (Object) redeemVoucherCodeResult.termsAndConditions) && Intrinsics.areEqual((Object) this.validTillDate, (Object) redeemVoucherCodeResult.validTillDate) && Intrinsics.areEqual((Object) this.deeplink, (Object) redeemVoucherCodeResult.deeplink) && Intrinsics.areEqual((Object) this.tag, (Object) redeemVoucherCodeResult.tag) && Intrinsics.areEqual((Object) this.campaignReferenceId, (Object) redeemVoucherCodeResult.campaignReferenceId) && Intrinsics.areEqual((Object) this.redeemedVouchersCount, (Object) redeemVoucherCodeResult.redeemedVouchersCount);
    }

    @Nullable
    public final BoundsResponse getBounds() {
        return this.bounds;
    }

    @Nullable
    public final String getCampaignReferenceId() {
        return this.campaignReferenceId;
    }

    @Nullable
    public final String getCustomerVoucherId() {
        return this.customerVoucherId;
    }

    @Nullable
    public final String getDeeplink() {
        return this.deeplink;
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
    public final Float getMaxDiscountCap() {
        return this.maxDiscountCap;
    }

    @Nullable
    public final Float getMinOrderValue() {
        return this.minOrderValue;
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

    @Nullable
    public final String getThumbnailURL() {
        return this.thumbnailURL;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getValidTillDate() {
        return this.validTillDate;
    }

    public int hashCode() {
        String str = this.customerVoucherId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.discountType;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Float f11 = this.discountValue;
        int hashCode4 = (hashCode3 + (f11 == null ? 0 : f11.hashCode())) * 31;
        Float f12 = this.maxDiscountCap;
        int hashCode5 = (hashCode4 + (f12 == null ? 0 : f12.hashCode())) * 31;
        Float f13 = this.minOrderValue;
        int hashCode6 = (hashCode5 + (f13 == null ? 0 : f13.hashCode())) * 31;
        BoundsResponse boundsResponse = this.bounds;
        int hashCode7 = (hashCode6 + (boundsResponse == null ? 0 : boundsResponse.hashCode())) * 31;
        String str4 = this.thumbnailURL;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.description;
        int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.termsAndConditions;
        int hashCode10 = (hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.validTillDate;
        int hashCode11 = (hashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.deeplink;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.tag;
        int hashCode13 = (hashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.campaignReferenceId;
        int hashCode14 = (hashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Integer num = this.redeemedVouchersCount;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode14 + i11;
    }

    public final void setBounds(@Nullable BoundsResponse boundsResponse) {
        this.bounds = boundsResponse;
    }

    public final void setDiscountType(@Nullable String str) {
        this.discountType = str;
    }

    public final void setDiscountValue(@Nullable Float f11) {
        this.discountValue = f11;
    }

    public final void setMaxDiscountCap(@Nullable Float f11) {
        this.maxDiscountCap = f11;
    }

    public final void setMinOrderValue(@Nullable Float f11) {
        this.minOrderValue = f11;
    }

    @NotNull
    public String toString() {
        String str = this.customerVoucherId;
        String str2 = this.title;
        String str3 = this.discountType;
        Float f11 = this.discountValue;
        Float f12 = this.maxDiscountCap;
        Float f13 = this.minOrderValue;
        BoundsResponse boundsResponse = this.bounds;
        String str4 = this.thumbnailURL;
        String str5 = this.description;
        String str6 = this.termsAndConditions;
        String str7 = this.validTillDate;
        String str8 = this.deeplink;
        String str9 = this.tag;
        String str10 = this.campaignReferenceId;
        Integer num = this.redeemedVouchersCount;
        return "RedeemVoucherCodeResult(customerVoucherId=" + str + ", title=" + str2 + ", discountType=" + str3 + ", discountValue=" + f11 + ", maxDiscountCap=" + f12 + ", minOrderValue=" + f13 + ", bounds=" + boundsResponse + ", thumbnailURL=" + str4 + ", description=" + str5 + ", termsAndConditions=" + str6 + ", validTillDate=" + str7 + ", deeplink=" + str8 + ", tag=" + str9 + ", campaignReferenceId=" + str10 + ", redeemedVouchersCount=" + num + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RedeemVoucherCodeResult(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.Float r20, java.lang.Float r21, java.lang.Float r22, com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.BoundsResponse r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.Integer r31, int r32, kotlin.jvm.internal.DefaultConstructorMarker r33) {
        /*
            r16 = this;
            r0 = r32
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r18
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r19
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r20
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r21
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r22
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r23
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r24
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r25
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0051
            r11 = r2
            goto L_0x0053
        L_0x0051:
            r11 = r26
        L_0x0053:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r27
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r28
        L_0x0063:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0069
            r14 = r2
            goto L_0x006b
        L_0x0069:
            r14 = r29
        L_0x006b:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0071
            r15 = r2
            goto L_0x0073
        L_0x0071:
            r15 = r30
        L_0x0073:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0078
            goto L_0x007a
        L_0x0078:
            r2 = r31
        L_0x007a:
            r17 = r16
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r11
            r28 = r12
            r29 = r13
            r30 = r14
            r31 = r15
            r32 = r2
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.RedeemVoucherCodeResult.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Float, java.lang.Float, java.lang.Float, com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.BoundsResponse, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
