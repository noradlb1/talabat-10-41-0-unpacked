package i30;

import j$.util.function.Supplier;
import java.util.concurrent.Callable;
import org.junit.platform.commons.function.Try;

public final /* synthetic */ class b implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Supplier f24344b;

    public /* synthetic */ b(Supplier supplier) {
        this.f24344b = supplier;
    }

    public final Object call() {
        return (Try) this.f24344b.get();
    }
}
