package d30;

import j$.util.function.Consumer;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class e0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ClassBasedTestDescriptor f61846b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ThrowableCollector f61847c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f61848d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61849e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ExtensionRegistry f61850f;

    public /* synthetic */ e0(ClassBasedTestDescriptor classBasedTestDescriptor, ThrowableCollector throwableCollector, Object obj, ExtensionContext extensionContext, ExtensionRegistry extensionRegistry) {
        this.f61846b = classBasedTestDescriptor;
        this.f61847c = throwableCollector;
        this.f61848d = obj;
        this.f61849e = extensionContext;
        this.f61850f = extensionRegistry;
    }

    public final void accept(Object obj) {
        this.f61846b.lambda$invokeAfterAllMethods$16(this.f61847c, this.f61848d, this.f61849e, this.f61850f, (Method) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
