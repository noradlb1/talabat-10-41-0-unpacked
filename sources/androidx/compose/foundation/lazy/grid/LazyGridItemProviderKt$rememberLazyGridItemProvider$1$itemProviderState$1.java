package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyGridItemProviderKt$rememberLazyGridItemProvider$1$itemProviderState$1 extends Lambda implements Function0<LazyGridItemProviderImpl> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Function1<LazyGridScope, Unit>> f2902g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<IntRange> f2903h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridItemProviderKt$rememberLazyGridItemProvider$1$itemProviderState$1(State<? extends Function1<? super LazyGridScope, Unit>> state, State<IntRange> state2) {
        super(0);
        this.f2902g = state;
        this.f2903h = state2;
    }

    @NotNull
    public final LazyGridItemProviderImpl invoke() {
        LazyGridScopeImpl lazyGridScopeImpl = new LazyGridScopeImpl();
        this.f2902g.getValue().invoke(lazyGridScopeImpl);
        return new LazyGridItemProviderImpl(lazyGridScopeImpl.getIntervals$foundation_release(), lazyGridScopeImpl.getHasCustomSpans$foundation_release(), this.f2903h.getValue());
    }
}
