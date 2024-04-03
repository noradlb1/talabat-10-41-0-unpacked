package org.junit.jupiter.engine.descriptor;

import j$.util.function.Consumer;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.engine.extension.ExtensionRegistrar;

public final /* synthetic */ class t implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Field f62476b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f62477c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ List f62478d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ExtensionRegistrar f62479e;

    public /* synthetic */ t(Field field, boolean z11, List list, ExtensionRegistrar extensionRegistrar) {
        this.f62476b = field;
        this.f62477c = z11;
        this.f62478d = list;
        this.f62479e = extensionRegistrar;
    }

    public final void accept(Object obj) {
        ExtensionUtils.lambda$registerExtensionsFromFields$3(this.f62476b, this.f62477c, this.f62478d, this.f62479e, obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
