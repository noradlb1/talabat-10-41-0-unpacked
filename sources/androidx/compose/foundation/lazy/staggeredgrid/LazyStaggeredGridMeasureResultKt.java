package androidx.compose.foundation.lazy.staggeredgrid;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"findVisibleItem", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "itemIndex", "", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridMeasureResultKt {
    @Nullable
    public static final LazyStaggeredGridItemInfo findVisibleItem(@NotNull LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, int i11) {
        Intrinsics.checkNotNullParameter(lazyStaggeredGridLayoutInfo, "<this>");
        if (lazyStaggeredGridLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            return null;
        }
        int index = ((LazyStaggeredGridItemInfo) CollectionsKt___CollectionsKt.first(lazyStaggeredGridLayoutInfo.getVisibleItemsInfo())).getIndex();
        boolean z11 = false;
        if (i11 <= ((LazyStaggeredGridItemInfo) CollectionsKt___CollectionsKt.last(lazyStaggeredGridLayoutInfo.getVisibleItemsInfo())).getIndex() && index <= i11) {
            z11 = true;
        }
        if (!z11) {
            return null;
        }
        return (LazyStaggeredGridItemInfo) CollectionsKt___CollectionsKt.getOrNull(lazyStaggeredGridLayoutInfo.getVisibleItemsInfo(), CollectionsKt__CollectionsKt.binarySearch$default((List) lazyStaggeredGridLayoutInfo.getVisibleItemsInfo(), 0, 0, (Function1) new LazyStaggeredGridMeasureResultKt$findVisibleItem$index$1(i11), 3, (Object) null));
    }
}
