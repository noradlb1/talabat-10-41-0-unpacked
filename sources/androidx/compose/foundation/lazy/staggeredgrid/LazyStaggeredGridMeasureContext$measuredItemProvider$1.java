package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n"}, d2 = {"", "index", "lane", "", "key", "", "Landroidx/compose/ui/layout/Placeable;", "placeables", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class LazyStaggeredGridMeasureContext$measuredItemProvider$1 implements MeasuredItemFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LazyStaggeredGridMeasureContext f3150a;

    public LazyStaggeredGridMeasureContext$measuredItemProvider$1(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        this.f3150a = lazyStaggeredGridMeasureContext;
    }

    @NotNull
    public final LazyStaggeredGridMeasuredItem createItem(int i11, int i12, @NotNull Object obj, @NotNull List<? extends Placeable> list) {
        boolean z11;
        Intrinsics.checkNotNullParameter(obj, "key");
        Intrinsics.checkNotNullParameter(list, "placeables");
        int i13 = 0;
        if (this.f3150a.getSpans().findNextItemIndex(i11, i12) >= this.f3150a.getItemProvider().getItemCount()) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean isVertical = this.f3150a.isVertical();
        long r72 = this.f3150a.m772getContentOffsetnOccac();
        if (!z11) {
            i13 = this.f3150a.getMainAxisSpacing();
        }
        return new LazyStaggeredGridMeasuredItem(i11, obj, list, isVertical, r72, i13, (DefaultConstructorMarker) null);
    }
}
