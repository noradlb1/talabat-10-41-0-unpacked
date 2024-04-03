package x00;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabat.mvp.addressV2.AddressInteractor;

public final /* synthetic */ class g implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddressInteractor f28224b;

    public /* synthetic */ g(AddressInteractor addressInteractor) {
        this.f28224b = addressInteractor;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.f28224b.lambda$onRequestError$8(volleyError);
    }
}
