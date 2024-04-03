package kotlin.sequences;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\t\u001a\u00020\nH\u0002J\t\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\rR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0004¨\u0006\u000e"}, d2 = {"kotlin/sequences/FlatteningSequence$iterator$1", "", "itemIterator", "getItemIterator", "()Ljava/util/Iterator;", "setItemIterator", "(Ljava/util/Iterator;)V", "iterator", "getIterator", "ensureItemIterator", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FlatteningSequence$iterator$1 implements Iterator<E>, KMappedMarker, j$.util.Iterator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlatteningSequence<T, R, E> f24990b;
    @Nullable
    private Iterator<? extends E> itemIterator;
    @NotNull
    private final Iterator<T> iterator;

    public FlatteningSequence$iterator$1(FlatteningSequence<T, R, E> flatteningSequence) {
        this.f24990b = flatteningSequence;
        this.iterator = flatteningSequence.sequence.iterator();
    }

    private final boolean ensureItemIterator() {
        boolean z11;
        Iterator<? extends E> it = this.itemIterator;
        if (it == null || it.hasNext()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            this.itemIterator = null;
        }
        while (true) {
            if (this.itemIterator == null) {
                if (this.iterator.hasNext()) {
                    Iterator<? extends E> it2 = (Iterator) this.f24990b.iterator.invoke(this.f24990b.transformer.invoke(this.iterator.next()));
                    if (it2.hasNext()) {
                        this.itemIterator = it2;
                        break;
                    }
                } else {
                    return false;
                }
            } else {
                break;
            }
        }
        return true;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    @Nullable
    public final java.util.Iterator<E> getItemIterator() {
        return this.itemIterator;
    }

    @NotNull
    public final java.util.Iterator<T> getIterator() {
        return this.iterator;
    }

    public boolean hasNext() {
        return ensureItemIterator();
    }

    public E next() {
        if (ensureItemIterator()) {
            java.util.Iterator<? extends E> it = this.itemIterator;
            Intrinsics.checkNotNull(it);
            return it.next();
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setItemIterator(@Nullable java.util.Iterator<? extends E> it) {
        this.itemIterator = it;
    }
}
