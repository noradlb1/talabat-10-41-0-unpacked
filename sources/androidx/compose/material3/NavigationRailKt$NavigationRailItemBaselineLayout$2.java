package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import j0.d;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationRailKt$NavigationRailItemBaselineLayout$2 implements MeasurePolicy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f7597a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7598b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f7599c;

    public NavigationRailKt$NavigationRailItemBaselineLayout$2(float f11, Function2<? super Composer, ? super Integer, Unit> function2, boolean z11) {
        this.f7597a = f11;
        this.f7598b = function2;
        this.f7599c = z11;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.a(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.b(this, intrinsicMeasureScope, list, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1784measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        float f11;
        Object obj;
        Placeable placeable;
        Placeable placeable2;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        Intrinsics.checkNotNullParameter(measureScope2, "$this$Layout");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        Iterable<Measurable> iterable = list2;
        for (Measurable measurable : iterable) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), (Object) "icon")) {
                Placeable r32 = measurable.m4508measureBRTryo0(j11);
                float f12 = (float) 2;
                int width = r32.getWidth() + measureScope2.m5441roundToPx0680j_4(Dp.m5478constructorimpl(NavigationRailKt.IndicatorHorizontalPadding * f12));
                int roundToInt = MathKt__MathJVMKt.roundToInt(((float) width) * this.f7597a);
                if (this.f7598b == null) {
                    f11 = NavigationRailKt.IndicatorVerticalPaddingNoLabel;
                } else {
                    f11 = NavigationRailKt.IndicatorVerticalPaddingWithLabel;
                }
                int height = r32.getHeight() + measureScope2.m5441roundToPx0680j_4(Dp.m5478constructorimpl(f11 * f12));
                for (Measurable measurable2 : iterable) {
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), (Object) "indicatorRipple")) {
                        Placeable r42 = measurable2.m4508measureBRTryo0(Constraints.Companion.m5430fixedJhjzzOo(width, height));
                        Iterator it = iterable.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), (Object) "indicator")) {
                                break;
                            }
                        }
                        Measurable measurable3 = (Measurable) obj;
                        if (measurable3 != null) {
                            placeable = measurable3.m4508measureBRTryo0(Constraints.Companion.m5430fixedJhjzzOo(roundToInt, height));
                        } else {
                            placeable = null;
                        }
                        if (this.f7598b != null) {
                            for (Measurable measurable4 : iterable) {
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), (Object) "label")) {
                                    placeable2 = measurable4.m4508measureBRTryo0(Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, 0, 11, (Object) null));
                                } else {
                                    long j12 = j11;
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        placeable2 = null;
                        if (this.f7598b == null) {
                            return NavigationRailKt.m1780placeIconX9ElhV4(measureScope, r32, r42, placeable, j11);
                        }
                        Intrinsics.checkNotNull(placeable2);
                        return NavigationRailKt.m1781placeLabelAndIconzUg2_y0(measureScope, placeable2, r32, r42, placeable, j11, this.f7599c, this.f7597a);
                    }
                    long j13 = j11;
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
