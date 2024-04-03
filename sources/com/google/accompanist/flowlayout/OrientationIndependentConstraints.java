package com.google.accompanist.flowlayout;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001a\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006B%\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u0012\u001a\u00020\bHÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/google/accompanist/flowlayout/OrientationIndependentConstraints;", "", "c", "Landroidx/compose/ui/unit/Constraints;", "orientation", "Lcom/google/accompanist/flowlayout/LayoutOrientation;", "(JLcom/google/accompanist/flowlayout/LayoutOrientation;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "mainAxisMin", "", "mainAxisMax", "crossAxisMin", "crossAxisMax", "(IIII)V", "getCrossAxisMax", "()I", "getCrossAxisMin", "getMainAxisMax", "getMainAxisMin", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "flowlayout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OrientationIndependentConstraints {
    private final int crossAxisMax;
    private final int crossAxisMin;
    private final int mainAxisMax;
    private final int mainAxisMin;

    public OrientationIndependentConstraints(int i11, int i12, int i13, int i14) {
        this.mainAxisMin = i11;
        this.mainAxisMax = i12;
        this.crossAxisMin = i13;
        this.crossAxisMax = i14;
    }

    public /* synthetic */ OrientationIndependentConstraints(long j11, LayoutOrientation layoutOrientation, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, layoutOrientation);
    }

    public static /* synthetic */ OrientationIndependentConstraints copy$default(OrientationIndependentConstraints orientationIndependentConstraints, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = orientationIndependentConstraints.mainAxisMin;
        }
        if ((i15 & 2) != 0) {
            i12 = orientationIndependentConstraints.mainAxisMax;
        }
        if ((i15 & 4) != 0) {
            i13 = orientationIndependentConstraints.crossAxisMin;
        }
        if ((i15 & 8) != 0) {
            i14 = orientationIndependentConstraints.crossAxisMax;
        }
        return orientationIndependentConstraints.copy(i11, i12, i13, i14);
    }

    public final int component1() {
        return this.mainAxisMin;
    }

    public final int component2() {
        return this.mainAxisMax;
    }

    public final int component3() {
        return this.crossAxisMin;
    }

    public final int component4() {
        return this.crossAxisMax;
    }

    @NotNull
    public final OrientationIndependentConstraints copy(int i11, int i12, int i13, int i14) {
        return new OrientationIndependentConstraints(i11, i12, i13, i14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrientationIndependentConstraints)) {
            return false;
        }
        OrientationIndependentConstraints orientationIndependentConstraints = (OrientationIndependentConstraints) obj;
        return this.mainAxisMin == orientationIndependentConstraints.mainAxisMin && this.mainAxisMax == orientationIndependentConstraints.mainAxisMax && this.crossAxisMin == orientationIndependentConstraints.crossAxisMin && this.crossAxisMax == orientationIndependentConstraints.crossAxisMax;
    }

    public final int getCrossAxisMax() {
        return this.crossAxisMax;
    }

    public final int getCrossAxisMin() {
        return this.crossAxisMin;
    }

    public final int getMainAxisMax() {
        return this.mainAxisMax;
    }

    public final int getMainAxisMin() {
        return this.mainAxisMin;
    }

    public int hashCode() {
        return (((((this.mainAxisMin * 31) + this.mainAxisMax) * 31) + this.crossAxisMin) * 31) + this.crossAxisMax;
    }

    @NotNull
    public String toString() {
        return "OrientationIndependentConstraints(mainAxisMin=" + this.mainAxisMin + ", mainAxisMax=" + this.mainAxisMax + ", crossAxisMin=" + this.crossAxisMin + ", crossAxisMax=" + this.crossAxisMax + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private OrientationIndependentConstraints(long r5, com.google.accompanist.flowlayout.LayoutOrientation r7) {
        /*
            r4 = this;
            com.google.accompanist.flowlayout.LayoutOrientation r0 = com.google.accompanist.flowlayout.LayoutOrientation.Horizontal
            if (r7 != r0) goto L_0x0009
            int r1 = androidx.compose.ui.unit.Constraints.m5424getMinWidthimpl(r5)
            goto L_0x000d
        L_0x0009:
            int r1 = androidx.compose.ui.unit.Constraints.m5423getMinHeightimpl(r5)
        L_0x000d:
            if (r7 != r0) goto L_0x0014
            int r2 = androidx.compose.ui.unit.Constraints.m5422getMaxWidthimpl(r5)
            goto L_0x0018
        L_0x0014:
            int r2 = androidx.compose.ui.unit.Constraints.m5421getMaxHeightimpl(r5)
        L_0x0018:
            if (r7 != r0) goto L_0x001f
            int r3 = androidx.compose.ui.unit.Constraints.m5423getMinHeightimpl(r5)
            goto L_0x0023
        L_0x001f:
            int r3 = androidx.compose.ui.unit.Constraints.m5424getMinWidthimpl(r5)
        L_0x0023:
            if (r7 != r0) goto L_0x002a
            int r5 = androidx.compose.ui.unit.Constraints.m5421getMaxHeightimpl(r5)
            goto L_0x002e
        L_0x002a:
            int r5 = androidx.compose.ui.unit.Constraints.m5422getMaxWidthimpl(r5)
        L_0x002e:
            r4.<init>(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.accompanist.flowlayout.OrientationIndependentConstraints.<init>(long, com.google.accompanist.flowlayout.LayoutOrientation):void");
    }
}
