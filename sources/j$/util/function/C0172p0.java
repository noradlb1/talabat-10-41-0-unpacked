package j$.util.function;

import java.util.function.LongToIntFunction;

/* renamed from: j$.util.function.p0  reason: case insensitive filesystem */
public final /* synthetic */ class C0172p0 implements r0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongToIntFunction f28859a;

    private /* synthetic */ C0172p0(LongToIntFunction longToIntFunction) {
        this.f28859a = longToIntFunction;
    }

    public static /* synthetic */ r0 b(LongToIntFunction longToIntFunction) {
        if (longToIntFunction == null) {
            return null;
        }
        return longToIntFunction instanceof q0 ? ((q0) longToIntFunction).f28861a : new C0172p0(longToIntFunction);
    }

    public final /* synthetic */ int a(long j11) {
        return this.f28859a.applyAsInt(j11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0172p0) {
            obj = ((C0172p0) obj).f28859a;
        }
        return this.f28859a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28859a.hashCode();
    }
}
