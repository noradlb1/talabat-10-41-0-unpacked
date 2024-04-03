package androidx.compose.runtime.external.kotlinx.collections.immutable.adapters;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H\u0003¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0001J\u0013\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0016\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0016\u0010\u0018\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u0019J\t\u0010\u001a\u001a\u00020\u000bH\u0001J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0003J\u0016\u0010\u001d\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u0019J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0001J\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0006\u0010\u0015\u001a\u00020\u0007H\u0001J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020$H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u0007X\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006%"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/adapters/ImmutableListAdapter;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "", "impl", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "equals", "other", "", "get", "index", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "toString", "", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ImmutableListAdapter<E> implements ImmutableList<E>, List<E>, KMappedMarker, j$.util.List {
    @NotNull
    private final List<E> impl;

    public ImmutableListAdapter(@NotNull List<? extends E> list) {
        Intrinsics.checkNotNullParameter(list, "impl");
        this.impl = list;
    }

    public void add(int i11, E e11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(E e11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i11, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        return this.impl.contains(obj);
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.impl.containsAll(collection);
    }

    public boolean equals(@Nullable Object obj) {
        return this.impl.equals(obj);
    }

    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
        forEach(Consumer.VivifiedWrapper.convert(consumer));
    }

    public E get(int i11) {
        return this.impl.get(i11);
    }

    public int getSize() {
        return this.impl.size();
    }

    public int hashCode() {
        return this.impl.hashCode();
    }

    public int indexOf(Object obj) {
        return this.impl.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.impl.isEmpty();
    }

    @NotNull
    public Iterator<E> iterator() {
        return this.impl.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.impl.lastIndexOf(obj);
    }

    @NotNull
    public ListIterator<E> listIterator() {
        return this.impl.listIterator();
    }

    @NotNull
    public ListIterator<E> listIterator(int i11) {
        return this.impl.listIterator(i11);
    }

    public E remove(int i11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    public /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
        return removeIf(Predicate.VivifiedWrapper.convert(predicate));
    }

    public void replaceAll(UnaryOperator<E> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ void replaceAll(java.util.function.UnaryOperator unaryOperator) {
        replaceAll(UnaryOperator.VivifiedWrapper.convert(unaryOperator));
    }

    public boolean retainAll(java.util.Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public E set(int i11, E e11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public void sort(Comparator<? super E> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection.CC.$default$toArray(this, intFunction);
    }

    public /* synthetic */ Object[] toArray(java.util.function.IntFunction intFunction) {
        return toArray(IntFunction.VivifiedWrapper.convert(intFunction));
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray(this, tArr);
    }

    @NotNull
    public String toString() {
        return this.impl.toString();
    }

    @NotNull
    public ImmutableList<E> subList(int i11, int i12) {
        return new ImmutableListAdapter(this.impl.subList(i11, i12));
    }
}
