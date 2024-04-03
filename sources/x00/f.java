package x00;

import JsonModels.Response.GeoPolygonRM;
import com.android.volley.Response;
import library.talabat.mvp.addressV2.AddressInteractor;

public final /* synthetic */ class f implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddressInteractor f28223b;

    public /* synthetic */ f(AddressInteractor addressInteractor) {
        this.f28223b = addressInteractor;
    }

    public final void onResponse(Object obj) {
        this.f28223b.lambda$onAreaGeoPolyGonDataReceived$9((GeoPolygonRM) obj);
    }
}
