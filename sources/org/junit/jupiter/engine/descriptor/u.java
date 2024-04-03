package org.junit.jupiter.engine.descriptor;

import j$.util.function.Consumer;
import java.lang.reflect.Field;
import org.junit.jupiter.engine.extension.ExtensionRegistrar;

public final /* synthetic */ class u implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionRegistrar f62480b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f62481c;

    public /* synthetic */ u(ExtensionRegistrar extensionRegistrar, Object obj) {
        this.f62480b = extensionRegistrar;
        this.f62481c = obj;
    }

    public final void accept(Object obj) {
        ExtensionUtils.lambda$registerExtensionsFromFields$4(this.f62480b, this.f62481c, (Field) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
