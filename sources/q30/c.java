package q30;

import j$.util.function.Consumer;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TestDescriptor f28159b;

    public /* synthetic */ c(TestDescriptor testDescriptor) {
        this.f28159b = testDescriptor;
    }

    public final void accept(Object obj) {
        this.f28159b.accept((TestDescriptor.Visitor) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
