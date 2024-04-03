package b10;

import buisnessmodels.Cart;
import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import datamodels.Restaurant;
import kotlin.jvm.functions.Function1;
import library.talabat.mvp.checkout.CheckoutPresenter;

public final /* synthetic */ class h implements Function1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckoutPresenter f24304b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Restaurant f24305c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Cart f24306d;

    public /* synthetic */ h(CheckoutPresenter checkoutPresenter, Restaurant restaurant, Cart cart) {
        this.f24304b = checkoutPresenter;
        this.f24305c = restaurant;
        this.f24306d = cart;
    }

    public final Object invoke(Object obj) {
        return this.f24304b.lambda$setTaxAndDelivery$0(this.f24305c, this.f24306d, (TProOrderStatus) obj);
    }
}
