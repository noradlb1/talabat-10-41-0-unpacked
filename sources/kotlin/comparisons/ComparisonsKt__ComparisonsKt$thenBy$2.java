package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "T", "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class ComparisonsKt__ComparisonsKt$thenBy$2<T> implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Comparator<T> f23838b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Comparator<? super K> f23839c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function1<T, K> f23840d;

    public ComparisonsKt__ComparisonsKt$thenBy$2(Comparator<T> comparator, Comparator<? super K> comparator2, Function1<? super T, ? extends K> function1) {
        this.f23838b = comparator;
        this.f23839c = comparator2;
        this.f23840d = function1;
    }

    public final int compare(T t11, T t12) {
        int compare = this.f23838b.compare(t11, t12);
        if (compare != 0) {
            return compare;
        }
        Comparator<? super K> comparator = this.f23839c;
        Function1<T, K> function1 = this.f23840d;
        return comparator.compare(function1.invoke(t11), function1.invoke(t12));
    }
}
