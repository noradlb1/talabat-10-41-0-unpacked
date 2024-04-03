package j$.util;

import j$.util.function.UnaryOperator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;

public interface List<E> extends Collection<E> {

    /* renamed from: j$.util.List$-CC  reason: invalid class name */
    public final /* synthetic */ class CC<E> {
        public static Spliterator $default$spliterator(java.util.List list) {
            if (list instanceof RandomAccess) {
                return new C0112a(list);
            }
            Objects.requireNonNull(list);
            return new X(16, (Collection) list);
        }
    }

    /* renamed from: j$.util.List$-EL  reason: invalid class name */
    public final /* synthetic */ class EL {
        public static void sort(java.util.List list, Comparator comparator) {
            if (list instanceof List) {
                ((List) list).sort(comparator);
                return;
            }
            Object[] array = list.toArray();
            Arrays.sort(array, comparator);
            ListIterator listIterator = list.listIterator();
            for (Object obj : array) {
                listIterator.next();
                listIterator.set(obj);
            }
        }
    }

    void add(int i11, E e11);

    boolean add(E e11);

    boolean addAll(int i11, Collection<? extends E> collection);

    boolean addAll(Collection<? extends E> collection);

    void clear();

    boolean contains(Object obj);

    boolean containsAll(Collection<?> collection);

    boolean equals(Object obj);

    E get(int i11);

    int hashCode();

    int indexOf(Object obj);

    boolean isEmpty();

    Iterator<E> iterator();

    int lastIndexOf(Object obj);

    ListIterator<E> listIterator();

    ListIterator<E> listIterator(int i11);

    E remove(int i11);

    boolean remove(Object obj);

    boolean removeAll(Collection<?> collection);

    void replaceAll(UnaryOperator<E> unaryOperator);

    boolean retainAll(Collection<?> collection);

    E set(int i11, E e11);

    int size();

    void sort(Comparator<? super E> comparator);

    Spliterator<E> spliterator();

    java.util.List<E> subList(int i11, int i12);

    Object[] toArray();

    <T> T[] toArray(T[] tArr);
}
