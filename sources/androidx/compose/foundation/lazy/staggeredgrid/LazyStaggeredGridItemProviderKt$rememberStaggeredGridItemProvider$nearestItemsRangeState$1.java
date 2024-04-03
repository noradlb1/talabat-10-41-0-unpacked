package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$nearestItemsRangeState$1 extends Lambda implements Function0<Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyStaggeredGridState f3132g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$nearestItemsRangeState$1(LazyStaggeredGridState lazyStaggeredGridState) {
        super(0);
        this.f3132g = lazyStaggeredGridState;
    }

    @NotNull
    public final Integer invoke() {
        return Integer.valueOf(this.f3132g.getFirstVisibleItemIndex());
    }
}
