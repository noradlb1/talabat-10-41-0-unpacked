package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1 implements LazyLayoutSemanticState {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f3165a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LazyStaggeredGridState f3166b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutItemProvider f3167c;

    public LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1(boolean z11, LazyStaggeredGridState lazyStaggeredGridState, LazyLayoutItemProvider lazyLayoutItemProvider) {
        this.f3165a = z11;
        this.f3166b = lazyStaggeredGridState;
        this.f3167c = lazyLayoutItemProvider;
    }

    @Nullable
    public Object animateScrollBy(float f11, @NotNull Continuation<? super Unit> continuation) {
        Object animateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(this.f3166b, f11, (AnimationSpec) null, continuation, 2, (Object) null);
        return animateScrollBy$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollBy$default : Unit.INSTANCE;
    }

    @NotNull
    public CollectionInfo collectionInfo() {
        return new CollectionInfo(-1, -1);
    }

    @NotNull
    public ScrollAxisRange scrollAxisRange() {
        return new ScrollAxisRange(new LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1$scrollAxisRange$1(this.f3166b), new LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1$scrollAxisRange$2(this.f3166b, this.f3167c), this.f3165a);
    }

    @Nullable
    public Object scrollToItem(int i11, @NotNull Continuation<? super Unit> continuation) {
        Object scrollToItem$default = LazyStaggeredGridState.scrollToItem$default(this.f3166b, i11, 0, continuation, 2, (Object) null);
        return scrollToItem$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToItem$default : Unit.INSTANCE;
    }
}
