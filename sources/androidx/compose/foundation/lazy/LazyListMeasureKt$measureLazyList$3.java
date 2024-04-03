package androidx.compose.foundation.lazy;

import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyListMeasureKt$measureLazyList$3 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<LazyListPositionedItem> f2797g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyListPositionedItem f2798h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyListMeasureKt$measureLazyList$3(List<LazyListPositionedItem> list, LazyListPositionedItem lazyListPositionedItem) {
        super(1);
        this.f2797g = list;
        this.f2798h = lazyListPositionedItem;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$invoke");
        List<LazyListPositionedItem> list = this.f2797g;
        LazyListPositionedItem lazyListPositionedItem = this.f2798h;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            LazyListPositionedItem lazyListPositionedItem2 = list.get(i11);
            if (lazyListPositionedItem2 != lazyListPositionedItem) {
                lazyListPositionedItem2.place(placementScope);
            }
        }
        LazyListPositionedItem lazyListPositionedItem3 = this.f2798h;
        if (lazyListPositionedItem3 != null) {
            lazyListPositionedItem3.place(placementScope);
        }
    }
}
