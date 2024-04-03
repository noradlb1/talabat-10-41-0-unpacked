package b10;

import com.talabat.feature.subscriptions.domain.model.Subscription;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import library.talabat.mvp.checkout.CheckoutInteractor;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckoutInteractor f24296b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f24297c;

    public /* synthetic */ c(CheckoutInteractor checkoutInteractor, Function1 function1) {
        this.f24296b = checkoutInteractor;
        this.f24297c = function1;
    }

    public final void accept(Object obj) {
        this.f24296b.lambda$getGetActiveSubscriptions$2(this.f24297c, (Subscription) obj);
    }
}
