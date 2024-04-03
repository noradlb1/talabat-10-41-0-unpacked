package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import j0.d;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SnackbarKt$TextOnlySnackbar$2 implements MeasurePolicy {
    public static final SnackbarKt$TextOnlySnackbar$2 INSTANCE = new SnackbarKt$TextOnlySnackbar$2();

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.a(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.b(this, intrinsicMeasureScope, list, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1367measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        boolean z11;
        boolean z12;
        float f11;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        boolean z13 = false;
        if (list.size() == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            Placeable r11 = ((Measurable) CollectionsKt___CollectionsKt.first(list)).m4508measureBRTryo0(j11);
            int i11 = r11.get(AlignmentLineKt.getFirstBaseline());
            int i12 = r11.get(AlignmentLineKt.getLastBaseline());
            if (i11 != Integer.MIN_VALUE) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (i12 != Integer.MIN_VALUE) {
                    z13 = true;
                }
                if (z13) {
                    if (i11 == i12) {
                        f11 = SnackbarKt.SnackbarMinHeightOneLine;
                    } else {
                        f11 = SnackbarKt.SnackbarMinHeightTwoLines;
                    }
                    int max = Math.max(measureScope.m5441roundToPx0680j_4(f11), r11.getHeight());
                    return MeasureScope.CC.p(measureScope, Constraints.m5422getMaxWidthimpl(j11), max, (Map) null, new SnackbarKt$TextOnlySnackbar$2$measure$4(max, r11), 4, (Object) null);
                }
                throw new IllegalArgumentException("No baselines for text".toString());
            }
            throw new IllegalArgumentException("No baselines for text".toString());
        }
        throw new IllegalArgumentException("text for Snackbar expected to have exactly only one child".toString());
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.c(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.d(this, intrinsicMeasureScope, list, i11);
    }
}
