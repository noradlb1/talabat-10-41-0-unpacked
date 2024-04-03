package g30;

import j$.util.function.Consumer;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.engine.extension.MutableExtensionRegistry;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MutableExtensionRegistry f62080b;

    public /* synthetic */ d(MutableExtensionRegistry mutableExtensionRegistry) {
        this.f62080b = mutableExtensionRegistry;
    }

    public final void accept(Object obj) {
        this.f62080b.registerAutoDetectedExtension((Extension) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
