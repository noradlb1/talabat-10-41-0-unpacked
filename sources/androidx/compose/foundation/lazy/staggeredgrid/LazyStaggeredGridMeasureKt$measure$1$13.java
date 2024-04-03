package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridMeasureKt$measure$1$13 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableVector<LazyStaggeredGridPositionedItem> f3151g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridMeasureKt$measure$1$13(MutableVector<LazyStaggeredGridPositionedItem> mutableVector) {
        super(1);
        this.f3151g = mutableVector;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        MutableVector<LazyStaggeredGridPositionedItem> mutableVector = this.f3151g;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                ((LazyStaggeredGridPositionedItem) content[i11]).place(placementScope);
                i11++;
            } while (i11 < size);
        }
    }
}
