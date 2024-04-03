package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "", "a", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComparisonsKt__ComparisonsKt$nullsFirst$1<T> implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Comparator<? super T> f23832b;

    public ComparisonsKt__ComparisonsKt$nullsFirst$1(Comparator<? super T> comparator) {
        this.f23832b = comparator;
    }

    public final int compare(@Nullable T t11, @Nullable T t12) {
        if (t11 == t12) {
            return 0;
        }
        if (t11 == null) {
            return -1;
        }
        if (t12 == null) {
            return 1;
        }
        return this.f23832b.compare(t11, t12);
    }
}
