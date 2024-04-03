package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazySemanticsKt$rememberLazyGridSemanticState$1$1$scrollAxisRange$1 extends Lambda implements Function0<Float> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyGridState f2973g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazySemanticsKt$rememberLazyGridSemanticState$1$1$scrollAxisRange$1(LazyGridState lazyGridState) {
        super(0);
        this.f2973g = lazyGridState;
    }

    @NotNull
    public final Float invoke() {
        return Float.valueOf(((float) this.f2973g.getFirstVisibleItemIndex()) + (((float) this.f2973g.getFirstVisibleItemScrollOffset()) / 100000.0f));
    }
}
