package library.talabat.mvp.cart;

import JsonModels.Response.CustomerAddressInfoJsonResult;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartInteractor f26629b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CustomerAddressInfoJsonResult f26630c;

    public /* synthetic */ a(CartInteractor cartInteractor, CustomerAddressInfoJsonResult customerAddressInfoJsonResult) {
        this.f26629b = cartInteractor;
        this.f26630c = customerAddressInfoJsonResult;
    }

    public final void accept(Object obj) {
        this.f26629b.lambda$getGetActiveSubscriptions$13(this.f26630c, (Subscription) obj);
    }
}
