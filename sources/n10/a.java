package n10;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabat.mvp.listingmenubridge.ListingMenuBridgeInteractor;

public final /* synthetic */ class a implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListingMenuBridgeInteractor f26890b;

    public /* synthetic */ a(ListingMenuBridgeInteractor listingMenuBridgeInteractor) {
        this.f26890b = listingMenuBridgeInteractor;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.f26890b.lambda$onMigratedErrorResponse$3(volleyError);
    }
}
