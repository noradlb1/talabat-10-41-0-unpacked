package x00;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.addressV2.AddressInteractor;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddressInteractor f28222b;

    public /* synthetic */ e(AddressInteractor addressInteractor) {
        this.f28222b = addressInteractor;
    }

    public final void accept(Object obj) {
        this.f28222b.lambda$updateAddress$0((Throwable) obj);
    }
}
