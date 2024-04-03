package d30;

import j$.util.function.Consumer;
import j$.util.function.Function;
import java.lang.reflect.Method;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;
import org.junit.jupiter.engine.extension.ExtensionRegistrar;

public final /* synthetic */ class d0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionRegistrar f61836b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function f61837c;

    public /* synthetic */ d0(ExtensionRegistrar extensionRegistrar, Function function) {
        this.f61836b = extensionRegistrar;
        this.f61837c = function;
    }

    public final void accept(Object obj) {
        ClassBasedTestDescriptor.lambda$registerMethodsAsExtensions$22(this.f61836b, this.f61837c, (Method) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
