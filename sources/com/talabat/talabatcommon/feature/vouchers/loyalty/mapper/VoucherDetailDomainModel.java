package com.talabat.talabatcommon.feature.vouchers.loyalty.mapper;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bµ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003¢\u0006\u0002\u0010\u0018J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003J\t\u0010;\u001a\u00020\nHÆ\u0003J\t\u0010<\u001a\u00020\fHÆ\u0003J\t\u0010=\u001a\u00020\nHÆ\u0003J\t\u0010>\u001a\u00020\nHÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J¹\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u0003HÆ\u0001J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\u0005HÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001e¨\u0006F"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/VoucherDetailDomainModel;", "", "id", "", "customerId", "", "title", "brandIds", "", "discountValue", "", "discountType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/DiscountType;", "maxDiscountCap", "minOrderValue", "talabatSharePercentage", "pointsCost", "partnerUrl", "partnerUrlText", "thumbnailURL", "imageURL", "nfpCouponCode", "description", "tag", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/List;FLcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/DiscountType;FFIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrandIds", "()Ljava/util/List;", "getCustomerId", "()I", "getDescription", "()Ljava/lang/String;", "getDiscountType", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/DiscountType;", "getDiscountValue", "()F", "getId", "getImageURL", "getMaxDiscountCap", "getMinOrderValue", "getNfpCouponCode", "getPartnerUrl", "getPartnerUrlText", "getPointsCost", "getTag", "getTalabatSharePercentage", "getThumbnailURL", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherDetailDomainModel {
    @NotNull
    private final List<Integer> brandIds;
    private final int customerId;
    @NotNull
    private final String description;
    @NotNull
    private final DiscountType discountType;
    private final float discountValue;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f61641id;
    @NotNull
    private final String imageURL;
    private final float maxDiscountCap;
    private final float minOrderValue;
    @NotNull
    private final String nfpCouponCode;
    @NotNull
    private final String partnerUrl;
    @NotNull
    private final String partnerUrlText;
    private final int pointsCost;
    @NotNull
    private final String tag;
    private final int talabatSharePercentage;
    @NotNull
    private final String thumbnailURL;
    @NotNull
    private final String title;

    public VoucherDetailDomainModel() {
        this((String) null, 0, (String) null, (List) null, 0.0f, (DiscountType) null, 0.0f, 0.0f, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 131071, (DefaultConstructorMarker) null);
    }

    public VoucherDetailDomainModel(@NotNull String str, int i11, @NotNull String str2, @NotNull List<Integer> list, float f11, @NotNull DiscountType discountType2, float f12, float f13, int i12, int i13, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9) {
        String str10 = str2;
        List<Integer> list2 = list;
        DiscountType discountType3 = discountType2;
        String str11 = str3;
        String str12 = str4;
        String str13 = str5;
        String str14 = str6;
        String str15 = str7;
        String str16 = str8;
        String str17 = str9;
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str10, "title");
        Intrinsics.checkNotNullParameter(list2, "brandIds");
        Intrinsics.checkNotNullParameter(discountType3, "discountType");
        Intrinsics.checkNotNullParameter(str11, "partnerUrl");
        Intrinsics.checkNotNullParameter(str12, "partnerUrlText");
        Intrinsics.checkNotNullParameter(str13, "thumbnailURL");
        Intrinsics.checkNotNullParameter(str14, "imageURL");
        Intrinsics.checkNotNullParameter(str15, "nfpCouponCode");
        Intrinsics.checkNotNullParameter(str16, "description");
        Intrinsics.checkNotNullParameter(str17, "tag");
        this.f61641id = str;
        this.customerId = i11;
        this.title = str10;
        this.brandIds = list2;
        this.discountValue = f11;
        this.discountType = discountType3;
        this.maxDiscountCap = f12;
        this.minOrderValue = f13;
        this.talabatSharePercentage = i12;
        this.pointsCost = i13;
        this.partnerUrl = str11;
        this.partnerUrlText = str12;
        this.thumbnailURL = str13;
        this.imageURL = str14;
        this.nfpCouponCode = str15;
        this.description = str16;
        this.tag = str17;
    }

    public static /* synthetic */ VoucherDetailDomainModel copy$default(VoucherDetailDomainModel voucherDetailDomainModel, String str, int i11, String str2, List list, float f11, DiscountType discountType2, float f12, float f13, int i12, int i13, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i14, Object obj) {
        VoucherDetailDomainModel voucherDetailDomainModel2 = voucherDetailDomainModel;
        int i15 = i14;
        return voucherDetailDomainModel.copy((i15 & 1) != 0 ? voucherDetailDomainModel2.f61641id : str, (i15 & 2) != 0 ? voucherDetailDomainModel2.customerId : i11, (i15 & 4) != 0 ? voucherDetailDomainModel2.title : str2, (i15 & 8) != 0 ? voucherDetailDomainModel2.brandIds : list, (i15 & 16) != 0 ? voucherDetailDomainModel2.discountValue : f11, (i15 & 32) != 0 ? voucherDetailDomainModel2.discountType : discountType2, (i15 & 64) != 0 ? voucherDetailDomainModel2.maxDiscountCap : f12, (i15 & 128) != 0 ? voucherDetailDomainModel2.minOrderValue : f13, (i15 & 256) != 0 ? voucherDetailDomainModel2.talabatSharePercentage : i12, (i15 & 512) != 0 ? voucherDetailDomainModel2.pointsCost : i13, (i15 & 1024) != 0 ? voucherDetailDomainModel2.partnerUrl : str3, (i15 & 2048) != 0 ? voucherDetailDomainModel2.partnerUrlText : str4, (i15 & 4096) != 0 ? voucherDetailDomainModel2.thumbnailURL : str5, (i15 & 8192) != 0 ? voucherDetailDomainModel2.imageURL : str6, (i15 & 16384) != 0 ? voucherDetailDomainModel2.nfpCouponCode : str7, (i15 & 32768) != 0 ? voucherDetailDomainModel2.description : str8, (i15 & 65536) != 0 ? voucherDetailDomainModel2.tag : str9);
    }

    @NotNull
    public final String component1() {
        return this.f61641id;
    }

    public final int component10() {
        return this.pointsCost;
    }

    @NotNull
    public final String component11() {
        return this.partnerUrl;
    }

    @NotNull
    public final String component12() {
        return this.partnerUrlText;
    }

    @NotNull
    public final String component13() {
        return this.thumbnailURL;
    }

    @NotNull
    public final String component14() {
        return this.imageURL;
    }

    @NotNull
    public final String component15() {
        return this.nfpCouponCode;
    }

    @NotNull
    public final String component16() {
        return this.description;
    }

    @NotNull
    public final String component17() {
        return this.tag;
    }

    public final int component2() {
        return this.customerId;
    }

    @NotNull
    public final String component3() {
        return this.title;
    }

    @NotNull
    public final List<Integer> component4() {
        return this.brandIds;
    }

    public final float component5() {
        return this.discountValue;
    }

    @NotNull
    public final DiscountType component6() {
        return this.discountType;
    }

    public final float component7() {
        return this.maxDiscountCap;
    }

    public final float component8() {
        return this.minOrderValue;
    }

    public final int component9() {
        return this.talabatSharePercentage;
    }

    @NotNull
    public final VoucherDetailDomainModel copy(@NotNull String str, int i11, @NotNull String str2, @NotNull List<Integer> list, float f11, @NotNull DiscountType discountType2, float f12, float f13, int i12, int i13, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9) {
        String str10 = str;
        Intrinsics.checkNotNullParameter(str10, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(list, "brandIds");
        Intrinsics.checkNotNullParameter(discountType2, "discountType");
        Intrinsics.checkNotNullParameter(str3, "partnerUrl");
        Intrinsics.checkNotNullParameter(str4, "partnerUrlText");
        Intrinsics.checkNotNullParameter(str5, "thumbnailURL");
        Intrinsics.checkNotNullParameter(str6, "imageURL");
        Intrinsics.checkNotNullParameter(str7, "nfpCouponCode");
        Intrinsics.checkNotNullParameter(str8, "description");
        Intrinsics.checkNotNullParameter(str9, "tag");
        return new VoucherDetailDomainModel(str10, i11, str2, list, f11, discountType2, f12, f13, i12, i13, str3, str4, str5, str6, str7, str8, str9);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoucherDetailDomainModel)) {
            return false;
        }
        VoucherDetailDomainModel voucherDetailDomainModel = (VoucherDetailDomainModel) obj;
        return Intrinsics.areEqual((Object) this.f61641id, (Object) voucherDetailDomainModel.f61641id) && this.customerId == voucherDetailDomainModel.customerId && Intrinsics.areEqual((Object) this.title, (Object) voucherDetailDomainModel.title) && Intrinsics.areEqual((Object) this.brandIds, (Object) voucherDetailDomainModel.brandIds) && Intrinsics.areEqual((Object) Float.valueOf(this.discountValue), (Object) Float.valueOf(voucherDetailDomainModel.discountValue)) && this.discountType == voucherDetailDomainModel.discountType && Intrinsics.areEqual((Object) Float.valueOf(this.maxDiscountCap), (Object) Float.valueOf(voucherDetailDomainModel.maxDiscountCap)) && Intrinsics.areEqual((Object) Float.valueOf(this.minOrderValue), (Object) Float.valueOf(voucherDetailDomainModel.minOrderValue)) && this.talabatSharePercentage == voucherDetailDomainModel.talabatSharePercentage && this.pointsCost == voucherDetailDomainModel.pointsCost && Intrinsics.areEqual((Object) this.partnerUrl, (Object) voucherDetailDomainModel.partnerUrl) && Intrinsics.areEqual((Object) this.partnerUrlText, (Object) voucherDetailDomainModel.partnerUrlText) && Intrinsics.areEqual((Object) this.thumbnailURL, (Object) voucherDetailDomainModel.thumbnailURL) && Intrinsics.areEqual((Object) this.imageURL, (Object) voucherDetailDomainModel.imageURL) && Intrinsics.areEqual((Object) this.nfpCouponCode, (Object) voucherDetailDomainModel.nfpCouponCode) && Intrinsics.areEqual((Object) this.description, (Object) voucherDetailDomainModel.description) && Intrinsics.areEqual((Object) this.tag, (Object) voucherDetailDomainModel.tag);
    }

    @NotNull
    public final List<Integer> getBrandIds() {
        return this.brandIds;
    }

    public final int getCustomerId() {
        return this.customerId;
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

    @NotNull
    public final String getId() {
        return this.f61641id;
    }

    @NotNull
    public final String getImageURL() {
        return this.imageURL;
    }

    public final float getMaxDiscountCap() {
        return this.maxDiscountCap;
    }

    public final float getMinOrderValue() {
        return this.minOrderValue;
    }

    @NotNull
    public final String getNfpCouponCode() {
        return this.nfpCouponCode;
    }

    @NotNull
    public final String getPartnerUrl() {
        return this.partnerUrl;
    }

    @NotNull
    public final String getPartnerUrlText() {
        return this.partnerUrlText;
    }

    public final int getPointsCost() {
        return this.pointsCost;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    public final int getTalabatSharePercentage() {
        return this.talabatSharePercentage;
    }

    @NotNull
    public final String getThumbnailURL() {
        return this.thumbnailURL;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.f61641id.hashCode() * 31) + this.customerId) * 31) + this.title.hashCode()) * 31) + this.brandIds.hashCode()) * 31) + Float.floatToIntBits(this.discountValue)) * 31) + this.discountType.hashCode()) * 31) + Float.floatToIntBits(this.maxDiscountCap)) * 31) + Float.floatToIntBits(this.minOrderValue)) * 31) + this.talabatSharePercentage) * 31) + this.pointsCost) * 31) + this.partnerUrl.hashCode()) * 31) + this.partnerUrlText.hashCode()) * 31) + this.thumbnailURL.hashCode()) * 31) + this.imageURL.hashCode()) * 31) + this.nfpCouponCode.hashCode()) * 31) + this.description.hashCode()) * 31) + this.tag.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f61641id;
        int i11 = this.customerId;
        String str2 = this.title;
        List<Integer> list = this.brandIds;
        float f11 = this.discountValue;
        DiscountType discountType2 = this.discountType;
        float f12 = this.maxDiscountCap;
        float f13 = this.minOrderValue;
        int i12 = this.talabatSharePercentage;
        int i13 = this.pointsCost;
        String str3 = this.partnerUrl;
        String str4 = this.partnerUrlText;
        String str5 = this.thumbnailURL;
        String str6 = this.imageURL;
        String str7 = this.nfpCouponCode;
        String str8 = this.description;
        String str9 = this.tag;
        return "VoucherDetailDomainModel(id=" + str + ", customerId=" + i11 + ", title=" + str2 + ", brandIds=" + list + ", discountValue=" + f11 + ", discountType=" + discountType2 + ", maxDiscountCap=" + f12 + ", minOrderValue=" + f13 + ", talabatSharePercentage=" + i12 + ", pointsCost=" + i13 + ", partnerUrl=" + str3 + ", partnerUrlText=" + str4 + ", thumbnailURL=" + str5 + ", imageURL=" + str6 + ", nfpCouponCode=" + str7 + ", description=" + str8 + ", tag=" + str9 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VoucherDetailDomainModel(java.lang.String r19, int r20, java.lang.String r21, java.util.List r22, float r23, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType r24, float r25, float r26, int r27, int r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
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
            kotlin.jvm.internal.IntCompanionObject r2 = kotlin.jvm.internal.IntCompanionObject.INSTANCE
            int r2 = com.talabat.talabatcommon.extentions.IntKt.orZero((kotlin.jvm.internal.IntCompanionObject) r2)
            goto L_0x001c
        L_0x001a:
            r2 = r20
        L_0x001c:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0027
            kotlin.jvm.internal.StringCompanionObject r3 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r3 = com.talabat.talabatcommon.extentions.StringUtils.empty(r3)
            goto L_0x0029
        L_0x0027:
            r3 = r21
        L_0x0029:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0032
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x0034
        L_0x0032:
            r4 = r22
        L_0x0034:
            r5 = r0 & 16
            r6 = 0
            if (r5 == 0) goto L_0x003b
            r5 = r6
            goto L_0x003d
        L_0x003b:
            r5 = r23
        L_0x003d:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0044
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType r7 = com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType.NONE
            goto L_0x0046
        L_0x0044:
            r7 = r24
        L_0x0046:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x004c
            r8 = r6
            goto L_0x004e
        L_0x004c:
            r8 = r25
        L_0x004e:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r6 = r26
        L_0x0055:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0060
            kotlin.jvm.internal.IntCompanionObject r9 = kotlin.jvm.internal.IntCompanionObject.INSTANCE
            int r9 = com.talabat.talabatcommon.extentions.IntKt.orZero((kotlin.jvm.internal.IntCompanionObject) r9)
            goto L_0x0062
        L_0x0060:
            r9 = r27
        L_0x0062:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x006d
            kotlin.jvm.internal.IntCompanionObject r10 = kotlin.jvm.internal.IntCompanionObject.INSTANCE
            int r10 = com.talabat.talabatcommon.extentions.IntKt.orZero((kotlin.jvm.internal.IntCompanionObject) r10)
            goto L_0x006f
        L_0x006d:
            r10 = r28
        L_0x006f:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x007a
            kotlin.jvm.internal.StringCompanionObject r11 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r11 = com.talabat.talabatcommon.extentions.StringUtils.empty(r11)
            goto L_0x007c
        L_0x007a:
            r11 = r29
        L_0x007c:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0087
            kotlin.jvm.internal.StringCompanionObject r12 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r12 = com.talabat.talabatcommon.extentions.StringUtils.empty(r12)
            goto L_0x0089
        L_0x0087:
            r12 = r30
        L_0x0089:
            r13 = r0 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x0094
            kotlin.jvm.internal.StringCompanionObject r13 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r13 = com.talabat.talabatcommon.extentions.StringUtils.empty(r13)
            goto L_0x0096
        L_0x0094:
            r13 = r31
        L_0x0096:
            r14 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x00a1
            kotlin.jvm.internal.StringCompanionObject r14 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r14 = com.talabat.talabatcommon.extentions.StringUtils.empty(r14)
            goto L_0x00a3
        L_0x00a1:
            r14 = r32
        L_0x00a3:
            r15 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r15 == 0) goto L_0x00ae
            kotlin.jvm.internal.StringCompanionObject r15 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r15 = com.talabat.talabatcommon.extentions.StringUtils.empty(r15)
            goto L_0x00b0
        L_0x00ae:
            r15 = r33
        L_0x00b0:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x00be
            kotlin.jvm.internal.StringCompanionObject r16 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r16 = com.talabat.talabatcommon.extentions.StringUtils.empty(r16)
            goto L_0x00c0
        L_0x00be:
            r16 = r34
        L_0x00c0:
            r17 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x00cd
            kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r0 = com.talabat.talabatcommon.extentions.StringUtils.empty(r0)
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
            r25 = r7
            r26 = r8
            r27 = r6
            r28 = r9
            r29 = r10
            r30 = r11
            r31 = r12
            r32 = r13
            r33 = r14
            r34 = r15
            r35 = r16
            r36 = r0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.VoucherDetailDomainModel.<init>(java.lang.String, int, java.lang.String, java.util.List, float, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType, float, float, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
