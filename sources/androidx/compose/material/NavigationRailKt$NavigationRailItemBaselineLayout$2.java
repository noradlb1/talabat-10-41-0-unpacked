package androidx.compose.material;

import androidx.compose.runtime.Composer;
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
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavigationRailKt$NavigationRailItemBaselineLayout$2 implements MeasurePolicy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4794a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f4795b;

    public NavigationRailKt$NavigationRailItemBaselineLayout$2(Function2<? super Composer, ? super Integer, Unit> function2, float f11) {
        this.f4794a = function2;
        this.f4795b = f11;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.a(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.b(this, intrinsicMeasureScope, list, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1315measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        Placeable placeable;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        long j12 = j11;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        Iterable<Measurable> iterable = list2;
        for (Measurable measurable : iterable) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), (Object) "icon")) {
                Placeable r12 = measurable.m4508measureBRTryo0(j12);
                if (this.f4794a != null) {
                    for (Measurable measurable2 : iterable) {
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), (Object) "label")) {
                            placeable = measurable2.m4508measureBRTryo0(Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, 0, 11, (Object) null));
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                placeable = null;
                if (this.f4794a == null) {
                    return NavigationRailKt.m1313placeIcon3p2s80s(measureScope, r12, j12);
                }
                Intrinsics.checkNotNull(placeable);
                return NavigationRailKt.m1314placeLabelAndIconDIyivk0(measureScope, placeable, r12, j11, this.f4795b);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.c(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.d(this, intrinsicMeasureScope, list, i11);
    }
}
