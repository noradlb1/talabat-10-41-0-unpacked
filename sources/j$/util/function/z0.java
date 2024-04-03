package j$.util.function;

import java.util.function.ObjIntConsumer;

public final /* synthetic */ class z0 implements ObjIntConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A0 f28873a;

    private /* synthetic */ z0(A0 a02) {
        this.f28873a = a02;
    }

    public static /* synthetic */ ObjIntConsumer a(A0 a02) {
        if (a02 == null) {
            return null;
        }
        return a02 instanceof y0 ? ((y0) a02).f28871a : new z0(a02);
    }

    public final /* synthetic */ void accept(Object obj, int i11) {
        this.f28873a.accept(obj, i11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        A0 a02 = this.f28873a;
        if (obj instanceof z0) {
            obj = ((z0) obj).f28873a;
        }
        return a02.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28873a.hashCode();
    }
}
