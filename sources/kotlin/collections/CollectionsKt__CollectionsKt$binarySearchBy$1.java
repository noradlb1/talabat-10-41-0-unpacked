package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "K", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class CollectionsKt__CollectionsKt$binarySearchBy$1 extends Lambda implements Function1<T, Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<T, K> f23793g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ K f23794h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(Function1<? super T, ? extends K> function1, K k11) {
        super(1);
        this.f23793g = function1;
        this.f23794h = k11;
    }

    @NotNull
    public final Integer invoke(T t11) {
        return Integer.valueOf(ComparisonsKt__ComparisonsKt.compareValues((Comparable) this.f23793g.invoke(t11), this.f23794h));
    }
}
