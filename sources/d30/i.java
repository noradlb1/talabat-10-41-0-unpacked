package d30;

import j$.util.function.Supplier;
import java.lang.reflect.Method;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;

public final /* synthetic */ class i implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f61866a;

    public /* synthetic */ i(Method method) {
        this.f61866a = method;
    }

    public final Object get() {
        return ClassBasedTestDescriptor.lambda$invokeMethodInExtensionContext$25(this.f61866a);
    }
}
