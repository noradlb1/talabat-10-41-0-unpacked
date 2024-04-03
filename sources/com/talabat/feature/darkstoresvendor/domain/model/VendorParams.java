package com.talabat.feature.darkstoresvendor.domain.model;

import com.talabat.core.fwf.data.FunWithFlagsConstants;
import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/domain/model/VendorParams;", "", "vendorCode", "", "globalEntityId", "latitude", "", "longitude", "customerId", "(Ljava/lang/String;Ljava/lang/String;DDLjava/lang/String;)V", "getCustomerId", "()Ljava/lang/String;", "getGlobalEntityId", "getLatitude", "()D", "getLongitude", "getVendorCode", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorParams {
    @NotNull
    private final String customerId;
    @NotNull
    private final String globalEntityId;
    private final double latitude;
    private final double longitude;
    @NotNull
    private final String vendorCode;

    public VendorParams(@NotNull String str, @NotNull String str2, double d11, double d12, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.VENDOR_CODE);
        Intrinsics.checkNotNullParameter(str2, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        Intrinsics.checkNotNullParameter(str3, "customerId");
        this.vendorCode = str;
        this.globalEntityId = str2;
        this.latitude = d11;
        this.longitude = d12;
        this.customerId = str3;
    }

    public static /* synthetic */ VendorParams copy$default(VendorParams vendorParams, String str, String str2, double d11, double d12, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = vendorParams.vendorCode;
        }
        if ((i11 & 2) != 0) {
            str2 = vendorParams.globalEntityId;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            d11 = vendorParams.latitude;
        }
        double d13 = d11;
        if ((i11 & 8) != 0) {
            d12 = vendorParams.longitude;
        }
        double d14 = d12;
        if ((i11 & 16) != 0) {
            str3 = vendorParams.customerId;
        }
        return vendorParams.copy(str, str4, d13, d14, str3);
    }

    @NotNull
    public final String component1() {
        return this.vendorCode;
    }

    @NotNull
    public final String component2() {
        return this.globalEntityId;
    }

    public final double component3() {
        return this.latitude;
    }

    public final double component4() {
        return this.longitude;
    }

    @NotNull
    public final String component5() {
        return this.customerId;
    }

    @NotNull
    public final VendorParams copy(@NotNull String str, @NotNull String str2, double d11, double d12, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.VENDOR_CODE);
        Intrinsics.checkNotNullParameter(str2, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        String str4 = str3;
        Intrinsics.checkNotNullParameter(str4, "customerId");
        return new VendorParams(str, str2, d11, d12, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorParams)) {
            return false;
        }
        VendorParams vendorParams = (VendorParams) obj;
        return Intrinsics.areEqual((Object) this.vendorCode, (Object) vendorParams.vendorCode) && Intrinsics.areEqual((Object) this.globalEntityId, (Object) vendorParams.globalEntityId) && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(vendorParams.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(vendorParams.longitude)) && Intrinsics.areEqual((Object) this.customerId, (Object) vendorParams.customerId);
    }

    @NotNull
    public final String getCustomerId() {
        return this.customerId;
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

    @NotNull
    public final String getVendorCode() {
        return this.vendorCode;
    }

    public int hashCode() {
        return (((((((this.vendorCode.hashCode() * 31) + this.globalEntityId.hashCode()) * 31) + Double.doubleToLongBits(this.latitude)) * 31) + Double.doubleToLongBits(this.longitude)) * 31) + this.customerId.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.vendorCode;
        String str2 = this.globalEntityId;
        double d11 = this.latitude;
        double d12 = this.longitude;
        String str3 = this.customerId;
        return "VendorParams(vendorCode=" + str + ", globalEntityId=" + str2 + ", latitude=" + d11 + ", longitude=" + d12 + ", customerId=" + str3 + ")";
    }
}
