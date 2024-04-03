package e30;

import j$.util.function.Supplier;
import org.junit.jupiter.engine.discovery.AbstractOrderingVisitor;

public final /* synthetic */ class f implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractOrderingVisitor.DescriptorWrapperOrderer f61969a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f61970b;

    public /* synthetic */ f(AbstractOrderingVisitor.DescriptorWrapperOrderer descriptorWrapperOrderer, int i11) {
        this.f61969a = descriptorWrapperOrderer;
        this.f61970b = i11;
    }

    public final Object get() {
        return this.f61969a.lambda$logDescriptorsAddedWarning$0(this.f61970b);
    }
}
