package kotlin.collections;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"kotlin/collections/CollectionsKt__IteratorsJVMKt$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CollectionsKt__IteratorsJVMKt$iterator$1 implements Iterator<T>, KMappedMarker, j$.util.Iterator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Enumeration<T> f23796b;

    public CollectionsKt__IteratorsJVMKt$iterator$1(Enumeration<T> enumeration) {
        this.f23796b = enumeration;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public boolean hasNext() {
        return this.f23796b.hasMoreElements();
    }

    public T next() {
        return this.f23796b.nextElement();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
