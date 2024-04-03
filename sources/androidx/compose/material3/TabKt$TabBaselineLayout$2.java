package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import j0.d;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TabKt$TabBaselineLayout$2 implements MeasurePolicy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8558a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8559b;

    public TabKt$TabBaselineLayout$2(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22) {
        this.f8558a = function2;
        this.f8559b = function22;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.a(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.b(this, intrinsicMeasureScope, list, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1887measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        Placeable placeable;
        Placeable placeable2;
        int i11;
        int i12;
        float f11;
        int i13;
        Integer num;
        Integer num2;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        Intrinsics.checkNotNullParameter(measureScope2, "$this$Layout");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        if (this.f8558a != null) {
            for (Measurable measurable : list2) {
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), (Object) "text")) {
                    placeable = measurable.m4508measureBRTryo0(Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, 0, 11, (Object) null));
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        placeable = null;
        if (this.f8559b != null) {
            for (Measurable measurable2 : list2) {
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), (Object) "icon")) {
                    placeable2 = measurable2.m4508measureBRTryo0(j11);
                } else {
                    long j12 = j11;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        placeable2 = null;
        int i14 = 0;
        if (placeable != null) {
            i11 = placeable.getWidth();
        } else {
            i11 = 0;
        }
        if (placeable2 != null) {
            i12 = placeable2.getWidth();
        } else {
            i12 = 0;
        }
        int max = Math.max(i11, i12);
        if (placeable == null || placeable2 == null) {
            f11 = TabKt.SmallTabHeight;
        } else {
            f11 = TabKt.LargeTabHeight;
        }
        int r52 = measureScope2.m5441roundToPx0680j_4(f11);
        if (placeable2 != null) {
            i13 = placeable2.getHeight();
        } else {
            i13 = 0;
        }
        if (placeable != null) {
            i14 = placeable.getHeight();
        }
        int max2 = Math.max(r52, i13 + i14 + measureScope2.m5440roundToPxR2X_6o(TabKt.IconDistanceFromBaseline));
        if (placeable != null) {
            num = Integer.valueOf(placeable.get(AlignmentLineKt.getFirstBaseline()));
        } else {
            num = null;
        }
        if (placeable != null) {
            num2 = Integer.valueOf(placeable.get(AlignmentLineKt.getLastBaseline()));
        } else {
            num2 = null;
        }
        return MeasureScope.CC.p(measureScope, max, max2, (Map) null, new TabKt$TabBaselineLayout$2$measure$1(placeable, placeable2, measureScope, max, max2, num, num2), 4, (Object) null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.c(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.d(this, intrinsicMeasureScope, list, i11);
    }
}
