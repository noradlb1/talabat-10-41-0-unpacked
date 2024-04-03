package d30;

import j$.util.function.Consumer;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.engine.descriptor.TestTemplateInvocationTestDescriptor;
import org.junit.jupiter.engine.extension.MutableExtensionRegistry;

public final /* synthetic */ class t1 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TestTemplateInvocationTestDescriptor f61920b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MutableExtensionRegistry f61921c;

    public /* synthetic */ t1(TestTemplateInvocationTestDescriptor testTemplateInvocationTestDescriptor, MutableExtensionRegistry mutableExtensionRegistry) {
        this.f61920b = testTemplateInvocationTestDescriptor;
        this.f61921c = mutableExtensionRegistry;
    }

    public final void accept(Object obj) {
        this.f61920b.lambda$populateNewExtensionRegistry$0(this.f61921c, (Extension) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
