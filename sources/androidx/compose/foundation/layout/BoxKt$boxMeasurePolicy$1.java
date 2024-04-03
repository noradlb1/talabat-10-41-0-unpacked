package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import j0.d;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\n"}, d2 = {"Landroidx/compose/ui/layout/MeasureScope;", "", "Landroidx/compose/ui/layout/Measurable;", "measurables", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class BoxKt$boxMeasurePolicy$1 implements MeasurePolicy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f2450a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Alignment f2451b;

    public BoxKt$boxMeasurePolicy$1(boolean z11, Alignment alignment) {
        this.f2450a = z11;
        this.f2451b = alignment;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.a(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.b(this, intrinsicMeasureScope, list, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m432measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        long j12;
        int i11;
        int i12;
        int i13;
        Placeable placeable;
        int i14;
        List<? extends Measurable> list2 = list;
        Intrinsics.checkNotNullParameter(measureScope, "$this$MeasurePolicy");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        if (list.isEmpty()) {
            return MeasureScope.CC.p(measureScope, Constraints.m5424getMinWidthimpl(j11), Constraints.m5423getMinHeightimpl(j11), (Map) null, BoxKt$boxMeasurePolicy$1$measure$1.INSTANCE, 4, (Object) null);
        }
        if (this.f2450a) {
            j12 = j11;
        } else {
            j12 = Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, 0, 10, (Object) null);
        }
        if (list.size() == 1) {
            Measurable measurable = (Measurable) list2.get(0);
            if (!BoxKt.getMatchesParentSize(measurable)) {
                Placeable r12 = measurable.m4508measureBRTryo0(j12);
                int max = Math.max(Constraints.m5424getMinWidthimpl(j11), r12.getWidth());
                i13 = Math.max(Constraints.m5423getMinHeightimpl(j11), r12.getHeight());
                placeable = r12;
                i14 = max;
            } else {
                i14 = Constraints.m5424getMinWidthimpl(j11);
                int r22 = Constraints.m5423getMinHeightimpl(j11);
                placeable = measurable.m4508measureBRTryo0(Constraints.Companion.m5430fixedJhjzzOo(Constraints.m5424getMinWidthimpl(j11), Constraints.m5423getMinHeightimpl(j11)));
                i13 = r22;
            }
            return MeasureScope.CC.p(measureScope, i14, i13, (Map) null, new BoxKt$boxMeasurePolicy$1$measure$2(placeable, measurable, measureScope, i14, i13, this.f2451b), 4, (Object) null);
        }
        Placeable[] placeableArr = new Placeable[list.size()];
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = Constraints.m5424getMinWidthimpl(j11);
        Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = Constraints.m5423getMinHeightimpl(j11);
        int size = list.size();
        boolean z11 = false;
        for (int i15 = 0; i15 < size; i15++) {
            Measurable measurable2 = (Measurable) list2.get(i15);
            if (!BoxKt.getMatchesParentSize(measurable2)) {
                Placeable r13 = measurable2.m4508measureBRTryo0(j12);
                placeableArr[i15] = r13;
                intRef.element = Math.max(intRef.element, r13.getWidth());
                intRef2.element = Math.max(intRef2.element, r13.getHeight());
            } else {
                z11 = true;
            }
        }
        if (z11) {
            int i16 = intRef.element;
            if (i16 != Integer.MAX_VALUE) {
                i11 = i16;
            } else {
                i11 = 0;
            }
            int i17 = intRef2.element;
            if (i17 != Integer.MAX_VALUE) {
                i12 = i17;
            } else {
                i12 = 0;
            }
            long Constraints = ConstraintsKt.Constraints(i11, i16, i12, i17);
            int size2 = list.size();
            for (int i18 = 0; i18 < size2; i18++) {
                Measurable measurable3 = (Measurable) list2.get(i18);
                if (BoxKt.getMatchesParentSize(measurable3)) {
                    placeableArr[i18] = measurable3.m4508measureBRTryo0(Constraints);
                }
            }
        }
        return MeasureScope.CC.p(measureScope, intRef.element, intRef2.element, (Map) null, new BoxKt$boxMeasurePolicy$1$measure$5(placeableArr, list, measureScope, intRef, intRef2, this.f2451b), 4, (Object) null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.c(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.d(this, intrinsicMeasureScope, list, i11);
    }
}
