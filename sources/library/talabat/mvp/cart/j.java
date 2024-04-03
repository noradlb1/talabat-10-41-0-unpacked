package library.talabat.mvp.cart;

import JsonModels.Response.CustomerAddressInfoJsonResult;
import com.android.volley.Response;

public final /* synthetic */ class j implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartInteractor f26645b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f26646c;

    public /* synthetic */ j(CartInteractor cartInteractor, boolean z11) {
        this.f26645b = cartInteractor;
        this.f26646c = z11;
    }

    public final void onResponse(Object obj) {
        this.f26645b.lambda$onAddressReceived$11(this.f26646c, (CustomerAddressInfoJsonResult) obj);
    }
}
