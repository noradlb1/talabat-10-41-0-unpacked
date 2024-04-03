package ue;

import com.talabat.CartScreen;

public final /* synthetic */ class u0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartScreen f57764b;

    public /* synthetic */ u0(CartScreen cartScreen) {
        this.f57764b = cartScreen;
    }

    public final void run() {
        this.f57764b.notifyFooterChanged();
    }
}
