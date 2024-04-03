package d30;

import j$.util.function.Consumer;
import java.util.Set;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class c1 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set f61835b;

    public /* synthetic */ c1(Set set) {
        this.f61835b = set;
    }

    public final void accept(Object obj) {
        this.f61835b.addAll(((TestDescriptor) obj).getTags());
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
