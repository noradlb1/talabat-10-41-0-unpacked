package androidx.compose.foundation.lazy;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyListStateKt$rememberLazyListState$1$1 extends Lambda implements Function0<LazyListState> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f2816g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f2817h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyListStateKt$rememberLazyListState$1$1(int i11, int i12) {
        super(0);
        this.f2816g = i11;
        this.f2817h = i12;
    }

    @NotNull
    public final LazyListState invoke() {
        return new LazyListState(this.f2816g, this.f2817h);
    }
}
