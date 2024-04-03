package androidx.compose.foundation.lazy.staggeredgrid;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridDslKt$items$3 extends Lambda implements Function1<Integer, Object> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<T, Object> f3102g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<T> f3103h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridDslKt$items$3(Function1<? super T, ? extends Object> function1, List<? extends T> list) {
        super(1);
        this.f3102g = function1;
        this.f3103h = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @Nullable
    public final Object invoke(int i11) {
        return this.f3102g.invoke(this.f3103h.get(i11));
    }
}
