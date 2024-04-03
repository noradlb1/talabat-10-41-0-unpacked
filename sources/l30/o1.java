package l30;

import j$.util.function.Supplier;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class o1 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f26494a;

    public /* synthetic */ o1(String str) {
        this.f26494a = str;
    }

    public final Object get() {
        return ReflectionUtils.lambda$parseFullyQualifiedMethodName$10(this.f26494a);
    }
}
