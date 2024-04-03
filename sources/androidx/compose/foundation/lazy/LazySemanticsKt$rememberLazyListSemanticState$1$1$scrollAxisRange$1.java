package androidx.compose.foundation.lazy;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazySemanticsKt$rememberLazyListSemanticState$1$1$scrollAxisRange$1 extends Lambda implements Function0<Float> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyListState f2822g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazySemanticsKt$rememberLazyListSemanticState$1$1$scrollAxisRange$1(LazyListState lazyListState) {
        super(0);
        this.f2822g = lazyListState;
    }

    @NotNull
    public final Float invoke() {
        return Float.valueOf(((float) this.f2822g.getFirstVisibleItemIndex()) + (((float) this.f2822g.getFirstVisibleItemScrollOffset()) / 100000.0f));
    }
}
