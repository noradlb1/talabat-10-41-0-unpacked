package j$.util.stream;

import j$.util.Map;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Map;
import java.util.Set;

/* renamed from: j$.util.stream.n  reason: case insensitive filesystem */
public final /* synthetic */ class C0259n implements Function, BiFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function f29184a;

    public /* synthetic */ C0259n(Function function) {
        this.f29184a = function;
    }

    public final Object apply(Object obj) {
        Map map = (Map) obj;
        Set set = Collectors.f28907a;
        Map.EL.a(map, new C0259n(this.f29184a));
        return map;
    }

    public final Object apply(Object obj, Object obj2) {
        Set set = Collectors.f28907a;
        return this.f29184a.apply(obj2);
    }

    public final /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
