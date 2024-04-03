package rj;

import JsonModels.GeoAddressRequest;
import com.android.volley.Response;
import com.talabat.darkstores.interactor.DarkstoresBridgeInteractor;

public final /* synthetic */ class a implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresBridgeInteractor f57371b;

    public /* synthetic */ a(DarkstoresBridgeInteractor darkstoresBridgeInteractor) {
        this.f57371b = darkstoresBridgeInteractor;
    }

    public final void onResponse(Object obj) {
        DarkstoresBridgeInteractor.m10104onGeoAddressRecieved$lambda6(this.f57371b, (GeoAddressRequest) obj);
    }
}
