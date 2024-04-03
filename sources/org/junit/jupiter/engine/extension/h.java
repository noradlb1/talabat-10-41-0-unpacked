package org.junit.jupiter.engine.extension;

import j$.util.function.Supplier;
import java.lang.reflect.Field;

public final /* synthetic */ class h implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Field f62597a;

    public /* synthetic */ h(Field field) {
        this.f62597a = field;
    }

    public final Object get() {
        return TempDirectory.lambda$determineCleanupModeForField$2(this.f62597a);
    }
}
