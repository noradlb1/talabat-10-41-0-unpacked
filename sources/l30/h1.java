package l30;

import j$.util.function.Supplier;

public final /* synthetic */ class h1 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f26479a;

    public /* synthetic */ h1(Class cls) {
        this.f26479a = cls;
    }

    public final Object get() {
        return String.format("Class [%s] must declare a single constructor", new Object[]{this.f26479a.getName()});
    }
}
