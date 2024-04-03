package ht;

import com.talabat.restaurants.v1.RestaurantsListPresenterRefactor;
import com.talabat.restaurants.v2.ui.viewmodels.VendorListGaWrapper;
import io.reactivex.functions.Consumer;
import tracking.ShopClickedEvent;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantsListPresenterRefactor f62139b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Boolean f62140c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f62141d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f62142e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ShopClickedEvent.EventOriginSource f62143f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f62144g;

    public /* synthetic */ i(RestaurantsListPresenterRefactor restaurantsListPresenterRefactor, Boolean bool, String str, String str2, ShopClickedEvent.EventOriginSource eventOriginSource, String str3) {
        this.f62139b = restaurantsListPresenterRefactor;
        this.f62140c = bool;
        this.f62141d = str;
        this.f62142e = str2;
        this.f62143f = eventOriginSource;
        this.f62144g = str3;
    }

    public final void accept(Object obj) {
        this.f62139b.lambda$sendGaOnRestaurantListLoaded$1(this.f62140c, this.f62141d, this.f62142e, this.f62143f, this.f62144g, (VendorListGaWrapper) obj);
    }
}
