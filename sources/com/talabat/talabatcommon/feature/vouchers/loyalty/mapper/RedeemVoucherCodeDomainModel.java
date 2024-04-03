package com.talabat.talabatcommon.feature.vouchers.loyalty.mapper;

import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.asm.Advice;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003J\t\u0010.\u001a\u00020\u000eHÆ\u0003J\t\u0010/\u001a\u00020\u000eHÆ\u0003J\t\u00100\u001a\u00020\u0012HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010%J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\fHÆ\u0003J¦\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010<J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0015HÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u0010\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001a¨\u0006B"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/RedeemVoucherCodeDomainModel;", "", "customerVoucherId", "", "title", "tag", "description", "deepLink", "voucherImage", "termsAndConditions", "validTil", "discountType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/DiscountType;", "discountValue", "", "maxDiscountCap", "minOrderValue", "bounds", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/Bounds;", "campaignReferenceId", "redeemedVouchersCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/DiscountType;FFFLcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/Bounds;Ljava/lang/String;Ljava/lang/Integer;)V", "getBounds", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/Bounds;", "getCampaignReferenceId", "()Ljava/lang/String;", "getCustomerVoucherId", "getDeepLink", "getDescription", "getDiscountType", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/DiscountType;", "getDiscountValue", "()F", "getMaxDiscountCap", "getMinOrderValue", "getRedeemedVouchersCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTag", "getTermsAndConditions", "getTitle", "getValidTil", "getVoucherImage", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/DiscountType;FFFLcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/Bounds;Ljava/lang/String;Ljava/lang/Integer;)Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/RedeemVoucherCodeDomainModel;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemVoucherCodeDomainModel {
    @NotNull
    private final Bounds bounds;
    @NotNull
    private final String campaignReferenceId;
    @NotNull
    private final String customerVoucherId;
    @NotNull
    private final String deepLink;
    @NotNull
    private final String description;
    @NotNull
    private final DiscountType discountType;
    private final float discountValue;
    private final float maxDiscountCap;
    private final float minOrderValue;
    @Nullable
    private final Integer redeemedVouchersCount;
    @NotNull
    private final String tag;
    @NotNull
    private final String termsAndConditions;
    @NotNull
    private final String title;
    @NotNull
    private final String validTil;
    @NotNull
    private final String voucherImage;

    public RedeemVoucherCodeDomainModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (DiscountType) null, 0.0f, 0.0f, 0.0f, (Bounds) null, (String) null, (Integer) null, Advice.MethodSizeHandler.UNDEFINED_SIZE, (DefaultConstructorMarker) null);
    }

    public RedeemVoucherCodeDomainModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull DiscountType discountType2, float f11, float f12, float f13, @NotNull Bounds bounds2, @NotNull String str9, @Nullable Integer num) {
        String str10 = str3;
        String str11 = str4;
        String str12 = str5;
        String str13 = str6;
        String str14 = str7;
        String str15 = str8;
        DiscountType discountType3 = discountType2;
        Bounds bounds3 = bounds2;
        String str16 = str9;
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.QUERY_CUSTOMER_VOUCHER_ID);
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str10, "tag");
        Intrinsics.checkNotNullParameter(str11, "description");
        Intrinsics.checkNotNullParameter(str12, "deepLink");
        Intrinsics.checkNotNullParameter(str13, "voucherImage");
        Intrinsics.checkNotNullParameter(str14, "termsAndConditions");
        Intrinsics.checkNotNullParameter(str15, "validTil");
        Intrinsics.checkNotNullParameter(discountType3, "discountType");
        Intrinsics.checkNotNullParameter(bounds3, Param.BOUNDS);
        Intrinsics.checkNotNullParameter(str16, "campaignReferenceId");
        this.customerVoucherId = str;
        this.title = str2;
        this.tag = str10;
        this.description = str11;
        this.deepLink = str12;
        this.voucherImage = str13;
        this.termsAndConditions = str14;
        this.validTil = str15;
        this.discountType = discountType3;
        this.discountValue = f11;
        this.maxDiscountCap = f12;
        this.minOrderValue = f13;
        this.bounds = bounds3;
        this.campaignReferenceId = str16;
        this.redeemedVouchersCount = num;
    }

    public static /* synthetic */ RedeemVoucherCodeDomainModel copy$default(RedeemVoucherCodeDomainModel redeemVoucherCodeDomainModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, DiscountType discountType2, float f11, float f12, float f13, Bounds bounds2, String str9, Integer num, int i11, Object obj) {
        RedeemVoucherCodeDomainModel redeemVoucherCodeDomainModel2 = redeemVoucherCodeDomainModel;
        int i12 = i11;
        return redeemVoucherCodeDomainModel.copy((i12 & 1) != 0 ? redeemVoucherCodeDomainModel2.customerVoucherId : str, (i12 & 2) != 0 ? redeemVoucherCodeDomainModel2.title : str2, (i12 & 4) != 0 ? redeemVoucherCodeDomainModel2.tag : str3, (i12 & 8) != 0 ? redeemVoucherCodeDomainModel2.description : str4, (i12 & 16) != 0 ? redeemVoucherCodeDomainModel2.deepLink : str5, (i12 & 32) != 0 ? redeemVoucherCodeDomainModel2.voucherImage : str6, (i12 & 64) != 0 ? redeemVoucherCodeDomainModel2.termsAndConditions : str7, (i12 & 128) != 0 ? redeemVoucherCodeDomainModel2.validTil : str8, (i12 & 256) != 0 ? redeemVoucherCodeDomainModel2.discountType : discountType2, (i12 & 512) != 0 ? redeemVoucherCodeDomainModel2.discountValue : f11, (i12 & 1024) != 0 ? redeemVoucherCodeDomainModel2.maxDiscountCap : f12, (i12 & 2048) != 0 ? redeemVoucherCodeDomainModel2.minOrderValue : f13, (i12 & 4096) != 0 ? redeemVoucherCodeDomainModel2.bounds : bounds2, (i12 & 8192) != 0 ? redeemVoucherCodeDomainModel2.campaignReferenceId : str9, (i12 & 16384) != 0 ? redeemVoucherCodeDomainModel2.redeemedVouchersCount : num);
    }

    @NotNull
    public final String component1() {
        return this.customerVoucherId;
    }

    public final float component10() {
        return this.discountValue;
    }

    public final float component11() {
        return this.maxDiscountCap;
    }

    public final float component12() {
        return this.minOrderValue;
    }

    @NotNull
    public final Bounds component13() {
        return this.bounds;
    }

    @NotNull
    public final String component14() {
        return this.campaignReferenceId;
    }

    @Nullable
    public final Integer component15() {
        return this.redeemedVouchersCount;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.tag;
    }

    @NotNull
    public final String component4() {
        return this.description;
    }

    @NotNull
    public final String component5() {
        return this.deepLink;
    }

    @NotNull
    public final String component6() {
        return this.voucherImage;
    }

    @NotNull
    public final String component7() {
        return this.termsAndConditions;
    }

    @NotNull
    public final String component8() {
        return this.validTil;
    }

    @NotNull
    public final DiscountType component9() {
        return this.discountType;
    }

    @NotNull
    public final RedeemVoucherCodeDomainModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull DiscountType discountType2, float f11, float f12, float f13, @NotNull Bounds bounds2, @NotNull String str9, @Nullable Integer num) {
        String str10 = str;
        Intrinsics.checkNotNullParameter(str10, VoucherUrlConstantsKt.QUERY_CUSTOMER_VOUCHER_ID);
        String str11 = str2;
        Intrinsics.checkNotNullParameter(str11, "title");
        String str12 = str3;
        Intrinsics.checkNotNullParameter(str12, "tag");
        String str13 = str4;
        Intrinsics.checkNotNullParameter(str13, "description");
        String str14 = str5;
        Intrinsics.checkNotNullParameter(str14, "deepLink");
        String str15 = str6;
        Intrinsics.checkNotNullParameter(str15, "voucherImage");
        String str16 = str7;
        Intrinsics.checkNotNullParameter(str16, "termsAndConditions");
        String str17 = str8;
        Intrinsics.checkNotNullParameter(str17, "validTil");
        DiscountType discountType3 = discountType2;
        Intrinsics.checkNotNullParameter(discountType3, "discountType");
        Bounds bounds3 = bounds2;
        Intrinsics.checkNotNullParameter(bounds3, Param.BOUNDS);
        String str18 = str9;
        Intrinsics.checkNotNullParameter(str18, "campaignReferenceId");
        return new RedeemVoucherCodeDomainModel(str10, str11, str12, str13, str14, str15, str16, str17, discountType3, f11, f12, f13, bounds3, str18, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedeemVoucherCodeDomainModel)) {
            return false;
        }
        RedeemVoucherCodeDomainModel redeemVoucherCodeDomainModel = (RedeemVoucherCodeDomainModel) obj;
        return Intrinsics.areEqual((Object) this.customerVoucherId, (Object) redeemVoucherCodeDomainModel.customerVoucherId) && Intrinsics.areEqual((Object) this.title, (Object) redeemVoucherCodeDomainModel.title) && Intrinsics.areEqual((Object) this.tag, (Object) redeemVoucherCodeDomainModel.tag) && Intrinsics.areEqual((Object) this.description, (Object) redeemVoucherCodeDomainModel.description) && Intrinsics.areEqual((Object) this.deepLink, (Object) redeemVoucherCodeDomainModel.deepLink) && Intrinsics.areEqual((Object) this.voucherImage, (Object) redeemVoucherCodeDomainModel.voucherImage) && Intrinsics.areEqual((Object) this.termsAndConditions, (Object) redeemVoucherCodeDomainModel.termsAndConditions) && Intrinsics.areEqual((Object) this.validTil, (Object) redeemVoucherCodeDomainModel.validTil) && this.discountType == redeemVoucherCodeDomainModel.discountType && Intrinsics.areEqual((Object) Float.valueOf(this.discountValue), (Object) Float.valueOf(redeemVoucherCodeDomainModel.discountValue)) && Intrinsics.areEqual((Object) Float.valueOf(this.maxDiscountCap), (Object) Float.valueOf(redeemVoucherCodeDomainModel.maxDiscountCap)) && Intrinsics.areEqual((Object) Float.valueOf(this.minOrderValue), (Object) Float.valueOf(redeemVoucherCodeDomainModel.minOrderValue)) && Intrinsics.areEqual((Object) this.bounds, (Object) redeemVoucherCodeDomainModel.bounds) && Intrinsics.areEqual((Object) this.campaignReferenceId, (Object) redeemVoucherCodeDomainModel.campaignReferenceId) && Intrinsics.areEqual((Object) this.redeemedVouchersCount, (Object) redeemVoucherCodeDomainModel.redeemedVouchersCount);
    }

    @NotNull
    public final Bounds getBounds() {
        return this.bounds;
    }

    @NotNull
    public final String getCampaignReferenceId() {
        return this.campaignReferenceId;
    }

    @NotNull
    public final String getCustomerVoucherId() {
        return this.customerVoucherId;
    }

    @NotNull
    public final String getDeepLink() {
        return this.deepLink;
    }

    @NotNull
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

    public final float getMaxDiscountCap() {
        return this.maxDiscountCap;
    }

    public final float getMinOrderValue() {
        return this.minOrderValue;
    }

    @Nullable
    public final Integer getRedeemedVouchersCount() {
        return this.redeemedVouchersCount;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final String getTermsAndConditions() {
        return this.termsAndConditions;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getValidTil() {
        return this.validTil;
    }

    @NotNull
    public final String getVoucherImage() {
        return this.voucherImage;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((this.customerVoucherId.hashCode() * 31) + this.title.hashCode()) * 31) + this.tag.hashCode()) * 31) + this.description.hashCode()) * 31) + this.deepLink.hashCode()) * 31) + this.voucherImage.hashCode()) * 31) + this.termsAndConditions.hashCode()) * 31) + this.validTil.hashCode()) * 31) + this.discountType.hashCode()) * 31) + Float.floatToIntBits(this.discountValue)) * 31) + Float.floatToIntBits(this.maxDiscountCap)) * 31) + Float.floatToIntBits(this.minOrderValue)) * 31) + this.bounds.hashCode()) * 31) + this.campaignReferenceId.hashCode()) * 31;
        Integer num = this.redeemedVouchersCount;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    @NotNull
    public String toString() {
        String str = this.customerVoucherId;
        String str2 = this.title;
        String str3 = this.tag;
        String str4 = this.description;
        String str5 = this.deepLink;
        String str6 = this.voucherImage;
        String str7 = this.termsAndConditions;
        String str8 = this.validTil;
        DiscountType discountType2 = this.discountType;
        float f11 = this.discountValue;
        float f12 = this.maxDiscountCap;
        float f13 = this.minOrderValue;
        Bounds bounds2 = this.bounds;
        String str9 = this.campaignReferenceId;
        Integer num = this.redeemedVouchersCount;
        return "RedeemVoucherCodeDomainModel(customerVoucherId=" + str + ", title=" + str2 + ", tag=" + str3 + ", description=" + str4 + ", deepLink=" + str5 + ", voucherImage=" + str6 + ", termsAndConditions=" + str7 + ", validTil=" + str8 + ", discountType=" + discountType2 + ", discountValue=" + f11 + ", maxDiscountCap=" + f12 + ", minOrderValue=" + f13 + ", bounds=" + bounds2 + ", campaignReferenceId=" + str9 + ", redeemedVouchersCount=" + num + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RedeemVoucherCodeDomainModel(java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType r29, float r30, float r31, float r32, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds r33, java.lang.String r34, java.lang.Integer r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
        /*
            r20 = this;
            r0 = r36
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            kotlin.jvm.internal.StringCompanionObject r1 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r1 = com.talabat.talabatcommon.extentions.StringUtils.empty(r1)
            goto L_0x000f
        L_0x000d:
            r1 = r21
        L_0x000f:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x001a
            kotlin.jvm.internal.StringCompanionObject r2 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r2 = com.talabat.talabatcommon.extentions.StringUtils.empty(r2)
            goto L_0x001c
        L_0x001a:
            r2 = r22
        L_0x001c:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0027
            kotlin.jvm.internal.StringCompanionObject r3 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r3 = com.talabat.talabatcommon.extentions.StringUtils.empty(r3)
            goto L_0x0029
        L_0x0027:
            r3 = r23
        L_0x0029:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0034
            kotlin.jvm.internal.StringCompanionObject r4 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r4 = com.talabat.talabatcommon.extentions.StringUtils.empty(r4)
            goto L_0x0036
        L_0x0034:
            r4 = r24
        L_0x0036:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0041
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r5 = com.talabat.talabatcommon.extentions.StringUtils.empty(r5)
            goto L_0x0043
        L_0x0041:
            r5 = r25
        L_0x0043:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x004e
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r6 = com.talabat.talabatcommon.extentions.StringUtils.empty(r6)
            goto L_0x0050
        L_0x004e:
            r6 = r26
        L_0x0050:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x005b
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r7 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
            goto L_0x005d
        L_0x005b:
            r7 = r27
        L_0x005d:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0068
            kotlin.jvm.internal.StringCompanionObject r8 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r8 = com.talabat.talabatcommon.extentions.StringUtils.empty(r8)
            goto L_0x006a
        L_0x0068:
            r8 = r28
        L_0x006a:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0071
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType r9 = com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType.NONE
            goto L_0x0073
        L_0x0071:
            r9 = r29
        L_0x0073:
            r10 = r0 & 512(0x200, float:7.175E-43)
            r11 = 0
            if (r10 == 0) goto L_0x007a
            r10 = r11
            goto L_0x007c
        L_0x007a:
            r10 = r30
        L_0x007c:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0082
            r12 = r11
            goto L_0x0084
        L_0x0082:
            r12 = r31
        L_0x0084:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0089
            goto L_0x008b
        L_0x0089:
            r11 = r32
        L_0x008b:
            r13 = r0 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x00ad
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds r13 = new com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 15
            r19 = 0
            r21 = r13
            r22 = r14
            r23 = r15
            r24 = r16
            r25 = r17
            r26 = r18
            r27 = r19
            r21.<init>(r22, r23, r24, r25, r26, r27)
            goto L_0x00af
        L_0x00ad:
            r13 = r33
        L_0x00af:
            r14 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x00ba
            kotlin.jvm.internal.StringCompanionObject r14 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r14 = com.talabat.talabatcommon.extentions.StringUtils.empty(r14)
            goto L_0x00bc
        L_0x00ba:
            r14 = r34
        L_0x00bc:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x00c2
            r0 = 0
            goto L_0x00c4
        L_0x00c2:
            r0 = r35
        L_0x00c4:
            r21 = r20
            r22 = r1
            r23 = r2
            r24 = r3
            r25 = r4
            r26 = r5
            r27 = r6
            r28 = r7
            r29 = r8
            r30 = r9
            r31 = r10
            r32 = r12
            r33 = r11
            r34 = r13
            r35 = r14
            r36 = r0
            r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType, float, float, float, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
