package androidx.compose.ui.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Landroidx/compose/ui/layout/RootMeasurePolicy;", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RootMeasurePolicy extends LayoutNode.NoIntrinsicsMeasurePolicy {
    @NotNull
    public static final RootMeasurePolicy INSTANCE = new RootMeasurePolicy();

    private RootMeasurePolicy() {
        super("Undefined intrinsics block and it is required");
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m4539measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(list, "measurables");
        if (list.isEmpty()) {
            return MeasureScope.CC.p(measureScope, Constraints.m5424getMinWidthimpl(j11), Constraints.m5423getMinHeightimpl(j11), (Map) null, RootMeasurePolicy$measure$1.INSTANCE, 4, (Object) null);
        }
        if (list.size() == 1) {
            Placeable r13 = ((Measurable) list.get(0)).m4508measureBRTryo0(j11);
            return MeasureScope.CC.p(measureScope, ConstraintsKt.m5436constrainWidthK40F9xA(j11, r13.getWidth()), ConstraintsKt.m5435constrainHeightK40F9xA(j11, r13.getHeight()), (Map) null, new RootMeasurePolicy$measure$2(r13), 4, (Object) null);
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(((Measurable) list.get(i11)).m4508measureBRTryo0(j11));
        }
        int size2 = arrayList.size();
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < size2; i14++) {
            Placeable placeable = (Placeable) arrayList.get(i14);
            i12 = Math.max(placeable.getWidth(), i12);
            i13 = Math.max(placeable.getHeight(), i13);
        }
        return MeasureScope.CC.p(measureScope, ConstraintsKt.m5436constrainWidthK40F9xA(j11, i12), ConstraintsKt.m5435constrainHeightK40F9xA(j11, i13), (Map) null, new RootMeasurePolicy$measure$4(arrayList), 4, (Object) null);
    }
}
