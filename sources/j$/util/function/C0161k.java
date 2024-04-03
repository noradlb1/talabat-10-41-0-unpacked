package j$.util.function;

import java.util.function.DoubleConsumer;

/* renamed from: j$.util.function.k  reason: case insensitive filesystem */
public final /* synthetic */ class C0161k implements C0165m {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoubleConsumer f28852a;

    private /* synthetic */ C0161k(DoubleConsumer doubleConsumer) {
        this.f28852a = doubleConsumer;
    }

    public static /* synthetic */ C0165m a(DoubleConsumer doubleConsumer) {
        if (doubleConsumer == null) {
            return null;
        }
        return doubleConsumer instanceof C0163l ? ((C0163l) doubleConsumer).f28854a : new C0161k(doubleConsumer);
    }

    public final /* synthetic */ void accept(double d11) {
        this.f28852a.accept(d11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0161k) {
            obj = ((C0161k) obj).f28852a;
        }
        return this.f28852a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28852a.hashCode();
    }

    public final /* synthetic */ C0165m m(C0165m mVar) {
        return a(this.f28852a.andThen(C0163l.a(mVar)));
    }
}
