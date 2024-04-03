package j$.util.function;

import java.util.function.LongBinaryOperator;

/* renamed from: j$.util.function.a0  reason: case insensitive filesystem */
public final /* synthetic */ class C0142a0 implements LongBinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0144b0 f28831a;

    private /* synthetic */ C0142a0(C0144b0 b0Var) {
        this.f28831a = b0Var;
    }

    public static /* synthetic */ LongBinaryOperator a(C0144b0 b0Var) {
        if (b0Var == null) {
            return null;
        }
        return b0Var instanceof Z ? ((Z) b0Var).f28829a : new C0142a0(b0Var);
    }

    public final /* synthetic */ long applyAsLong(long j11, long j12) {
        return this.f28831a.applyAsLong(j11, j12);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        C0144b0 b0Var = this.f28831a;
        if (obj instanceof C0142a0) {
            obj = ((C0142a0) obj).f28831a;
        }
        return b0Var.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28831a.hashCode();
    }
}
