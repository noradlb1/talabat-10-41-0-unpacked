package org.junit.jupiter.engine.extension;

import j$.util.function.Consumer;
import org.junit.jupiter.api.extension.ExtensionContext;

public final /* synthetic */ class k implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TempDirectory f62605b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62606c;

    public /* synthetic */ k(TempDirectory tempDirectory, ExtensionContext extensionContext) {
        this.f62605b = tempDirectory;
        this.f62606c = extensionContext;
    }

    public final void accept(Object obj) {
        this.f62605b.lambda$beforeEach$0(this.f62606c, obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
