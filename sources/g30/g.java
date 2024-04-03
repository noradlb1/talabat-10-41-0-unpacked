package g30;

import j$.util.function.Consumer;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.engine.extension.MutableExtensionRegistry;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MutableExtensionRegistry f62083b;

    public /* synthetic */ g(MutableExtensionRegistry mutableExtensionRegistry) {
        this.f62083b = mutableExtensionRegistry;
    }

    public final void accept(Object obj) {
        this.f62083b.registerDefaultExtension((Extension) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
