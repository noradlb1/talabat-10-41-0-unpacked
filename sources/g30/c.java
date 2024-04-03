package g30;

import j$.util.function.Consumer;
import org.junit.jupiter.engine.extension.MutableExtensionRegistry;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MutableExtensionRegistry f62079b;

    public /* synthetic */ c(MutableExtensionRegistry mutableExtensionRegistry) {
        this.f62079b = mutableExtensionRegistry;
    }

    public final void accept(Object obj) {
        this.f62079b.registerExtension((Class) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
