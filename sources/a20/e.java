package a20;

import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import com.android.volley.Response;
import library.talabat.mvp.restaurantlistrefactor.MenuApiInteractor;
import library.talabat.mvp.restaurantlistrefactor.MenuApiListener;

public final /* synthetic */ class e implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuApiInteractor f24282b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuApiListener f24283c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f24284d;

    public /* synthetic */ e(MenuApiInteractor menuApiInteractor, MenuApiListener menuApiListener, String str) {
        this.f24282b = menuApiInteractor;
        this.f24283c = menuApiListener;
        this.f24284d = str;
    }

    public final void onResponse(Object obj) {
        this.f24282b.lambda$onMenuReceived$5(this.f24283c, this.f24284d, (SplitMenuRM) obj);
    }
}
