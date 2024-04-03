package j10;

import JsonModels.Response.GoogleAreaRM;
import com.android.volley.Response;
import library.talabat.mvp.homemap.HomeMapInteractor;

public final /* synthetic */ class i implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeMapInteractor f24350b;

    public /* synthetic */ i(HomeMapInteractor homeMapInteractor) {
        this.f24350b = homeMapInteractor;
    }

    public final void onResponse(Object obj) {
        HomeMapInteractor.m7887onGoogleAreaReceived$lambda0(this.f24350b, (GoogleAreaRM) obj);
    }
}
