package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
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
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AppBarKt$TopAppBarLayout$2 implements MeasurePolicy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f6470a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Horizontal f6471b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Vertical f6472c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f6473d;

    public AppBarKt$TopAppBarLayout$2(float f11, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i11) {
        this.f6470a = f11;
        this.f6471b = horizontal;
        this.f6472c = vertical;
        this.f6473d = i11;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.a(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.b(this, intrinsicMeasureScope, list, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1506measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        int i11;
        int i12;
        List<? extends Measurable> list2 = list;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        Iterable<Measurable> iterable = list2;
        for (Measurable measurable : iterable) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), (Object) "navigationIcon")) {
                Placeable r22 = measurable.m4508measureBRTryo0(Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, 0, 14, (Object) null));
                for (Measurable measurable2 : iterable) {
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), (Object) "actionIcons")) {
                        Placeable r102 = measurable2.m4508measureBRTryo0(Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, 0, 14, (Object) null));
                        if (Constraints.m5422getMaxWidthimpl(j11) == Integer.MAX_VALUE) {
                            i11 = Constraints.m5422getMaxWidthimpl(j11);
                        } else {
                            i11 = RangesKt___RangesKt.coerceAtLeast((Constraints.m5422getMaxWidthimpl(j11) - r22.getWidth()) - r102.getWidth(), 0);
                        }
                        int i13 = i11;
                        for (Measurable measurable3 : iterable) {
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), (Object) "title")) {
                                Placeable r12 = measurable3.m4508measureBRTryo0(Constraints.m5413copyZbe2FdA$default(j11, 0, i13, 0, 0, 12, (Object) null));
                                if (r12.get(AlignmentLineKt.getLastBaseline()) != Integer.MIN_VALUE) {
                                    i12 = r12.get(AlignmentLineKt.getLastBaseline());
                                } else {
                                    i12 = 0;
                                }
                                int roundToInt = MathKt__MathJVMKt.roundToInt(this.f6470a);
                                return MeasureScope.CC.p(measureScope, Constraints.m5422getMaxWidthimpl(j11), roundToInt, (Map) null, new AppBarKt$TopAppBarLayout$2$measure$1(r22, roundToInt, r12, this.f6471b, j11, r102, measureScope, this.f6472c, this.f6473d, i12), 4, (Object) null);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
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
