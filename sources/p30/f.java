package p30;

import j$.util.function.Supplier;
import org.junit.platform.engine.support.descriptor.FilePosition;

public final /* synthetic */ class f implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f28149a;

    public /* synthetic */ f(String str) {
        this.f28149a = str;
    }

    public final Object get() {
        return FilePosition.lambda$fromQuery$0(this.f28149a);
    }
}
