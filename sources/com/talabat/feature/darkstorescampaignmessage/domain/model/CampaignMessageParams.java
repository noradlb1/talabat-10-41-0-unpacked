package com.talabat.feature.darkstorescampaignmessage.domain.model;

import com.talabat.core.fwf.data.FunWithFlagsConstants;
import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003JV\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\fHÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011¨\u0006)"}, d2 = {"Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignMessageParams;", "", "subTotal", "", "subTotalAfterDiscount", "vendorCode", "", "latitude", "", "longitude", "globalEntityId", "chainId", "", "(FLjava/lang/Float;Ljava/lang/String;DDLjava/lang/String;I)V", "getChainId", "()I", "getGlobalEntityId", "()Ljava/lang/String;", "getLatitude", "()D", "getLongitude", "getSubTotal", "()F", "getSubTotalAfterDiscount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getVendorCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(FLjava/lang/Float;Ljava/lang/String;DDLjava/lang/String;I)Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignMessageParams;", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_darkstores-campaign-message_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignMessageParams {
    private final int chainId;
    @NotNull
    private final String globalEntityId;
    private final double latitude;
    private final double longitude;
    private final float subTotal;
    @Nullable
    private final Float subTotalAfterDiscount;
    @NotNull
    private final String vendorCode;

    public CampaignMessageParams(float f11, @Nullable Float f12, @NotNull String str, double d11, double d12, @NotNull String str2, int i11) {
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.VENDOR_CODE);
        Intrinsics.checkNotNullParameter(str2, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        this.subTotal = f11;
        this.subTotalAfterDiscount = f12;
        this.vendorCode = str;
        this.latitude = d11;
        this.longitude = d12;
        this.globalEntityId = str2;
        this.chainId = i11;
    }

    public static /* synthetic */ CampaignMessageParams copy$default(CampaignMessageParams campaignMessageParams, float f11, Float f12, String str, double d11, double d12, String str2, int i11, int i12, Object obj) {
        CampaignMessageParams campaignMessageParams2 = campaignMessageParams;
        return campaignMessageParams.copy((i12 & 1) != 0 ? campaignMessageParams2.subTotal : f11, (i12 & 2) != 0 ? campaignMessageParams2.subTotalAfterDiscount : f12, (i12 & 4) != 0 ? campaignMessageParams2.vendorCode : str, (i12 & 8) != 0 ? campaignMessageParams2.latitude : d11, (i12 & 16) != 0 ? campaignMessageParams2.longitude : d12, (i12 & 32) != 0 ? campaignMessageParams2.globalEntityId : str2, (i12 & 64) != 0 ? campaignMessageParams2.chainId : i11);
    }

    public final float component1() {
        return this.subTotal;
    }

    @Nullable
    public final Float component2() {
        return this.subTotalAfterDiscount;
    }

    @NotNull
    public final String component3() {
        return this.vendorCode;
    }

    public final double component4() {
        return this.latitude;
    }

    public final double component5() {
        return this.longitude;
    }

    @NotNull
    public final String component6() {
        return this.globalEntityId;
    }

    public final int component7() {
        return this.chainId;
    }

    @NotNull
    public final CampaignMessageParams copy(float f11, @Nullable Float f12, @NotNull String str, double d11, double d12, @NotNull String str2, int i11) {
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.VENDOR_CODE);
        String str3 = str2;
        Intrinsics.checkNotNullParameter(str3, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        return new CampaignMessageParams(f11, f12, str, d11, d12, str3, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CampaignMessageParams)) {
            return false;
        }
        CampaignMessageParams campaignMessageParams = (CampaignMessageParams) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.subTotal), (Object) Float.valueOf(campaignMessageParams.subTotal)) && Intrinsics.areEqual((Object) this.subTotalAfterDiscount, (Object) campaignMessageParams.subTotalAfterDiscount) && Intrinsics.areEqual((Object) this.vendorCode, (Object) campaignMessageParams.vendorCode) && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(campaignMessageParams.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(campaignMessageParams.longitude)) && Intrinsics.areEqual((Object) this.globalEntityId, (Object) campaignMessageParams.globalEntityId) && this.chainId == campaignMessageParams.chainId;
    }

    public final int getChainId() {
        return this.chainId;
    }

    @NotNull
    public final String getGlobalEntityId() {
        return this.globalEntityId;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final float getSubTotal() {
        return this.subTotal;
    }

    @Nullable
    public final Float getSubTotalAfterDiscount() {
        return this.subTotalAfterDiscount;
    }

    @NotNull
    public final String getVendorCode() {
        return this.vendorCode;
    }

    public int hashCode() {
        int floatToIntBits = Float.floatToIntBits(this.subTotal) * 31;
        Float f11 = this.subTotalAfterDiscount;
        return ((((((((((floatToIntBits + (f11 == null ? 0 : f11.hashCode())) * 31) + this.vendorCode.hashCode()) * 31) + Double.doubleToLongBits(this.latitude)) * 31) + Double.doubleToLongBits(this.longitude)) * 31) + this.globalEntityId.hashCode()) * 31) + this.chainId;
    }

    @NotNull
    public String toString() {
        float f11 = this.subTotal;
        Float f12 = this.subTotalAfterDiscount;
        String str = this.vendorCode;
        double d11 = this.latitude;
        double d12 = this.longitude;
        String str2 = this.globalEntityId;
        int i11 = this.chainId;
        return "CampaignMessageParams(subTotal=" + f11 + ", subTotalAfterDiscount=" + f12 + ", vendorCode=" + str + ", latitude=" + d11 + ", longitude=" + d12 + ", globalEntityId=" + str2 + ", chainId=" + i11 + ")";
    }
}
