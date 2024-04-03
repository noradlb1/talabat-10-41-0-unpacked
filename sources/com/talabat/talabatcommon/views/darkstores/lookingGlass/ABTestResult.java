package com.talabat.talabatcommon.views.darkstores.lookingGlass;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0006\"\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/ABTestResult;", "", "isNewDesign", "", "isGrayBackground", "(ZZ)V", "()Z", "setGrayBackground", "(Z)V", "setNewDesign", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ABTestResult {
    private boolean isGrayBackground;
    private boolean isNewDesign;

    public ABTestResult(boolean z11, boolean z12) {
        this.isNewDesign = z11;
        this.isGrayBackground = z12;
    }

    public static /* synthetic */ ABTestResult copy$default(ABTestResult aBTestResult, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = aBTestResult.isNewDesign;
        }
        if ((i11 & 2) != 0) {
            z12 = aBTestResult.isGrayBackground;
        }
        return aBTestResult.copy(z11, z12);
    }

    public final boolean component1() {
        return this.isNewDesign;
    }

    public final boolean component2() {
        return this.isGrayBackground;
    }

    @NotNull
    public final ABTestResult copy(boolean z11, boolean z12) {
        return new ABTestResult(z11, z12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ABTestResult)) {
            return false;
        }
        ABTestResult aBTestResult = (ABTestResult) obj;
        return this.isNewDesign == aBTestResult.isNewDesign && this.isGrayBackground == aBTestResult.isGrayBackground;
    }

    public int hashCode() {
        boolean z11 = this.isNewDesign;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (z11 ? 1 : 0) * true;
        boolean z13 = this.isGrayBackground;
        if (!z13) {
            z12 = z13;
        }
        return i11 + (z12 ? 1 : 0);
    }

    public final boolean isGrayBackground() {
        return this.isGrayBackground;
    }

    public final boolean isNewDesign() {
        return this.isNewDesign;
    }

    public final void setGrayBackground(boolean z11) {
        this.isGrayBackground = z11;
    }

    public final void setNewDesign(boolean z11) {
        this.isNewDesign = z11;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isNewDesign;
        boolean z12 = this.isGrayBackground;
        return "ABTestResult(isNewDesign=" + z11 + ", isGrayBackground=" + z12 + ")";
    }
}
