package j10;

import JsonModels.GeoAddressRequest;
import com.android.volley.Response;
import library.talabat.mvp.homemap.HomeMapInteractor;

public final /* synthetic */ class c implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeMapInteractor f24347b;

    public /* synthetic */ c(HomeMapInteractor homeMapInteractor) {
        this.f24347b = homeMapInteractor;
    }

    public final void onResponse(Object obj) {
        HomeMapInteractor.m7890onReverseGeoAreaReceived$lambda1(this.f24347b, (GeoAddressRequest) obj);
    }
}
