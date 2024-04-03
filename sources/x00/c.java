package x00;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.addressV2.AddressInteractor;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddressInteractor f28220b;

    public /* synthetic */ c(AddressInteractor addressInteractor) {
        this.f28220b = addressInteractor;
    }

    public final void accept(Object obj) {
        this.f28220b.lambda$callDeleteAddressMicroservice$6((Throwable) obj);
    }
}
