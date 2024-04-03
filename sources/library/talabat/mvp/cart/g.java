package library.talabat.mvp.cart;

import JsonModels.Response.ParallelBin.ParallelBinRM;
import com.android.volley.Response;

public final /* synthetic */ class g implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartInteractor f26640b;

    public /* synthetic */ g(CartInteractor cartInteractor) {
        this.f26640b = cartInteractor;
    }

    public final void onResponse(Object obj) {
        this.f26640b.lambda$onAllBinResponse$8((ParallelBinRM) obj);
    }
}
