package j$.util.function;

import java.util.function.IntToDoubleFunction;

public final /* synthetic */ class Q implements IntToDoubleFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ S f28820a;

    private /* synthetic */ Q(S s11) {
        this.f28820a = s11;
    }

    public static /* synthetic */ IntToDoubleFunction a(S s11) {
        if (s11 == null) {
            return null;
        }
        return s11 instanceof P ? ((P) s11).f28817a : new Q(s11);
    }

    public final /* synthetic */ double applyAsDouble(int i11) {
        return ((P) this.f28820a).a(i11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        S s11 = this.f28820a;
        if (obj instanceof Q) {
            obj = ((Q) obj).f28820a;
        }
        return s11.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28820a.hashCode();
    }
}
