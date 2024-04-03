package u30;

import java.util.Set;
import org.mockito.internal.configuration.InjectingAnnotationEngine;

public final /* synthetic */ class b implements AutoCloseable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set f63577b;

    public /* synthetic */ b(Set set) {
        this.f63577b = set;
    }

    public final void close() {
        InjectingAnnotationEngine.lambda$injectCloseableMocks$1(this.f63577b);
    }
}
