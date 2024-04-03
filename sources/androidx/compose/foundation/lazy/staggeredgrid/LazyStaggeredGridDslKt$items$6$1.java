package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridDslKt$items$6$1 extends Lambda implements Function1<Integer, Object> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<T, Object> f3106g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ T[] f3107h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridDslKt$items$6$1(Function1<? super T, ? extends Object> function1, T[] tArr) {
        super(1);
        this.f3106g = function1;
        this.f3107h = tArr;
    }

    @NotNull
    public final Object invoke(int i11) {
        return this.f3106g.invoke(this.f3107h[i11]);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
