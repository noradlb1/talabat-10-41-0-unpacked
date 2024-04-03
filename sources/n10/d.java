package n10;

import JsonModels.Request.InforMapRequest;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabat.mvp.listingmenubridge.ListingMenuBridgeInteractor;

public final /* synthetic */ class d implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListingMenuBridgeInteractor f26895b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ InforMapRequest f26896c;

    public /* synthetic */ d(ListingMenuBridgeInteractor listingMenuBridgeInteractor, InforMapRequest inforMapRequest) {
        this.f26895b = listingMenuBridgeInteractor;
        this.f26896c = inforMapRequest;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.f26895b.lambda$onGetBranchIdFromGrlRequestError$1(this.f26896c, volleyError);
    }
}
