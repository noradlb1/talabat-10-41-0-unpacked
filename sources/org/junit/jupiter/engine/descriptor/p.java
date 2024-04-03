package org.junit.jupiter.engine.descriptor;

import j$.util.function.Consumer;
import j$.util.function.Supplier;
import java.lang.reflect.Field;
import org.junit.platform.commons.util.Preconditions;

public final /* synthetic */ class p implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f62468b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Field f62469c;

    public /* synthetic */ p(Class cls, Field field) {
        this.f62468b = cls;
        this.f62469c = field;
    }

    public final void accept(Object obj) {
        Preconditions.condition(!((Class) obj).equals(this.f62468b), (Supplier<String>) new s(this.f62469c, this.f62468b));
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
