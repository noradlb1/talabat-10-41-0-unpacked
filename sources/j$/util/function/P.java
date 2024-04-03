package j$.util.function;

import java.util.function.IntToDoubleFunction;

public final /* synthetic */ class P implements S {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntToDoubleFunction f28817a;

    private /* synthetic */ P(IntToDoubleFunction intToDoubleFunction) {
        this.f28817a = intToDoubleFunction;
    }

    public static /* synthetic */ S b(IntToDoubleFunction intToDoubleFunction) {
        if (intToDoubleFunction == null) {
            return null;
        }
        return intToDoubleFunction instanceof Q ? ((Q) intToDoubleFunction).f28820a : new P(intToDoubleFunction);
    }

    public final /* synthetic */ double a(int i11) {
        return this.f28817a.applyAsDouble(i11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof P) {
            obj = ((P) obj).f28817a;
        }
        return this.f28817a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28817a.hashCode();
    }
}
