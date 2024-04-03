package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridDslKt$rememberRowHeightSums$1$1 extends Lambda implements Function2<Density, Constraints, int[]> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f3127g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ StaggeredGridCells f3128h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Vertical f3129i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridDslKt$rememberRowHeightSums$1$1(PaddingValues paddingValues, StaggeredGridCells staggeredGridCells, Arrangement.Vertical vertical) {
        super(2);
        this.f3127g = paddingValues;
        this.f3128h = staggeredGridCells;
        this.f3129i = vertical;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m767invoke0kLqBqw((Density) obj, ((Constraints) obj2).m5428unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final int[] m767invoke0kLqBqw(@NotNull Density density, long j11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(density, "$this$null");
        if (Constraints.m5421getMaxHeightimpl(j11) != Integer.MAX_VALUE) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            List<Integer> calculateCrossAxisCellSizes = this.f3128h.calculateCrossAxisCellSizes(density, Constraints.m5421getMaxHeightimpl(j11) - density.m5441roundToPx0680j_4(Dp.m5478constructorimpl(this.f3127g.m499calculateTopPaddingD9Ej5fM() + this.f3127g.m496calculateBottomPaddingD9Ej5fM())), density.m5441roundToPx0680j_4(this.f3129i.m423getSpacingD9Ej5fM()));
            int size = calculateCrossAxisCellSizes.size();
            int[] iArr = new int[size];
            for (int i11 = 0; i11 < size; i11++) {
                iArr[i11] = calculateCrossAxisCellSizes.get(i11).intValue();
            }
            int size2 = calculateCrossAxisCellSizes.size();
            for (int i12 = 1; i12 < size2; i12++) {
                iArr[i12] = iArr[i12] + iArr[i12 - 1];
            }
            return iArr;
        }
        throw new IllegalArgumentException("LazyHorizontalStaggeredGrid's height should be bound by parent.".toString());
    }
}
