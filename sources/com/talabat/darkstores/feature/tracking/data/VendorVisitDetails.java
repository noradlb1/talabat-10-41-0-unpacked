package com.talabat.darkstores.feature.tracking.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/data/VendorVisitDetails;", "", "chainId", "", "chainName", "", "branchId", "branchName", "verticalType", "isDarkstore", "", "(ILjava/lang/String;ILjava/lang/String;IZ)V", "getBranchId", "()I", "getBranchName", "()Ljava/lang/String;", "getChainId", "getChainName", "()Z", "getVerticalType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorVisitDetails {
    private final int branchId;
    @NotNull
    private final String branchName;
    private final int chainId;
    @NotNull
    private final String chainName;
    private final boolean isDarkstore;
    private final int verticalType;

    public VendorVisitDetails(int i11, @NotNull String str, int i12, @NotNull String str2, int i13, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "chainName");
        Intrinsics.checkNotNullParameter(str2, "branchName");
        this.chainId = i11;
        this.chainName = str;
        this.branchId = i12;
        this.branchName = str2;
        this.verticalType = i13;
        this.isDarkstore = z11;
    }

    public static /* synthetic */ VendorVisitDetails copy$default(VendorVisitDetails vendorVisitDetails, int i11, String str, int i12, String str2, int i13, boolean z11, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i11 = vendorVisitDetails.chainId;
        }
        if ((i14 & 2) != 0) {
            str = vendorVisitDetails.chainName;
        }
        String str3 = str;
        if ((i14 & 4) != 0) {
            i12 = vendorVisitDetails.branchId;
        }
        int i15 = i12;
        if ((i14 & 8) != 0) {
            str2 = vendorVisitDetails.branchName;
        }
        String str4 = str2;
        if ((i14 & 16) != 0) {
            i13 = vendorVisitDetails.verticalType;
        }
        int i16 = i13;
        if ((i14 & 32) != 0) {
            z11 = vendorVisitDetails.isDarkstore;
        }
        return vendorVisitDetails.copy(i11, str3, i15, str4, i16, z11);
    }

    public final int component1() {
        return this.chainId;
    }

    @NotNull
    public final String component2() {
        return this.chainName;
    }

    public final int component3() {
        return this.branchId;
    }

    @NotNull
    public final String component4() {
        return this.branchName;
    }

    public final int component5() {
        return this.verticalType;
    }

    public final boolean component6() {
        return this.isDarkstore;
    }

    @NotNull
    public final VendorVisitDetails copy(int i11, @NotNull String str, int i12, @NotNull String str2, int i13, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "chainName");
        Intrinsics.checkNotNullParameter(str2, "branchName");
        return new VendorVisitDetails(i11, str, i12, str2, i13, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorVisitDetails)) {
            return false;
        }
        VendorVisitDetails vendorVisitDetails = (VendorVisitDetails) obj;
        return this.chainId == vendorVisitDetails.chainId && Intrinsics.areEqual((Object) this.chainName, (Object) vendorVisitDetails.chainName) && this.branchId == vendorVisitDetails.branchId && Intrinsics.areEqual((Object) this.branchName, (Object) vendorVisitDetails.branchName) && this.verticalType == vendorVisitDetails.verticalType && this.isDarkstore == vendorVisitDetails.isDarkstore;
    }

    public final int getBranchId() {
        return this.branchId;
    }

    @NotNull
    public final String getBranchName() {
        return this.branchName;
    }

    public final int getChainId() {
        return this.chainId;
    }

    @NotNull
    public final String getChainName() {
        return this.chainName;
    }

    public final int getVerticalType() {
        return this.verticalType;
    }

    public int hashCode() {
        int hashCode = ((((((((this.chainId * 31) + this.chainName.hashCode()) * 31) + this.branchId) * 31) + this.branchName.hashCode()) * 31) + this.verticalType) * 31;
        boolean z11 = this.isDarkstore;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isDarkstore() {
        return this.isDarkstore;
    }

    @NotNull
    public String toString() {
        int i11 = this.chainId;
        String str = this.chainName;
        int i12 = this.branchId;
        String str2 = this.branchName;
        int i13 = this.verticalType;
        boolean z11 = this.isDarkstore;
        return "VendorVisitDetails(chainId=" + i11 + ", chainName=" + str + ", branchId=" + i12 + ", branchName=" + str2 + ", verticalType=" + i13 + ", isDarkstore=" + z11 + ")";
    }
}
