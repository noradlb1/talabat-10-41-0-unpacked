package a20;

import JsonModels.Request.InforMapRequest;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabat.mvp.restaurantlistrefactor.MenuApiInteractor;
import library.talabat.mvp.restaurantlistrefactor.MenuApiListener;

public final /* synthetic */ class h implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuApiInteractor f24288b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ InforMapRequest f24289c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MenuApiListener f24290d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f24291e;

    public /* synthetic */ h(MenuApiInteractor menuApiInteractor, InforMapRequest inforMapRequest, MenuApiListener menuApiListener, String str) {
        this.f24288b = menuApiInteractor;
        this.f24289c = inforMapRequest;
        this.f24290d = menuApiListener;
        this.f24291e = str;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.f24288b.lambda$onGetBranchIdFromGrlRequestError$2(this.f24289c, this.f24290d, this.f24291e, volleyError);
    }
}
