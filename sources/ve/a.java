package ve;

import buisnessmodels.GEMEngine;
import com.talabat.Adyen.AdyenCheckoutScreen;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdyenCheckoutScreen f57891b;

    public /* synthetic */ a(AdyenCheckoutScreen adyenCheckoutScreen) {
        this.f57891b = adyenCheckoutScreen;
    }

    public final void accept(Object obj) {
        this.f57891b.lambda$onCreate$0((GEMEngine) obj);
    }
}
