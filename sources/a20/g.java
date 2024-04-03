package a20;

import JsonModels.Response.MenuItemResponse;
import com.android.volley.Response;
import library.talabat.mvp.restaurantlistrefactor.MenuApiInteractor;
import library.talabat.mvp.restaurantlistrefactor.MenuApiListener;

public final /* synthetic */ class g implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuApiInteractor f24286b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuApiListener f24287c;

    public /* synthetic */ g(MenuApiInteractor menuApiInteractor, MenuApiListener menuApiListener) {
        this.f24286b = menuApiInteractor;
        this.f24287c = menuApiListener;
    }

    public final void onResponse(Object obj) {
        this.f24286b.lambda$onInfoRecieved$6(this.f24287c, (MenuItemResponse) obj);
    }
}
