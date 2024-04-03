package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyGridState$Companion$Saver$1 extends Lambda implements Function2<SaverScope, LazyGridState, List<? extends Integer>> {
    public static final LazyGridState$Companion$Saver$1 INSTANCE = new LazyGridState$Companion$Saver$1();

    public LazyGridState$Companion$Saver$1() {
        super(2);
    }

    @NotNull
    public final List<Integer> invoke(@NotNull SaverScope saverScope, @NotNull LazyGridState lazyGridState) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$listSaver");
        Intrinsics.checkNotNullParameter(lazyGridState, "it");
        return CollectionsKt__CollectionsKt.listOf(Integer.valueOf(lazyGridState.getFirstVisibleItemIndex()), Integer.valueOf(lazyGridState.getFirstVisibleItemScrollOffset()));
    }
}
