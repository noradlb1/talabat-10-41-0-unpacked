package j$.util.stream;

import j$.util.C0189n;
import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Consumer;
import java.util.Comparator;

/* renamed from: j$.util.stream.r3  reason: case insensitive filesystem */
final class C0282r3 implements Spliterator, Consumer {

    /* renamed from: d  reason: collision with root package name */
    private static final Object f29214d = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Spliterator f29215a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap f29216b;

    /* renamed from: c  reason: collision with root package name */
    private Object f29217c;

    C0282r3(Spliterator spliterator) {
        this(spliterator, new ConcurrentHashMap());
    }

    private C0282r3(Spliterator spliterator, ConcurrentHashMap concurrentHashMap) {
        this.f29215a = spliterator;
        this.f29216b = concurrentHashMap;
    }

    public final boolean a(Consumer consumer) {
        while (this.f29215a.a(this)) {
            Object obj = this.f29217c;
            if (obj == null) {
                obj = f29214d;
            }
            if (this.f29216b.putIfAbsent(obj, Boolean.TRUE) == null) {
                consumer.accept(this.f29217c);
                this.f29217c = null;
                return true;
            }
        }
        return false;
    }

    public final void accept(Object obj) {
        this.f29217c = obj;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final int characteristics() {
        return (this.f29215a.characteristics() & -16469) | 1;
    }

    public final long estimateSize() {
        return this.f29215a.estimateSize();
    }

    public final void forEachRemaining(Consumer consumer) {
        this.f29215a.forEachRemaining(new C0269p(6, this, consumer));
    }

    public final Comparator getComparator() {
        return this.f29215a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0189n.i(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return C0189n.k(this, i11);
    }

    /* access modifiers changed from: package-private */
    public final void i(Consumer consumer, Object obj) {
        if (this.f29216b.putIfAbsent(obj != null ? obj : f29214d, Boolean.TRUE) == null) {
            consumer.accept(obj);
        }
    }

    public final Spliterator trySplit() {
        Spliterator trySplit = this.f29215a.trySplit();
        if (trySplit != null) {
            return new C0282r3(trySplit, this.f29216b);
        }
        return null;
    }
}
