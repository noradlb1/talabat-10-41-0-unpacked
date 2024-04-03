package androidx.compose.ui.window;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import j0.d;
import java.util.List;
import kotlin.Metadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidDialog_androidKt$DialogLayout$1 implements MeasurePolicy {
    public static final AndroidDialog_androidKt$DialogLayout$1 INSTANCE = new AndroidDialog_androidKt$DialogLayout$1();

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.a(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.b(this, intrinsicMeasureScope, list, i11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: androidx.compose.ui.layout.Placeable} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.layout.MeasureResult m5726measure3p2s80s(@org.jetbrains.annotations.NotNull androidx.compose.ui.layout.MeasureScope r12, @org.jetbrains.annotations.NotNull java.util.List<? extends androidx.compose.ui.layout.Measurable> r13, long r14) {
        /*
            r11 = this;
            java.lang.String r0 = "$this$Layout"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "measurables"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r13.size()
            r0.<init>(r1)
            int r1 = r13.size()
            r2 = 0
            r3 = r2
        L_0x0019:
            if (r3 >= r1) goto L_0x002b
            java.lang.Object r4 = r13.get(r3)
            androidx.compose.ui.layout.Measurable r4 = (androidx.compose.ui.layout.Measurable) r4
            androidx.compose.ui.layout.Placeable r4 = r4.m4508measureBRTryo0(r14)
            r0.add(r4)
            int r3 = r3 + 1
            goto L_0x0019
        L_0x002b:
            boolean r13 = r0.isEmpty()
            r1 = 0
            r3 = 1
            if (r13 == 0) goto L_0x0035
            r13 = r1
            goto L_0x005b
        L_0x0035:
            java.lang.Object r13 = r0.get(r2)
            r4 = r13
            androidx.compose.ui.layout.Placeable r4 = (androidx.compose.ui.layout.Placeable) r4
            int r4 = r4.getWidth()
            int r5 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r0)
            if (r3 > r5) goto L_0x005b
            r6 = r3
        L_0x0047:
            java.lang.Object r7 = r0.get(r6)
            r8 = r7
            androidx.compose.ui.layout.Placeable r8 = (androidx.compose.ui.layout.Placeable) r8
            int r8 = r8.getWidth()
            if (r4 >= r8) goto L_0x0056
            r13 = r7
            r4 = r8
        L_0x0056:
            if (r6 == r5) goto L_0x005b
            int r6 = r6 + 1
            goto L_0x0047
        L_0x005b:
            androidx.compose.ui.layout.Placeable r13 = (androidx.compose.ui.layout.Placeable) r13
            if (r13 == 0) goto L_0x0064
            int r13 = r13.getWidth()
            goto L_0x0068
        L_0x0064:
            int r13 = androidx.compose.ui.unit.Constraints.m5424getMinWidthimpl(r14)
        L_0x0068:
            r5 = r13
            boolean r13 = r0.isEmpty()
            if (r13 == 0) goto L_0x0070
            goto L_0x0096
        L_0x0070:
            java.lang.Object r13 = r0.get(r2)
            r1 = r13
            androidx.compose.ui.layout.Placeable r1 = (androidx.compose.ui.layout.Placeable) r1
            int r1 = r1.getHeight()
            int r2 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r0)
            if (r3 > r2) goto L_0x0095
        L_0x0081:
            java.lang.Object r4 = r0.get(r3)
            r6 = r4
            androidx.compose.ui.layout.Placeable r6 = (androidx.compose.ui.layout.Placeable) r6
            int r6 = r6.getHeight()
            if (r1 >= r6) goto L_0x0090
            r13 = r4
            r1 = r6
        L_0x0090:
            if (r3 == r2) goto L_0x0095
            int r3 = r3 + 1
            goto L_0x0081
        L_0x0095:
            r1 = r13
        L_0x0096:
            androidx.compose.ui.layout.Placeable r1 = (androidx.compose.ui.layout.Placeable) r1
            if (r1 == 0) goto L_0x009f
            int r13 = r1.getHeight()
            goto L_0x00a3
        L_0x009f:
            int r13 = androidx.compose.ui.unit.Constraints.m5423getMinHeightimpl(r14)
        L_0x00a3:
            r6 = r13
            r7 = 0
            androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1$measure$1 r8 = new androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1$measure$1
            r8.<init>(r0)
            r9 = 4
            r10 = 0
            r4 = r12
            androidx.compose.ui.layout.MeasureResult r12 = androidx.compose.ui.layout.MeasureScope.CC.p(r4, r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1.m5726measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.c(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.d(this, intrinsicMeasureScope, list, i11);
    }
}
