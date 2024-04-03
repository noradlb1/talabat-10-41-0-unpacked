package com.talabat.feature.darkstorescart.data.model;

import com.serjltt.moshi.adapters.FallbackEnum;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b,\b\b\u0018\u00002\u00020\u0001:\u0002@AB\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0003\u0010\f\u001a\u00020\r\u0012\u0010\b\u0001\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u0010\b\u0001\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u00101\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010$J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010)J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\nHÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\t\u00108\u001a\u00020\rHÆ\u0003J\u0011\u00109\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\u0001\u0010:\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\u00072\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0003\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0010\b\u0003\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020\u00162\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u0014HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010%\u001a\u0004\b\u0015\u0010$R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,¨\u0006B"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "", "globalId", "", "name", "description", "totalTriggerThreshold", "", "appliesTo", "discountType", "Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;", "discountValue", "campaignType", "Lcom/talabat/feature/darkstorescart/data/model/Campaign$CampaignType;", "productTriggers", "", "Lcom/talabat/feature/darkstorescart/data/model/ProductTrigger;", "benefits", "Lcom/talabat/feature/darkstorescart/data/model/Benefit;", "usageLimit", "", "isAutoAddable", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;FLcom/talabat/feature/darkstorescart/data/model/Campaign$CampaignType;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getAppliesTo", "()Ljava/lang/String;", "getBenefits", "()Ljava/util/List;", "getCampaignType", "()Lcom/talabat/feature/darkstorescart/data/model/Campaign$CampaignType;", "getDescription", "getDiscountType", "()Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;", "getDiscountValue", "()F", "getGlobalId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "getProductTriggers", "getTotalTriggerThreshold", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getUsageLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;FLcom/talabat/feature/darkstorescart/data/model/Campaign$CampaignType;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "equals", "other", "hashCode", "toString", "CampaignType", "Type", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Campaign {
    @NotNull
    private final String appliesTo;
    @Nullable
    private final List<Benefit> benefits;
    @NotNull
    private final CampaignType campaignType;
    @NotNull
    private final String description;
    @NotNull
    private final Type discountType;
    private final float discountValue;
    @NotNull
    private final String globalId;
    @Nullable
    private final Boolean isAutoAddable;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58488name;
    @Nullable
    private final List<ProductTrigger> productTriggers;
    @Nullable
    private final Float totalTriggerThreshold;
    @Nullable
    private final Integer usageLimit;

    @JsonClass(generateAdapter = false)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/Campaign$CampaignType;", "", "(Ljava/lang/String;I)V", "MixAndMatch", "SameItemBundle", "Strikethrough", "Generic", "BasketValue", "Else", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @FallbackEnum(name = "Else")
    public enum CampaignType {
        MixAndMatch,
        SameItemBundle,
        Strikethrough,
        Generic,
        BasketValue,
        Else
    }

    @JsonClass(generateAdapter = false)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;", "", "(Ljava/lang/String;I)V", "PERCENTAGE", "ABSOLUTE", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Type {
        PERCENTAGE,
        ABSOLUTE
    }

    public Campaign(@NotNull @Json(name = "global_id") String str, @NotNull @Json(name = "name") String str2, @NotNull @Json(name = "description") String str3, @Nullable @Json(name = "total_trigger_threshold") Float f11, @NotNull @Json(name = "campaign_applies_to") String str4, @NotNull @Json(name = "discount_type") Type type, @Json(name = "discount_value") float f12, @NotNull @Json(name = "campaign_type") CampaignType campaignType2, @Nullable @Json(name = "product_triggers") List<ProductTrigger> list, @Nullable @Json(name = "benefits") List<Benefit> list2, @Nullable @Json(name = "cart_item_usage_limit") Integer num, @Nullable @Json(name = "campaign_is_auto_addable") Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "globalId");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "appliesTo");
        Intrinsics.checkNotNullParameter(type, "discountType");
        Intrinsics.checkNotNullParameter(campaignType2, "campaignType");
        this.globalId = str;
        this.f58488name = str2;
        this.description = str3;
        this.totalTriggerThreshold = f11;
        this.appliesTo = str4;
        this.discountType = type;
        this.discountValue = f12;
        this.campaignType = campaignType2;
        this.productTriggers = list;
        this.benefits = list2;
        this.usageLimit = num;
        this.isAutoAddable = bool;
    }

    public static /* synthetic */ Campaign copy$default(Campaign campaign, String str, String str2, String str3, Float f11, String str4, Type type, float f12, CampaignType campaignType2, List list, List list2, Integer num, Boolean bool, int i11, Object obj) {
        Campaign campaign2 = campaign;
        int i12 = i11;
        return campaign.copy((i12 & 1) != 0 ? campaign2.globalId : str, (i12 & 2) != 0 ? campaign2.f58488name : str2, (i12 & 4) != 0 ? campaign2.description : str3, (i12 & 8) != 0 ? campaign2.totalTriggerThreshold : f11, (i12 & 16) != 0 ? campaign2.appliesTo : str4, (i12 & 32) != 0 ? campaign2.discountType : type, (i12 & 64) != 0 ? campaign2.discountValue : f12, (i12 & 128) != 0 ? campaign2.campaignType : campaignType2, (i12 & 256) != 0 ? campaign2.productTriggers : list, (i12 & 512) != 0 ? campaign2.benefits : list2, (i12 & 1024) != 0 ? campaign2.usageLimit : num, (i12 & 2048) != 0 ? campaign2.isAutoAddable : bool);
    }

    @NotNull
    public final String component1() {
        return this.globalId;
    }

    @Nullable
    public final List<Benefit> component10() {
        return this.benefits;
    }

    @Nullable
    public final Integer component11() {
        return this.usageLimit;
    }

    @Nullable
    public final Boolean component12() {
        return this.isAutoAddable;
    }

    @NotNull
    public final String component2() {
        return this.f58488name;
    }

    @NotNull
    public final String component3() {
        return this.description;
    }

    @Nullable
    public final Float component4() {
        return this.totalTriggerThreshold;
    }

    @NotNull
    public final String component5() {
        return this.appliesTo;
    }

    @NotNull
    public final Type component6() {
        return this.discountType;
    }

    public final float component7() {
        return this.discountValue;
    }

    @NotNull
    public final CampaignType component8() {
        return this.campaignType;
    }

    @Nullable
    public final List<ProductTrigger> component9() {
        return this.productTriggers;
    }

    @NotNull
    public final Campaign copy(@NotNull @Json(name = "global_id") String str, @NotNull @Json(name = "name") String str2, @NotNull @Json(name = "description") String str3, @Nullable @Json(name = "total_trigger_threshold") Float f11, @NotNull @Json(name = "campaign_applies_to") String str4, @NotNull @Json(name = "discount_type") Type type, @Json(name = "discount_value") float f12, @NotNull @Json(name = "campaign_type") CampaignType campaignType2, @Nullable @Json(name = "product_triggers") List<ProductTrigger> list, @Nullable @Json(name = "benefits") List<Benefit> list2, @Nullable @Json(name = "cart_item_usage_limit") Integer num, @Nullable @Json(name = "campaign_is_auto_addable") Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "globalId");
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str5, "name");
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str6, "description");
        String str7 = str4;
        Intrinsics.checkNotNullParameter(str7, "appliesTo");
        Type type2 = type;
        Intrinsics.checkNotNullParameter(type2, "discountType");
        CampaignType campaignType3 = campaignType2;
        Intrinsics.checkNotNullParameter(campaignType3, "campaignType");
        return new Campaign(str, str5, str6, f11, str7, type2, f12, campaignType3, list, list2, num, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Campaign)) {
            return false;
        }
        Campaign campaign = (Campaign) obj;
        return Intrinsics.areEqual((Object) this.globalId, (Object) campaign.globalId) && Intrinsics.areEqual((Object) this.f58488name, (Object) campaign.f58488name) && Intrinsics.areEqual((Object) this.description, (Object) campaign.description) && Intrinsics.areEqual((Object) this.totalTriggerThreshold, (Object) campaign.totalTriggerThreshold) && Intrinsics.areEqual((Object) this.appliesTo, (Object) campaign.appliesTo) && this.discountType == campaign.discountType && Intrinsics.areEqual((Object) Float.valueOf(this.discountValue), (Object) Float.valueOf(campaign.discountValue)) && this.campaignType == campaign.campaignType && Intrinsics.areEqual((Object) this.productTriggers, (Object) campaign.productTriggers) && Intrinsics.areEqual((Object) this.benefits, (Object) campaign.benefits) && Intrinsics.areEqual((Object) this.usageLimit, (Object) campaign.usageLimit) && Intrinsics.areEqual((Object) this.isAutoAddable, (Object) campaign.isAutoAddable);
    }

    @NotNull
    public final String getAppliesTo() {
        return this.appliesTo;
    }

    @Nullable
    public final List<Benefit> getBenefits() {
        return this.benefits;
    }

    @NotNull
    public final CampaignType getCampaignType() {
        return this.campaignType;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final Type getDiscountType() {
        return this.discountType;
    }

    public final float getDiscountValue() {
        return this.discountValue;
    }

    @NotNull
    public final String getGlobalId() {
        return this.globalId;
    }

    @NotNull
    public final String getName() {
        return this.f58488name;
    }

    @Nullable
    public final List<ProductTrigger> getProductTriggers() {
        return this.productTriggers;
    }

    @Nullable
    public final Float getTotalTriggerThreshold() {
        return this.totalTriggerThreshold;
    }

    @Nullable
    public final Integer getUsageLimit() {
        return this.usageLimit;
    }

    public int hashCode() {
        int hashCode = ((((this.globalId.hashCode() * 31) + this.f58488name.hashCode()) * 31) + this.description.hashCode()) * 31;
        Float f11 = this.totalTriggerThreshold;
        int i11 = 0;
        int hashCode2 = (((((((((hashCode + (f11 == null ? 0 : f11.hashCode())) * 31) + this.appliesTo.hashCode()) * 31) + this.discountType.hashCode()) * 31) + Float.floatToIntBits(this.discountValue)) * 31) + this.campaignType.hashCode()) * 31;
        List<ProductTrigger> list = this.productTriggers;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<Benefit> list2 = this.benefits;
        int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num = this.usageLimit;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.isAutoAddable;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode5 + i11;
    }

    @Nullable
    public final Boolean isAutoAddable() {
        return this.isAutoAddable;
    }

    @NotNull
    public String toString() {
        String str = this.globalId;
        String str2 = this.f58488name;
        String str3 = this.description;
        Float f11 = this.totalTriggerThreshold;
        String str4 = this.appliesTo;
        Type type = this.discountType;
        float f12 = this.discountValue;
        CampaignType campaignType2 = this.campaignType;
        List<ProductTrigger> list = this.productTriggers;
        List<Benefit> list2 = this.benefits;
        Integer num = this.usageLimit;
        Boolean bool = this.isAutoAddable;
        return "Campaign(globalId=" + str + ", name=" + str2 + ", description=" + str3 + ", totalTriggerThreshold=" + f11 + ", appliesTo=" + str4 + ", discountType=" + type + ", discountValue=" + f12 + ", campaignType=" + campaignType2 + ", productTriggers=" + list + ", benefits=" + list2 + ", usageLimit=" + num + ", isAutoAddable=" + bool + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Campaign(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.Float r19, java.lang.String r20, com.talabat.feature.darkstorescart.data.model.Campaign.Type r21, float r22, com.talabat.feature.darkstorescart.data.model.Campaign.CampaignType r23, java.util.List r24, java.util.List r25, java.lang.Integer r26, java.lang.Boolean r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r15 = this;
            r0 = r28
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x000a
            com.talabat.feature.darkstorescart.data.model.Campaign$CampaignType r1 = com.talabat.feature.darkstorescart.data.model.Campaign.CampaignType.Else
            r10 = r1
            goto L_0x000c
        L_0x000a:
            r10 = r23
        L_0x000c:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            r2 = 0
            if (r1 == 0) goto L_0x0013
            r13 = r2
            goto L_0x0015
        L_0x0013:
            r13 = r26
        L_0x0015:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x001b
            r14 = r2
            goto L_0x001d
        L_0x001b:
            r14 = r27
        L_0x001d:
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r11 = r24
            r12 = r25
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstorescart.data.model.Campaign.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Float, java.lang.String, com.talabat.feature.darkstorescart.data.model.Campaign$Type, float, com.talabat.feature.darkstorescart.data.model.Campaign$CampaignType, java.util.List, java.util.List, java.lang.Integer, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
