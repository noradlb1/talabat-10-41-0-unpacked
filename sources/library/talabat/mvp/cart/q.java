package library.talabat.mvp.cart;

import io.reactivex.functions.Consumer;

public final /* synthetic */ class q implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartInteractor f26657b;

    public /* synthetic */ q(CartInteractor cartInteractor) {
        this.f26657b = cartInteractor;
    }

    public final void accept(Object obj) {
        this.f26657b.lambda$loadUserInfoBackgroundFromMicroservice$6((Throwable) obj);
    }
}
