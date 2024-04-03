package b10;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import library.talabat.mvp.checkout.CheckoutInteractor;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckoutInteractor f24298b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f24299c;

    public /* synthetic */ d(CheckoutInteractor checkoutInteractor, Function1 function1) {
        this.f24298b = checkoutInteractor;
        this.f24299c = function1;
    }

    public final void accept(Object obj) {
        this.f24298b.lambda$getGetActiveSubscriptions$3(this.f24299c, (Throwable) obj);
    }
}
