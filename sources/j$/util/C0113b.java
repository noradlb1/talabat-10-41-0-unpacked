package j$.util;

import j$.lang.a;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.Serializable;
import java.util.Comparator;

/* renamed from: j$.util.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0113b implements Comparator, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f28602a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f28603b;

    public /* synthetic */ C0113b(int i11, Object obj) {
        this.f28602a = i11;
        this.f28603b = obj;
    }

    public final int compare(Object obj, Object obj2) {
        int i11 = this.f28602a;
        Object obj3 = this.f28603b;
        switch (i11) {
            case 0:
                ToDoubleFunction toDoubleFunction = (ToDoubleFunction) obj3;
                return Double.compare(toDoubleFunction.applyAsDouble(obj), toDoubleFunction.applyAsDouble(obj2));
            case 1:
                ToIntFunction toIntFunction = (ToIntFunction) obj3;
                int applyAsInt = toIntFunction.applyAsInt(obj);
                int applyAsInt2 = toIntFunction.applyAsInt(obj2);
                if (applyAsInt < applyAsInt2) {
                    return -1;
                }
                return applyAsInt == applyAsInt2 ? 0 : 1;
            case 2:
                ToLongFunction toLongFunction = (ToLongFunction) obj3;
                return a.a(toLongFunction.applyAsLong(obj), toLongFunction.applyAsLong(obj2));
            default:
                Function function = (Function) obj3;
                return ((Comparable) function.apply(obj)).compareTo(function.apply(obj2));
        }
    }
}
