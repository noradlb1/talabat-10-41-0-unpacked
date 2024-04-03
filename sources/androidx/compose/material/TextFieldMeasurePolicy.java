package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J<\u0010\u0011\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\"\u0010\u0014\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u0015\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016J/\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u001f\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"Landroidx/compose/material/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicWidth", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int intrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope r12, java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> r13, int r14, kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.IntrinsicMeasurable, ? super java.lang.Integer, java.lang.Integer> r15) {
        /*
            r11 = this;
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r0 = r13.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0115
            java.lang.Object r1 = r0.next()
            r2 = r1
            androidx.compose.ui.layout.IntrinsicMeasurable r2 = (androidx.compose.ui.layout.IntrinsicMeasurable) r2
            java.lang.Object r2 = androidx.compose.material.TextFieldImplKt.getLayoutId(r2)
            java.lang.String r3 = "TextField"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0006
            java.lang.Integer r0 = java.lang.Integer.valueOf(r14)
            java.lang.Object r0 = r15.invoke(r1, r0)
            java.lang.Number r0 = (java.lang.Number) r0
            int r1 = r0.intValue()
            java.util.Iterator r0 = r13.iterator()
        L_0x0031:
            boolean r2 = r0.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x004c
            java.lang.Object r2 = r0.next()
            r4 = r2
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            java.lang.Object r4 = androidx.compose.material.TextFieldImplKt.getLayoutId(r4)
            java.lang.String r5 = "Label"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x0031
            goto L_0x004d
        L_0x004c:
            r2 = r3
        L_0x004d:
            androidx.compose.ui.layout.IntrinsicMeasurable r2 = (androidx.compose.ui.layout.IntrinsicMeasurable) r2
            r0 = 0
            if (r2 == 0) goto L_0x0062
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            java.lang.Object r2 = r15.invoke(r2, r4)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            r4 = r2
            goto L_0x0063
        L_0x0062:
            r4 = r0
        L_0x0063:
            java.util.Iterator r2 = r13.iterator()
        L_0x0067:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0081
            java.lang.Object r5 = r2.next()
            r6 = r5
            androidx.compose.ui.layout.IntrinsicMeasurable r6 = (androidx.compose.ui.layout.IntrinsicMeasurable) r6
            java.lang.Object r6 = androidx.compose.material.TextFieldImplKt.getLayoutId(r6)
            java.lang.String r7 = "Trailing"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0067
            goto L_0x0082
        L_0x0081:
            r5 = r3
        L_0x0082:
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            if (r5 == 0) goto L_0x0096
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)
            java.lang.Object r2 = r15.invoke(r5, r2)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            r5 = r2
            goto L_0x0097
        L_0x0096:
            r5 = r0
        L_0x0097:
            java.util.Iterator r2 = r13.iterator()
        L_0x009b:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x00b5
            java.lang.Object r6 = r2.next()
            r7 = r6
            androidx.compose.ui.layout.IntrinsicMeasurable r7 = (androidx.compose.ui.layout.IntrinsicMeasurable) r7
            java.lang.Object r7 = androidx.compose.material.TextFieldImplKt.getLayoutId(r7)
            java.lang.String r8 = "Leading"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x009b
            goto L_0x00b6
        L_0x00b5:
            r6 = r3
        L_0x00b6:
            androidx.compose.ui.layout.IntrinsicMeasurable r6 = (androidx.compose.ui.layout.IntrinsicMeasurable) r6
            if (r6 == 0) goto L_0x00ca
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)
            java.lang.Object r2 = r15.invoke(r6, r2)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            r6 = r2
            goto L_0x00cb
        L_0x00ca:
            r6 = r0
        L_0x00cb:
            java.util.Iterator r13 = r13.iterator()
        L_0x00cf:
            boolean r2 = r13.hasNext()
            if (r2 == 0) goto L_0x00e9
            java.lang.Object r2 = r13.next()
            r7 = r2
            androidx.compose.ui.layout.IntrinsicMeasurable r7 = (androidx.compose.ui.layout.IntrinsicMeasurable) r7
            java.lang.Object r7 = androidx.compose.material.TextFieldImplKt.getLayoutId(r7)
            java.lang.String r8 = "Hint"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x00cf
            r3 = r2
        L_0x00e9:
            androidx.compose.ui.layout.IntrinsicMeasurable r3 = (androidx.compose.ui.layout.IntrinsicMeasurable) r3
            if (r3 == 0) goto L_0x00fc
            java.lang.Integer r13 = java.lang.Integer.valueOf(r14)
            java.lang.Object r13 = r15.invoke(r3, r13)
            java.lang.Number r13 = (java.lang.Number) r13
            int r13 = r13.intValue()
            goto L_0x00fd
        L_0x00fc:
            r13 = r0
        L_0x00fd:
            if (r4 <= 0) goto L_0x0102
            r14 = 1
            r2 = r14
            goto L_0x0103
        L_0x0102:
            r2 = r0
        L_0x0103:
            long r7 = androidx.compose.material.TextFieldImplKt.getZeroConstraints()
            float r9 = r12.getDensity()
            androidx.compose.foundation.layout.PaddingValues r10 = r11.paddingValues
            r3 = r4
            r4 = r6
            r6 = r13
            int r12 = androidx.compose.material.TextFieldKt.m1452calculateHeightO3s9Psw(r1, r2, r3, r4, r5, r6, r7, r9, r10)
            return r12
        L_0x0115:
            java.util.NoSuchElementException r12 = new java.util.NoSuchElementException
            java.lang.String r13 = "Collection contains no element matching the predicate."
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldMeasurePolicy.intrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope, java.util.List, int, kotlin.jvm.functions.Function2):int");
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
            java.lang.Object r2 = androidx.compose.material.TextFieldImplKt.getLayoutId(r2)
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
            java.lang.Object r4 = androidx.compose.material.TextFieldImplKt.getLayoutId(r4)
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
            java.lang.Object r6 = androidx.compose.material.TextFieldImplKt.getLayoutId(r6)
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
            java.lang.Object r7 = androidx.compose.material.TextFieldImplKt.getLayoutId(r7)
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
            java.lang.Object r7 = androidx.compose.material.TextFieldImplKt.getLayoutId(r7)
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
            long r6 = androidx.compose.material.TextFieldImplKt.getZeroConstraints()
            r2 = r5
            r5 = r10
            int r10 = androidx.compose.material.TextFieldKt.m1453calculateWidthVsPV1Ek(r1, r2, r3, r4, r5, r6)
            return r10
        L_0x0107:
            java.util.NoSuchElementException r10 = new java.util.NoSuchElementException
            java.lang.String r11 = "Collection contains no element matching the predicate."
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldMeasurePolicy.intrinsicWidth(java.util.List, int, kotlin.jvm.functions.Function2):int");
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

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m1454measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        Object obj;
        Placeable placeable;
        Object obj2;
        Placeable placeable2;
        Object obj3;
        Placeable placeable3;
        int i11;
        int i12;
        Object obj4;
        Placeable placeable4;
        boolean z11;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        Intrinsics.checkNotNullParameter(measureScope2, "$this$measure");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        int r22 = measureScope2.m5441roundToPx0680j_4(this.paddingValues.m499calculateTopPaddingD9Ej5fM());
        int r12 = measureScope2.m5441roundToPx0680j_4(this.paddingValues.m496calculateBottomPaddingD9Ej5fM());
        int r122 = measureScope2.m5441roundToPx0680j_4(TextFieldKt.getTextFieldTopPadding());
        long r32 = Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, 0, 10, (Object) null);
        Iterable<Measurable> iterable = list2;
        Iterator it = iterable.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), (Object) "Leading")) {
                break;
            }
        }
        Measurable measurable = (Measurable) obj;
        if (measurable != null) {
            placeable = measurable.m4508measureBRTryo0(r32);
        } else {
            placeable = null;
        }
        int widthOrZero = TextFieldImplKt.widthOrZero(placeable) + 0;
        Iterator it2 = iterable.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it2.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj2), (Object) "Trailing")) {
                break;
            }
        }
        Measurable measurable2 = (Measurable) obj2;
        if (measurable2 != null) {
            placeable2 = measurable2.m4508measureBRTryo0(ConstraintsKt.m5439offsetNN6EwU$default(r32, -widthOrZero, 0, 2, (Object) null));
        } else {
            placeable2 = null;
        }
        int i13 = -r12;
        int i14 = -(widthOrZero + TextFieldImplKt.widthOrZero(placeable2));
        long r33 = ConstraintsKt.m5438offsetNN6EwU(r32, i14, i13);
        Iterator it3 = iterable.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it3.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj3), (Object) "Label")) {
                break;
            }
        }
        Measurable measurable3 = (Measurable) obj3;
        if (measurable3 != null) {
            placeable3 = measurable3.m4508measureBRTryo0(r33);
        } else {
            placeable3 = null;
        }
        if (placeable3 != null) {
            i11 = placeable3.get(AlignmentLineKt.getLastBaseline());
            if (i11 == Integer.MIN_VALUE) {
                i11 = placeable3.getHeight();
            }
        } else {
            i11 = 0;
        }
        int max = Math.max(i11, r22);
        if (placeable3 != null) {
            i12 = (i13 - r122) - max;
        } else {
            i12 = (-r22) - r12;
        }
        int i15 = r122;
        long r52 = ConstraintsKt.m5438offsetNN6EwU(Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, 0, 11, (Object) null), i14, i12);
        for (Measurable measurable4 : iterable) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), (Object) "TextField")) {
                Placeable r72 = measurable4.m4508measureBRTryo0(r52);
                long r53 = Constraints.m5413copyZbe2FdA$default(r52, 0, 0, 0, 0, 14, (Object) null);
                Iterator it4 = iterable.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        obj4 = null;
                        break;
                    }
                    obj4 = it4.next();
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj4), (Object) "Hint")) {
                        break;
                    }
                }
                Measurable measurable5 = (Measurable) obj4;
                if (measurable5 != null) {
                    placeable4 = measurable5.m4508measureBRTryo0(r53);
                } else {
                    placeable4 = null;
                }
                int r28 = TextFieldKt.m1453calculateWidthVsPV1Ek(TextFieldImplKt.widthOrZero(placeable), TextFieldImplKt.widthOrZero(placeable2), r72.getWidth(), TextFieldImplKt.widthOrZero(placeable3), TextFieldImplKt.widthOrZero(placeable4), j11);
                int height = r72.getHeight();
                if (placeable3 != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                int r16 = TextFieldKt.m1452calculateHeightO3s9Psw(height, z11, max, TextFieldImplKt.heightOrZero(placeable), TextFieldImplKt.heightOrZero(placeable2), TextFieldImplKt.heightOrZero(placeable4), j11, measureScope.getDensity(), this.paddingValues);
                return MeasureScope.CC.p(measureScope, r28, r16, (Map) null, new TextFieldMeasurePolicy$measure$1(placeable3, r22, i11, r28, r16, r72, placeable4, placeable, placeable2, this, max, i15, measureScope), 4, (Object) null);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
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
