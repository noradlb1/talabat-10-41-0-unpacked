package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "T", "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class ComparisonsKt__ComparisonsKt$compareBy$3<T> implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Comparator<? super K> f23827b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1<T, K> f23828c;

    public ComparisonsKt__ComparisonsKt$compareBy$3(Comparator<? super K> comparator, Function1<? super T, ? extends K> function1) {
        this.f23827b = comparator;
        this.f23828c = function1;
    }

    public final int compare(T t11, T t12) {
        Comparator<? super K> comparator = this.f23827b;
        Function1<T, K> function1 = this.f23828c;
        return comparator.compare(function1.invoke(t11), function1.invoke(t12));
    }
}
