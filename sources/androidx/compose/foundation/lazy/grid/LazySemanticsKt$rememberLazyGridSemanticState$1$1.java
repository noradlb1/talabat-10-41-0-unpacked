package androidx.compose.foundation.lazy.grid;

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
public final class LazySemanticsKt$rememberLazyGridSemanticState$1$1 implements LazyLayoutSemanticState {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f2970a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LazyGridState f2971b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutItemProvider f2972c;

    public LazySemanticsKt$rememberLazyGridSemanticState$1$1(boolean z11, LazyGridState lazyGridState, LazyLayoutItemProvider lazyLayoutItemProvider) {
        this.f2970a = z11;
        this.f2971b = lazyGridState;
        this.f2972c = lazyLayoutItemProvider;
    }

    @Nullable
    public Object animateScrollBy(float f11, @NotNull Continuation<? super Unit> continuation) {
        Object animateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(this.f2971b, f11, (AnimationSpec) null, continuation, 2, (Object) null);
        return animateScrollBy$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollBy$default : Unit.INSTANCE;
    }

    @NotNull
    public CollectionInfo collectionInfo() {
        return new CollectionInfo(-1, -1);
    }

    @NotNull
    public ScrollAxisRange scrollAxisRange() {
        return new ScrollAxisRange(new LazySemanticsKt$rememberLazyGridSemanticState$1$1$scrollAxisRange$1(this.f2971b), new LazySemanticsKt$rememberLazyGridSemanticState$1$1$scrollAxisRange$2(this.f2971b, this.f2972c), this.f2970a);
    }

    @Nullable
    public Object scrollToItem(int i11, @NotNull Continuation<? super Unit> continuation) {
        Object scrollToItem$default = LazyGridState.scrollToItem$default(this.f2971b, i11, 0, continuation, 2, (Object) null);
        return scrollToItem$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToItem$default : Unit.INSTANCE;
    }
}
