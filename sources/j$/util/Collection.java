package j$.util;

import j$.lang.Iterable;
import j$.util.List;
import j$.util.Set;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import j$.util.stream.StreamSupport;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

public interface Collection<E> extends Iterable<E> {

    /* renamed from: j$.util.Collection$-CC  reason: invalid class name */
    public final /* synthetic */ class CC<E> {
        public static Stream $default$parallelStream(java.util.Collection collection) {
            return StreamSupport.stream(EL.a(collection), true);
        }

        public static boolean $default$removeIf(java.util.Collection collection, Predicate predicate) {
            if (DesugarCollections.f28542a.isInstance(collection)) {
                return DesugarCollections.c(collection, predicate);
            }
            Objects.requireNonNull(predicate);
            Iterator it = collection.iterator();
            boolean z11 = false;
            while (it.hasNext()) {
                if (predicate.test(it.next())) {
                    it.remove();
                    z11 = true;
                }
            }
            return z11;
        }

        public static Spliterator $default$spliterator(java.util.Collection collection) {
            Objects.requireNonNull(collection);
            return new X(0, collection);
        }

        public static Stream $default$stream(java.util.Collection collection) {
            return StreamSupport.stream(EL.a(collection), false);
        }

        public static Object[] $default$toArray(java.util.Collection collection, IntFunction intFunction) {
            return collection.toArray((Object[]) intFunction.apply(0));
        }
    }

    /* renamed from: j$.util.Collection$-EL  reason: invalid class name */
    public final /* synthetic */ class EL {
        public static Spliterator a(java.util.Collection collection) {
            if (collection instanceof Collection) {
                return ((Collection) collection).spliterator();
            }
            if (collection instanceof LinkedHashSet) {
                LinkedHashSet linkedHashSet = (LinkedHashSet) collection;
                Objects.requireNonNull(linkedHashSet);
                return new X(17, (java.util.Collection) linkedHashSet);
            } else if (!(collection instanceof SortedSet)) {
                return collection instanceof Set ? Set.CC.$default$spliterator((java.util.Set) collection) : collection instanceof List ? List.CC.$default$spliterator((java.util.List) collection) : CC.$default$spliterator(collection);
            } else {
                SortedSet sortedSet = (SortedSet) collection;
                return new C0325x(sortedSet, sortedSet);
            }
        }

        public static /* synthetic */ Stream stream(java.util.Collection collection) {
            return collection instanceof Collection ? ((Collection) collection).stream() : CC.$default$stream(collection);
        }
    }

    boolean add(E e11);

    boolean addAll(java.util.Collection<? extends E> collection);

    void clear();

    boolean contains(Object obj);

    boolean containsAll(java.util.Collection<?> collection);

    boolean equals(Object obj);

    void forEach(Consumer<? super E> consumer);

    int hashCode();

    boolean isEmpty();

    Iterator<E> iterator();

    Stream<E> parallelStream();

    boolean remove(Object obj);

    boolean removeAll(java.util.Collection<?> collection);

    boolean removeIf(Predicate<? super E> predicate);

    boolean retainAll(java.util.Collection<?> collection);

    int size();

    Spliterator<E> spliterator();

    Stream<E> stream();

    Object[] toArray();

    <T> T[] toArray(IntFunction<T[]> intFunction);

    <T> T[] toArray(T[] tArr);
}
