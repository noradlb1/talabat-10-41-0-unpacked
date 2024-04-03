package com.designsystem.ds_stepper;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/designsystem/ds_stepper/MM2Properties;", "", "isMM2", "", "mm2Loading", "mmIsEnabled", "(ZZZ)V", "isClickable", "()Z", "isEnabled", "isLoading", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MM2Properties {
    private final boolean isClickable;
    private final boolean isEnabled;
    private final boolean isLoading;
    private final boolean isMM2;
    private final boolean mm2Loading;
    private final boolean mmIsEnabled;

    public MM2Properties(boolean z11, boolean z12, boolean z13) {
        boolean z14;
        boolean z15;
        this.isMM2 = z11;
        this.mm2Loading = z12;
        this.mmIsEnabled = z13;
        boolean z16 = true;
        if (!z11 || !z12) {
            z14 = false;
        } else {
            z14 = true;
        }
        this.isLoading = z14;
        if (!z11 || (z11 && z13)) {
            z15 = true;
        } else {
            z15 = false;
        }
        this.isEnabled = z15;
        this.isClickable = (!z15 || z14) ? false : z16;
    }

    private final boolean component2() {
        return this.mm2Loading;
    }

    private final boolean component3() {
        return this.mmIsEnabled;
    }

    public static /* synthetic */ MM2Properties copy$default(MM2Properties mM2Properties, boolean z11, boolean z12, boolean z13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = mM2Properties.isMM2;
        }
        if ((i11 & 2) != 0) {
            z12 = mM2Properties.mm2Loading;
        }
        if ((i11 & 4) != 0) {
            z13 = mM2Properties.mmIsEnabled;
        }
        return mM2Properties.copy(z11, z12, z13);
    }

    public final boolean component1() {
        return this.isMM2;
    }

    @NotNull
    public final MM2Properties copy(boolean z11, boolean z12, boolean z13) {
        return new MM2Properties(z11, z12, z13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MM2Properties)) {
            return false;
        }
        MM2Properties mM2Properties = (MM2Properties) obj;
        return this.isMM2 == mM2Properties.isMM2 && this.mm2Loading == mM2Properties.mm2Loading && this.mmIsEnabled == mM2Properties.mmIsEnabled;
    }

    public int hashCode() {
        boolean z11 = this.isMM2;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (z11 ? 1 : 0) * true;
        boolean z13 = this.mm2Loading;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.mmIsEnabled;
        if (!z14) {
            z12 = z14;
        }
        return i12 + (z12 ? 1 : 0);
    }

    public final boolean isClickable() {
        return this.isClickable;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final boolean isMM2() {
        return this.isMM2;
    }

    @NotNull
    public String toString() {
        return "MM2Properties(isMM2=" + this.isMM2 + ", mm2Loading=" + this.mm2Loading + ", mmIsEnabled=" + this.mmIsEnabled + ')';
    }
}
