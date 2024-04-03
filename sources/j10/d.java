package j10;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabat.mvp.homemap.HomeMapInteractor;

public final /* synthetic */ class d implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeMapInteractor f24348b;

    public /* synthetic */ d(HomeMapInteractor homeMapInteractor) {
        this.f24348b = homeMapInteractor;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        HomeMapInteractor.m7889onRequestError$lambda8(this.f24348b, volleyError);
    }
}
