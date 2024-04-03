package org.junit.jupiter.engine.extension;

import j$.util.function.Consumer;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtensionContext;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TempDirectory f62593b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f62594c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62595d;

    public /* synthetic */ f(TempDirectory tempDirectory, Object obj, ExtensionContext extensionContext) {
        this.f62593b = tempDirectory;
        this.f62594c = obj;
        this.f62595d = extensionContext;
    }

    public final void accept(Object obj) {
        this.f62593b.lambda$injectFields$1(this.f62594c, this.f62595d, (Field) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
