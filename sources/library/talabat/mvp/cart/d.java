package library.talabat.mvp.cart;

import JsonModels.Response.CustomerAddressInfoJsonResult;
import com.android.volley.Response;

public final /* synthetic */ class d implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartInteractor f26637b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f26638c;

    public /* synthetic */ d(CartInteractor cartInteractor, boolean z11) {
        this.f26637b = cartInteractor;
        this.f26638c = z11;
    }

    public final void onResponse(Object obj) {
        this.f26637b.lambda$onBackGroundAddressReceived$12(this.f26638c, (CustomerAddressInfoJsonResult) obj);
    }
}
