package j$.util.function;

import java.util.function.IntConsumer;

public final /* synthetic */ class J implements IntConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ K f28807a;

    private /* synthetic */ J(K k11) {
        this.f28807a = k11;
    }

    public static /* synthetic */ IntConsumer a(K k11) {
        if (k11 == null) {
            return null;
        }
        return k11 instanceof I ? ((I) k11).f28804a : new J(k11);
    }

    public final /* synthetic */ void accept(int i11) {
        this.f28807a.accept(i11);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a(this.f28807a.n(I.a(intConsumer)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        K k11 = this.f28807a;
        if (obj instanceof J) {
            obj = ((J) obj).f28807a;
        }
        return k11.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28807a.hashCode();
    }
}
