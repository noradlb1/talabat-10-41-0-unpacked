package j0;

import androidx.compose.ui.layout.DefaultIntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.IntrinsicMinMax;
import androidx.compose.ui.layout.IntrinsicWidthHeight;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class d {
    public static int a(MeasurePolicy measurePolicy, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            arrayList.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) list.get(i12), IntrinsicMinMax.Max, IntrinsicWidthHeight.Height));
        }
        return measurePolicy.m4509measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, i11, 0, 0, 13, (Object) null)).getHeight();
    }

    public static int b(MeasurePolicy measurePolicy, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            arrayList.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) list.get(i12), IntrinsicMinMax.Max, IntrinsicWidthHeight.Width));
        }
        return measurePolicy.m4509measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, 0, 0, i11, 7, (Object) null)).getWidth();
    }

    public static int c(MeasurePolicy measurePolicy, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            arrayList.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) list.get(i12), IntrinsicMinMax.Min, IntrinsicWidthHeight.Height));
        }
        return measurePolicy.m4509measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, i11, 0, 0, 13, (Object) null)).getHeight();
    }

    public static int d(MeasurePolicy measurePolicy, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            arrayList.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) list.get(i12), IntrinsicMinMax.Min, IntrinsicWidthHeight.Width));
        }
        return measurePolicy.m4509measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, 0, 0, i11, 7, (Object) null)).getWidth();
    }
}
