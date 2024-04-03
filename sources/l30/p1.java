package l30;

import j$.util.function.Supplier;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class p1 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f26496a;

    public /* synthetic */ p1(Class cls) {
        this.f26496a = cls;
    }

    public final Object get() {
        return ReflectionUtils.lambda$findNestedClasses$15(this.f26496a);
    }
}
