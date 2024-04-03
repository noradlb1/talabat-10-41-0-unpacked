package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1$scrollAxisRange$1 extends Lambda implements Function0<Float> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyStaggeredGridState f3168g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1$scrollAxisRange$1(LazyStaggeredGridState lazyStaggeredGridState) {
        super(0);
        this.f3168g = lazyStaggeredGridState;
    }

    @NotNull
    public final Float invoke() {
        return Float.valueOf(((float) this.f3168g.getFirstVisibleItemIndex()) + (((float) this.f3168g.getFirstVisibleItemScrollOffset()) / 100000.0f));
    }
}
