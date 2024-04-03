package p30;

import j$.util.function.Supplier;
import java.net.URI;
import org.junit.platform.engine.support.descriptor.ClasspathResourceSource;

public final /* synthetic */ class e implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ URI f28148a;

    public /* synthetic */ e(URI uri) {
        this.f28148a = uri;
    }

    public final Object get() {
        return ClasspathResourceSource.lambda$from$0(this.f28148a);
    }
}
