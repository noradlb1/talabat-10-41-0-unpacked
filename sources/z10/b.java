package z10;

import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import com.android.volley.Response;
import library.talabat.mvp.restaurantlist.RestaurantListInteractor;

public final /* synthetic */ class b implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantListInteractor f28241b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f28242c;

    public /* synthetic */ b(RestaurantListInteractor restaurantListInteractor, String str) {
        this.f28241b = restaurantListInteractor;
        this.f28242c = str;
    }

    public final void onResponse(Object obj) {
        this.f28241b.lambda$onMenuReceived$1(this.f28242c, (SplitMenuRM) obj);
    }
}
