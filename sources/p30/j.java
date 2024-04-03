package p30;

import j$.util.function.Supplier;
import java.net.URI;

public final /* synthetic */ class j implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ URI f28153a;

    public /* synthetic */ j(URI uri) {
        this.f28153a = uri;
    }

    public final Object get() {
        return String.format("The supplied URI [%s] is not path-based. Falling back to default UriSource implementation.", new Object[]{this.f28153a});
    }
}
