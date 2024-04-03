package library.talabat.mvp.cart;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public final /* synthetic */ class n implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CartInteractor f26652a;

    public /* synthetic */ n(CartInteractor cartInteractor) {
        this.f26652a = cartInteractor;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        this.f26652a.lambda$getLoadCustomerDetailsSingle$7(singleEmitter);
    }
}
