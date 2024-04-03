package d30;

import j$.util.function.Supplier;
import java.util.List;
import org.junit.jupiter.engine.descriptor.TestTemplateTestDescriptor;

public final /* synthetic */ class v1 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f61925a;

    public /* synthetic */ v1(List list) {
        this.f61925a = list;
    }

    public final Object get() {
        return TestTemplateTestDescriptor.lambda$validateWasAtLeastInvokedOnce$6(this.f61925a);
    }
}
