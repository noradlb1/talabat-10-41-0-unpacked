package n10;

import JsonModels.Response.MenuItemResponse;
import com.android.volley.Response;
import library.talabat.mvp.listingmenubridge.DarkstoresTrackingData;
import library.talabat.mvp.listingmenubridge.ListingMenuBridgeInteractor;

public final /* synthetic */ class b implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListingMenuBridgeInteractor f26891b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DarkstoresTrackingData f26892c;

    public /* synthetic */ b(ListingMenuBridgeInteractor listingMenuBridgeInteractor, DarkstoresTrackingData darkstoresTrackingData) {
        this.f26891b = listingMenuBridgeInteractor;
        this.f26892c = darkstoresTrackingData;
    }

    public final void onResponse(Object obj) {
        this.f26891b.lambda$onMigratedInfoReceived$2(this.f26892c, (MenuItemResponse) obj);
    }
}
