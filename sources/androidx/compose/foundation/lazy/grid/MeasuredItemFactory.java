package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bà\u0001\u0018\u00002\u00020\u0001JC\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/grid/MeasuredItemFactory;", "", "createItem", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItem;", "index", "Landroidx/compose/foundation/lazy/grid/ItemIndex;", "key", "crossAxisSize", "", "mainAxisSpacing", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "createItem-PU_OBEw", "(ILjava/lang/Object;IILjava/util/List;)Landroidx/compose/foundation/lazy/grid/LazyMeasuredItem;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface MeasuredItemFactory {
    @NotNull
    /* renamed from: createItem-PU_OBEw  reason: not valid java name */
    LazyMeasuredItem m733createItemPU_OBEw(int i11, @NotNull Object obj, int i12, int i13, @NotNull List<? extends Placeable> list);
}
