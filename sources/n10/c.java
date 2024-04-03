package n10;

import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import com.android.volley.Response;
import library.talabat.mvp.listingmenubridge.ListingMenuBridgeInteractor;

public final /* synthetic */ class c implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListingMenuBridgeInteractor f26893b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f26894c;

    public /* synthetic */ c(ListingMenuBridgeInteractor listingMenuBridgeInteractor, String str) {
        this.f26893b = listingMenuBridgeInteractor;
        this.f26894c = str;
    }

    public final void onResponse(Object obj) {
        this.f26893b.lambda$onMenuReceived$0(this.f26894c, (SplitMenuRM) obj);
    }
}
