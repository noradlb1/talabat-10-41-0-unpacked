package com.talabat.talabatcommon.ports.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JB\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/talabat/talabatcommon/ports/dto/VendorBusyPopupCallArguments;", "", "branchId", "", "primaryCuisineId", "vendorName", "", "isTGO", "", "verticalType", "(ILjava/lang/Integer;Ljava/lang/String;ZI)V", "getBranchId", "()I", "()Z", "getPrimaryCuisineId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVendorName", "()Ljava/lang/String;", "getVerticalType", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/Integer;Ljava/lang/String;ZI)Lcom/talabat/talabatcommon/ports/dto/VendorBusyPopupCallArguments;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorBusyPopupCallArguments {
    private final int branchId;
    private final boolean isTGO;
    @Nullable
    private final Integer primaryCuisineId;
    @NotNull
    private final String vendorName;
    private final int verticalType;

    public VendorBusyPopupCallArguments(int i11, @Nullable Integer num, @NotNull String str, boolean z11, int i12) {
        Intrinsics.checkNotNullParameter(str, "vendorName");
        this.branchId = i11;
        this.primaryCuisineId = num;
        this.vendorName = str;
        this.isTGO = z11;
        this.verticalType = i12;
    }

    public static /* synthetic */ VendorBusyPopupCallArguments copy$default(VendorBusyPopupCallArguments vendorBusyPopupCallArguments, int i11, Integer num, String str, boolean z11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = vendorBusyPopupCallArguments.branchId;
        }
        if ((i13 & 2) != 0) {
            num = vendorBusyPopupCallArguments.primaryCuisineId;
        }
        Integer num2 = num;
        if ((i13 & 4) != 0) {
            str = vendorBusyPopupCallArguments.vendorName;
        }
        String str2 = str;
        if ((i13 & 8) != 0) {
            z11 = vendorBusyPopupCallArguments.isTGO;
        }
        boolean z12 = z11;
        if ((i13 & 16) != 0) {
            i12 = vendorBusyPopupCallArguments.verticalType;
        }
        return vendorBusyPopupCallArguments.copy(i11, num2, str2, z12, i12);
    }

    public final int component1() {
        return this.branchId;
    }

    @Nullable
    public final Integer component2() {
        return this.primaryCuisineId;
    }

    @NotNull
    public final String component3() {
        return this.vendorName;
    }

    public final boolean component4() {
        return this.isTGO;
    }

    public final int component5() {
        return this.verticalType;
    }

    @NotNull
    public final VendorBusyPopupCallArguments copy(int i11, @Nullable Integer num, @NotNull String str, boolean z11, int i12) {
        Intrinsics.checkNotNullParameter(str, "vendorName");
        return new VendorBusyPopupCallArguments(i11, num, str, z11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorBusyPopupCallArguments)) {
            return false;
        }
        VendorBusyPopupCallArguments vendorBusyPopupCallArguments = (VendorBusyPopupCallArguments) obj;
        return this.branchId == vendorBusyPopupCallArguments.branchId && Intrinsics.areEqual((Object) this.primaryCuisineId, (Object) vendorBusyPopupCallArguments.primaryCuisineId) && Intrinsics.areEqual((Object) this.vendorName, (Object) vendorBusyPopupCallArguments.vendorName) && this.isTGO == vendorBusyPopupCallArguments.isTGO && this.verticalType == vendorBusyPopupCallArguments.verticalType;
    }

    public final int getBranchId() {
        return this.branchId;
    }

    @Nullable
    public final Integer getPrimaryCuisineId() {
        return this.primaryCuisineId;
    }

    @NotNull
    public final String getVendorName() {
        return this.vendorName;
    }

    public final int getVerticalType() {
        return this.verticalType;
    }

    public int hashCode() {
        int i11 = this.branchId * 31;
        Integer num = this.primaryCuisineId;
        int hashCode = (((i11 + (num == null ? 0 : num.hashCode())) * 31) + this.vendorName.hashCode()) * 31;
        boolean z11 = this.isTGO;
        if (z11) {
            z11 = true;
        }
        return ((hashCode + (z11 ? 1 : 0)) * 31) + this.verticalType;
    }

    public final boolean isTGO() {
        return this.isTGO;
    }

    @NotNull
    public String toString() {
        int i11 = this.branchId;
        Integer num = this.primaryCuisineId;
        String str = this.vendorName;
        boolean z11 = this.isTGO;
        int i12 = this.verticalType;
        return "VendorBusyPopupCallArguments(branchId=" + i11 + ", primaryCuisineId=" + num + ", vendorName=" + str + ", isTGO=" + z11 + ", verticalType=" + i12 + ")";
    }
}
