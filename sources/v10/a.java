package v10;

import JsonModels.Request.InforMapRequest;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabat.mvp.orderlistscreen.OrderListScreenInteractor;

public final /* synthetic */ class a implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderListScreenInteractor f28212b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ InforMapRequest f28213c;

    public /* synthetic */ a(OrderListScreenInteractor orderListScreenInteractor, InforMapRequest inforMapRequest) {
        this.f28212b = orderListScreenInteractor;
        this.f28213c = inforMapRequest;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.f28212b.lambda$onGetBranchIdForReorderCartRequestError$1(this.f28213c, volleyError);
    }
}
