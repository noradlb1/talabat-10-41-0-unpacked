package d30;

import j$.util.function.Consumer;
import org.junit.jupiter.engine.extension.ExtensionRegistrar;

public final /* synthetic */ class q0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionRegistrar f61903b;

    public /* synthetic */ q0(ExtensionRegistrar extensionRegistrar) {
        this.f61903b = extensionRegistrar;
    }

    public final void accept(Object obj) {
        this.f61903b.registerExtension((Class) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
