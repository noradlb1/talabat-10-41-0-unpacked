package org.junit.jupiter.engine.descriptor;

import j$.util.function.Supplier;
import java.lang.reflect.Field;

public final /* synthetic */ class s implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Field f62474a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f62475b;

    public /* synthetic */ s(Field field, Class cls) {
        this.f62474a = field;
        this.f62475b = cls;
    }

    public final Object get() {
        return String.format("Failed to register extension via field [%s]. The field registers an extension of type [%s] via @RegisterExtension and @ExtendWith, but only one registration of a given extension type is permitted.", new Object[]{this.f62474a, this.f62475b.getName()});
    }
}
