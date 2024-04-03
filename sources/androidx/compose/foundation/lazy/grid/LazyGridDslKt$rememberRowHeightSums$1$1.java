package androidx.compose.foundation.lazy.grid;

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
public final class LazyGridDslKt$rememberRowHeightSums$1$1 extends Lambda implements Function2<Density, Constraints, List<Integer>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f2887g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GridCells f2888h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Vertical f2889i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridDslKt$rememberRowHeightSums$1$1(PaddingValues paddingValues, GridCells gridCells, Arrangement.Vertical vertical) {
        super(2);
        this.f2887g = paddingValues;
        this.f2888h = gridCells;
        this.f2889i = vertical;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m684invoke0kLqBqw((Density) obj, ((Constraints) obj2).m5428unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final List<Integer> m684invoke0kLqBqw(@NotNull Density density, long j11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(density, "$this$null");
        if (Constraints.m5421getMaxHeightimpl(j11) != Integer.MAX_VALUE) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            List<Integer> mutableList = CollectionsKt___CollectionsKt.toMutableList(this.f2888h.calculateCrossAxisCellSizes(density, Constraints.m5421getMaxHeightimpl(j11) - density.m5441roundToPx0680j_4(Dp.m5478constructorimpl(this.f2887g.m499calculateTopPaddingD9Ej5fM() + this.f2887g.m496calculateBottomPaddingD9Ej5fM())), density.m5441roundToPx0680j_4(this.f2889i.m423getSpacingD9Ej5fM())));
            int size = mutableList.size();
            for (int i11 = 1; i11 < size; i11++) {
                mutableList.set(i11, Integer.valueOf(mutableList.get(i11).intValue() + mutableList.get(i11 - 1).intValue()));
            }
            return mutableList;
        }
        throw new IllegalArgumentException("LazyHorizontalGrid's height should be bound by parent.".toString());
    }
}
