package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyGridItemProviderKt$rememberLazyGridItemProvider$nearestItemsRangeState$1$1 extends Lambda implements Function0<Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyGridState f2904g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridItemProviderKt$rememberLazyGridItemProvider$nearestItemsRangeState$1$1(LazyGridState lazyGridState) {
        super(0);
        this.f2904g = lazyGridState;
    }

    @NotNull
    public final Integer invoke() {
        return Integer.valueOf(this.f2904g.getFirstVisibleItemIndex());
    }
}
