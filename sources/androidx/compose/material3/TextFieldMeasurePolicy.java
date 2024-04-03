package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J<\u0010\u0011\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\"\u0010\u0014\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u0015\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016J/\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u001f\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"Landroidx/compose/material3/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicWidth", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class TextFieldMeasurePolicy implements MeasurePolicy {
    /* access modifiers changed from: private */
    public final float animationProgress;
    /* access modifiers changed from: private */
    @NotNull
    public final PaddingValues paddingValues;
    /* access modifiers changed from: private */
    public final boolean singleLine;

    public TextFieldMeasurePolicy(boolean z11, float f11, @NotNull PaddingValues paddingValues2) {
        Intrinsics.checkNotNullParameter(paddingValues2, "paddingValues");
        this.singleLine = z11;
        this.animationProgress = f11;
        this.paddingValues = paddingValues2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int intrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope r16, java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> r17, int r18, kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.IntrinsicMeasurable, ? super java.lang.Integer, java.lang.Integer> r19) {
        /*
            r15 = this;
            r0 = r19
            r1 = r17
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r2 = r1.iterator()
        L_0x000a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0152
            java.lang.Object r3 = r2.next()
            r4 = r3
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            java.lang.Object r4 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r4)
            java.lang.String r5 = "TextField"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x014f
            java.lang.Integer r2 = java.lang.Integer.valueOf(r18)
            java.lang.Object r2 = r0.invoke(r3, r2)
            java.lang.Number r2 = (java.lang.Number) r2
            int r3 = r2.intValue()
            java.util.Iterator r2 = r1.iterator()
        L_0x0035:
            boolean r4 = r2.hasNext()
            r5 = 0
            if (r4 == 0) goto L_0x0050
            java.lang.Object r4 = r2.next()
            r6 = r4
            androidx.compose.ui.layout.IntrinsicMeasurable r6 = (androidx.compose.ui.layout.IntrinsicMeasurable) r6
            java.lang.Object r6 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r6)
            java.lang.String r7 = "Label"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0035
            goto L_0x0051
        L_0x0050:
            r4 = r5
        L_0x0051:
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            r2 = 0
            if (r4 == 0) goto L_0x0066
            java.lang.Integer r6 = java.lang.Integer.valueOf(r18)
            java.lang.Object r4 = r0.invoke(r4, r6)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r6 = r4
            goto L_0x0067
        L_0x0066:
            r6 = r2
        L_0x0067:
            java.util.Iterator r4 = r1.iterator()
        L_0x006b:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x0085
            java.lang.Object r7 = r4.next()
            r8 = r7
            androidx.compose.ui.layout.IntrinsicMeasurable r8 = (androidx.compose.ui.layout.IntrinsicMeasurable) r8
            java.lang.Object r8 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r8)
            java.lang.String r9 = "Trailing"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x006b
            goto L_0x0086
        L_0x0085:
            r7 = r5
        L_0x0086:
            androidx.compose.ui.layout.IntrinsicMeasurable r7 = (androidx.compose.ui.layout.IntrinsicMeasurable) r7
            if (r7 == 0) goto L_0x009a
            java.lang.Integer r4 = java.lang.Integer.valueOf(r18)
            java.lang.Object r4 = r0.invoke(r7, r4)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r7 = r4
            goto L_0x009b
        L_0x009a:
            r7 = r2
        L_0x009b:
            java.util.Iterator r4 = r1.iterator()
        L_0x009f:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x00b9
            java.lang.Object r8 = r4.next()
            r9 = r8
            androidx.compose.ui.layout.IntrinsicMeasurable r9 = (androidx.compose.ui.layout.IntrinsicMeasurable) r9
            java.lang.Object r9 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r9)
            java.lang.String r10 = "Leading"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x009f
            goto L_0x00ba
        L_0x00b9:
            r8 = r5
        L_0x00ba:
            androidx.compose.ui.layout.IntrinsicMeasurable r8 = (androidx.compose.ui.layout.IntrinsicMeasurable) r8
            if (r8 == 0) goto L_0x00ce
            java.lang.Integer r4 = java.lang.Integer.valueOf(r18)
            java.lang.Object r4 = r0.invoke(r8, r4)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r8 = r4
            goto L_0x00cf
        L_0x00ce:
            r8 = r2
        L_0x00cf:
            java.util.Iterator r4 = r1.iterator()
        L_0x00d3:
            boolean r9 = r4.hasNext()
            if (r9 == 0) goto L_0x00ed
            java.lang.Object r9 = r4.next()
            r10 = r9
            androidx.compose.ui.layout.IntrinsicMeasurable r10 = (androidx.compose.ui.layout.IntrinsicMeasurable) r10
            java.lang.Object r10 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r10)
            java.lang.String r11 = "Hint"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r10 == 0) goto L_0x00d3
            goto L_0x00ee
        L_0x00ed:
            r9 = r5
        L_0x00ee:
            androidx.compose.ui.layout.IntrinsicMeasurable r9 = (androidx.compose.ui.layout.IntrinsicMeasurable) r9
            if (r9 == 0) goto L_0x0102
            java.lang.Integer r4 = java.lang.Integer.valueOf(r18)
            java.lang.Object r4 = r0.invoke(r9, r4)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r9 = r4
            goto L_0x0103
        L_0x0102:
            r9 = r2
        L_0x0103:
            java.util.Iterator r1 = r1.iterator()
        L_0x0107:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0121
            java.lang.Object r4 = r1.next()
            r10 = r4
            androidx.compose.ui.layout.IntrinsicMeasurable r10 = (androidx.compose.ui.layout.IntrinsicMeasurable) r10
            java.lang.Object r10 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r10)
            java.lang.String r11 = "Supporting"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r10 == 0) goto L_0x0107
            r5 = r4
        L_0x0121:
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            if (r5 == 0) goto L_0x0134
            java.lang.Integer r1 = java.lang.Integer.valueOf(r18)
            java.lang.Object r0 = r0.invoke(r5, r1)
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            goto L_0x0135
        L_0x0134:
            r0 = r2
        L_0x0135:
            if (r6 <= 0) goto L_0x013a
            r1 = 1
            r4 = r1
            goto L_0x013b
        L_0x013a:
            r4 = r2
        L_0x013b:
            long r10 = androidx.compose.material3.TextFieldImplKt.getZeroConstraints()
            float r12 = r16.getDensity()
            r14 = r15
            androidx.compose.foundation.layout.PaddingValues r13 = r14.paddingValues
            r5 = r6
            r6 = r8
            r8 = r9
            r9 = r0
            int r0 = androidx.compose.material3.TextFieldKt.m1929calculateHeightjCXOeKk(r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            return r0
        L_0x014f:
            r14 = r15
            goto L_0x000a
        L_0x0152:
            r14 = r15
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            java.lang.String r1 = "Collection contains no element matching the predicate."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldMeasurePolicy.intrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope, java.util.List, int, kotlin.jvm.functions.Function2):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int intrinsicWidth(java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> r10, int r11, kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.IntrinsicMeasurable, ? super java.lang.Integer, java.lang.Integer> r12) {
        /*
            r9 = this;
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r0 = r10.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0107
            java.lang.Object r1 = r0.next()
            r2 = r1
            androidx.compose.ui.layout.IntrinsicMeasurable r2 = (androidx.compose.ui.layout.IntrinsicMeasurable) r2
            java.lang.Object r2 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r2)
            java.lang.String r3 = "TextField"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0006
            java.lang.Integer r0 = java.lang.Integer.valueOf(r11)
            java.lang.Object r0 = r12.invoke(r1, r0)
            java.lang.Number r0 = (java.lang.Number) r0
            int r3 = r0.intValue()
            java.util.Iterator r0 = r10.iterator()
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
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)
            java.lang.Object r1 = r12.invoke(r1, r4)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r4 = r1
            goto L_0x0063
        L_0x0062:
            r4 = r0
        L_0x0063:
            java.util.Iterator r1 = r10.iterator()
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
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            java.lang.Object r1 = r12.invoke(r5, r1)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r5 = r1
            goto L_0x0097
        L_0x0096:
            r5 = r0
        L_0x0097:
            java.util.Iterator r1 = r10.iterator()
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
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            java.lang.Object r1 = r12.invoke(r6, r1)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            goto L_0x00ca
        L_0x00c9:
            r1 = r0
        L_0x00ca:
            java.util.Iterator r10 = r10.iterator()
        L_0x00ce:
            boolean r6 = r10.hasNext()
            if (r6 == 0) goto L_0x00e8
            java.lang.Object r6 = r10.next()
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
            java.lang.Integer r10 = java.lang.Integer.valueOf(r11)
            java.lang.Object r10 = r12.invoke(r2, r10)
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            goto L_0x00fc
        L_0x00fb:
            r10 = r0
        L_0x00fc:
            long r6 = androidx.compose.material3.TextFieldImplKt.getZeroConstraints()
            r2 = r5
            r5 = r10
            int r10 = androidx.compose.material3.TextFieldKt.m1930calculateWidthVsPV1Ek(r1, r2, r3, r4, r5, r6)
            return r10
        L_0x0107:
            java.util.NoSuchElementException r10 = new java.util.NoSuchElementException
            java.lang.String r11 = "Collection contains no element matching the predicate."
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldMeasurePolicy.intrinsicWidth(java.util.List, int, kotlin.jvm.functions.Function2):int");
    }

    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, list, i11, TextFieldMeasurePolicy$maxIntrinsicHeight$1.INSTANCE);
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return intrinsicWidth(list, i11, TextFieldMeasurePolicy$maxIntrinsicWidth$1.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v7, resolved type: androidx.compose.ui.layout.Measurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v9, resolved type: androidx.compose.ui.layout.Measurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.ui.layout.MeasureResult m1931measure3p2s80s(@org.jetbrains.annotations.NotNull androidx.compose.ui.layout.MeasureScope r39, @org.jetbrains.annotations.NotNull java.util.List<? extends androidx.compose.ui.layout.Measurable> r40, long r41) {
        /*
            r38 = this;
            r15 = r38
            r14 = r39
            r0 = r40
            java.lang.String r1 = "$this$measure"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            java.lang.String r1 = "measurables"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            androidx.compose.foundation.layout.PaddingValues r1 = r15.paddingValues
            float r1 = r1.m499calculateTopPaddingD9Ej5fM()
            int r2 = r14.m5441roundToPx0680j_4(r1)
            androidx.compose.foundation.layout.PaddingValues r1 = r15.paddingValues
            float r1 = r1.m496calculateBottomPaddingD9Ej5fM()
            int r1 = r14.m5441roundToPx0680j_4(r1)
            float r3 = androidx.compose.material3.TextFieldKt.getTextFieldTopPadding()
            int r16 = r14.m5441roundToPx0680j_4(r3)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 10
            r10 = 0
            r3 = r41
            long r3 = androidx.compose.ui.unit.Constraints.m5413copyZbe2FdA$default(r3, r5, r6, r7, r8, r9, r10)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r5 = r0.iterator()
        L_0x003f:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0059
            java.lang.Object r6 = r5.next()
            r8 = r6
            androidx.compose.ui.layout.Measurable r8 = (androidx.compose.ui.layout.Measurable) r8
            java.lang.Object r8 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r8)
            java.lang.String r9 = "Leading"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x003f
            goto L_0x005a
        L_0x0059:
            r6 = 0
        L_0x005a:
            androidx.compose.ui.layout.Measurable r6 = (androidx.compose.ui.layout.Measurable) r6
            if (r6 == 0) goto L_0x0064
            androidx.compose.ui.layout.Placeable r5 = r6.m4508measureBRTryo0(r3)
            r8 = r5
            goto L_0x0065
        L_0x0064:
            r8 = 0
        L_0x0065:
            int r5 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r8)
            r6 = 0
            int r5 = r5 + r6
            int r9 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r8)
            int r9 = java.lang.Math.max(r6, r9)
            java.util.Iterator r10 = r0.iterator()
        L_0x0077:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0091
            java.lang.Object r11 = r10.next()
            r12 = r11
            androidx.compose.ui.layout.Measurable r12 = (androidx.compose.ui.layout.Measurable) r12
            java.lang.Object r12 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r12)
            java.lang.String r13 = "Trailing"
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 == 0) goto L_0x0077
            goto L_0x0092
        L_0x0091:
            r11 = 0
        L_0x0092:
            androidx.compose.ui.layout.Measurable r11 = (androidx.compose.ui.layout.Measurable) r11
            if (r11 == 0) goto L_0x00aa
            int r10 = -r5
            r20 = 0
            r21 = 2
            r22 = 0
            r17 = r3
            r19 = r10
            long r12 = androidx.compose.ui.unit.ConstraintsKt.m5439offsetNN6EwU$default(r17, r19, r20, r21, r22)
            androidx.compose.ui.layout.Placeable r10 = r11.m4508measureBRTryo0(r12)
            goto L_0x00ab
        L_0x00aa:
            r10 = 0
        L_0x00ab:
            int r11 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r10)
            int r5 = r5 + r11
            int r11 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r10)
            int r9 = java.lang.Math.max(r9, r11)
            int r11 = -r1
            int r5 = -r5
            long r11 = androidx.compose.ui.unit.ConstraintsKt.m5438offsetNN6EwU(r3, r5, r11)
            java.util.Iterator r13 = r0.iterator()
        L_0x00c2:
            boolean r17 = r13.hasNext()
            if (r17 == 0) goto L_0x00df
            java.lang.Object r17 = r13.next()
            r18 = r17
            androidx.compose.ui.layout.Measurable r18 = (androidx.compose.ui.layout.Measurable) r18
            java.lang.Object r6 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r18)
            java.lang.String r7 = "Label"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x00dd
            goto L_0x00e1
        L_0x00dd:
            r6 = 0
            goto L_0x00c2
        L_0x00df:
            r17 = 0
        L_0x00e1:
            r6 = r17
            androidx.compose.ui.layout.Measurable r6 = (androidx.compose.ui.layout.Measurable) r6
            if (r6 == 0) goto L_0x00ec
            androidx.compose.ui.layout.Placeable r6 = r6.m4508measureBRTryo0(r11)
            goto L_0x00ed
        L_0x00ec:
            r6 = 0
        L_0x00ed:
            if (r6 == 0) goto L_0x0101
            androidx.compose.ui.layout.HorizontalAlignmentLine r7 = androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline()
            int r7 = r6.get(r7)
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r7 == r11) goto L_0x00fc
            goto L_0x0102
        L_0x00fc:
            int r7 = r6.getHeight()
            goto L_0x0102
        L_0x0101:
            r7 = 0
        L_0x0102:
            int r13 = java.lang.Math.max(r7, r2)
            if (r6 == 0) goto L_0x010b
            int r11 = r13 + r16
            goto L_0x010c
        L_0x010b:
            r11 = r2
        L_0x010c:
            int r12 = -r11
            int r12 = r12 - r1
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 11
            r31 = 0
            r24 = r41
            r35 = r13
            long r13 = androidx.compose.ui.unit.Constraints.m5413copyZbe2FdA$default(r24, r26, r27, r28, r29, r30, r31)
            long r12 = androidx.compose.ui.unit.ConstraintsKt.m5438offsetNN6EwU(r13, r5, r12)
            java.util.Iterator r5 = r0.iterator()
        L_0x012a:
            boolean r14 = r5.hasNext()
            r36 = r7
            java.lang.String r7 = "Collection contains no element matching the predicate."
            if (r14 == 0) goto L_0x02ad
            java.lang.Object r14 = r5.next()
            androidx.compose.ui.layout.Measurable r14 = (androidx.compose.ui.layout.Measurable) r14
            r17 = r5
            java.lang.Object r5 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r14)
            r37 = r7
            java.lang.String r7 = "TextField"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
            if (r5 == 0) goto L_0x02a5
            androidx.compose.ui.layout.Placeable r7 = r14.m4508measureBRTryo0(r12)
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 14
            r31 = 0
            r24 = r12
            long r12 = androidx.compose.ui.unit.Constraints.m5413copyZbe2FdA$default(r24, r26, r27, r28, r29, r30, r31)
            java.util.Iterator r5 = r0.iterator()
        L_0x0164:
            boolean r14 = r5.hasNext()
            if (r14 == 0) goto L_0x0188
            java.lang.Object r14 = r5.next()
            r17 = r14
            androidx.compose.ui.layout.Measurable r17 = (androidx.compose.ui.layout.Measurable) r17
            r18 = r5
            java.lang.Object r5 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r17)
            r17 = r14
            java.lang.String r14 = "Hint"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r14)
            if (r5 == 0) goto L_0x0185
            r14 = r17
            goto L_0x0189
        L_0x0185:
            r5 = r18
            goto L_0x0164
        L_0x0188:
            r14 = 0
        L_0x0189:
            androidx.compose.ui.layout.Measurable r14 = (androidx.compose.ui.layout.Measurable) r14
            if (r14 == 0) goto L_0x0193
            androidx.compose.ui.layout.Placeable r5 = r14.m4508measureBRTryo0(r12)
            r12 = r5
            goto L_0x0194
        L_0x0193:
            r12 = 0
        L_0x0194:
            int r5 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r7)
            int r13 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r12)
            int r5 = java.lang.Math.max(r5, r13)
            int r5 = r5 + r11
            int r5 = r5 + r1
            int r1 = java.lang.Math.max(r9, r5)
            r19 = 0
            int r1 = -r1
            r21 = 1
            r22 = 0
            r17 = r3
            r20 = r1
            long r24 = androidx.compose.ui.unit.ConstraintsKt.m5439offsetNN6EwU$default(r17, r19, r20, r21, r22)
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 11
            r31 = 0
            long r3 = androidx.compose.ui.unit.Constraints.m5413copyZbe2FdA$default(r24, r26, r27, r28, r29, r30, r31)
            java.util.Iterator r1 = r0.iterator()
        L_0x01c9:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x01e3
            java.lang.Object r5 = r1.next()
            r9 = r5
            androidx.compose.ui.layout.Measurable r9 = (androidx.compose.ui.layout.Measurable) r9
            java.lang.Object r9 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r9)
            java.lang.String r11 = "Supporting"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r11)
            if (r9 == 0) goto L_0x01c9
            goto L_0x01e4
        L_0x01e3:
            r5 = 0
        L_0x01e4:
            androidx.compose.ui.layout.Measurable r5 = (androidx.compose.ui.layout.Measurable) r5
            if (r5 == 0) goto L_0x01ee
            androidx.compose.ui.layout.Placeable r1 = r5.m4508measureBRTryo0(r3)
            r11 = r1
            goto L_0x01ef
        L_0x01ee:
            r11 = 0
        L_0x01ef:
            int r1 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r11)
            int r17 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r8)
            int r18 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r10)
            int r19 = r7.getWidth()
            int r20 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r6)
            int r21 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r12)
            r22 = r41
            int r14 = androidx.compose.material3.TextFieldKt.m1930calculateWidthVsPV1Ek(r17, r18, r19, r20, r21, r22)
            int r24 = r7.getHeight()
            if (r6 == 0) goto L_0x0217
            r3 = 1
            r25 = r3
            goto L_0x0219
        L_0x0217:
            r25 = 0
        L_0x0219:
            int r27 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r8)
            int r28 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r10)
            int r29 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r12)
            int r30 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r11)
            float r33 = r39.getDensity()
            androidx.compose.foundation.layout.PaddingValues r3 = r15.paddingValues
            r26 = r35
            r31 = r41
            r34 = r3
            int r17 = androidx.compose.material3.TextFieldKt.m1929calculateHeightjCXOeKk(r24, r25, r26, r27, r28, r29, r30, r31, r33, r34)
            int r1 = r17 - r1
            java.util.Iterator r0 = r0.iterator()
        L_0x023f:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x029d
            java.lang.Object r3 = r0.next()
            androidx.compose.ui.layout.Measurable r3 = (androidx.compose.ui.layout.Measurable) r3
            java.lang.Object r4 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r3)
            java.lang.String r5 = "Container"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x029a
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r14 == r0) goto L_0x025e
            r4 = r14
            goto L_0x025f
        L_0x025e:
            r4 = 0
        L_0x025f:
            if (r1 == r0) goto L_0x0263
            r0 = r1
            goto L_0x0264
        L_0x0263:
            r0 = 0
        L_0x0264:
            long r0 = androidx.compose.ui.unit.ConstraintsKt.Constraints(r4, r14, r0, r1)
            androidx.compose.ui.layout.Placeable r13 = r3.m4508measureBRTryo0(r0)
            r18 = 0
            androidx.compose.material3.TextFieldMeasurePolicy$measure$1 r19 = new androidx.compose.material3.TextFieldMeasurePolicy$measure$1
            r0 = r19
            r1 = r6
            r3 = r36
            r4 = r14
            r5 = r17
            r6 = r7
            r7 = r12
            r9 = r10
            r10 = r13
            r12 = r38
            r13 = r35
            r20 = r14
            r14 = r16
            r15 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r5 = 4
            r6 = 0
            r0 = r39
            r1 = r20
            r2 = r17
            r3 = r18
            r4 = r19
            androidx.compose.ui.layout.MeasureResult r0 = androidx.compose.ui.layout.MeasureScope.CC.p(r0, r1, r2, r3, r4, r5, r6)
            return r0
        L_0x029a:
            r15 = r38
            goto L_0x023f
        L_0x029d:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r5 = r37
            r0.<init>(r5)
            throw r0
        L_0x02a5:
            r15 = r38
            r5 = r17
            r7 = r36
            goto L_0x012a
        L_0x02ad:
            r5 = r7
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldMeasurePolicy.m1931measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }

    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, list, i11, TextFieldMeasurePolicy$minIntrinsicHeight$1.INSTANCE);
    }

    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return intrinsicWidth(list, i11, TextFieldMeasurePolicy$minIntrinsicWidth$1.INSTANCE);
    }
}
