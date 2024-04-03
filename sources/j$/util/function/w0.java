package j$.util.function;

import java.util.function.ObjDoubleConsumer;

public final /* synthetic */ class w0 implements ObjDoubleConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x0 f28869a;

    private /* synthetic */ w0(x0 x0Var) {
        this.f28869a = x0Var;
    }

    public static /* synthetic */ ObjDoubleConsumer a(x0 x0Var) {
        if (x0Var == null) {
            return null;
        }
        return x0Var instanceof v0 ? ((v0) x0Var).f28867a : new w0(x0Var);
    }

    public final /* synthetic */ void accept(Object obj, double d11) {
        this.f28869a.accept(obj, d11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        x0 x0Var = this.f28869a;
        if (obj instanceof w0) {
            obj = ((w0) obj).f28869a;
        }
        return x0Var.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28869a.hashCode();
    }
}
