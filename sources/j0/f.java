package j0;

import androidx.compose.ui.layout.DefaultIntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.IntrinsicMinMax;
import androidx.compose.ui.layout.IntrinsicWidthHeight;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class f {
    public static int a(MultiContentMeasurePolicy multiContentMeasurePolicy, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            List list2 = (List) list.get(i12);
            ArrayList arrayList2 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i13 = 0; i13 < size2; i13++) {
                arrayList2.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) list2.get(i13), IntrinsicMinMax.Max, IntrinsicWidthHeight.Height));
            }
            arrayList.add(arrayList2);
        }
        return multiContentMeasurePolicy.m4523measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, i11, 0, 0, 13, (Object) null)).getHeight();
    }

    public static int b(MultiContentMeasurePolicy multiContentMeasurePolicy, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            List list2 = (List) list.get(i12);
            ArrayList arrayList2 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i13 = 0; i13 < size2; i13++) {
                arrayList2.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) list2.get(i13), IntrinsicMinMax.Max, IntrinsicWidthHeight.Width));
            }
            arrayList.add(arrayList2);
        }
        return multiContentMeasurePolicy.m4523measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, 0, 0, i11, 7, (Object) null)).getWidth();
    }

    public static int c(MultiContentMeasurePolicy multiContentMeasurePolicy, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            List list2 = (List) list.get(i12);
            ArrayList arrayList2 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i13 = 0; i13 < size2; i13++) {
                arrayList2.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) list2.get(i13), IntrinsicMinMax.Min, IntrinsicWidthHeight.Height));
            }
            arrayList.add(arrayList2);
        }
        return multiContentMeasurePolicy.m4523measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, i11, 0, 0, 13, (Object) null)).getHeight();
    }

    public static int d(MultiContentMeasurePolicy multiContentMeasurePolicy, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            List list2 = (List) list.get(i12);
            ArrayList arrayList2 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i13 = 0; i13 < size2; i13++) {
                arrayList2.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) list2.get(i13), IntrinsicMinMax.Min, IntrinsicWidthHeight.Width));
            }
            arrayList.add(arrayList2);
        }
        return multiContentMeasurePolicy.m4523measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, 0, 0, i11, 7, (Object) null)).getWidth();
    }
}
