package y00;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.addresslist.AddressListInteractor;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddressListInteractor f28233b;

    public /* synthetic */ a(AddressListInteractor addressListInteractor) {
        this.f28233b = addressListInteractor;
    }

    public final void accept(Object obj) {
        this.f28233b.observe((Throwable) obj);
    }
}
