package i9;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped;

public final /* synthetic */ class k implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f47120b;

    public /* synthetic */ k(int i11) {
        this.f47120b = i11;
    }

    public final Object get() {
        return Striped.lambda$semaphore$1(this.f47120b);
    }
}
