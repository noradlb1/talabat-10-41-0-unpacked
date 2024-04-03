package l30;

import j$.util.function.Supplier;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class e1 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f26471a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f26472b;

    public /* synthetic */ e1(String str, Class cls) {
        this.f26471a = str;
        this.f26472b = cls;
    }

    public final Object get() {
        return ReflectionUtils.lambda$getRequiredMethod$26(this.f26471a, this.f26472b);
    }
}
