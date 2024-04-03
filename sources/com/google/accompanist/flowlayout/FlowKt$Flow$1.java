package com.google.accompanist.flowlayout;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import j0.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class FlowKt$Flow$1 implements MeasurePolicy {
    final /* synthetic */ FlowCrossAxisAlignment $crossAxisAlignment;
    final /* synthetic */ float $crossAxisSpacing;
    final /* synthetic */ MainAxisAlignment $lastLineMainAxisAlignment;
    final /* synthetic */ MainAxisAlignment $mainAxisAlignment;
    final /* synthetic */ SizeMode $mainAxisSize;
    final /* synthetic */ float $mainAxisSpacing;
    final /* synthetic */ LayoutOrientation $orientation;

    public FlowKt$Flow$1(LayoutOrientation layoutOrientation, float f11, SizeMode sizeMode, float f12, MainAxisAlignment mainAxisAlignment, MainAxisAlignment mainAxisAlignment2, FlowCrossAxisAlignment flowCrossAxisAlignment) {
        this.$orientation = layoutOrientation;
        this.$mainAxisSpacing = f11;
        this.$mainAxisSize = sizeMode;
        this.$crossAxisSpacing = f12;
        this.$mainAxisAlignment = mainAxisAlignment;
        this.$lastLineMainAxisAlignment = mainAxisAlignment2;
        this.$crossAxisAlignment = flowCrossAxisAlignment;
    }

    private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref.IntRef intRef, MeasureScope measureScope, float f11, OrientationIndependentConstraints orientationIndependentConstraints, LayoutOrientation layoutOrientation, Placeable placeable) {
        if (list.isEmpty() || intRef.element + measureScope.m5441roundToPx0680j_4(f11) + FlowKt.Flow_F4y8cZ0$mainAxisSize(placeable, layoutOrientation) <= orientationIndependentConstraints.getMainAxisMax()) {
            return true;
        }
        return false;
    }

    private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, Ref.IntRef intRef, MeasureScope measureScope, float f11, List<Placeable> list2, List<Integer> list3, Ref.IntRef intRef2, List<Integer> list4, Ref.IntRef intRef3, Ref.IntRef intRef4) {
        Collection collection = list;
        if (!collection.isEmpty()) {
            intRef.element += measureScope.m5441roundToPx0680j_4(f11);
        }
        collection.add(CollectionsKt___CollectionsKt.toList(list2));
        list3.add(Integer.valueOf(intRef2.element));
        list4.add(Integer.valueOf(intRef.element));
        intRef.element += intRef2.element;
        intRef3.element = Math.max(intRef3.element, intRef4.element);
        list2.clear();
        intRef4.element = 0;
        intRef2.element = 0;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.a(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.b(this, intrinsicMeasureScope, list, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m9018measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        long j12;
        int i11;
        int i12;
        int i13;
        Ref.IntRef intRef;
        Ref.IntRef intRef2;
        ArrayList arrayList;
        MeasureScope measureScope2 = measureScope;
        Intrinsics.checkNotNullParameter(measureScope2, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Ref.IntRef intRef3 = new Ref.IntRef();
        Ref.IntRef intRef4 = new Ref.IntRef();
        ArrayList arrayList5 = new ArrayList();
        Ref.IntRef intRef5 = new Ref.IntRef();
        Ref.IntRef intRef6 = new Ref.IntRef();
        OrientationIndependentConstraints orientationIndependentConstraints = new OrientationIndependentConstraints(j11, this.$orientation, (DefaultConstructorMarker) null);
        if (this.$orientation == LayoutOrientation.Horizontal) {
            j12 = ConstraintsKt.Constraints$default(0, orientationIndependentConstraints.getMainAxisMax(), 0, 0, 13, (Object) null);
        } else {
            j12 = ConstraintsKt.Constraints$default(0, 0, 0, orientationIndependentConstraints.getMainAxisMax(), 7, (Object) null);
        }
        long j13 = j12;
        for (Measurable r12 : list) {
            Placeable r32 = r12.m4508measureBRTryo0(j13);
            Placeable placeable = r32;
            long j14 = j13;
            OrientationIndependentConstraints orientationIndependentConstraints2 = orientationIndependentConstraints;
            Ref.IntRef intRef7 = intRef6;
            if (!measure_3p2s80s$canAddToCurrentSequence(arrayList5, intRef5, measureScope, this.$mainAxisSpacing, orientationIndependentConstraints, this.$orientation, placeable)) {
                intRef = intRef5;
                arrayList = arrayList5;
                intRef2 = intRef4;
                measure_3p2s80s$startNewSequence(arrayList2, intRef4, measureScope, this.$crossAxisSpacing, arrayList5, arrayList3, intRef7, arrayList4, intRef3, intRef);
            } else {
                intRef = intRef5;
                arrayList = arrayList5;
                intRef2 = intRef4;
            }
            Ref.IntRef intRef8 = intRef;
            if (!arrayList.isEmpty()) {
                intRef8.element += measureScope2.m5441roundToPx0680j_4(this.$mainAxisSpacing);
            }
            Placeable placeable2 = placeable;
            ArrayList arrayList6 = arrayList;
            arrayList6.add(placeable2);
            intRef8.element += FlowKt.Flow_F4y8cZ0$mainAxisSize(placeable2, this.$orientation);
            intRef6 = intRef7;
            intRef6.element = Math.max(intRef6.element, FlowKt.Flow_F4y8cZ0$crossAxisSize(placeable2, this.$orientation));
            arrayList5 = arrayList6;
            intRef5 = intRef8;
            orientationIndependentConstraints = orientationIndependentConstraints2;
            j13 = j14;
            intRef4 = intRef2;
        }
        OrientationIndependentConstraints orientationIndependentConstraints3 = orientationIndependentConstraints;
        ArrayList arrayList7 = arrayList5;
        Ref.IntRef intRef9 = intRef4;
        Ref.IntRef intRef10 = intRef5;
        if (!arrayList7.isEmpty()) {
            measure_3p2s80s$startNewSequence(arrayList2, intRef9, measureScope, this.$crossAxisSpacing, arrayList7, arrayList3, intRef6, arrayList4, intRef3, intRef10);
        }
        if (orientationIndependentConstraints3.getMainAxisMax() == Integer.MAX_VALUE || this.$mainAxisSize != SizeMode.Expand) {
            i11 = Math.max(intRef3.element, orientationIndependentConstraints3.getMainAxisMin());
        } else {
            i11 = orientationIndependentConstraints3.getMainAxisMax();
        }
        int i14 = i11;
        int max = Math.max(intRef9.element, orientationIndependentConstraints3.getCrossAxisMin());
        LayoutOrientation layoutOrientation = this.$orientation;
        LayoutOrientation layoutOrientation2 = LayoutOrientation.Horizontal;
        if (layoutOrientation == layoutOrientation2) {
            i12 = i14;
        } else {
            i12 = max;
        }
        if (layoutOrientation == layoutOrientation2) {
            i13 = max;
        } else {
            i13 = i14;
        }
        return MeasureScope.CC.p(measureScope, i12, i13, (Map) null, new FlowKt$Flow$1$measure$1(arrayList2, measureScope, this.$mainAxisSpacing, this.$mainAxisAlignment, this.$lastLineMainAxisAlignment, layoutOrientation, i14, this.$crossAxisAlignment, arrayList3, arrayList4), 4, (Object) null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.c(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.d(this, intrinsicMeasureScope, list, i11);
    }
}
