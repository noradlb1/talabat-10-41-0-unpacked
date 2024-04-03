package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "it", "", "invoke-_-orMbw", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;I)J"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyGridScopeImpl$item$2$1 extends Lambda implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<LazyGridItemSpanScope, GridItemSpan> f2952g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridScopeImpl$item$2$1(Function1<? super LazyGridItemSpanScope, GridItemSpan> function1) {
        super(2);
        this.f2952g = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return GridItemSpan.m656boximpl(m707invoke_orMbw((LazyGridItemSpanScope) obj, ((Number) obj2).intValue()));
    }

    /* renamed from: invoke-_-orMbw  reason: not valid java name */
    public final long m707invoke_orMbw(@NotNull LazyGridItemSpanScope lazyGridItemSpanScope, int i11) {
        Intrinsics.checkNotNullParameter(lazyGridItemSpanScope, "$this$null");
        return this.f2952g.invoke(lazyGridItemSpanScope).m663unboximpl();
    }
}
