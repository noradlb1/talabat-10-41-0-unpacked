package library.talabat.mvp.cart;

import JsonModels.Response.CustomerAddressInfoJsonResult;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartInteractor f26643b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CustomerAddressInfoJsonResult f26644c;

    public /* synthetic */ i(CartInteractor cartInteractor, CustomerAddressInfoJsonResult customerAddressInfoJsonResult) {
        this.f26643b = cartInteractor;
        this.f26644c = customerAddressInfoJsonResult;
    }

    public final void accept(Object obj) {
        this.f26643b.lambda$getGetActiveSubscriptions$14(this.f26644c, (Throwable) obj);
    }
}
