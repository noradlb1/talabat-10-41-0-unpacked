package j$.util.function;

import j$.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/* renamed from: j$.util.function.f  reason: case insensitive filesystem */
public final /* synthetic */ class C0151f implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BinaryOperator f28844a;

    private /* synthetic */ C0151f(BinaryOperator binaryOperator) {
        this.f28844a = binaryOperator;
    }

    public static /* synthetic */ BinaryOperator a(BinaryOperator binaryOperator) {
        if (binaryOperator == null) {
            return null;
        }
        return binaryOperator instanceof C0149e ? ((C0149e) binaryOperator).f28842a : new C0151f(binaryOperator);
    }

    public final /* synthetic */ BiFunction andThen(Function function) {
        return C0141a.a(this.f28844a.andThen(Function.VivifiedWrapper.convert(function)));
    }

    public final /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.f28844a.apply(obj, obj2);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        BinaryOperator binaryOperator = this.f28844a;
        if (obj instanceof C0151f) {
            obj = ((C0151f) obj).f28844a;
        }
        return binaryOperator.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28844a.hashCode();
    }
}
