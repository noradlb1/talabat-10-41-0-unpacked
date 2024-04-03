package library.talabat.mvp.cart;

import io.reactivex.functions.Consumer;

public final /* synthetic */ class m implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartInteractor f26651b;

    public /* synthetic */ m(CartInteractor cartInteractor) {
        this.f26651b = cartInteractor;
    }

    public final void accept(Object obj) {
        this.f26651b.lambda$loadCustomerDetailsFromMicroservice$4((Throwable) obj);
    }
}
