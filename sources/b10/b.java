package b10;

import JsonModels.Response.ParallelBin.ParallelBinRM;
import com.android.volley.Response;
import library.talabat.mvp.checkout.CheckoutInteractor;

public final /* synthetic */ class b implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckoutInteractor f24294b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f24295c;

    public /* synthetic */ b(CheckoutInteractor checkoutInteractor, boolean z11) {
        this.f24294b = checkoutInteractor;
        this.f24295c = z11;
    }

    public final void onResponse(Object obj) {
        this.f24294b.lambda$onAllBinResponse$4(this.f24295c, (ParallelBinRM) obj);
    }
}
