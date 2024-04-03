package a20;

import JsonModels.Response.McdStoresRM;
import com.android.volley.Response;
import library.talabat.mvp.restaurantlistrefactor.MenuApiInteractor;
import library.talabat.mvp.restaurantlistrefactor.MenuApiListener;

public final /* synthetic */ class f implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuApiListener f24285b;

    public /* synthetic */ f(MenuApiListener menuApiListener) {
        this.f24285b = menuApiListener;
    }

    public final void onResponse(Object obj) {
        MenuApiInteractor.lambda$onMcdBlockBranchReceived$4(this.f24285b, (McdStoresRM) obj);
    }
}
