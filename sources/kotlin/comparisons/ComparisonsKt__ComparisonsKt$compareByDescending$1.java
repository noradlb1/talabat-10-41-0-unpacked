package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class ComparisonsKt__ComparisonsKt$compareByDescending$1<T> implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1<T, Comparable<?>> f23829b;

    public ComparisonsKt__ComparisonsKt$compareByDescending$1(Function1<? super T, ? extends Comparable<?>> function1) {
        this.f23829b = function1;
    }

    public final int compare(T t11, T t12) {
        Function1<T, Comparable<?>> function1 = this.f23829b;
        return ComparisonsKt__ComparisonsKt.compareValues(function1.invoke(t12), function1.invoke(t11));
    }
}
