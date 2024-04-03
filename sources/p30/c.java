package p30;

import j$.util.function.Supplier;
import java.net.URI;
import org.junit.platform.engine.support.descriptor.ClassSource;

public final /* synthetic */ class c implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ URI f28146a;

    public /* synthetic */ c(URI uri) {
        this.f28146a = uri;
    }

    public final Object get() {
        return ClassSource.lambda$from$0(this.f28146a);
    }
}
