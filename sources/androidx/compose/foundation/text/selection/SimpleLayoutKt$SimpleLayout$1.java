package androidx.compose.foundation.text.selection;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import j0.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SimpleLayoutKt$SimpleLayout$1 implements MeasurePolicy {
    public static final SimpleLayoutKt$SimpleLayout$1 INSTANCE = new SimpleLayoutKt$SimpleLayout$1();

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.a(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.b(this, intrinsicMeasureScope, list, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1040measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        Integer num = 0;
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(((Measurable) list.get(i11)).m4508measureBRTryo0(j11));
        }
        int size2 = arrayList.size();
        Integer num2 = num;
        for (int i12 = 0; i12 < size2; i12++) {
            num2 = Integer.valueOf(Math.max(num2.intValue(), ((Placeable) arrayList.get(i12)).getWidth()));
        }
        int intValue = num2.intValue();
        int size3 = arrayList.size();
        for (int i13 = 0; i13 < size3; i13++) {
            num = Integer.valueOf(Math.max(num.intValue(), ((Placeable) arrayList.get(i13)).getHeight()));
        }
        return MeasureScope.CC.p(measureScope, intValue, num.intValue(), (Map) null, new SimpleLayoutKt$SimpleLayout$1$measure$1(arrayList), 4, (Object) null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.c(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.d(this, intrinsicMeasureScope, list, i11);
    }
}
