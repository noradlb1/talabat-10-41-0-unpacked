package androidx.compose.foundation.lazy.grid;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class LazyGridDslKt$itemsIndexed$2 extends Lambda implements Function1<Integer, Object> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Integer, T, Object> f2870g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<T> f2871h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridDslKt$itemsIndexed$2(Function2<? super Integer, ? super T, ? extends Object> function2, List<? extends T> list) {
        super(1);
        this.f2870g = function2;
        this.f2871h = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @NotNull
    public final Object invoke(int i11) {
        return this.f2870g.invoke(Integer.valueOf(i11), this.f2871h.get(i11));
    }
}
