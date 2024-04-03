package e30;

import j$.util.function.Consumer;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TestDescriptor f61968b;

    public /* synthetic */ e(TestDescriptor testDescriptor) {
        this.f61968b = testDescriptor;
    }

    public final void accept(Object obj) {
        this.f61968b.addChild((TestDescriptor) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
