package d30;

import j$.util.function.Consumer;
import java.util.Set;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class f1 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set f61855b;

    public /* synthetic */ f1(Set set) {
        this.f61855b = set;
    }

    public final void accept(Object obj) {
        this.f61855b.addAll(((TestDescriptor) obj).getTags());
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
