package com.talabat.feature.darkstorescart.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonClass;
import com.talabat.feature.darkstorescart.data.model.Campaign;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\nHÆ\u0003J\t\u00107\u001a\u00020\fHÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010.J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0010HÆ\u0003Jj\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001¢\u0006\u0002\u0010<J\t\u0010=\u001a\u00020\u0007HÖ\u0001J\u0013\u0010>\u001a\u00020\u00102\b\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020\u0007HÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001J\u0019\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010\u0015R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006H"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;", "Landroid/os/Parcelable;", "id", "", "campaignType", "Lcom/talabat/feature/darkstorescart/data/model/Campaign$CampaignType;", "triggerQty", "", "benefitQty", "discountType", "Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;", "discountValue", "", "usageLimit", "campaignId", "isAutoAddable", "", "(Ljava/lang/String;Lcom/talabat/feature/darkstorescart/data/model/Campaign$CampaignType;IILcom/talabat/feature/darkstorescart/data/model/Campaign$Type;FLjava/lang/Integer;Ljava/lang/String;Z)V", "getBenefitQty", "()I", "setBenefitQty", "(I)V", "getCampaignId", "()Ljava/lang/String;", "setCampaignId", "(Ljava/lang/String;)V", "getCampaignType", "()Lcom/talabat/feature/darkstorescart/data/model/Campaign$CampaignType;", "setCampaignType", "(Lcom/talabat/feature/darkstorescart/data/model/Campaign$CampaignType;)V", "getDiscountType", "()Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;", "setDiscountType", "(Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;)V", "getDiscountValue", "()F", "setDiscountValue", "(F)V", "getId", "setId", "()Z", "setAutoAddable", "(Z)V", "getTriggerQty", "setTriggerQty", "getUsageLimit", "()Ljava/lang/Integer;", "setUsageLimit", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/talabat/feature/darkstorescart/data/model/Campaign$CampaignType;IILcom/talabat/feature/darkstorescart/data/model/Campaign$Type;FLjava/lang/Integer;Ljava/lang/String;Z)Lcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class CampaignTrigger implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<CampaignTrigger> CREATOR = new Creator();
    private int benefitQty;
    @NotNull
    private String campaignId;
    @NotNull
    private Campaign.CampaignType campaignType;
    @NotNull
    private Campaign.Type discountType;
    private float discountValue;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private String f58489id;
    private boolean isAutoAddable;
    private int triggerQty;
    @Nullable
    private Integer usageLimit;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CampaignTrigger> {
        @NotNull
        public final CampaignTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CampaignTrigger(parcel.readString(), Campaign.CampaignType.valueOf(parcel.readString()), parcel.readInt(), parcel.readInt(), Campaign.Type.valueOf(parcel.readString()), parcel.readFloat(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() != 0);
        }

        @NotNull
        public final CampaignTrigger[] newArray(int i11) {
            return new CampaignTrigger[i11];
        }
    }

    public CampaignTrigger() {
        this((String) null, (Campaign.CampaignType) null, 0, 0, (Campaign.Type) null, 0.0f, (Integer) null, (String) null, false, 511, (DefaultConstructorMarker) null);
    }

    public CampaignTrigger(@NotNull String str, @NotNull Campaign.CampaignType campaignType2, int i11, int i12, @NotNull Campaign.Type type, float f11, @Nullable Integer num, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(campaignType2, "campaignType");
        Intrinsics.checkNotNullParameter(type, "discountType");
        Intrinsics.checkNotNullParameter(str2, "campaignId");
        this.f58489id = str;
        this.campaignType = campaignType2;
        this.triggerQty = i11;
        this.benefitQty = i12;
        this.discountType = type;
        this.discountValue = f11;
        this.usageLimit = num;
        this.campaignId = str2;
        this.isAutoAddable = z11;
    }

    public static /* synthetic */ CampaignTrigger copy$default(CampaignTrigger campaignTrigger, String str, Campaign.CampaignType campaignType2, int i11, int i12, Campaign.Type type, float f11, Integer num, String str2, boolean z11, int i13, Object obj) {
        CampaignTrigger campaignTrigger2 = campaignTrigger;
        int i14 = i13;
        return campaignTrigger.copy((i14 & 1) != 0 ? campaignTrigger2.f58489id : str, (i14 & 2) != 0 ? campaignTrigger2.campaignType : campaignType2, (i14 & 4) != 0 ? campaignTrigger2.triggerQty : i11, (i14 & 8) != 0 ? campaignTrigger2.benefitQty : i12, (i14 & 16) != 0 ? campaignTrigger2.discountType : type, (i14 & 32) != 0 ? campaignTrigger2.discountValue : f11, (i14 & 64) != 0 ? campaignTrigger2.usageLimit : num, (i14 & 128) != 0 ? campaignTrigger2.campaignId : str2, (i14 & 256) != 0 ? campaignTrigger2.isAutoAddable : z11);
    }

    @NotNull
    public final String component1() {
        return this.f58489id;
    }

    @NotNull
    public final Campaign.CampaignType component2() {
        return this.campaignType;
    }

    public final int component3() {
        return this.triggerQty;
    }

    public final int component4() {
        return this.benefitQty;
    }

    @NotNull
    public final Campaign.Type component5() {
        return this.discountType;
    }

    public final float component6() {
        return this.discountValue;
    }

    @Nullable
    public final Integer component7() {
        return this.usageLimit;
    }

    @NotNull
    public final String component8() {
        return this.campaignId;
    }

    public final boolean component9() {
        return this.isAutoAddable;
    }

    @NotNull
    public final CampaignTrigger copy(@NotNull String str, @NotNull Campaign.CampaignType campaignType2, int i11, int i12, @NotNull Campaign.Type type, float f11, @Nullable Integer num, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(campaignType2, "campaignType");
        Campaign.Type type2 = type;
        Intrinsics.checkNotNullParameter(type2, "discountType");
        String str3 = str2;
        Intrinsics.checkNotNullParameter(str3, "campaignId");
        return new CampaignTrigger(str, campaignType2, i11, i12, type2, f11, num, str3, z11);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CampaignTrigger)) {
            return false;
        }
        CampaignTrigger campaignTrigger = (CampaignTrigger) obj;
        return Intrinsics.areEqual((Object) this.f58489id, (Object) campaignTrigger.f58489id) && this.campaignType == campaignTrigger.campaignType && this.triggerQty == campaignTrigger.triggerQty && this.benefitQty == campaignTrigger.benefitQty && this.discountType == campaignTrigger.discountType && Intrinsics.areEqual((Object) Float.valueOf(this.discountValue), (Object) Float.valueOf(campaignTrigger.discountValue)) && Intrinsics.areEqual((Object) this.usageLimit, (Object) campaignTrigger.usageLimit) && Intrinsics.areEqual((Object) this.campaignId, (Object) campaignTrigger.campaignId) && this.isAutoAddable == campaignTrigger.isAutoAddable;
    }

    public final int getBenefitQty() {
        return this.benefitQty;
    }

    @NotNull
    public final String getCampaignId() {
        return this.campaignId;
    }

    @NotNull
    public final Campaign.CampaignType getCampaignType() {
        return this.campaignType;
    }

    @NotNull
    public final Campaign.Type getDiscountType() {
        return this.discountType;
    }

    public final float getDiscountValue() {
        return this.discountValue;
    }

    @NotNull
    public final String getId() {
        return this.f58489id;
    }

    public final int getTriggerQty() {
        return this.triggerQty;
    }

    @Nullable
    public final Integer getUsageLimit() {
        return this.usageLimit;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.f58489id.hashCode() * 31) + this.campaignType.hashCode()) * 31) + this.triggerQty) * 31) + this.benefitQty) * 31) + this.discountType.hashCode()) * 31) + Float.floatToIntBits(this.discountValue)) * 31;
        Integer num = this.usageLimit;
        int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.campaignId.hashCode()) * 31;
        boolean z11 = this.isAutoAddable;
        if (z11) {
            z11 = true;
        }
        return hashCode2 + (z11 ? 1 : 0);
    }

    public final boolean isAutoAddable() {
        return this.isAutoAddable;
    }

    public final void setAutoAddable(boolean z11) {
        this.isAutoAddable = z11;
    }

    public final void setBenefitQty(int i11) {
        this.benefitQty = i11;
    }

    public final void setCampaignId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.campaignId = str;
    }

    public final void setCampaignType(@NotNull Campaign.CampaignType campaignType2) {
        Intrinsics.checkNotNullParameter(campaignType2, "<set-?>");
        this.campaignType = campaignType2;
    }

    public final void setDiscountType(@NotNull Campaign.Type type) {
        Intrinsics.checkNotNullParameter(type, "<set-?>");
        this.discountType = type;
    }

    public final void setDiscountValue(float f11) {
        this.discountValue = f11;
    }

    public final void setId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f58489id = str;
    }

    public final void setTriggerQty(int i11) {
        this.triggerQty = i11;
    }

    public final void setUsageLimit(@Nullable Integer num) {
        this.usageLimit = num;
    }

    @NotNull
    public String toString() {
        String str = this.f58489id;
        Campaign.CampaignType campaignType2 = this.campaignType;
        int i11 = this.triggerQty;
        int i12 = this.benefitQty;
        Campaign.Type type = this.discountType;
        float f11 = this.discountValue;
        Integer num = this.usageLimit;
        String str2 = this.campaignId;
        boolean z11 = this.isAutoAddable;
        return "CampaignTrigger(id=" + str + ", campaignType=" + campaignType2 + ", triggerQty=" + i11 + ", benefitQty=" + i12 + ", discountType=" + type + ", discountValue=" + f11 + ", usageLimit=" + num + ", campaignId=" + str2 + ", isAutoAddable=" + z11 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.f58489id);
        parcel.writeString(this.campaignType.name());
        parcel.writeInt(this.triggerQty);
        parcel.writeInt(this.benefitQty);
        parcel.writeString(this.discountType.name());
        parcel.writeFloat(this.discountValue);
        Integer num = this.usageLimit;
        if (num == null) {
            i12 = 0;
        } else {
            parcel.writeInt(1);
            i12 = num.intValue();
        }
        parcel.writeInt(i12);
        parcel.writeString(this.campaignId);
        parcel.writeInt(this.isAutoAddable ? 1 : 0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CampaignTrigger(java.lang.String r12, com.talabat.feature.darkstorescart.data.model.Campaign.CampaignType r13, int r14, int r15, com.talabat.feature.darkstorescart.data.model.Campaign.Type r16, float r17, java.lang.Integer r18, java.lang.String r19, boolean r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r11 = this;
            r0 = r21
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000b
        L_0x000a:
            r1 = r12
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            com.talabat.feature.darkstorescart.data.model.Campaign$CampaignType r3 = com.talabat.feature.darkstorescart.data.model.Campaign.CampaignType.SameItemBundle
            goto L_0x0013
        L_0x0012:
            r3 = r13
        L_0x0013:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x001a
            r4 = r5
            goto L_0x001b
        L_0x001a:
            r4 = r14
        L_0x001b:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0021
            r6 = 1
            goto L_0x0022
        L_0x0021:
            r6 = r15
        L_0x0022:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0029
            com.talabat.feature.darkstorescart.data.model.Campaign$Type r7 = com.talabat.feature.darkstorescart.data.model.Campaign.Type.PERCENTAGE
            goto L_0x002b
        L_0x0029:
            r7 = r16
        L_0x002b:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0031
            r8 = 0
            goto L_0x0033
        L_0x0031:
            r8 = r17
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0039
            r9 = 0
            goto L_0x003b
        L_0x0039:
            r9 = r18
        L_0x003b:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r2 = r19
        L_0x0042:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r5 = r20
        L_0x0049:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r2
            r21 = r5
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstorescart.data.model.CampaignTrigger.<init>(java.lang.String, com.talabat.feature.darkstorescart.data.model.Campaign$CampaignType, int, int, com.talabat.feature.darkstorescart.data.model.Campaign$Type, float, java.lang.Integer, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
