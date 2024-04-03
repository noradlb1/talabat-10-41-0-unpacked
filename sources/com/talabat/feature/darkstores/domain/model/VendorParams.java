package com.talabat.feature.darkstores.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/talabat/feature/darkstores/domain/model/VendorParams;", "", "chainId", "", "branchId", "vendorName", "", "vendorLogoImageUrl", "isDarkStore", "", "restaurantJson", "(IILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getBranchId", "()I", "getChainId", "()Z", "getRestaurantJson", "()Ljava/lang/String;", "getVendorLogoImageUrl", "getVendorName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "com_talabat_feature_darkstores_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorParams {
    private final int branchId;
    private final int chainId;
    private final boolean isDarkStore;
    @NotNull
    private final String restaurantJson;
    @NotNull
    private final String vendorLogoImageUrl;
    @NotNull
    private final String vendorName;

    public VendorParams(int i11, int i12, @NotNull String str, @NotNull String str2, boolean z11, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "vendorName");
        Intrinsics.checkNotNullParameter(str2, "vendorLogoImageUrl");
        Intrinsics.checkNotNullParameter(str3, "restaurantJson");
        this.chainId = i11;
        this.branchId = i12;
        this.vendorName = str;
        this.vendorLogoImageUrl = str2;
        this.isDarkStore = z11;
        this.restaurantJson = str3;
    }

    public static /* synthetic */ VendorParams copy$default(VendorParams vendorParams, int i11, int i12, String str, String str2, boolean z11, String str3, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = vendorParams.chainId;
        }
        if ((i13 & 2) != 0) {
            i12 = vendorParams.branchId;
        }
        int i14 = i12;
        if ((i13 & 4) != 0) {
            str = vendorParams.vendorName;
        }
        String str4 = str;
        if ((i13 & 8) != 0) {
            str2 = vendorParams.vendorLogoImageUrl;
        }
        String str5 = str2;
        if ((i13 & 16) != 0) {
            z11 = vendorParams.isDarkStore;
        }
        boolean z12 = z11;
        if ((i13 & 32) != 0) {
            str3 = vendorParams.restaurantJson;
        }
        return vendorParams.copy(i11, i14, str4, str5, z12, str3);
    }

    public final int component1() {
        return this.chainId;
    }

    public final int component2() {
        return this.branchId;
    }

    @NotNull
    public final String component3() {
        return this.vendorName;
    }

    @NotNull
    public final String component4() {
        return this.vendorLogoImageUrl;
    }

    public final boolean component5() {
        return this.isDarkStore;
    }

    @NotNull
    public final String component6() {
        return this.restaurantJson;
    }

    @NotNull
    public final VendorParams copy(int i11, int i12, @NotNull String str, @NotNull String str2, boolean z11, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "vendorName");
        Intrinsics.checkNotNullParameter(str2, "vendorLogoImageUrl");
        Intrinsics.checkNotNullParameter(str3, "restaurantJson");
        return new VendorParams(i11, i12, str, str2, z11, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorParams)) {
            return false;
        }
        VendorParams vendorParams = (VendorParams) obj;
        return this.chainId == vendorParams.chainId && this.branchId == vendorParams.branchId && Intrinsics.areEqual((Object) this.vendorName, (Object) vendorParams.vendorName) && Intrinsics.areEqual((Object) this.vendorLogoImageUrl, (Object) vendorParams.vendorLogoImageUrl) && this.isDarkStore == vendorParams.isDarkStore && Intrinsics.areEqual((Object) this.restaurantJson, (Object) vendorParams.restaurantJson);
    }

    public final int getBranchId() {
        return this.branchId;
    }

    public final int getChainId() {
        return this.chainId;
    }

    @NotNull
    public final String getRestaurantJson() {
        return this.restaurantJson;
    }

    @NotNull
    public final String getVendorLogoImageUrl() {
        return this.vendorLogoImageUrl;
    }

    @NotNull
    public final String getVendorName() {
        return this.vendorName;
    }

    public int hashCode() {
        int hashCode = ((((((this.chainId * 31) + this.branchId) * 31) + this.vendorName.hashCode()) * 31) + this.vendorLogoImageUrl.hashCode()) * 31;
        boolean z11 = this.isDarkStore;
        if (z11) {
            z11 = true;
        }
        return ((hashCode + (z11 ? 1 : 0)) * 31) + this.restaurantJson.hashCode();
    }

    public final boolean isDarkStore() {
        return this.isDarkStore;
    }

    @NotNull
    public String toString() {
        int i11 = this.chainId;
        int i12 = this.branchId;
        String str = this.vendorName;
        String str2 = this.vendorLogoImageUrl;
        boolean z11 = this.isDarkStore;
        String str3 = this.restaurantJson;
        return "VendorParams(chainId=" + i11 + ", branchId=" + i12 + ", vendorName=" + str + ", vendorLogoImageUrl=" + str2 + ", isDarkStore=" + z11 + ", restaurantJson=" + str3 + ")";
    }
}
