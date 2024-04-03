package j$.lang;

import j$.util.C0189n;
import j$.util.Collection;
import j$.util.List;
import j$.util.Set;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

public interface Iterable<T> {

    /* renamed from: j$.lang.Iterable$-CC  reason: invalid class name */
    public final /* synthetic */ class CC<T> {
        public static void $default$forEach(Iterable iterable, Consumer consumer) {
            Objects.requireNonNull(consumer);
            for (Object accept : iterable) {
                consumer.accept(accept);
            }
        }

        public static Spliterator $default$spliterator(Iterable iterable) {
            return Spliterators.spliteratorUnknownSize(iterable.iterator(), 0);
        }
    }

    /* renamed from: j$.lang.Iterable$-EL  reason: invalid class name */
    public final /* synthetic */ class EL {
        public static void forEach(Iterable iterable, Consumer consumer) {
            if (iterable instanceof Iterable) {
                ((Iterable) iterable).forEach(consumer);
            } else if (iterable instanceof Collection) {
                Objects.requireNonNull(consumer);
                for (Object accept : (Collection) iterable) {
                    consumer.accept(accept);
                }
            } else {
                CC.$default$forEach(iterable, consumer);
            }
        }

        public static /* synthetic */ Spliterator spliterator(Iterable iterable) {
            return iterable instanceof Iterable ? ((Iterable) iterable).spliterator() : iterable instanceof LinkedHashSet ? C0189n.q((LinkedHashSet) iterable) : iterable instanceof SortedSet ? C0189n.l((SortedSet) iterable) : iterable instanceof Set ? Set.CC.$default$spliterator((java.util.Set) iterable) : iterable instanceof List ? List.CC.$default$spliterator((java.util.List) iterable) : iterable instanceof Collection ? Collection.CC.$default$spliterator((java.util.Collection) iterable) : CC.$default$spliterator(iterable);
        }
    }

    void forEach(Consumer<? super T> consumer);

    Iterator<T> iterator();

    Spliterator<T> spliterator();
}
