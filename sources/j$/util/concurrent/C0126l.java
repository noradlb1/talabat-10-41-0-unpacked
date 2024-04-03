package j$.util.concurrent;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: j$.util.concurrent.l  reason: case insensitive filesystem */
final class C0126l extends C0115a implements Iterator, Enumeration, j$.util.Iterator {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f28717k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0126l(E[] eArr, int i11, int i12, ConcurrentHashMap concurrentHashMap, int i13) {
        super(eArr, i11, i12, concurrentHashMap);
        this.f28717k = i13;
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        switch (this.f28717k) {
            case 0:
                Iterator.CC.$default$forEachRemaining(this, consumer);
                return;
            default:
                Iterator.CC.$default$forEachRemaining(this, consumer);
                return;
        }
    }

    public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        switch (this.f28717k) {
            case 0:
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                return;
            default:
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                return;
        }
    }

    public final Object next() {
        switch (this.f28717k) {
            case 0:
                E e11 = this.f28655b;
                if (e11 != null) {
                    this.f28695j = e11;
                    f();
                    return e11.f28632b;
                }
                throw new NoSuchElementException();
            default:
                E e12 = this.f28655b;
                if (e12 != null) {
                    Object obj = e12.f28633c;
                    this.f28695j = e12;
                    f();
                    return obj;
                }
                throw new NoSuchElementException();
        }
    }

    public final Object nextElement() {
        switch (this.f28717k) {
            case 0:
                return next();
            default:
                return next();
        }
    }
}
