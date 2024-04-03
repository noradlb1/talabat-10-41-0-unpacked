package l30;

import j$.util.function.Supplier;
import java.lang.reflect.Field;

public final /* synthetic */ class k1 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Field f26484a;

    public /* synthetic */ k1(Field field) {
        this.f26484a = field;
    }

    public final Object get() {
        return String.format("Cannot read non-static field [%s] on a null instance.", new Object[]{this.f26484a});
    }
}
