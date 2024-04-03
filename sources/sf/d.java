package sf;

import buisnessmodels.GEMEngine;
import com.talabat.checkoutdotcom.CheckoutTokenScreen;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckoutTokenScreen f57392b;

    public /* synthetic */ d(CheckoutTokenScreen checkoutTokenScreen) {
        this.f57392b = checkoutTokenScreen;
    }

    public final void accept(Object obj) {
        this.f57392b.lambda$onCreate$1((GEMEngine) obj);
    }
}
