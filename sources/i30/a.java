package i30;

import java.util.concurrent.Callable;
import org.junit.platform.commons.function.Try;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f24343b;

    public /* synthetic */ a(Callable callable) {
        this.f24343b = callable;
    }

    public final Object call() {
        return Try.success(this.f24343b.call());
    }
}
