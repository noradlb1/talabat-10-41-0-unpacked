package e30;

import j$.util.function.Supplier;
import org.junit.jupiter.engine.discovery.AbstractOrderingVisitor;

public final /* synthetic */ class g implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractOrderingVisitor.DescriptorWrapperOrderer f61971a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f61972b;

    public /* synthetic */ g(AbstractOrderingVisitor.DescriptorWrapperOrderer descriptorWrapperOrderer, int i11) {
        this.f61971a = descriptorWrapperOrderer;
        this.f61972b = i11;
    }

    public final Object get() {
        return this.f61971a.lambda$logDescriptorsRemovedWarning$1(this.f61972b);
    }
}
