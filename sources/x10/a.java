package x10;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabat.mvp.quickorder.QuickOrderInteractor;

public final /* synthetic */ class a implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickOrderInteractor f28230b;

    public /* synthetic */ a(QuickOrderInteractor quickOrderInteractor) {
        this.f28230b = quickOrderInteractor;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.f28230b.lambda$onRequestError$1(volleyError);
    }
}
