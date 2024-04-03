package n10;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabat.mvp.listingmenubridge.ListingMenuBridgeInteractor;

public final /* synthetic */ class e implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListingMenuBridgeInteractor f26897b;

    public /* synthetic */ e(ListingMenuBridgeInteractor listingMenuBridgeInteractor) {
        this.f26897b = listingMenuBridgeInteractor;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.f26897b.dispatchError(volleyError);
    }
}
