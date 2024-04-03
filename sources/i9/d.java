package i9;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Supplier f47112b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f47113c;

    public /* synthetic */ d(Supplier supplier, Runnable runnable) {
        this.f47112b = supplier;
        this.f47113c = runnable;
    }

    public final void run() {
        Callables.lambda$threadRenaming$3(this.f47112b, this.f47113c);
    }
}
