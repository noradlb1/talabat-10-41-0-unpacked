package a10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.cart.CartView;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartView f24272b;

    public /* synthetic */ e(CartView cartView) {
        this.f24272b = cartView;
    }

    public final void accept(Object obj) {
        this.f24272b.notifySubTotalChanged(((Float) obj).floatValue());
    }
}
