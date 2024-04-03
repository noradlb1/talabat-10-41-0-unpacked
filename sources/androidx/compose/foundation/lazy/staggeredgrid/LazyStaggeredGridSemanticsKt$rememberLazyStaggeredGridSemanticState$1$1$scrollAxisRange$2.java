package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1$scrollAxisRange$2 extends Lambda implements Function0<Float> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyStaggeredGridState f3169g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutItemProvider f3170h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1$scrollAxisRange$2(LazyStaggeredGridState lazyStaggeredGridState, LazyLayoutItemProvider lazyLayoutItemProvider) {
        super(0);
        this.f3169g = lazyStaggeredGridState;
        this.f3170h = lazyLayoutItemProvider;
    }

    @NotNull
    public final Float invoke() {
        float f11;
        float f12;
        if (this.f3169g.getCanScrollForward$foundation_release()) {
            f12 = (float) this.f3170h.getItemCount();
            f11 = 1.0f;
        } else {
            f12 = (float) this.f3169g.getFirstVisibleItemIndex();
            f11 = ((float) this.f3169g.getFirstVisibleItemScrollOffset()) / 100000.0f;
        }
        return Float.valueOf(f12 + f11);
    }
}
