package androidx.compose.material;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import j0.d;
import java.util.List;
import kotlin.Metadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AlertDialogKt$AlertDialogBaselineLayout$2 implements MeasurePolicy {
    public static final AlertDialogKt$AlertDialogBaselineLayout$2 INSTANCE = new AlertDialogKt$AlertDialogBaselineLayout$2();

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.a(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.b(this, intrinsicMeasureScope, list, i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0110  */
    @org.jetbrains.annotations.NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.layout.MeasureResult m1077measure3p2s80s(@org.jetbrains.annotations.NotNull androidx.compose.ui.layout.MeasureScope r12, @org.jetbrains.annotations.NotNull java.util.List<? extends androidx.compose.ui.layout.Measurable> r13, long r14) {
        /*
            r11 = this;
            java.lang.String r0 = "$this$Layout"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "measurables"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r0 = r13.iterator()
        L_0x0010:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x002b
            java.lang.Object r1 = r0.next()
            r3 = r1
            androidx.compose.ui.layout.Measurable r3 = (androidx.compose.ui.layout.Measurable) r3
            java.lang.Object r3 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r3)
            java.lang.String r4 = "title"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0010
            goto L_0x002c
        L_0x002b:
            r1 = r2
        L_0x002c:
            androidx.compose.ui.layout.Measurable r1 = (androidx.compose.ui.layout.Measurable) r1
            if (r1 == 0) goto L_0x0041
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 11
            r10 = 0
            r3 = r14
            long r3 = androidx.compose.ui.unit.Constraints.m5413copyZbe2FdA$default(r3, r5, r6, r7, r8, r9, r10)
            androidx.compose.ui.layout.Placeable r0 = r1.m4508measureBRTryo0(r3)
            goto L_0x0042
        L_0x0041:
            r0 = r2
        L_0x0042:
            java.util.Iterator r13 = r13.iterator()
        L_0x0046:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x0060
            java.lang.Object r1 = r13.next()
            r3 = r1
            androidx.compose.ui.layout.Measurable r3 = (androidx.compose.ui.layout.Measurable) r3
            java.lang.Object r3 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r3)
            java.lang.String r4 = "text"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0046
            goto L_0x0061
        L_0x0060:
            r1 = r2
        L_0x0061:
            androidx.compose.ui.layout.Measurable r1 = (androidx.compose.ui.layout.Measurable) r1
            if (r1 == 0) goto L_0x0076
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 11
            r10 = 0
            r3 = r14
            long r13 = androidx.compose.ui.unit.Constraints.m5413copyZbe2FdA$default(r3, r5, r6, r7, r8, r9, r10)
            androidx.compose.ui.layout.Placeable r13 = r1.m4508measureBRTryo0(r13)
            goto L_0x0077
        L_0x0076:
            r13 = r2
        L_0x0077:
            r14 = 0
            if (r0 == 0) goto L_0x007f
            int r15 = r0.getWidth()
            goto L_0x0080
        L_0x007f:
            r15 = r14
        L_0x0080:
            if (r13 == 0) goto L_0x0087
            int r1 = r13.getWidth()
            goto L_0x0088
        L_0x0087:
            r1 = r14
        L_0x0088:
            int r4 = java.lang.Math.max(r15, r1)
            r15 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == 0) goto L_0x00a7
            androidx.compose.ui.layout.HorizontalAlignmentLine r1 = androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline()
            int r1 = r0.get(r1)
            if (r1 != r15) goto L_0x009c
            r1 = r2
            goto L_0x00a0
        L_0x009c:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x00a0:
            if (r1 == 0) goto L_0x00a7
            int r1 = r1.intValue()
            goto L_0x00a8
        L_0x00a7:
            r1 = r14
        L_0x00a8:
            if (r0 == 0) goto L_0x00c1
            androidx.compose.ui.layout.HorizontalAlignmentLine r3 = androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline()
            int r3 = r0.get(r3)
            if (r3 != r15) goto L_0x00b6
            r3 = r2
            goto L_0x00ba
        L_0x00b6:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x00ba:
            if (r3 == 0) goto L_0x00c1
            int r3 = r3.intValue()
            goto L_0x00c2
        L_0x00c1:
            r3 = r14
        L_0x00c2:
            long r5 = androidx.compose.material.AlertDialogKt.TitleBaselineDistanceFromTop
            int r5 = r12.m5440roundToPxR2X_6o(r5)
            int r5 = r5 - r1
            if (r13 == 0) goto L_0x00e3
            androidx.compose.ui.layout.HorizontalAlignmentLine r1 = androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline()
            int r1 = r13.get(r1)
            if (r1 != r15) goto L_0x00d8
            goto L_0x00dc
        L_0x00d8:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
        L_0x00dc:
            if (r2 == 0) goto L_0x00e3
            int r15 = r2.intValue()
            goto L_0x00e4
        L_0x00e3:
            r15 = r14
        L_0x00e4:
            if (r0 != 0) goto L_0x00ef
            long r1 = androidx.compose.material.AlertDialogKt.TextBaselineDistanceFromTop
            int r1 = r12.m5440roundToPxR2X_6o(r1)
            goto L_0x00f7
        L_0x00ef:
            long r1 = androidx.compose.material.AlertDialogKt.TextBaselineDistanceFromTitle
            int r1 = r12.m5440roundToPxR2X_6o(r1)
        L_0x00f7:
            if (r0 == 0) goto L_0x00ff
            int r2 = r0.getHeight()
            int r2 = r2 + r5
            goto L_0x0100
        L_0x00ff:
            r2 = r14
        L_0x0100:
            if (r0 != 0) goto L_0x0105
            int r6 = r1 - r15
            goto L_0x010e
        L_0x0105:
            if (r3 != 0) goto L_0x010a
            int r6 = r2 - r15
            goto L_0x010d
        L_0x010a:
            int r6 = r5 + r3
            int r6 = r6 - r15
        L_0x010d:
            int r6 = r6 + r1
        L_0x010e:
            if (r13 == 0) goto L_0x0128
            if (r3 != 0) goto L_0x0119
            int r14 = r13.getHeight()
            int r14 = r14 + r1
            int r14 = r14 - r15
            goto L_0x0128
        L_0x0119:
            int r7 = r13.getHeight()
            int r7 = r7 + r1
            int r7 = r7 - r15
            if (r0 == 0) goto L_0x0125
            int r14 = r0.getHeight()
        L_0x0125:
            int r14 = r14 - r3
            int r7 = r7 - r14
            r14 = r7
        L_0x0128:
            int r14 = r14 + r2
            r15 = 0
            androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2$measure$1 r7 = new androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2$measure$1
            r7.<init>(r0, r5, r13, r6)
            r8 = 4
            r9 = 0
            r3 = r12
            r5 = r14
            r6 = r15
            androidx.compose.ui.layout.MeasureResult r12 = androidx.compose.ui.layout.MeasureScope.CC.p(r3, r4, r5, r6, r7, r8, r9)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2.m1077measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.c(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.d(this, intrinsicMeasureScope, list, i11);
    }
}
