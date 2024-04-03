package j$.util.function;

import j$.util.function.BiFunction;
import java.util.Comparator;

/* renamed from: j$.util.function.d  reason: case insensitive filesystem */
public final /* synthetic */ class C0147d implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f28839a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Comparator f28840b;

    public /* synthetic */ C0147d(Comparator comparator, int i11) {
        this.f28839a = i11;
        this.f28840b = comparator;
    }

    public final /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f28839a) {
            case 0:
                return BiFunction.CC.$default$andThen(this, function);
            default:
                return BiFunction.CC.$default$andThen(this, function);
        }
    }

    public final Object apply(Object obj, Object obj2) {
        int i11 = this.f28839a;
        Comparator comparator = this.f28840b;
        switch (i11) {
            case 0:
                return comparator.compare(obj, obj2) >= 0 ? obj : obj2;
            default:
                return comparator.compare(obj, obj2) <= 0 ? obj : obj2;
        }
    }
}
