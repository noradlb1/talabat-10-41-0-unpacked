package j$.util.function;

import j$.util.function.ToIntFunction;
import java.util.function.ToIntFunction;

public final /* synthetic */ class M0 implements ToIntFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ToIntFunction f28813a;

    private /* synthetic */ M0(ToIntFunction toIntFunction) {
        this.f28813a = toIntFunction;
    }

    public static /* synthetic */ ToIntFunction a(ToIntFunction toIntFunction) {
        if (toIntFunction == null) {
            return null;
        }
        return toIntFunction instanceof ToIntFunction.VivifiedWrapper ? ((ToIntFunction.VivifiedWrapper) toIntFunction).f28823a : new M0(toIntFunction);
    }

    public final /* synthetic */ int applyAsInt(Object obj) {
        return this.f28813a.applyAsInt(obj);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        ToIntFunction toIntFunction = this.f28813a;
        if (obj instanceof M0) {
            obj = ((M0) obj).f28813a;
        }
        return toIntFunction.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28813a.hashCode();
    }
}
