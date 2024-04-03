package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import j0.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ListItemKt$BaselinesOffsetColumn$1 implements MeasurePolicy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List<Dp> f4627a;

    public ListItemKt$BaselinesOffsetColumn$1(List<Dp> list) {
        this.f4627a = list;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.a(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.b(this, intrinsicMeasureScope, list, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1283measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        int i11;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        long r12 = Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, Integer.MAX_VALUE, 3, (Object) null);
        Iterable<Measurable> iterable = list;
        ArrayList<Placeable> arrayList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Measurable r13 : iterable) {
            arrayList.add(r13.m4508measureBRTryo0(r12));
        }
        int i12 = 0;
        for (Placeable width : arrayList) {
            i12 = Math.max(i12, width.getWidth());
        }
        int size = arrayList.size();
        Integer[] numArr = new Integer[size];
        for (int i13 = 0; i13 < size; i13++) {
            numArr[i13] = 0;
        }
        List<Dp> list2 = this.f4627a;
        int size2 = arrayList.size();
        int i14 = 0;
        for (int i15 = 0; i15 < size2; i15++) {
            Placeable placeable = (Placeable) arrayList.get(i15);
            if (i15 > 0) {
                int i16 = i15 - 1;
                i11 = ((Placeable) arrayList.get(i16)).getHeight() - ((Placeable) arrayList.get(i16)).get(AlignmentLineKt.getLastBaseline());
            } else {
                i11 = 0;
            }
            int max = Math.max(0, (measureScope.m5441roundToPx0680j_4(list2.get(i15).m5492unboximpl()) - placeable.get(AlignmentLineKt.getFirstBaseline())) - i11);
            numArr[i15] = Integer.valueOf(max + i14);
            i14 += max + placeable.getHeight();
        }
        return MeasureScope.CC.p(measureScope, i12, i14, (Map) null, new ListItemKt$BaselinesOffsetColumn$1$measure$2(arrayList, numArr), 4, (Object) null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.c(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.d(this, intrinsicMeasureScope, list, i11);
    }
}
