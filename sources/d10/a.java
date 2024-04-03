package d10;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabat.mvp.choosesavedaddress.ChooseSavedAddressInteractor;

public final /* synthetic */ class a implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChooseSavedAddressInteractor f24314b;

    public /* synthetic */ a(ChooseSavedAddressInteractor chooseSavedAddressInteractor) {
        this.f24314b = chooseSavedAddressInteractor;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        ChooseSavedAddressInteractor.m7877onRequestError$lambda2(this.f24314b, volleyError);
    }
}
