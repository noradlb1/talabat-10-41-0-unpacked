package b10;

import com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus;
import io.reactivex.functions.Consumer;
import library.talabat.mvp.checkout.CheckoutInteractor;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckoutInteractor f24300b;

    public /* synthetic */ e(CheckoutInteractor checkoutInteractor) {
        this.f24300b = checkoutInteractor;
    }

    public final void accept(Object obj) {
        this.f24300b.lambda$postSubscriptionPayment$0((SubscriptionPaymentStatus) obj);
    }
}
