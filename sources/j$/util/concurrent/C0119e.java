package j$.util.concurrent;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: j$.util.concurrent.e  reason: case insensitive filesystem */
final class C0119e extends C0115a implements Iterator, j$.util.Iterator {
    C0119e(E[] eArr, int i11, int i12, ConcurrentHashMap concurrentHashMap) {
        super(eArr, i11, i12, concurrentHashMap);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, Consumer.VivifiedWrapper.convert(consumer));
    }

    public final Object next() {
        E e11 = this.f28655b;
        if (e11 != null) {
            Object obj = e11.f28632b;
            Object obj2 = e11.f28633c;
            this.f28695j = e11;
            f();
            return new C0128n(obj, obj2, this.f28694i);
        }
        throw new NoSuchElementException();
    }
}
