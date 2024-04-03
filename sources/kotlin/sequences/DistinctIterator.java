package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B)\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0005\u001a\u00020\u0004H\u0014R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR$\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00028\u00010\fj\b\u0012\u0004\u0012\u00028\u0001`\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lkotlin/sequences/DistinctIterator;", "T", "K", "Lkotlin/collections/AbstractIterator;", "", "a", "", "source", "Ljava/util/Iterator;", "Lkotlin/Function1;", "keySelector", "Lkotlin/jvm/functions/Function1;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "observed", "Ljava/util/HashSet;", "<init>", "(Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
final class DistinctIterator<T, K> extends AbstractIterator<T> {
    @NotNull
    private final Function1<T, K> keySelector;
    @NotNull
    private final HashSet<K> observed = new HashSet<>();
    @NotNull
    private final Iterator<T> source;

    public DistinctIterator(@NotNull Iterator<? extends T> it, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(it, "source");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        this.source = it;
        this.keySelector = function1;
    }

    public void a() {
        while (this.source.hasNext()) {
            T next = this.source.next();
            if (this.observed.add(this.keySelector.invoke(next))) {
                c(next);
                return;
            }
        }
        b();
    }
}
