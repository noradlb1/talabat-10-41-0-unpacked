package e30;

import j$.util.function.Consumer;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TestDescriptor f61967b;

    public /* synthetic */ d(TestDescriptor testDescriptor) {
        this.f61967b = testDescriptor;
    }

    public final void accept(Object obj) {
        this.f61967b.removeChild((TestDescriptor) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
