package androidx.compose.foundation.lazy;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyListItemProviderKt$rememberLazyListItemProvider$1$itemProviderState$1 extends Lambda implements Function0<LazyListItemProviderImpl> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Function1<LazyListScope, Unit>> f2748g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<IntRange> f2749h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LazyItemScopeImpl f2750i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyListItemProviderKt$rememberLazyListItemProvider$1$itemProviderState$1(State<? extends Function1<? super LazyListScope, Unit>> state, State<IntRange> state2, LazyItemScopeImpl lazyItemScopeImpl) {
        super(0);
        this.f2748g = state;
        this.f2749h = state2;
        this.f2750i = lazyItemScopeImpl;
    }

    @NotNull
    public final LazyListItemProviderImpl invoke() {
        LazyListScopeImpl lazyListScopeImpl = new LazyListScopeImpl();
        this.f2748g.getValue().invoke(lazyListScopeImpl);
        return new LazyListItemProviderImpl(lazyListScopeImpl.getIntervals(), this.f2749h.getValue(), lazyListScopeImpl.getHeaderIndexes(), this.f2750i);
    }
}
