package a20;

import JsonModels.Response.InforMapAddressRM;
import com.android.volley.Response;
import library.talabat.mvp.restaurantlistrefactor.MenuApiInteractor;
import library.talabat.mvp.restaurantlistrefactor.MenuApiListener;

public final /* synthetic */ class d implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuApiListener f24281b;

    public /* synthetic */ d(MenuApiListener menuApiListener) {
        this.f24281b = menuApiListener;
    }

    public final void onResponse(Object obj) {
        MenuApiInteractor.lambda$onInforBranchReceived$3(this.f24281b, (InforMapAddressRM) obj);
    }
}
