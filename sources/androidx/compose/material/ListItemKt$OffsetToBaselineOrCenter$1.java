package androidx.compose.material;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import j0.d;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ListItemKt$OffsetToBaselineOrCenter$1 implements MeasurePolicy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f4644a;

    public ListItemKt$OffsetToBaselineOrCenter$1(float f11) {
        this.f4644a = f11;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.a(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.b(this, intrinsicMeasureScope, list, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1284measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        int i11;
        int i12;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        Placeable r11 = ((Measurable) list.get(0)).m4508measureBRTryo0(Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, 0, 11, (Object) null));
        int i13 = r11.get(AlignmentLineKt.getFirstBaseline());
        if (i13 != Integer.MIN_VALUE) {
            i12 = measureScope.m5441roundToPx0680j_4(this.f4644a) - i13;
            i11 = Math.max(Constraints.m5423getMinHeightimpl(j11), r11.getHeight() + i12);
        } else {
            i11 = Math.max(Constraints.m5423getMinHeightimpl(j11), r11.getHeight());
            i12 = IntOffset.m5597getYimpl(Alignment.Companion.getCenter().m2554alignKFBX0sM(IntSize.Companion.m5643getZeroYbymL2g(), IntSizeKt.IntSize(0, i11 - r11.getHeight()), measureScope.getLayoutDirection()));
        }
        return MeasureScope.CC.p(measureScope, r11.getWidth(), i11, (Map) null, new ListItemKt$OffsetToBaselineOrCenter$1$measure$1(r11, i12), 4, (Object) null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.c(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.d(this, intrinsicMeasureScope, list, i11);
    }
}
