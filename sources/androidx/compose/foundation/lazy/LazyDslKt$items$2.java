package androidx.compose.foundation.lazy;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class LazyDslKt$items$2 extends Lambda implements Function1<Integer, Object> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<T, Object> f2707g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<T> f2708h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyDslKt$items$2(Function1<? super T, ? extends Object> function1, List<? extends T> list) {
        super(1);
        this.f2707g = function1;
        this.f2708h = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @NotNull
    public final Object invoke(int i11) {
        return this.f2707g.invoke(this.f2708h.get(i11));
    }
}
