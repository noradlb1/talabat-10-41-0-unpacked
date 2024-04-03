package p30;

import j$.util.function.Consumer;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class a implements Consumer {
    public final void accept(Object obj) {
        ((TestDescriptor) obj).setParent((TestDescriptor) null);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
