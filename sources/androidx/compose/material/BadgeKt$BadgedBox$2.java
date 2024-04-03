package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import com.huawei.hms.flutter.map.constants.Param;
import j0.d;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BadgeKt$BadgedBox$2 implements MeasurePolicy {
    public static final BadgeKt$BadgedBox$2 INSTANCE = new BadgeKt$BadgedBox$2();

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.a(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.b(this, intrinsicMeasureScope, list, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1104measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        Iterable<Measurable> iterable = list2;
        for (Measurable measurable : iterable) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), (Object) "badge")) {
                Placeable r22 = measurable.m4508measureBRTryo0(Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, 0, 11, (Object) null));
                for (Measurable measurable2 : iterable) {
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), (Object) Param.ANCHOR)) {
                        Placeable r12 = measurable2.m4508measureBRTryo0(j11);
                        int i11 = r12.get(AlignmentLineKt.getFirstBaseline());
                        int i12 = r12.get(AlignmentLineKt.getLastBaseline());
                        return measureScope.layout(r12.getWidth(), r12.getHeight(), MapsKt__MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(i11)), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(i12))), new BadgeKt$BadgedBox$2$measure$1(r22, measureScope, r12));
                    }
                    long j12 = j11;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            long j13 = j11;
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
