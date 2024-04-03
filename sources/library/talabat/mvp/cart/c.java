package library.talabat.mvp.cart;

import io.reactivex.functions.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartInteractor f26634b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f26635c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f26636d;

    public /* synthetic */ c(CartInteractor cartInteractor, int i11, float f11) {
        this.f26634b = cartInteractor;
        this.f26635c = i11;
        this.f26636d = f11;
    }

    public final void accept(Object obj) {
        this.f26634b.lambda$loadCouponsAndPromotions$1(this.f26635c, this.f26636d, (Throwable) obj);
    }
}
