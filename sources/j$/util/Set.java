package j$.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public interface Set<E> extends Collection<E> {

    /* renamed from: j$.util.Set$-CC  reason: invalid class name */
    public final /* synthetic */ class CC<E> {
        public static Spliterator $default$spliterator(java.util.Set set) {
            Objects.requireNonNull(set);
            return new X(1, (Collection) set);
        }
    }

    boolean add(E e11);

    boolean addAll(Collection<? extends E> collection);

    void clear();

    boolean contains(Object obj);

    boolean containsAll(Collection<?> collection);

    boolean equals(Object obj);

    int hashCode();

    boolean isEmpty();

    Iterator<E> iterator();

    boolean remove(Object obj);

    boolean removeAll(Collection<?> collection);

    boolean retainAll(Collection<?> collection);

    int size();

    Spliterator<E> spliterator();

    Object[] toArray();

    <T> T[] toArray(T[] tArr);
}
