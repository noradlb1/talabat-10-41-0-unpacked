package androidx.compose.runtime.collection;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"androidx/compose/runtime/collection/IdentityArraySet$iterator$1", "", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IdentityArraySet$iterator$1 implements Iterator<T>, KMappedMarker, j$.util.Iterator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IdentityArraySet<T> f9259b;
    private int index;

    public IdentityArraySet$iterator$1(IdentityArraySet<T> identityArraySet) {
        this.f9259b = identityArraySet;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        return this.index < this.f9259b.size();
    }

    @NotNull
    public T next() {
        T[] values = this.f9259b.getValues();
        int i11 = this.index;
        this.index = i11 + 1;
        T t11 = values[i11];
        Intrinsics.checkNotNull(t11, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        return t11;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i11) {
        this.index = i11;
    }
}
