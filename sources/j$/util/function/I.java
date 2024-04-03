package j$.util.function;

import java.util.function.IntConsumer;

public final /* synthetic */ class I implements K {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntConsumer f28804a;

    private /* synthetic */ I(IntConsumer intConsumer) {
        this.f28804a = intConsumer;
    }

    public static /* synthetic */ K a(IntConsumer intConsumer) {
        if (intConsumer == null) {
            return null;
        }
        return intConsumer instanceof J ? ((J) intConsumer).f28807a : new I(intConsumer);
    }

    public final /* synthetic */ void accept(int i11) {
        this.f28804a.accept(i11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof I) {
            obj = ((I) obj).f28804a;
        }
        return this.f28804a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28804a.hashCode();
    }

    public final /* synthetic */ K n(K k11) {
        return a(this.f28804a.andThen(J.a(k11)));
    }
}
