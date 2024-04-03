package androidx.compose.foundation.lazy.grid;

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
public final class LazyGridDslKt$rememberColumnWidthSums$1$1 extends Lambda implements Function2<Density, Constraints, List<Integer>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f2884g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GridCells f2885h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Horizontal f2886i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridDslKt$rememberColumnWidthSums$1$1(PaddingValues paddingValues, GridCells gridCells, Arrangement.Horizontal horizontal) {
        super(2);
        this.f2884g = paddingValues;
        this.f2885h = gridCells;
        this.f2886i = horizontal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m683invoke0kLqBqw((Density) obj, ((Constraints) obj2).m5428unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final List<Integer> m683invoke0kLqBqw(@NotNull Density density, long j11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(density, "$this$null");
        if (Constraints.m5422getMaxWidthimpl(j11) != Integer.MAX_VALUE) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            PaddingValues paddingValues = this.f2884g;
            LayoutDirection layoutDirection = LayoutDirection.Ltr;
            List<Integer> mutableList = CollectionsKt___CollectionsKt.toMutableList(this.f2885h.calculateCrossAxisCellSizes(density, Constraints.m5422getMaxWidthimpl(j11) - density.m5441roundToPx0680j_4(Dp.m5478constructorimpl(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) + PaddingKt.calculateEndPadding(this.f2884g, layoutDirection))), density.m5441roundToPx0680j_4(this.f2886i.m409getSpacingD9Ej5fM())));
            int size = mutableList.size();
            for (int i11 = 1; i11 < size; i11++) {
                mutableList.set(i11, Integer.valueOf(mutableList.get(i11).intValue() + mutableList.get(i11 - 1).intValue()));
            }
            return mutableList;
        }
        throw new IllegalArgumentException("LazyVerticalGrid's width should be bound by parent.".toString());
    }
}
