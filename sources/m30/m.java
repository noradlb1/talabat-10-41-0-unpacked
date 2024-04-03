package m30;

import j$.util.function.Consumer;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class m implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TestDescriptor.Visitor f26882b;

    public /* synthetic */ m(TestDescriptor.Visitor visitor) {
        this.f26882b = visitor;
    }

    public final void accept(Object obj) {
        ((TestDescriptor) obj).accept(this.f26882b);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
