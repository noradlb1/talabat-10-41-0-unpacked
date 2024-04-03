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
import j0.d;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SnackbarKt$OneRowSnackbar$2 implements MeasurePolicy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5402a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f5403b;

    public SnackbarKt$OneRowSnackbar$2(String str, String str2) {
        this.f5402a = str;
        this.f5403b = str2;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.a(this, intrinsicMeasureScope, list, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
        return d.b(this, intrinsicMeasureScope, list, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1366measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        boolean z11;
        boolean z12;
        int i11;
        int i12;
        int i13;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        Intrinsics.checkNotNullParameter(measureScope2, "$this$Layout");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        Iterable<Measurable> iterable = list2;
        String str = this.f5402a;
        for (Measurable measurable : iterable) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), (Object) str)) {
                Placeable r52 = measurable.m4508measureBRTryo0(j11);
                int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((Constraints.m5422getMaxWidthimpl(j11) - r52.getWidth()) - measureScope2.m5441roundToPx0680j_4(SnackbarKt.TextEndExtraSpacing), Constraints.m5424getMinWidthimpl(j11));
                String str2 = this.f5403b;
                for (Measurable measurable2 : iterable) {
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), (Object) str2)) {
                        Placeable r82 = measurable2.m4508measureBRTryo0(Constraints.m5413copyZbe2FdA$default(j11, 0, coerceAtLeast, 0, 0, 9, (Object) null));
                        int i14 = r82.get(AlignmentLineKt.getFirstBaseline());
                        boolean z13 = true;
                        int i15 = 0;
                        if (i14 != Integer.MIN_VALUE) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z11) {
                            int i16 = r82.get(AlignmentLineKt.getLastBaseline());
                            if (i16 != Integer.MIN_VALUE) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (z12) {
                                if (i14 != i16) {
                                    z13 = false;
                                }
                                int r11 = Constraints.m5422getMaxWidthimpl(j11) - r52.getWidth();
                                if (z13) {
                                    i13 = Math.max(measureScope2.m5441roundToPx0680j_4(SnackbarKt.SnackbarMinHeightOneLine), r52.getHeight());
                                    int height = (i13 - r82.getHeight()) / 2;
                                    int i17 = r52.get(AlignmentLineKt.getFirstBaseline());
                                    if (i17 != Integer.MIN_VALUE) {
                                        i15 = (i14 + height) - i17;
                                    }
                                    i11 = i15;
                                    i12 = height;
                                } else {
                                    int r62 = measureScope2.m5441roundToPx0680j_4(SnackbarKt.HeightToFirstLine) - i14;
                                    int max = Math.max(measureScope2.m5441roundToPx0680j_4(SnackbarKt.SnackbarMinHeightTwoLines), r82.getHeight() + r62);
                                    i12 = r62;
                                    i11 = (max - r52.getHeight()) / 2;
                                    i13 = max;
                                }
                                return MeasureScope.CC.p(measureScope, Constraints.m5422getMaxWidthimpl(j11), i13, (Map) null, new SnackbarKt$OneRowSnackbar$2$measure$4(r82, i12, r52, r11, i11), 4, (Object) null);
                            }
                            throw new IllegalArgumentException("No baselines for text".toString());
                        }
                        throw new IllegalArgumentException("No baselines for text".toString());
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
