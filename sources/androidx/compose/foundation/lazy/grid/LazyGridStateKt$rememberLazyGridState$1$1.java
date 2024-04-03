package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyGridStateKt$rememberLazyGridState$1$1 extends Lambda implements Function0<LazyGridState> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f2968g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f2969h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridStateKt$rememberLazyGridState$1$1(int i11, int i12) {
        super(0);
        this.f2968g = i11;
        this.f2969h = i12;
    }

    @NotNull
    public final LazyGridState invoke() {
        return new LazyGridState(this.f2968g, this.f2969h);
    }
}
