package org.junit.jupiter.engine.descriptor;

import j$.util.function.Supplier;
import java.lang.reflect.Field;

public final /* synthetic */ class o implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Field f62465a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f62466b;

    public /* synthetic */ o(Field field, Object obj) {
        this.f62465a = field;
        this.f62466b = obj;
    }

    public final Object get() {
        return ExtensionUtils.lambda$registerExtensionsFromFields$0(this.f62465a, this.f62466b);
    }
}
