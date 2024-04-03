package b20;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.restaurantmenu.RestaurantMeuScreenPresenterR;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantMeuScreenPresenterR f24308b;

    public /* synthetic */ c(RestaurantMeuScreenPresenterR restaurantMeuScreenPresenterR) {
        this.f24308b = restaurantMeuScreenPresenterR;
    }

    public final void accept(Object obj) {
        this.f24308b.logError((Throwable) obj);
    }
}
