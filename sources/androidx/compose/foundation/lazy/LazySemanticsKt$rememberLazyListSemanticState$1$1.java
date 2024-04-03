package androidx.compose.foundation.lazy;

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
public final class LazySemanticsKt$rememberLazyListSemanticState$1$1 implements LazyLayoutSemanticState {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f2818a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LazyListState f2819b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutItemProvider f2820c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f2821d;

    public LazySemanticsKt$rememberLazyListSemanticState$1$1(boolean z11, LazyListState lazyListState, LazyLayoutItemProvider lazyLayoutItemProvider, boolean z12) {
        this.f2818a = z11;
        this.f2819b = lazyListState;
        this.f2820c = lazyLayoutItemProvider;
        this.f2821d = z12;
    }

    @Nullable
    public Object animateScrollBy(float f11, @NotNull Continuation<? super Unit> continuation) {
        Object animateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(this.f2819b, f11, (AnimationSpec) null, continuation, 2, (Object) null);
        return animateScrollBy$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollBy$default : Unit.INSTANCE;
    }

    @NotNull
    public CollectionInfo collectionInfo() {
        if (this.f2821d) {
            return new CollectionInfo(-1, 1);
        }
        return new CollectionInfo(1, -1);
    }

    @NotNull
    public ScrollAxisRange scrollAxisRange() {
        return new ScrollAxisRange(new LazySemanticsKt$rememberLazyListSemanticState$1$1$scrollAxisRange$1(this.f2819b), new LazySemanticsKt$rememberLazyListSemanticState$1$1$scrollAxisRange$2(this.f2819b, this.f2820c), this.f2818a);
    }

    @Nullable
    public Object scrollToItem(int i11, @NotNull Continuation<? super Unit> continuation) {
        Object scrollToItem$default = LazyListState.scrollToItem$default(this.f2819b, i11, 0, continuation, 2, (Object) null);
        return scrollToItem$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToItem$default : Unit.INSTANCE;
    }
}
