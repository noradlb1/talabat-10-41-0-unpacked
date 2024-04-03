package i9;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;
import java.util.concurrent.Callable;

public final /* synthetic */ class e implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Supplier f47114b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Callable f47115c;

    public /* synthetic */ e(Supplier supplier, Callable callable) {
        this.f47114b = supplier;
        this.f47115c = callable;
    }

    public final Object call() {
        return Callables.lambda$threadRenaming$2(this.f47114b, this.f47115c);
    }
}
