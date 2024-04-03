package j$.util.function;

import java.util.function.ObjIntConsumer;

public final /* synthetic */ class y0 implements A0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ObjIntConsumer f28871a;

    private /* synthetic */ y0(ObjIntConsumer objIntConsumer) {
        this.f28871a = objIntConsumer;
    }

    public static /* synthetic */ A0 a(ObjIntConsumer objIntConsumer) {
        if (objIntConsumer == null) {
            return null;
        }
        return objIntConsumer instanceof z0 ? ((z0) objIntConsumer).f28873a : new y0(objIntConsumer);
    }

    public final /* synthetic */ void accept(Object obj, int i11) {
        this.f28871a.accept(obj, i11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof y0) {
            obj = ((y0) obj).f28871a;
        }
        return this.f28871a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28871a.hashCode();
    }
}
