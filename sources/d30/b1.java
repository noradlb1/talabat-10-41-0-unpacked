package d30;

import j$.util.function.Supplier;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.engine.descriptor.MethodBasedTestDescriptor;

public final /* synthetic */ class b1 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodBasedTestDescriptor f61830a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TestWatcher f61831b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61832c;

    public /* synthetic */ b1(MethodBasedTestDescriptor methodBasedTestDescriptor, TestWatcher testWatcher, ExtensionContext extensionContext) {
        this.f61830a = methodBasedTestDescriptor;
        this.f61831b = testWatcher;
        this.f61832c = extensionContext;
    }

    public final Object get() {
        return this.f61830a.lambda$invokeTestWatchers$2(this.f61831b, this.f61832c);
    }
}
