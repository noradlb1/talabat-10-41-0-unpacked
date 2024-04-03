package j$.util.function;

import j$.util.function.BiFunction;
import java.util.function.BinaryOperator;

/* renamed from: j$.util.function.e  reason: case insensitive filesystem */
public final /* synthetic */ class C0149e implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BinaryOperator f28842a;

    private /* synthetic */ C0149e(BinaryOperator binaryOperator) {
        this.f28842a = binaryOperator;
    }

    public static /* synthetic */ BinaryOperator a(BinaryOperator binaryOperator) {
        if (binaryOperator == null) {
            return null;
        }
        return binaryOperator instanceof C0151f ? ((C0151f) binaryOperator).f28844a : new C0149e(binaryOperator);
    }

    public final /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.VivifiedWrapper.convert(this.f28842a.andThen(D.a(function)));
    }

    public final /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.f28842a.apply(obj, obj2);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0149e) {
            obj = ((C0149e) obj).f28842a;
        }
        return this.f28842a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28842a.hashCode();
    }
}
