package b10;

import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import kotlin.jvm.functions.Function1;
import library.talabat.mvp.checkout.CheckoutPresenter;

public final /* synthetic */ class g implements Function1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckoutPresenter f24302b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f24303c;

    public /* synthetic */ g(CheckoutPresenter checkoutPresenter, Function1 function1) {
        this.f24302b = checkoutPresenter;
        this.f24303c = function1;
    }

    public final Object invoke(Object obj) {
        return this.f24302b.lambda$onSubscriptionPlansLoaded$1(this.f24303c, (TProOrderStatus) obj);
    }
}
