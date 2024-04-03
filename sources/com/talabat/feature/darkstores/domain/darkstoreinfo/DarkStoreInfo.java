package com.talabat.feature.darkstores.domain.darkstoreinfo;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/darkstores/domain/darkstoreinfo/DarkStoreInfo;", "", "chainId", "", "branchId", "vendorName", "", "migrated", "", "selectedCountryId", "(IILjava/lang/String;ZI)V", "getBranchId", "()I", "getChainId", "getMigrated", "()Z", "getSelectedCountryId", "getVendorName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "com_talabat_feature_darkstores_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkStoreInfo {
    private final int branchId;
    private final int chainId;
    private final boolean migrated;
    private final int selectedCountryId;
    @NotNull
    private final String vendorName;

    public DarkStoreInfo(int i11, int i12, @NotNull String str, boolean z11, int i13) {
        Intrinsics.checkNotNullParameter(str, "vendorName");
        this.chainId = i11;
        this.branchId = i12;
        this.vendorName = str;
        this.migrated = z11;
        this.selectedCountryId = i13;
    }

    public static /* synthetic */ DarkStoreInfo copy$default(DarkStoreInfo darkStoreInfo, int i11, int i12, String str, boolean z11, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i11 = darkStoreInfo.chainId;
        }
        if ((i14 & 2) != 0) {
            i12 = darkStoreInfo.branchId;
        }
        int i15 = i12;
        if ((i14 & 4) != 0) {
            str = darkStoreInfo.vendorName;
        }
        String str2 = str;
        if ((i14 & 8) != 0) {
            z11 = darkStoreInfo.migrated;
        }
        boolean z12 = z11;
        if ((i14 & 16) != 0) {
            i13 = darkStoreInfo.selectedCountryId;
        }
        return darkStoreInfo.copy(i11, i15, str2, z12, i13);
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

    public final boolean component4() {
        return this.migrated;
    }

    public final int component5() {
        return this.selectedCountryId;
    }

    @NotNull
    public final DarkStoreInfo copy(int i11, int i12, @NotNull String str, boolean z11, int i13) {
        Intrinsics.checkNotNullParameter(str, "vendorName");
        return new DarkStoreInfo(i11, i12, str, z11, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DarkStoreInfo)) {
            return false;
        }
        DarkStoreInfo darkStoreInfo = (DarkStoreInfo) obj;
        return this.chainId == darkStoreInfo.chainId && this.branchId == darkStoreInfo.branchId && Intrinsics.areEqual((Object) this.vendorName, (Object) darkStoreInfo.vendorName) && this.migrated == darkStoreInfo.migrated && this.selectedCountryId == darkStoreInfo.selectedCountryId;
    }

    public final int getBranchId() {
        return this.branchId;
    }

    public final int getChainId() {
        return this.chainId;
    }

    public final boolean getMigrated() {
        return this.migrated;
    }

    public final int getSelectedCountryId() {
        return this.selectedCountryId;
    }

    @NotNull
    public final String getVendorName() {
        return this.vendorName;
    }

    public int hashCode() {
        int hashCode = ((((this.chainId * 31) + this.branchId) * 31) + this.vendorName.hashCode()) * 31;
        boolean z11 = this.migrated;
        if (z11) {
            z11 = true;
        }
        return ((hashCode + (z11 ? 1 : 0)) * 31) + this.selectedCountryId;
    }

    @NotNull
    public String toString() {
        int i11 = this.chainId;
        int i12 = this.branchId;
        String str = this.vendorName;
        boolean z11 = this.migrated;
        int i13 = this.selectedCountryId;
        return "DarkStoreInfo(chainId=" + i11 + ", branchId=" + i12 + ", vendorName=" + str + ", migrated=" + z11 + ", selectedCountryId=" + i13 + ")";
    }
}
