package com.talabat.feature.pharmacy.model;

import androidx.autofill.HintConstants;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u001cJ\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/talabat/feature/pharmacy/model/Vendor;", "Ljava/io/Serializable;", "chainId", "", "chainName", "vendorAddress", "phoneNumber", "logUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChainId", "()Ljava/lang/String;", "getChainName", "getLogUrl", "getPhoneNumber", "getVendorAddress", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toMap", "", "toString", "com_talabat_feature_pharmacy_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Vendor implements Serializable {
    @NotNull
    private final String chainId;
    @NotNull
    private final String chainName;
    @NotNull
    private final String logUrl;
    @NotNull
    private final String phoneNumber;
    @Nullable
    private final String vendorAddress;

    public Vendor(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "chainId");
        Intrinsics.checkNotNullParameter(str2, "chainName");
        Intrinsics.checkNotNullParameter(str4, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        Intrinsics.checkNotNullParameter(str5, "logUrl");
        this.chainId = str;
        this.chainName = str2;
        this.vendorAddress = str3;
        this.phoneNumber = str4;
        this.logUrl = str5;
    }

    public static /* synthetic */ Vendor copy$default(Vendor vendor, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = vendor.chainId;
        }
        if ((i11 & 2) != 0) {
            str2 = vendor.chainName;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = vendor.vendorAddress;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = vendor.phoneNumber;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = vendor.logUrl;
        }
        return vendor.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    public final String component1() {
        return this.chainId;
    }

    @NotNull
    public final String component2() {
        return this.chainName;
    }

    @Nullable
    public final String component3() {
        return this.vendorAddress;
    }

    @NotNull
    public final String component4() {
        return this.phoneNumber;
    }

    @NotNull
    public final String component5() {
        return this.logUrl;
    }

    @NotNull
    public final Vendor copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "chainId");
        Intrinsics.checkNotNullParameter(str2, "chainName");
        Intrinsics.checkNotNullParameter(str4, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        Intrinsics.checkNotNullParameter(str5, "logUrl");
        return new Vendor(str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vendor)) {
            return false;
        }
        Vendor vendor = (Vendor) obj;
        return Intrinsics.areEqual((Object) this.chainId, (Object) vendor.chainId) && Intrinsics.areEqual((Object) this.chainName, (Object) vendor.chainName) && Intrinsics.areEqual((Object) this.vendorAddress, (Object) vendor.vendorAddress) && Intrinsics.areEqual((Object) this.phoneNumber, (Object) vendor.phoneNumber) && Intrinsics.areEqual((Object) this.logUrl, (Object) vendor.logUrl);
    }

    @NotNull
    public final String getChainId() {
        return this.chainId;
    }

    @NotNull
    public final String getChainName() {
        return this.chainName;
    }

    @NotNull
    public final String getLogUrl() {
        return this.logUrl;
    }

    @NotNull
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Nullable
    public final String getVendorAddress() {
        return this.vendorAddress;
    }

    public int hashCode() {
        int hashCode = ((this.chainId.hashCode() * 31) + this.chainName.hashCode()) * 31;
        String str = this.vendorAddress;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.phoneNumber.hashCode()) * 31) + this.logUrl.hashCode();
    }

    @NotNull
    public final Map<String, Object> toMap() {
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("chain_id", this.chainId);
        pairArr[1] = TuplesKt.to("chain_name", this.chainName);
        String str = this.vendorAddress;
        if (str == null) {
            str = "";
        }
        pairArr[2] = TuplesKt.to("vendor_address", str);
        pairArr[3] = TuplesKt.to("phone_number", this.phoneNumber);
        pairArr[4] = TuplesKt.to("logo_url", this.logUrl);
        return MapsKt__MapsKt.mapOf(pairArr);
    }

    @NotNull
    public String toString() {
        String str = this.chainId;
        String str2 = this.chainName;
        String str3 = this.vendorAddress;
        String str4 = this.phoneNumber;
        String str5 = this.logUrl;
        return "Vendor(chainId=" + str + ", chainName=" + str2 + ", vendorAddress=" + str3 + ", phoneNumber=" + str4 + ", logUrl=" + str5 + ")";
    }
}
