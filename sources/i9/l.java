package i9;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped;

public final /* synthetic */ class l implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f47121b;

    public /* synthetic */ l(int i11) {
        this.f47121b = i11;
    }

    public final Object get() {
        return Striped.lambda$lazyWeakSemaphore$2(this.f47121b);
    }
}
