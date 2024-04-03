package j$.util.concurrent;

/* renamed from: j$.util.concurrent.a  reason: case insensitive filesystem */
abstract class C0115a extends N {

    /* renamed from: i  reason: collision with root package name */
    final ConcurrentHashMap f28694i;

    /* renamed from: j  reason: collision with root package name */
    E f28695j;

    C0115a(E[] eArr, int i11, int i12, ConcurrentHashMap concurrentHashMap) {
        super(eArr, i11, 0, i12);
        this.f28694i = concurrentHashMap;
        f();
    }

    public final boolean hasMoreElements() {
        return this.f28655b != null;
    }

    public final boolean hasNext() {
        return this.f28655b != null;
    }

    public final void remove() {
        E e11 = this.f28695j;
        if (e11 != null) {
            this.f28695j = null;
            this.f28694i.replaceNode(e11.f28632b, null, (Object) null);
            return;
        }
        throw new IllegalStateException();
    }
}
