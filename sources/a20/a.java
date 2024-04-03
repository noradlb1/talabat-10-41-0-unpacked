package a20;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabat.mvp.restaurantlistrefactor.MenuApiInteractor;
import library.talabat.mvp.restaurantlistrefactor.MenuApiListener;

public final /* synthetic */ class a implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuApiListener f24277b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f24278c;

    public /* synthetic */ a(MenuApiListener menuApiListener, String str) {
        this.f24277b = menuApiListener;
        this.f24278c = str;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        MenuApiInteractor.lambda$onRequestError$1(this.f24277b, this.f24278c, volleyError);
    }
}
