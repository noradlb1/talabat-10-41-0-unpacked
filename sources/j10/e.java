package j10;

import JsonModels.ReorderAreasResponse;
import com.android.volley.Response;
import library.talabat.mvp.homemap.HomeMapInteractor;

public final /* synthetic */ class e implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeMapInteractor f24349b;

    public /* synthetic */ e(HomeMapInteractor homeMapInteractor) {
        this.f24349b = homeMapInteractor;
    }

    public final void onResponse(Object obj) {
        HomeMapInteractor.m7888onReorderAreasRecieved$lambda2(this.f24349b, (ReorderAreasResponse) obj);
    }
}
