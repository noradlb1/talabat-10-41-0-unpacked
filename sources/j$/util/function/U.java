package j$.util.function;

import java.util.function.IntToLongFunction;

public final /* synthetic */ class U implements IntToLongFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ V f28825a;

    private /* synthetic */ U(V v11) {
        this.f28825a = v11;
    }

    public static /* synthetic */ IntToLongFunction a(V v11) {
        if (v11 == null) {
            return null;
        }
        return v11 instanceof T ? ((T) v11).f28821a : new U(v11);
    }

    public final /* synthetic */ long applyAsLong(int i11) {
        return ((T) this.f28825a).a(i11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        V v11 = this.f28825a;
        if (obj instanceof U) {
            obj = ((U) obj).f28825a;
        }
        return v11.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28825a.hashCode();
    }
}
