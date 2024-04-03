package com.talabat.sdsquad.data.vendorslist.response;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/response/Sort;", "", "type", "", "isOn", "", "(IZ)V", "()Z", "setOn", "(Z)V", "getType", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Sort {
    private boolean isOn;
    private final int type;

    public Sort(int i11, boolean z11) {
        this.type = i11;
        this.isOn = z11;
    }

    public static /* synthetic */ Sort copy$default(Sort sort, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = sort.type;
        }
        if ((i12 & 2) != 0) {
            z11 = sort.isOn;
        }
        return sort.copy(i11, z11);
    }

    public final int component1() {
        return this.type;
    }

    public final boolean component2() {
        return this.isOn;
    }

    @NotNull
    public final Sort copy(int i11, boolean z11) {
        return new Sort(i11, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Sort)) {
            return false;
        }
        Sort sort = (Sort) obj;
        return this.type == sort.type && this.isOn == sort.isOn;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int i11 = this.type * 31;
        boolean z11 = this.isOn;
        if (z11) {
            z11 = true;
        }
        return i11 + (z11 ? 1 : 0);
    }

    public final boolean isOn() {
        return this.isOn;
    }

    public final void setOn(boolean z11) {
        this.isOn = z11;
    }

    @NotNull
    public String toString() {
        int i11 = this.type;
        boolean z11 = this.isOn;
        return "Sort(type=" + i11 + ", isOn=" + z11 + ")";
    }
}
