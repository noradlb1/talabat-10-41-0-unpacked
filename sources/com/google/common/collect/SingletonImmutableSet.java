package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    final transient E element;

    public SingletonImmutableSet(E e11) {
        this.element = Preconditions.checkNotNull(e11);
    }

    public ImmutableList<E> asList() {
        return ImmutableList.of(this.element);
    }

    public boolean contains(@CheckForNull Object obj) {
        return this.element.equals(obj);
    }

    public int copyIntoArray(Object[] objArr, int i11) {
        objArr[i11] = this.element;
        return i11 + 1;
    }

    public final int hashCode() {
        return this.element.hashCode();
    }

    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return 1;
    }

    public String toString() {
        return '[' + this.element.toString() + AbstractJsonLexerKt.END_LIST;
    }

    public UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }
}
