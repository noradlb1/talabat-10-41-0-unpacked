package b20;

import io.reactivex.functions.Action;
import library.talabat.mvp.restaurantmenu.RestaurantMeuScreenPresenterR;

public final /* synthetic */ class d implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantMeuScreenPresenterR f24309b;

    public /* synthetic */ d(RestaurantMeuScreenPresenterR restaurantMeuScreenPresenterR) {
        this.f24309b = restaurantMeuScreenPresenterR;
    }

    public final void run() {
        this.f24309b.stopProgress();
    }
}
