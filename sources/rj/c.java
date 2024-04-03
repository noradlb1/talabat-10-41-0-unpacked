package rj;

import JsonModels.Response.CustomerAddressInfoJsonResult;
import com.android.volley.Response;
import com.talabat.darkstores.interactor.DarkstoresBridgeInteractor;

public final /* synthetic */ class c implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresBridgeInteractor f57373b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f57374c;

    public /* synthetic */ c(DarkstoresBridgeInteractor darkstoresBridgeInteractor, boolean z11) {
        this.f57373b = darkstoresBridgeInteractor;
        this.f57374c = z11;
    }

    public final void onResponse(Object obj) {
        DarkstoresBridgeInteractor.m10103onAddressReceived$lambda5(this.f57373b, this.f57374c, (CustomerAddressInfoJsonResult) obj);
    }
}
