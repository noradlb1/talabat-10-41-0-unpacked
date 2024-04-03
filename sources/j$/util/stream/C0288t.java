package j$.util.stream;

import j$.util.Map;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/* renamed from: j$.util.stream.t  reason: case insensitive filesystem */
public final /* synthetic */ class C0288t implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f29226a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f29227b;

    public /* synthetic */ C0288t(int i11, Object obj) {
        this.f29226a = i11;
        this.f29227b = obj;
    }

    public final /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f29226a) {
            case 0:
                return BiFunction.CC.$default$andThen(this, function);
            case 1:
                return BiFunction.CC.$default$andThen(this, function);
            case 2:
                return BiFunction.CC.$default$andThen(this, function);
            default:
                return BiFunction.CC.$default$andThen(this, function);
        }
    }

    public final Object apply(Object obj, Object obj2) {
        int i11 = this.f29226a;
        Object obj3 = this.f29227b;
        switch (i11) {
            case 0:
                ((BiConsumer) obj3).accept(obj, obj2);
                return obj;
            case 1:
                ((BiConsumer) obj3).accept(obj, obj2);
                return obj;
            case 2:
                ((BiConsumer) obj3).accept(obj, obj2);
                return obj;
            default:
                BinaryOperator binaryOperator = (BinaryOperator) obj3;
                Map map = (Map) obj;
                Set set = Collectors.f28907a;
                for (Map.Entry entry : ((Map) obj2).entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (map instanceof j$.util.Map) {
                        ((j$.util.Map) map).merge(key, value, binaryOperator);
                    } else if (map instanceof ConcurrentMap) {
                        ConcurrentMap.CC.$default$merge((java.util.concurrent.ConcurrentMap) map, key, value, binaryOperator);
                    } else {
                        Map.CC.$default$merge(map, key, value, binaryOperator);
                    }
                }
                return map;
        }
    }
}
