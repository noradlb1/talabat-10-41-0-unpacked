package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.ComposableOpenTarget;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$itemProviderState$1 extends Lambda implements Function0<LazyLayoutItemProvider> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Function1<LazyStaggeredGridScope, Unit>> f3130g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<IntRange> f3131h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$itemProviderState$1(State<? extends Function1<? super LazyStaggeredGridScope, Unit>> state, State<IntRange> state2) {
        super(0);
        this.f3130g = state;
        this.f3131h = state2;
    }

    @NotNull
    @ComposableOpenTarget(index = 0)
    public final LazyLayoutItemProvider invoke() {
        LazyStaggeredGridScopeImpl lazyStaggeredGridScopeImpl = new LazyStaggeredGridScopeImpl();
        this.f3130g.getValue().invoke(lazyStaggeredGridScopeImpl);
        return LazyLayoutItemProviderKt.LazyLayoutItemProvider(lazyStaggeredGridScopeImpl.getIntervals(), this.f3131h.getValue(), ComposableSingletons$LazyStaggeredGridItemProviderKt.INSTANCE.m764getLambda1$foundation_release());
    }
}
