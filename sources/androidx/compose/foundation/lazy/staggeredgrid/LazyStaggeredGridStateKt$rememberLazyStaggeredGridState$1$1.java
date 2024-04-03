package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridStateKt$rememberLazyStaggeredGridState$1$1 extends Lambda implements Function0<LazyStaggeredGridState> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f3177g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f3178h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridStateKt$rememberLazyStaggeredGridState$1$1(int i11, int i12) {
        super(0);
        this.f3177g = i11;
        this.f3178h = i12;
    }

    @NotNull
    public final LazyStaggeredGridState invoke() {
        return new LazyStaggeredGridState(this.f3177g, this.f3178h);
    }
}
