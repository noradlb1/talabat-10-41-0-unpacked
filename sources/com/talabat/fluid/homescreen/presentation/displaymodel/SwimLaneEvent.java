package com.talabat.fluid.homescreen.presentation.displaymodel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J;\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/displaymodel/SwimLaneEvent;", "", "branchId", "", "shopType", "isGlrEnabled", "", "isDarkStore", "isMigrated", "(IIZZZ)V", "getBranchId", "()I", "()Z", "getShopType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimLaneEvent {
    private final int branchId;
    private final boolean isDarkStore;
    private final boolean isGlrEnabled;
    private final boolean isMigrated;
    private final int shopType;

    public SwimLaneEvent(int i11, int i12, boolean z11, boolean z12, boolean z13) {
        this.branchId = i11;
        this.shopType = i12;
        this.isGlrEnabled = z11;
        this.isDarkStore = z12;
        this.isMigrated = z13;
    }

    public static /* synthetic */ SwimLaneEvent copy$default(SwimLaneEvent swimLaneEvent, int i11, int i12, boolean z11, boolean z12, boolean z13, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = swimLaneEvent.branchId;
        }
        if ((i13 & 2) != 0) {
            i12 = swimLaneEvent.shopType;
        }
        int i14 = i12;
        if ((i13 & 4) != 0) {
            z11 = swimLaneEvent.isGlrEnabled;
        }
        boolean z14 = z11;
        if ((i13 & 8) != 0) {
            z12 = swimLaneEvent.isDarkStore;
        }
        boolean z15 = z12;
        if ((i13 & 16) != 0) {
            z13 = swimLaneEvent.isMigrated;
        }
        return swimLaneEvent.copy(i11, i14, z14, z15, z13);
    }

    public final int component1() {
        return this.branchId;
    }

    public final int component2() {
        return this.shopType;
    }

    public final boolean component3() {
        return this.isGlrEnabled;
    }

    public final boolean component4() {
        return this.isDarkStore;
    }

    public final boolean component5() {
        return this.isMigrated;
    }

    @NotNull
    public final SwimLaneEvent copy(int i11, int i12, boolean z11, boolean z12, boolean z13) {
        return new SwimLaneEvent(i11, i12, z11, z12, z13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimLaneEvent)) {
            return false;
        }
        SwimLaneEvent swimLaneEvent = (SwimLaneEvent) obj;
        return this.branchId == swimLaneEvent.branchId && this.shopType == swimLaneEvent.shopType && this.isGlrEnabled == swimLaneEvent.isGlrEnabled && this.isDarkStore == swimLaneEvent.isDarkStore && this.isMigrated == swimLaneEvent.isMigrated;
    }

    public final int getBranchId() {
        return this.branchId;
    }

    public final int getShopType() {
        return this.shopType;
    }

    public int hashCode() {
        int i11 = ((this.branchId * 31) + this.shopType) * 31;
        boolean z11 = this.isGlrEnabled;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i12 = (i11 + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.isDarkStore;
        if (z13) {
            z13 = true;
        }
        int i13 = (i12 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.isMigrated;
        if (!z14) {
            z12 = z14;
        }
        return i13 + (z12 ? 1 : 0);
    }

    public final boolean isDarkStore() {
        return this.isDarkStore;
    }

    public final boolean isGlrEnabled() {
        return this.isGlrEnabled;
    }

    public final boolean isMigrated() {
        return this.isMigrated;
    }

    @NotNull
    public String toString() {
        int i11 = this.branchId;
        int i12 = this.shopType;
        boolean z11 = this.isGlrEnabled;
        boolean z12 = this.isDarkStore;
        boolean z13 = this.isMigrated;
        return "SwimLaneEvent(branchId=" + i11 + ", shopType=" + i12 + ", isGlrEnabled=" + z11 + ", isDarkStore=" + z12 + ", isMigrated=" + z13 + ")";
    }
}
