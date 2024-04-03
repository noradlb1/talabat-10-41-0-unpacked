package j$.util.stream;

import j$.util.StringJoiner;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* renamed from: j$.util.stream.l  reason: case insensitive filesystem */
public final /* synthetic */ class C0249l implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f29171a;

    public /* synthetic */ C0249l(int i11) {
        this.f29171a = i11;
    }

    public final /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f29171a) {
            case 0:
                return BiFunction.CC.$default$andThen(this, function);
            case 1:
                return BiFunction.CC.$default$andThen(this, function);
            case 2:
                return BiFunction.CC.$default$andThen(this, function);
            case 3:
                return BiFunction.CC.$default$andThen(this, function);
            case 4:
                return BiFunction.CC.$default$andThen(this, function);
            case 5:
                return BiFunction.CC.$default$andThen(this, function);
            case 6:
                return BiFunction.CC.$default$andThen(this, function);
            case 7:
                return BiFunction.CC.$default$andThen(this, function);
            default:
                return BiFunction.CC.$default$andThen(this, function);
        }
    }

    public final Object apply(Object obj, Object obj2) {
        switch (this.f29171a) {
            case 0:
                Collection collection = (Collection) obj;
                Set set = Collectors.f28907a;
                collection.addAll((Collection) obj2);
                return collection;
            case 1:
                List list = (List) obj;
                Set set2 = Collectors.f28907a;
                list.addAll((List) obj2);
                return list;
            case 2:
                Set set3 = (Set) obj;
                Set set4 = (Set) obj2;
                Set set5 = Collectors.f28907a;
                if (set3.size() < set4.size()) {
                    set4.addAll(set3);
                    return set4;
                }
                set3.addAll(set4);
                return set3;
            case 3:
                long[] jArr = (long[]) obj;
                Set set6 = Collectors.f28907a;
                jArr[0] = jArr[0] + ((long[]) obj2)[0];
                return jArr;
            case 4:
                return new P0((D0) obj, (D0) obj2);
            case 5:
                return new Q0((E0) obj, (E0) obj2);
            case 6:
                return new R0((F0) obj, (F0) obj2);
            case 7:
                return new T0((H0) obj, (H0) obj2);
            default:
                return ((StringJoiner) obj).c((StringJoiner) obj2);
        }
    }
}
