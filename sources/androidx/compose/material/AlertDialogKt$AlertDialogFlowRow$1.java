package androidx.compose.material;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import j0.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AlertDialogKt$AlertDialogFlowRow$1 implements MeasurePolicy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f3806a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f3807b;

    public AlertDialogKt$AlertDialogFlowRow$1(float f11, float f12) {
        this.f3806a = f11;
        this.f3807b = f12;
    }

    private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref.IntRef intRef, MeasureScope measureScope, float f11, long j11, Placeable placeable) {
        if (list.isEmpty() || intRef.element + measureScope.m5441roundToPx0680j_4(f11) + placeable.getWidth() <= Constraints.m5422getMaxWidthimpl(j11)) {
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
    public final MeasureResult m1078measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        int i11;
        Ref.IntRef intRef;
        ArrayList arrayList;
        Ref.IntRef intRef2;
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
        long Constraints$default = ConstraintsKt.Constraints$default(0, Constraints.m5422getMaxWidthimpl(j11), 0, 0, 13, (Object) null);
        for (Measurable r12 : list) {
            Placeable r25 = r12.m4508measureBRTryo0(Constraints$default);
            long j12 = Constraints$default;
            Ref.IntRef intRef7 = intRef6;
            if (!measure_3p2s80s$canAddToCurrentSequence(arrayList5, intRef5, measureScope, this.f3806a, j11, r25)) {
                intRef2 = intRef5;
                arrayList = arrayList5;
                intRef = intRef4;
                measure_3p2s80s$startNewSequence(arrayList2, intRef4, measureScope, this.f3807b, arrayList5, arrayList3, intRef7, arrayList4, intRef3, intRef2);
            } else {
                intRef2 = intRef5;
                arrayList = arrayList5;
                intRef = intRef4;
            }
            Ref.IntRef intRef8 = intRef2;
            if (!arrayList.isEmpty()) {
                intRef8.element += measureScope2.m5441roundToPx0680j_4(this.f3806a);
            }
            Placeable placeable = r25;
            ArrayList arrayList6 = arrayList;
            arrayList6.add(placeable);
            intRef8.element += placeable.getWidth();
            intRef6 = intRef7;
            intRef6.element = Math.max(intRef6.element, placeable.getHeight());
            arrayList5 = arrayList6;
            intRef5 = intRef8;
            Constraints$default = j12;
            intRef4 = intRef;
        }
        ArrayList arrayList7 = arrayList5;
        Ref.IntRef intRef9 = intRef4;
        Ref.IntRef intRef10 = intRef5;
        if (!arrayList7.isEmpty()) {
            measure_3p2s80s$startNewSequence(arrayList2, intRef9, measureScope, this.f3807b, arrayList7, arrayList3, intRef6, arrayList4, intRef3, intRef10);
        }
        if (Constraints.m5422getMaxWidthimpl(j11) != Integer.MAX_VALUE) {
            i11 = Constraints.m5422getMaxWidthimpl(j11);
        } else {
            i11 = Math.max(intRef3.element, Constraints.m5424getMinWidthimpl(j11));
        }
        int i12 = i11;
        return MeasureScope.CC.p(measureScope, i12, Math.max(intRef9.element, Constraints.m5423getMinHeightimpl(j11)), (Map) null, new AlertDialogKt$AlertDialogFlowRow$1$measure$1(arrayList2, measureScope, this.f3806a, i12, arrayList4), 4, (Object) null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.c(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.d(this, intrinsicMeasureScope, list, i11);
    }
}
