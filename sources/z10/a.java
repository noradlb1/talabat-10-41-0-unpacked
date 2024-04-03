package z10;

import JsonModels.Request.InforMapRequest;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabat.mvp.restaurantlist.RestaurantListInteractor;

public final /* synthetic */ class a implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantListInteractor f28239b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ InforMapRequest f28240c;

    public /* synthetic */ a(RestaurantListInteractor restaurantListInteractor, InforMapRequest inforMapRequest) {
        this.f28239b = restaurantListInteractor;
        this.f28240c = inforMapRequest;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.f28239b.lambda$onGetBranchIdFromGrlRequestError$0(this.f28240c, volleyError);
    }
}
