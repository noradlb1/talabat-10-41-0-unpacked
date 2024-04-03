package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public final class HashMultiset<E> extends AbstractMapBasedMultiset<E> {
    @GwtIncompatible
    @J2ktIncompatible
    private static final long serialVersionUID = 0;

    public HashMultiset(int i11) {
        super(i11);
    }

    public static <E> HashMultiset<E> create() {
        return create(3);
    }

    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public ObjectCountHashMap<E> newBackingMap(int i11) {
        return new ObjectCountHashMap<>(i11);
    }

    public static <E> HashMultiset<E> create(int i11) {
        return new HashMultiset<>(i11);
    }

    public static <E> HashMultiset<E> create(Iterable<? extends E> iterable) {
        HashMultiset<E> create = create(Multisets.inferDistinctElements(iterable));
        Iterables.addAll(create, iterable);
        return create;
    }
}
