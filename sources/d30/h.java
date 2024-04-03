package d30;

import j$.util.function.Consumer;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ThrowableCollector f61858b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61859c;

    public /* synthetic */ h(ThrowableCollector throwableCollector, ExtensionContext extensionContext) {
        this.f61858b = throwableCollector;
        this.f61859c = extensionContext;
    }

    public final void accept(Object obj) {
        this.f61858b.execute(new f0((AfterAllCallback) obj, this.f61859c));
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
