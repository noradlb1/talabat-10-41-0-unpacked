package j$.util.function;

import java.util.function.LongBinaryOperator;

public final /* synthetic */ class Z implements C0144b0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongBinaryOperator f28829a;

    private /* synthetic */ Z(LongBinaryOperator longBinaryOperator) {
        this.f28829a = longBinaryOperator;
    }

    public static /* synthetic */ C0144b0 a(LongBinaryOperator longBinaryOperator) {
        if (longBinaryOperator == null) {
            return null;
        }
        return longBinaryOperator instanceof C0142a0 ? ((C0142a0) longBinaryOperator).f28831a : new Z(longBinaryOperator);
    }

    public final /* synthetic */ long applyAsLong(long j11, long j12) {
        return this.f28829a.applyAsLong(j11, j12);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof Z) {
            obj = ((Z) obj).f28829a;
        }
        return this.f28829a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28829a.hashCode();
    }
}
