package rj;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.talabat.darkstores.interactor.DarkstoresBridgeInteractor;

public final /* synthetic */ class j implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresBridgeInteractor f57379b;

    public /* synthetic */ j(DarkstoresBridgeInteractor darkstoresBridgeInteractor) {
        this.f57379b = darkstoresBridgeInteractor;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        DarkstoresBridgeInteractor.m10105onRequestError$lambda7(this.f57379b, volleyError);
    }
}
