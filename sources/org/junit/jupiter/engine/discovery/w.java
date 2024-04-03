package org.junit.jupiter.engine.discovery;

import j$.util.function.Supplier;
import java.util.List;

public final /* synthetic */ class w implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassSelectorResolver f62559a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f62560b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f62561c;

    public /* synthetic */ w(ClassSelectorResolver classSelectorResolver, Class cls, List list) {
        this.f62559a = classSelectorResolver;
        this.f62560b = cls;
        this.f62561c = list;
    }

    public final Object get() {
        return this.f62559a.lambda$toResolution$12(this.f62560b, this.f62561c);
    }
}
