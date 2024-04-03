package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridKt$ScrollPositionUpdater$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutItemProvider f3147g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyStaggeredGridState f3148h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f3149i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridKt$ScrollPositionUpdater$1(LazyLayoutItemProvider lazyLayoutItemProvider, LazyStaggeredGridState lazyStaggeredGridState, int i11) {
        super(2);
        this.f3147g = lazyLayoutItemProvider;
        this.f3148h = lazyStaggeredGridState;
        this.f3149i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LazyStaggeredGridKt.ScrollPositionUpdater(this.f3147g, this.f3148h, composer, this.f3149i | 1);
    }
}
