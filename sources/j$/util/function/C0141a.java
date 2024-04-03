package j$.util.function;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Function;

/* renamed from: j$.util.function.a  reason: case insensitive filesystem */
public final /* synthetic */ class C0141a implements BiFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BiFunction f28830a;

    private /* synthetic */ C0141a(BiFunction biFunction) {
        this.f28830a = biFunction;
    }

    public static /* synthetic */ BiFunction a(BiFunction biFunction) {
        if (biFunction == null) {
            return null;
        }
        return biFunction instanceof BiFunction.VivifiedWrapper ? ((BiFunction.VivifiedWrapper) biFunction).f28786a : biFunction instanceof BinaryOperator ? C0151f.a((BinaryOperator) biFunction) : new C0141a(biFunction);
    }

    public final /* synthetic */ java.util.function.BiFunction andThen(Function function) {
        return a(this.f28830a.andThen(Function.VivifiedWrapper.convert(function)));
    }

    public final /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.f28830a.apply(obj, obj2);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        BiFunction biFunction = this.f28830a;
        if (obj instanceof C0141a) {
            obj = ((C0141a) obj).f28830a;
        }
        return biFunction.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28830a.hashCode();
    }
}
