package b20;

import JsonModels.Response.ParallelBin.ParallelBinRM;
import com.android.volley.Response;
import library.talabat.mvp.restaurantmenu.RestaurantMenuInteractor;

public final /* synthetic */ class a implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantMenuInteractor f24307b;

    public /* synthetic */ a(RestaurantMenuInteractor restaurantMenuInteractor) {
        this.f24307b = restaurantMenuInteractor;
    }

    public final void onResponse(Object obj) {
        this.f24307b.lambda$onAllBinResponse$0((ParallelBinRM) obj);
    }
}
