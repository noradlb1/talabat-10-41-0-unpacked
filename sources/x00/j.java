package x00;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.addressV2.AddressInteractor;

public final /* synthetic */ class j implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddressInteractor f28227b;

    public /* synthetic */ j(AddressInteractor addressInteractor) {
        this.f28227b = addressInteractor;
    }

    public final void accept(Object obj) {
        this.f28227b.lambda$addAddress$1((Throwable) obj);
    }
}
