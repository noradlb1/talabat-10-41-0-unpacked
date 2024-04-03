package j$.util.function;

import java.util.function.ObjLongConsumer;

public final /* synthetic */ class B0 implements D0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ObjLongConsumer f28783a;

    private /* synthetic */ B0(ObjLongConsumer objLongConsumer) {
        this.f28783a = objLongConsumer;
    }

    public static /* synthetic */ D0 a(ObjLongConsumer objLongConsumer) {
        if (objLongConsumer == null) {
            return null;
        }
        return objLongConsumer instanceof C0 ? ((C0) objLongConsumer).f28790a : new B0(objLongConsumer);
    }

    public final /* synthetic */ void accept(Object obj, long j11) {
        this.f28783a.accept(obj, j11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof B0) {
            obj = ((B0) obj).f28783a;
        }
        return this.f28783a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28783a.hashCode();
    }
}
