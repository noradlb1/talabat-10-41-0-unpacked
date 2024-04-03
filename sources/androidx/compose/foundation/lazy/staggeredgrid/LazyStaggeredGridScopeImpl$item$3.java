package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u000b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridScopeImpl$item$3 extends Lambda implements Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<LazyStaggeredGridItemScope, Composer, Integer, Unit> f3164g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridScopeImpl$item$3(Function3<? super LazyStaggeredGridItemScope, ? super Composer, ? super Integer, Unit> function3) {
        super(4);
        this.f3164g = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((LazyStaggeredGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull LazyStaggeredGridItemScope lazyStaggeredGridItemScope, int i11, @Nullable Composer composer, int i12) {
        Intrinsics.checkNotNullParameter(lazyStaggeredGridItemScope, "$this$items");
        if ((i12 & 14) == 0) {
            i12 |= composer.changed((Object) lazyStaggeredGridItemScope) ? 4 : 2;
        }
        if ((i12 & 651) != 130 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2037756640, i12, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScopeImpl.item.<anonymous> (LazyStaggeredGridScope.kt:37)");
            }
            this.f3164g.invoke(lazyStaggeredGridItemScope, composer, Integer.valueOf(i12 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
