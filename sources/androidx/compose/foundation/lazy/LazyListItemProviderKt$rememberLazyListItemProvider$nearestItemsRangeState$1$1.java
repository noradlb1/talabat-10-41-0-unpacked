package androidx.compose.foundation.lazy;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyListItemProviderKt$rememberLazyListItemProvider$nearestItemsRangeState$1$1 extends Lambda implements Function0<Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyListState f2751g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyListItemProviderKt$rememberLazyListItemProvider$nearestItemsRangeState$1$1(LazyListState lazyListState) {
        super(0);
        this.f2751g = lazyListState;
    }

    @NotNull
    public final Integer invoke() {
        return Integer.valueOf(this.f2751g.getFirstVisibleItemIndex());
    }
}
