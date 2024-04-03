package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridDslKt$rememberColumnWidthSums$1$1 extends Lambda implements Function2<Density, Constraints, int[]> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f3124g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ StaggeredGridCells f3125h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Horizontal f3126i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridDslKt$rememberColumnWidthSums$1$1(PaddingValues paddingValues, StaggeredGridCells staggeredGridCells, Arrangement.Horizontal horizontal) {
        super(2);
        this.f3124g = paddingValues;
        this.f3125h = staggeredGridCells;
        this.f3126i = horizontal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m766invoke0kLqBqw((Density) obj, ((Constraints) obj2).m5428unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final int[] m766invoke0kLqBqw(@NotNull Density density, long j11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(density, "$this$null");
        if (Constraints.m5422getMaxWidthimpl(j11) != Integer.MAX_VALUE) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            PaddingValues paddingValues = this.f3124g;
            LayoutDirection layoutDirection = LayoutDirection.Ltr;
            List<Integer> calculateCrossAxisCellSizes = this.f3125h.calculateCrossAxisCellSizes(density, Constraints.m5422getMaxWidthimpl(j11) - density.m5441roundToPx0680j_4(Dp.m5478constructorimpl(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) + PaddingKt.calculateEndPadding(this.f3124g, layoutDirection))), density.m5441roundToPx0680j_4(this.f3126i.m409getSpacingD9Ej5fM()));
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
        throw new IllegalArgumentException("LazyVerticalStaggeredGrid's width should be bound by parent.".toString());
    }
}
