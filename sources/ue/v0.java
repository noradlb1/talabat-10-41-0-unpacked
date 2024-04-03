package ue;

import com.talabat.CartScreen;
import java.util.concurrent.Callable;

public final /* synthetic */ class v0 implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartScreen f57787b;

    public /* synthetic */ v0(CartScreen cartScreen) {
        this.f57787b = cartScreen;
    }

    public final Object call() {
        return Boolean.valueOf(this.f57787b.isGemActive());
    }
}
