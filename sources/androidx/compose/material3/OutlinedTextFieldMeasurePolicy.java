package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B4\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0002\u0010\fJ<\u0010\r\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J<\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J\"\u0010\u0018\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010\u0019\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J/\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!J\"\u0010\"\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010#\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "onLabelMeasured", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Size;", "", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Lkotlin/jvm/functions/Function1;ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicWidth", "height", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {
    /* access modifiers changed from: private */
    public final float animationProgress;
    @NotNull
    private final Function1<Size, Unit> onLabelMeasured;
    /* access modifiers changed from: private */
    @NotNull
    public final PaddingValues paddingValues;
    /* access modifiers changed from: private */
    public final boolean singleLine;

    public OutlinedTextFieldMeasurePolicy(@NotNull Function1<? super Size, Unit> function1, boolean z11, float f11, @NotNull PaddingValues paddingValues2) {
        Intrinsics.checkNotNullParameter(function1, "onLabelMeasured");
        Intrinsics.checkNotNullParameter(paddingValues2, "paddingValues");
        this.onLabelMeasured = function1;
        this.singleLine = z11;
        this.animationProgress = f11;
        this.paddingValues = paddingValues2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int intrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope r12, java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> r13, int r14, kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.IntrinsicMeasurable, ? super java.lang.Integer, java.lang.Integer> r15) {
        /*
            r11 = this;
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r0 = r13.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0141
            java.lang.Object r1 = r0.next()
            r2 = r1
            androidx.compose.ui.layout.IntrinsicMeasurable r2 = (androidx.compose.ui.layout.IntrinsicMeasurable) r2
            java.lang.Object r2 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r2)
            java.lang.String r3 = "TextField"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0006
            java.lang.Integer r0 = java.lang.Integer.valueOf(r14)
            java.lang.Object r0 = r15.invoke(r1, r0)
            java.lang.Number r0 = (java.lang.Number) r0
            int r3 = r0.intValue()
            java.util.Iterator r0 = r13.iterator()
        L_0x0031:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x004c
            java.lang.Object r1 = r0.next()
            r4 = r1
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            java.lang.Object r4 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r4)
            java.lang.String r5 = "Label"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x0031
            goto L_0x004d
        L_0x004c:
            r1 = r2
        L_0x004d:
            androidx.compose.ui.layout.IntrinsicMeasurable r1 = (androidx.compose.ui.layout.IntrinsicMeasurable) r1
            r0 = 0
            if (r1 == 0) goto L_0x0062
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            java.lang.Object r1 = r15.invoke(r1, r4)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r4 = r1
            goto L_0x0063
        L_0x0062:
            r4 = r0
        L_0x0063:
            java.util.Iterator r1 = r13.iterator()
        L_0x0067:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0081
            java.lang.Object r5 = r1.next()
            r6 = r5
            androidx.compose.ui.layout.IntrinsicMeasurable r6 = (androidx.compose.ui.layout.IntrinsicMeasurable) r6
            java.lang.Object r6 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r6)
            java.lang.String r7 = "Trailing"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0067
            goto L_0x0082
        L_0x0081:
            r5 = r2
        L_0x0082:
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            if (r5 == 0) goto L_0x0096
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            java.lang.Object r1 = r15.invoke(r5, r1)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r5 = r1
            goto L_0x0097
        L_0x0096:
            r5 = r0
        L_0x0097:
            java.util.Iterator r1 = r13.iterator()
        L_0x009b:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x00b5
            java.lang.Object r6 = r1.next()
            r7 = r6
            androidx.compose.ui.layout.IntrinsicMeasurable r7 = (androidx.compose.ui.layout.IntrinsicMeasurable) r7
            java.lang.Object r7 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r7)
            java.lang.String r8 = "Leading"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x009b
            goto L_0x00b6
        L_0x00b5:
            r6 = r2
        L_0x00b6:
            androidx.compose.ui.layout.IntrinsicMeasurable r6 = (androidx.compose.ui.layout.IntrinsicMeasurable) r6
            if (r6 == 0) goto L_0x00c9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            java.lang.Object r1 = r15.invoke(r6, r1)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            goto L_0x00ca
        L_0x00c9:
            r1 = r0
        L_0x00ca:
            java.util.Iterator r6 = r13.iterator()
        L_0x00ce:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00e8
            java.lang.Object r7 = r6.next()
            r8 = r7
            androidx.compose.ui.layout.IntrinsicMeasurable r8 = (androidx.compose.ui.layout.IntrinsicMeasurable) r8
            java.lang.Object r8 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r8)
            java.lang.String r9 = "Hint"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x00ce
            goto L_0x00e9
        L_0x00e8:
            r7 = r2
        L_0x00e9:
            androidx.compose.ui.layout.IntrinsicMeasurable r7 = (androidx.compose.ui.layout.IntrinsicMeasurable) r7
            if (r7 == 0) goto L_0x00fc
            java.lang.Integer r6 = java.lang.Integer.valueOf(r14)
            java.lang.Object r6 = r15.invoke(r7, r6)
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            goto L_0x00fd
        L_0x00fc:
            r6 = r0
        L_0x00fd:
            java.util.Iterator r13 = r13.iterator()
        L_0x0101:
            boolean r7 = r13.hasNext()
            if (r7 == 0) goto L_0x011b
            java.lang.Object r7 = r13.next()
            r8 = r7
            androidx.compose.ui.layout.IntrinsicMeasurable r8 = (androidx.compose.ui.layout.IntrinsicMeasurable) r8
            java.lang.Object r8 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r8)
            java.lang.String r9 = "Supporting"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x0101
            r2 = r7
        L_0x011b:
            androidx.compose.ui.layout.IntrinsicMeasurable r2 = (androidx.compose.ui.layout.IntrinsicMeasurable) r2
            if (r2 == 0) goto L_0x012e
            java.lang.Integer r13 = java.lang.Integer.valueOf(r14)
            java.lang.Object r13 = r15.invoke(r2, r13)
            java.lang.Number r13 = (java.lang.Number) r13
            int r13 = r13.intValue()
            goto L_0x012f
        L_0x012e:
            r13 = r0
        L_0x012f:
            long r7 = androidx.compose.material3.TextFieldImplKt.getZeroConstraints()
            float r9 = r12.getDensity()
            androidx.compose.foundation.layout.PaddingValues r10 = r11.paddingValues
            r2 = r5
            r5 = r6
            r6 = r13
            int r12 = androidx.compose.material3.OutlinedTextFieldKt.m1787calculateHeightO3s9Psw(r1, r2, r3, r4, r5, r6, r7, r9, r10)
            return r12
        L_0x0141:
            java.util.NoSuchElementException r12 = new java.util.NoSuchElementException
            java.lang.String r13 = "Collection contains no element matching the predicate."
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.intrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope, java.util.List, int, kotlin.jvm.functions.Function2):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int intrinsicWidth(androidx.compose.ui.layout.IntrinsicMeasureScope r12, java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> r13, int r14, kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.IntrinsicMeasurable, ? super java.lang.Integer, java.lang.Integer> r15) {
        /*
            r11 = this;
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r0 = r13.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0119
            java.lang.Object r1 = r0.next()
            r2 = r1
            androidx.compose.ui.layout.IntrinsicMeasurable r2 = (androidx.compose.ui.layout.IntrinsicMeasurable) r2
            java.lang.Object r2 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r2)
            java.lang.String r3 = "TextField"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0006
            java.lang.Integer r0 = java.lang.Integer.valueOf(r14)
            java.lang.Object r0 = r15.invoke(r1, r0)
            java.lang.Number r0 = (java.lang.Number) r0
            int r3 = r0.intValue()
            java.util.Iterator r0 = r13.iterator()
        L_0x0031:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x004c
            java.lang.Object r1 = r0.next()
            r4 = r1
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            java.lang.Object r4 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r4)
            java.lang.String r5 = "Label"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x0031
            goto L_0x004d
        L_0x004c:
            r1 = r2
        L_0x004d:
            androidx.compose.ui.layout.IntrinsicMeasurable r1 = (androidx.compose.ui.layout.IntrinsicMeasurable) r1
            r0 = 0
            if (r1 == 0) goto L_0x0062
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            java.lang.Object r1 = r15.invoke(r1, r4)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r4 = r1
            goto L_0x0063
        L_0x0062:
            r4 = r0
        L_0x0063:
            java.util.Iterator r1 = r13.iterator()
        L_0x0067:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0081
            java.lang.Object r5 = r1.next()
            r6 = r5
            androidx.compose.ui.layout.IntrinsicMeasurable r6 = (androidx.compose.ui.layout.IntrinsicMeasurable) r6
            java.lang.Object r6 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r6)
            java.lang.String r7 = "Trailing"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0067
            goto L_0x0082
        L_0x0081:
            r5 = r2
        L_0x0082:
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            if (r5 == 0) goto L_0x0096
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            java.lang.Object r1 = r15.invoke(r5, r1)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r5 = r1
            goto L_0x0097
        L_0x0096:
            r5 = r0
        L_0x0097:
            java.util.Iterator r1 = r13.iterator()
        L_0x009b:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x00b5
            java.lang.Object r6 = r1.next()
            r7 = r6
            androidx.compose.ui.layout.IntrinsicMeasurable r7 = (androidx.compose.ui.layout.IntrinsicMeasurable) r7
            java.lang.Object r7 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r7)
            java.lang.String r8 = "Leading"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x009b
            goto L_0x00b6
        L_0x00b5:
            r6 = r2
        L_0x00b6:
            androidx.compose.ui.layout.IntrinsicMeasurable r6 = (androidx.compose.ui.layout.IntrinsicMeasurable) r6
            if (r6 == 0) goto L_0x00c9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            java.lang.Object r1 = r15.invoke(r6, r1)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            goto L_0x00ca
        L_0x00c9:
            r1 = r0
        L_0x00ca:
            java.util.Iterator r13 = r13.iterator()
        L_0x00ce:
            boolean r6 = r13.hasNext()
            if (r6 == 0) goto L_0x00e8
            java.lang.Object r6 = r13.next()
            r7 = r6
            androidx.compose.ui.layout.IntrinsicMeasurable r7 = (androidx.compose.ui.layout.IntrinsicMeasurable) r7
            java.lang.Object r7 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r7)
            java.lang.String r8 = "Hint"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x00ce
            r2 = r6
        L_0x00e8:
            androidx.compose.ui.layout.IntrinsicMeasurable r2 = (androidx.compose.ui.layout.IntrinsicMeasurable) r2
            if (r2 == 0) goto L_0x00fb
            java.lang.Integer r13 = java.lang.Integer.valueOf(r14)
            java.lang.Object r13 = r15.invoke(r2, r13)
            java.lang.Number r13 = (java.lang.Number) r13
            int r13 = r13.intValue()
            goto L_0x00fc
        L_0x00fb:
            r13 = r0
        L_0x00fc:
            float r14 = r11.animationProgress
            r15 = 1065353216(0x3f800000, float:1.0)
            int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r14 >= 0) goto L_0x0107
            r14 = 1
            r6 = r14
            goto L_0x0108
        L_0x0107:
            r6 = r0
        L_0x0108:
            long r7 = androidx.compose.material3.TextFieldImplKt.getZeroConstraints()
            float r9 = r12.getDensity()
            androidx.compose.foundation.layout.PaddingValues r10 = r11.paddingValues
            r2 = r5
            r5 = r13
            int r12 = androidx.compose.material3.OutlinedTextFieldKt.m1788calculateWidthO3s9Psw(r1, r2, r3, r4, r5, r6, r7, r9, r10)
            return r12
        L_0x0119:
            java.util.NoSuchElementException r12 = new java.util.NoSuchElementException
            java.lang.String r13 = "Collection contains no element matching the predicate."
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.intrinsicWidth(androidx.compose.ui.layout.IntrinsicMeasureScope, java.util.List, int, kotlin.jvm.functions.Function2):int");
    }

    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, list, i11, OutlinedTextFieldMeasurePolicy$maxIntrinsicHeight$1.INSTANCE);
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return intrinsicWidth(intrinsicMeasureScope, list, i11, OutlinedTextFieldMeasurePolicy$maxIntrinsicWidth$1.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v7, resolved type: androidx.compose.ui.layout.Measurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v9, resolved type: androidx.compose.ui.layout.Measurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.ui.layout.MeasureResult m1790measure3p2s80s(@org.jetbrains.annotations.NotNull androidx.compose.ui.layout.MeasureScope r33, @org.jetbrains.annotations.NotNull java.util.List<? extends androidx.compose.ui.layout.Measurable> r34, long r35) {
        /*
            r32 = this;
            r12 = r32
            r13 = r33
            r0 = r34
            java.lang.String r1 = "$this$measure"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            java.lang.String r1 = "measurables"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            androidx.compose.foundation.layout.PaddingValues r1 = r12.paddingValues
            float r1 = r1.m496calculateBottomPaddingD9Ej5fM()
            int r1 = r13.m5441roundToPx0680j_4(r1)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 10
            r9 = 0
            r2 = r35
            long r2 = androidx.compose.ui.unit.Constraints.m5413copyZbe2FdA$default(r2, r4, r5, r6, r7, r8, r9)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r4 = r0.iterator()
        L_0x002d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0047
            java.lang.Object r5 = r4.next()
            r7 = r5
            androidx.compose.ui.layout.Measurable r7 = (androidx.compose.ui.layout.Measurable) r7
            java.lang.Object r7 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r7)
            java.lang.String r8 = "Leading"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x002d
            goto L_0x0048
        L_0x0047:
            r5 = 0
        L_0x0048:
            androidx.compose.ui.layout.Measurable r5 = (androidx.compose.ui.layout.Measurable) r5
            if (r5 == 0) goto L_0x0051
            androidx.compose.ui.layout.Placeable r4 = r5.m4508measureBRTryo0(r2)
            goto L_0x0052
        L_0x0051:
            r4 = 0
        L_0x0052:
            int r5 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r4)
            r7 = 0
            int r5 = r5 + r7
            int r8 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r4)
            int r8 = java.lang.Math.max(r7, r8)
            java.util.Iterator r9 = r0.iterator()
        L_0x0064:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x007e
            java.lang.Object r10 = r9.next()
            r11 = r10
            androidx.compose.ui.layout.Measurable r11 = (androidx.compose.ui.layout.Measurable) r11
            java.lang.Object r11 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r11)
            java.lang.String r14 = "Trailing"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r14)
            if (r11 == 0) goto L_0x0064
            goto L_0x007f
        L_0x007e:
            r10 = 0
        L_0x007f:
            androidx.compose.ui.layout.Measurable r10 = (androidx.compose.ui.layout.Measurable) r10
            if (r10 == 0) goto L_0x0096
            int r9 = -r5
            r17 = 0
            r18 = 2
            r19 = 0
            r14 = r2
            r16 = r9
            long r14 = androidx.compose.ui.unit.ConstraintsKt.m5439offsetNN6EwU$default(r14, r16, r17, r18, r19)
            androidx.compose.ui.layout.Placeable r9 = r10.m4508measureBRTryo0(r14)
            goto L_0x0097
        L_0x0096:
            r9 = 0
        L_0x0097:
            int r10 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r9)
            int r5 = r5 + r10
            int r10 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r9)
            int r8 = java.lang.Math.max(r8, r10)
            float r10 = r12.animationProgress
            r11 = 1065353216(0x3f800000, float:1.0)
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 >= 0) goto L_0x00ae
            r10 = 1
            goto L_0x00af
        L_0x00ae:
            r10 = r7
        L_0x00af:
            androidx.compose.foundation.layout.PaddingValues r11 = r12.paddingValues
            androidx.compose.ui.unit.LayoutDirection r14 = r33.getLayoutDirection()
            float r11 = r11.m497calculateLeftPaddingu2uoSUM(r14)
            int r11 = r13.m5441roundToPx0680j_4(r11)
            androidx.compose.foundation.layout.PaddingValues r14 = r12.paddingValues
            androidx.compose.ui.unit.LayoutDirection r15 = r33.getLayoutDirection()
            float r14 = r14.m498calculateRightPaddingu2uoSUM(r15)
            int r14 = r13.m5441roundToPx0680j_4(r14)
            int r11 = r11 + r14
            if (r10 == 0) goto L_0x00d1
            int r14 = -r5
            int r14 = r14 - r11
            goto L_0x00d2
        L_0x00d1:
            int r14 = -r11
        L_0x00d2:
            int r11 = -r1
            long r14 = androidx.compose.ui.unit.ConstraintsKt.m5438offsetNN6EwU(r2, r14, r11)
            java.util.Iterator r16 = r0.iterator()
        L_0x00db:
            boolean r17 = r16.hasNext()
            if (r17 == 0) goto L_0x00f8
            java.lang.Object r17 = r16.next()
            r18 = r17
            androidx.compose.ui.layout.Measurable r18 = (androidx.compose.ui.layout.Measurable) r18
            java.lang.Object r6 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r18)
            java.lang.String r7 = "Label"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x00f6
            goto L_0x00fa
        L_0x00f6:
            r7 = 0
            goto L_0x00db
        L_0x00f8:
            r17 = 0
        L_0x00fa:
            r6 = r17
            androidx.compose.ui.layout.Measurable r6 = (androidx.compose.ui.layout.Measurable) r6
            if (r6 == 0) goto L_0x0105
            androidx.compose.ui.layout.Placeable r6 = r6.m4508measureBRTryo0(r14)
            goto L_0x0106
        L_0x0105:
            r6 = 0
        L_0x0106:
            if (r6 == 0) goto L_0x011f
            kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Size, kotlin.Unit> r7 = r12.onLabelMeasured
            int r14 = r6.getWidth()
            float r14 = (float) r14
            int r15 = r6.getHeight()
            float r15 = (float) r15
            long r14 = androidx.compose.ui.geometry.SizeKt.Size(r14, r15)
            androidx.compose.ui.geometry.Size r14 = androidx.compose.ui.geometry.Size.m2733boximpl(r14)
            r7.invoke(r14)
        L_0x011f:
            int r7 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r6)
            int r7 = r7 / 2
            androidx.compose.foundation.layout.PaddingValues r14 = r12.paddingValues
            float r14 = r14.m499calculateTopPaddingD9Ej5fM()
            int r14 = r13.m5441roundToPx0680j_4(r14)
            int r7 = java.lang.Math.max(r7, r14)
            int r5 = -r5
            int r11 = r11 - r7
            r14 = r35
            long r16 = androidx.compose.ui.unit.ConstraintsKt.m5438offsetNN6EwU(r14, r5, r11)
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 11
            r23 = 0
            long r13 = androidx.compose.ui.unit.Constraints.m5413copyZbe2FdA$default(r16, r18, r19, r20, r21, r22, r23)
            java.util.Iterator r5 = r0.iterator()
        L_0x014f:
            boolean r11 = r5.hasNext()
            java.lang.String r15 = "Collection contains no element matching the predicate."
            if (r11 == 0) goto L_0x02be
            java.lang.Object r11 = r5.next()
            androidx.compose.ui.layout.Measurable r11 = (androidx.compose.ui.layout.Measurable) r11
            r16 = r5
            java.lang.Object r5 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r11)
            r17 = r15
            java.lang.String r15 = "TextField"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r15)
            if (r5 == 0) goto L_0x02ba
            androidx.compose.ui.layout.Placeable r5 = r11.m4508measureBRTryo0(r13)
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 14
            r31 = 0
            r24 = r13
            long r13 = androidx.compose.ui.unit.Constraints.m5413copyZbe2FdA$default(r24, r26, r27, r28, r29, r30, r31)
            java.util.Iterator r11 = r0.iterator()
        L_0x0187:
            boolean r15 = r11.hasNext()
            if (r15 == 0) goto L_0x01ab
            java.lang.Object r15 = r11.next()
            r16 = r15
            androidx.compose.ui.layout.Measurable r16 = (androidx.compose.ui.layout.Measurable) r16
            r18 = r11
            java.lang.Object r11 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r16)
            r16 = r15
            java.lang.String r15 = "Hint"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r15)
            if (r11 == 0) goto L_0x01a8
            r15 = r16
            goto L_0x01ac
        L_0x01a8:
            r11 = r18
            goto L_0x0187
        L_0x01ab:
            r15 = 0
        L_0x01ac:
            androidx.compose.ui.layout.Measurable r15 = (androidx.compose.ui.layout.Measurable) r15
            if (r15 == 0) goto L_0x01b5
            androidx.compose.ui.layout.Placeable r11 = r15.m4508measureBRTryo0(r13)
            goto L_0x01b6
        L_0x01b5:
            r11 = 0
        L_0x01b6:
            int r13 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r5)
            int r14 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r11)
            int r13 = java.lang.Math.max(r13, r14)
            int r13 = r13 + r7
            int r13 = r13 + r1
            int r1 = java.lang.Math.max(r8, r13)
            r16 = 0
            int r1 = -r1
            r18 = 1
            r19 = 0
            r7 = r17
            r14 = r2
            r17 = r1
            long r24 = androidx.compose.ui.unit.ConstraintsKt.m5439offsetNN6EwU$default(r14, r16, r17, r18, r19)
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 11
            r31 = 0
            long r1 = androidx.compose.ui.unit.Constraints.m5413copyZbe2FdA$default(r24, r26, r27, r28, r29, r30, r31)
            java.util.Iterator r3 = r0.iterator()
        L_0x01ec:
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x0206
            java.lang.Object r8 = r3.next()
            r13 = r8
            androidx.compose.ui.layout.Measurable r13 = (androidx.compose.ui.layout.Measurable) r13
            java.lang.Object r13 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r13)
            java.lang.String r14 = "Supporting"
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r14)
            if (r13 == 0) goto L_0x01ec
            goto L_0x0207
        L_0x0206:
            r8 = 0
        L_0x0207:
            androidx.compose.ui.layout.Measurable r8 = (androidx.compose.ui.layout.Measurable) r8
            if (r8 == 0) goto L_0x0211
            androidx.compose.ui.layout.Placeable r1 = r8.m4508measureBRTryo0(r1)
            r13 = r1
            goto L_0x0212
        L_0x0211:
            r13 = 0
        L_0x0212:
            int r1 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r13)
            int r14 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r4)
            int r15 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r9)
            int r16 = r5.getWidth()
            int r17 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r6)
            int r18 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r11)
            float r22 = r33.getDensity()
            androidx.compose.foundation.layout.PaddingValues r2 = r12.paddingValues
            r19 = r10
            r20 = r35
            r23 = r2
            int r10 = androidx.compose.material3.OutlinedTextFieldKt.m1788calculateWidthO3s9Psw(r14, r15, r16, r17, r18, r19, r20, r22, r23)
            int r14 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r4)
            int r15 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r9)
            int r16 = r5.getHeight()
            int r17 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r6)
            int r18 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r11)
            int r19 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r13)
            float r22 = r33.getDensity()
            androidx.compose.foundation.layout.PaddingValues r2 = r12.paddingValues
            r23 = r2
            int r14 = androidx.compose.material3.OutlinedTextFieldKt.m1787calculateHeightO3s9Psw(r14, r15, r16, r17, r18, r19, r20, r22, r23)
            int r1 = r14 - r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0264:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x02b4
            java.lang.Object r2 = r0.next()
            androidx.compose.ui.layout.Measurable r2 = (androidx.compose.ui.layout.Measurable) r2
            java.lang.Object r3 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r2)
            java.lang.String r8 = "Container"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r8)
            if (r3 == 0) goto L_0x0264
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r10 == r0) goto L_0x0283
            r3 = r10
            goto L_0x0284
        L_0x0283:
            r3 = 0
        L_0x0284:
            if (r1 == r0) goto L_0x0288
            r7 = r1
            goto L_0x0289
        L_0x0288:
            r7 = 0
        L_0x0289:
            long r0 = androidx.compose.ui.unit.ConstraintsKt.Constraints(r3, r10, r7, r1)
            androidx.compose.ui.layout.Placeable r8 = r2.m4508measureBRTryo0(r0)
            r15 = 0
            androidx.compose.material3.OutlinedTextFieldMeasurePolicy$measure$2 r16 = new androidx.compose.material3.OutlinedTextFieldMeasurePolicy$measure$2
            r0 = r16
            r1 = r14
            r2 = r10
            r3 = r4
            r4 = r9
            r7 = r11
            r9 = r13
            r17 = r10
            r10 = r32
            r11 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r5 = 4
            r6 = 0
            r0 = r33
            r1 = r17
            r2 = r14
            r3 = r15
            r4 = r16
            androidx.compose.ui.layout.MeasureResult r0 = androidx.compose.ui.layout.MeasureScope.CC.p(r0, r1, r2, r3, r4, r5, r6)
            return r0
        L_0x02b4:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>(r7)
            throw r0
        L_0x02ba:
            r5 = r16
            goto L_0x014f
        L_0x02be:
            r5 = r15
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.m1790measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }

    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, list, i11, OutlinedTextFieldMeasurePolicy$minIntrinsicHeight$1.INSTANCE);
    }

    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return intrinsicWidth(intrinsicMeasureScope, list, i11, OutlinedTextFieldMeasurePolicy$minIntrinsicWidth$1.INSTANCE);
    }
}
