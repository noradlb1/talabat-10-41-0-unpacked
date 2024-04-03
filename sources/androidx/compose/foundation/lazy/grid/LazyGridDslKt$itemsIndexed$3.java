package androidx.compose.foundation.lazy.grid;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "it", "", "invoke-_-orMbw", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;I)J"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class LazyGridDslKt$itemsIndexed$3 extends Lambda implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<LazyGridItemSpanScope, Integer, T, GridItemSpan> f2872g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<T> f2873h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridDslKt$itemsIndexed$3(Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, List<? extends T> list) {
        super(2);
        this.f2872g = function3;
        this.f2873h = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return GridItemSpan.m656boximpl(m681invoke_orMbw((LazyGridItemSpanScope) obj, ((Number) obj2).intValue()));
    }

    /* renamed from: invoke-_-orMbw  reason: not valid java name */
    public final long m681invoke_orMbw(@NotNull LazyGridItemSpanScope lazyGridItemSpanScope, int i11) {
        Intrinsics.checkNotNullParameter(lazyGridItemSpanScope, "$this$null");
        return this.f2872g.invoke(lazyGridItemSpanScope, Integer.valueOf(i11), this.f2873h.get(i11)).m663unboximpl();
    }
}
