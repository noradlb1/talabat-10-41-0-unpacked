package j$.util.function;

import java.util.function.ObjLongConsumer;

public final /* synthetic */ class C0 implements ObjLongConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ D0 f28790a;

    private /* synthetic */ C0(D0 d02) {
        this.f28790a = d02;
    }

    public static /* synthetic */ ObjLongConsumer a(D0 d02) {
        if (d02 == null) {
            return null;
        }
        return d02 instanceof B0 ? ((B0) d02).f28783a : new C0(d02);
    }

    public final /* synthetic */ void accept(Object obj, long j11) {
        this.f28790a.accept(obj, j11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        D0 d02 = this.f28790a;
        if (obj instanceof C0) {
            obj = ((C0) obj).f28790a;
        }
        return d02.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28790a.hashCode();
    }
}
