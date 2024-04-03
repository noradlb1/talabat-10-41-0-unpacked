package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
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
public final class SliderKt$SliderImpl$2 implements MeasurePolicy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f8063a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f8064b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f8065c;

    public SliderKt$SliderImpl$2(MutableState<Float> mutableState, MutableState<Integer> mutableState2, float f11) {
        this.f8063a = mutableState;
        this.f8064b = mutableState2;
        this.f8065c = f11;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.a(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.b(this, intrinsicMeasureScope, list, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1822measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        boolean z11;
        boolean z12;
        List<? extends Measurable> list2 = list;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        Iterable<Measurable> iterable = list2;
        for (Measurable measurable : iterable) {
            if (LayoutIdKt.getLayoutId(measurable) == SliderComponents.THUMB) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                Placeable r22 = measurable.m4508measureBRTryo0(j11);
                int r13 = Constraints.m5422getMaxWidthimpl(j11) - r22.getWidth();
                for (Measurable measurable2 : iterable) {
                    if (LayoutIdKt.getLayoutId(measurable2) == SliderComponents.TRACK) {
                        z12 = true;
                        continue;
                    } else {
                        z12 = false;
                        continue;
                    }
                    if (z12) {
                        Placeable r11 = measurable2.m4508measureBRTryo0(Constraints.m5413copyZbe2FdA$default(j11, 0, r13, 0, 0, 8, (Object) null));
                        int width = r11.getWidth() + r22.getWidth();
                        int max = Math.max(r11.getHeight(), r22.getHeight());
                        this.f8063a.setValue(Float.valueOf((float) r22.getWidth()));
                        this.f8064b.setValue(Integer.valueOf(width));
                        return MeasureScope.CC.p(measureScope, width, max, (Map) null, new SliderKt$SliderImpl$2$measure$1(r11, r22.getWidth() / 2, (max - r11.getHeight()) / 2, r22, MathKt__MathJVMKt.roundToInt(((float) r11.getWidth()) * this.f8065c), (max - r22.getHeight()) / 2), 4, (Object) null);
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            long j12 = j11;
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
