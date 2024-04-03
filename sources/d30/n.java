package d30;

import j$.util.function.Consumer;
import java.lang.reflect.Method;
import org.junit.jupiter.engine.extension.MutableExtensionRegistry;

public final /* synthetic */ class n implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MutableExtensionRegistry f61889b;

    public /* synthetic */ n(MutableExtensionRegistry mutableExtensionRegistry) {
        this.f61889b = mutableExtensionRegistry;
    }

    public final void accept(Object obj) {
        ExtensionUtils.k(this.f61889b, (Method) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
