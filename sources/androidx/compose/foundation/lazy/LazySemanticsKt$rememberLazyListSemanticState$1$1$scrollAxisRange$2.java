package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazySemanticsKt$rememberLazyListSemanticState$1$1$scrollAxisRange$2 extends Lambda implements Function0<Float> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyListState f2823g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutItemProvider f2824h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazySemanticsKt$rememberLazyListSemanticState$1$1$scrollAxisRange$2(LazyListState lazyListState, LazyLayoutItemProvider lazyLayoutItemProvider) {
        super(0);
        this.f2823g = lazyListState;
        this.f2824h = lazyLayoutItemProvider;
    }

    @NotNull
    public final Float invoke() {
        float f11;
        float f12;
        if (this.f2823g.getCanScrollForward$foundation_release()) {
            f12 = (float) this.f2824h.getItemCount();
            f11 = 1.0f;
        } else {
            f12 = (float) this.f2823g.getFirstVisibleItemIndex();
            f11 = ((float) this.f2823g.getFirstVisibleItemScrollOffset()) / 100000.0f;
        }
        return Float.valueOf(f12 + f11);
    }
}
