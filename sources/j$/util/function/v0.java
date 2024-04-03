package j$.util.function;

import java.util.function.ObjDoubleConsumer;

public final /* synthetic */ class v0 implements x0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ObjDoubleConsumer f28867a;

    private /* synthetic */ v0(ObjDoubleConsumer objDoubleConsumer) {
        this.f28867a = objDoubleConsumer;
    }

    public static /* synthetic */ x0 a(ObjDoubleConsumer objDoubleConsumer) {
        if (objDoubleConsumer == null) {
            return null;
        }
        return objDoubleConsumer instanceof w0 ? ((w0) objDoubleConsumer).f28869a : new v0(objDoubleConsumer);
    }

    public final /* synthetic */ void accept(Object obj, double d11) {
        this.f28867a.accept(obj, d11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof v0) {
            obj = ((v0) obj).f28867a;
        }
        return this.f28867a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28867a.hashCode();
    }
}
