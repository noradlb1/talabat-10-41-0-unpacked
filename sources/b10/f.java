package b10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.checkout.CheckoutInteractor;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckoutInteractor f24301b;

    public /* synthetic */ f(CheckoutInteractor checkoutInteractor) {
        this.f24301b = checkoutInteractor;
    }

    public final void accept(Object obj) {
        this.f24301b.lambda$postSubscriptionPayment$1((Throwable) obj);
    }
}
