package u10;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabat.mvp.orderconfirmation.OrderConfirmationInteractor;

public final /* synthetic */ class b implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderConfirmationInteractor f28210b;

    public /* synthetic */ b(OrderConfirmationInteractor orderConfirmationInteractor) {
        this.f28210b = orderConfirmationInteractor;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        OrderConfirmationInteractor.m7910onThankYouApiRequestError$lambda1(this.f28210b, volleyError);
    }
}
