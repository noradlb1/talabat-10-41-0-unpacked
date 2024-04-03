package p10;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabat.mvp.login.LoginInteractor;

public final /* synthetic */ class f implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginInteractor f28137b;

    public /* synthetic */ f(LoginInteractor loginInteractor) {
        this.f28137b = loginInteractor;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.f28137b.lambda$onRequestError$5(volleyError);
    }
}
