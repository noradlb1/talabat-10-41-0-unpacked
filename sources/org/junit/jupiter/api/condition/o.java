package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class o implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f57130a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f57131b;

    public /* synthetic */ o(Class cls, String str) {
        this.f57130a = cls;
        this.f57131b = str;
    }

    public final Object get() {
        return ReflectionUtils.getRequiredMethod(this.f57130a, this.f57131b, ExtensionContext.class);
    }
}
