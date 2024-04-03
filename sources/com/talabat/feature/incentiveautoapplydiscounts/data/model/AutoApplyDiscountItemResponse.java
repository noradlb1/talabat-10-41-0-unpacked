package com.talabat.feature.incentiveautoapplydiscounts.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003Jz\u0010$\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\tHÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0004\u0010\u0018R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0002\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006+"}, d2 = {"Lcom/talabat/feature/incentiveautoapplydiscounts/data/model/AutoApplyDiscountItemResponse;", "", "isSelected", "", "isAvailable", "discountPercentage", "", "enforceMinOrderAmount", "campaignId", "", "discount", "conditionAmount", "discriminator", "marketingTitle", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;)V", "getCampaignId", "()Ljava/lang/String;", "getConditionAmount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getDiscount", "getDiscountPercentage", "getDiscriminator", "getEnforceMinOrderAmount", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMarketingTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/feature/incentiveautoapplydiscounts/data/model/AutoApplyDiscountItemResponse;", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_incentive-auto-apply-discounts_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AutoApplyDiscountItemResponse {
    @Nullable
    private final String campaignId;
    @Nullable
    private final Float conditionAmount;
    @Nullable
    private final Float discount;
    @Nullable
    private final Float discountPercentage;
    @Nullable
    private final String discriminator;
    @Nullable
    private final Boolean enforceMinOrderAmount;
    @Nullable
    private final Boolean isAvailable;
    @Nullable
    private final Boolean isSelected;
    @Nullable
    private final String marketingTitle;

    public AutoApplyDiscountItemResponse() {
        this((Boolean) null, (Boolean) null, (Float) null, (Boolean) null, (String) null, (Float) null, (Float) null, (String) null, (String) null, 511, (DefaultConstructorMarker) null);
    }

    public AutoApplyDiscountItemResponse(@Nullable @Json(name = "isSelected") Boolean bool, @Nullable @Json(name = "isAvailable") Boolean bool2, @Nullable @Json(name = "discountPercentage") Float f11, @Nullable @Json(name = "enforceMinOrderAmount") Boolean bool3, @Nullable @Json(name = "campaign_id") String str, @Nullable @Json(name = "discount") Float f12, @Nullable @Json(name = "conditionAmount") Float f13, @Nullable @Json(name = "discriminator") String str2, @Nullable @Json(name = "marketingTitle") String str3) {
        this.isSelected = bool;
        this.isAvailable = bool2;
        this.discountPercentage = f11;
        this.enforceMinOrderAmount = bool3;
        this.campaignId = str;
        this.discount = f12;
        this.conditionAmount = f13;
        this.discriminator = str2;
        this.marketingTitle = str3;
    }

    public static /* synthetic */ AutoApplyDiscountItemResponse copy$default(AutoApplyDiscountItemResponse autoApplyDiscountItemResponse, Boolean bool, Boolean bool2, Float f11, Boolean bool3, String str, Float f12, Float f13, String str2, String str3, int i11, Object obj) {
        AutoApplyDiscountItemResponse autoApplyDiscountItemResponse2 = autoApplyDiscountItemResponse;
        int i12 = i11;
        return autoApplyDiscountItemResponse.copy((i12 & 1) != 0 ? autoApplyDiscountItemResponse2.isSelected : bool, (i12 & 2) != 0 ? autoApplyDiscountItemResponse2.isAvailable : bool2, (i12 & 4) != 0 ? autoApplyDiscountItemResponse2.discountPercentage : f11, (i12 & 8) != 0 ? autoApplyDiscountItemResponse2.enforceMinOrderAmount : bool3, (i12 & 16) != 0 ? autoApplyDiscountItemResponse2.campaignId : str, (i12 & 32) != 0 ? autoApplyDiscountItemResponse2.discount : f12, (i12 & 64) != 0 ? autoApplyDiscountItemResponse2.conditionAmount : f13, (i12 & 128) != 0 ? autoApplyDiscountItemResponse2.discriminator : str2, (i12 & 256) != 0 ? autoApplyDiscountItemResponse2.marketingTitle : str3);
    }

    @Nullable
    public final Boolean component1() {
        return this.isSelected;
    }

    @Nullable
    public final Boolean component2() {
        return this.isAvailable;
    }

    @Nullable
    public final Float component3() {
        return this.discountPercentage;
    }

    @Nullable
    public final Boolean component4() {
        return this.enforceMinOrderAmount;
    }

    @Nullable
    public final String component5() {
        return this.campaignId;
    }

    @Nullable
    public final Float component6() {
        return this.discount;
    }

    @Nullable
    public final Float component7() {
        return this.conditionAmount;
    }

    @Nullable
    public final String component8() {
        return this.discriminator;
    }

    @Nullable
    public final String component9() {
        return this.marketingTitle;
    }

    @NotNull
    public final AutoApplyDiscountItemResponse copy(@Nullable @Json(name = "isSelected") Boolean bool, @Nullable @Json(name = "isAvailable") Boolean bool2, @Nullable @Json(name = "discountPercentage") Float f11, @Nullable @Json(name = "enforceMinOrderAmount") Boolean bool3, @Nullable @Json(name = "campaign_id") String str, @Nullable @Json(name = "discount") Float f12, @Nullable @Json(name = "conditionAmount") Float f13, @Nullable @Json(name = "discriminator") String str2, @Nullable @Json(name = "marketingTitle") String str3) {
        return new AutoApplyDiscountItemResponse(bool, bool2, f11, bool3, str, f12, f13, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutoApplyDiscountItemResponse)) {
            return false;
        }
        AutoApplyDiscountItemResponse autoApplyDiscountItemResponse = (AutoApplyDiscountItemResponse) obj;
        return Intrinsics.areEqual((Object) this.isSelected, (Object) autoApplyDiscountItemResponse.isSelected) && Intrinsics.areEqual((Object) this.isAvailable, (Object) autoApplyDiscountItemResponse.isAvailable) && Intrinsics.areEqual((Object) this.discountPercentage, (Object) autoApplyDiscountItemResponse.discountPercentage) && Intrinsics.areEqual((Object) this.enforceMinOrderAmount, (Object) autoApplyDiscountItemResponse.enforceMinOrderAmount) && Intrinsics.areEqual((Object) this.campaignId, (Object) autoApplyDiscountItemResponse.campaignId) && Intrinsics.areEqual((Object) this.discount, (Object) autoApplyDiscountItemResponse.discount) && Intrinsics.areEqual((Object) this.conditionAmount, (Object) autoApplyDiscountItemResponse.conditionAmount) && Intrinsics.areEqual((Object) this.discriminator, (Object) autoApplyDiscountItemResponse.discriminator) && Intrinsics.areEqual((Object) this.marketingTitle, (Object) autoApplyDiscountItemResponse.marketingTitle);
    }

    @Nullable
    public final String getCampaignId() {
        return this.campaignId;
    }

    @Nullable
    public final Float getConditionAmount() {
        return this.conditionAmount;
    }

    @Nullable
    public final Float getDiscount() {
        return this.discount;
    }

    @Nullable
    public final Float getDiscountPercentage() {
        return this.discountPercentage;
    }

    @Nullable
    public final String getDiscriminator() {
        return this.discriminator;
    }

    @Nullable
    public final Boolean getEnforceMinOrderAmount() {
        return this.enforceMinOrderAmount;
    }

    @Nullable
    public final String getMarketingTitle() {
        return this.marketingTitle;
    }

    public int hashCode() {
        Boolean bool = this.isSelected;
        int i11 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.isAvailable;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Float f11 = this.discountPercentage;
        int hashCode3 = (hashCode2 + (f11 == null ? 0 : f11.hashCode())) * 31;
        Boolean bool3 = this.enforceMinOrderAmount;
        int hashCode4 = (hashCode3 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str = this.campaignId;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        Float f12 = this.discount;
        int hashCode6 = (hashCode5 + (f12 == null ? 0 : f12.hashCode())) * 31;
        Float f13 = this.conditionAmount;
        int hashCode7 = (hashCode6 + (f13 == null ? 0 : f13.hashCode())) * 31;
        String str2 = this.discriminator;
        int hashCode8 = (hashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.marketingTitle;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode8 + i11;
    }

    @Nullable
    public final Boolean isAvailable() {
        return this.isAvailable;
    }

    @Nullable
    public final Boolean isSelected() {
        return this.isSelected;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.isSelected;
        Boolean bool2 = this.isAvailable;
        Float f11 = this.discountPercentage;
        Boolean bool3 = this.enforceMinOrderAmount;
        String str = this.campaignId;
        Float f12 = this.discount;
        Float f13 = this.conditionAmount;
        String str2 = this.discriminator;
        String str3 = this.marketingTitle;
        return "AutoApplyDiscountItemResponse(isSelected=" + bool + ", isAvailable=" + bool2 + ", discountPercentage=" + f11 + ", enforceMinOrderAmount=" + bool3 + ", campaignId=" + str + ", discount=" + f12 + ", conditionAmount=" + f13 + ", discriminator=" + str2 + ", marketingTitle=" + str3 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AutoApplyDiscountItemResponse(java.lang.Boolean r11, java.lang.Boolean r12, java.lang.Float r13, java.lang.Boolean r14, java.lang.String r15, java.lang.Float r16, java.lang.Float r17, java.lang.String r18, java.lang.String r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r14
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r15
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0034
            r8 = r2
            goto L_0x0036
        L_0x0034:
            r8 = r17
        L_0x0036:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003c
            r9 = r2
            goto L_0x003e
        L_0x003c:
            r9 = r18
        L_0x003e:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r2 = r19
        L_0x0045:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.incentiveautoapplydiscounts.data.model.AutoApplyDiscountItemResponse.<init>(java.lang.Boolean, java.lang.Boolean, java.lang.Float, java.lang.Boolean, java.lang.String, java.lang.Float, java.lang.Float, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
