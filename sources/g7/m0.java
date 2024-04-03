package g7;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class m0 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f35244b;

    public /* synthetic */ m0(AtomicBoolean atomicBoolean) {
        this.f35244b = atomicBoolean;
    }

    public final Object get() {
        return Boolean.valueOf(this.f35244b.get());
    }
}
