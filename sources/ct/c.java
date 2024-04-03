package ct;

import com.talabat.restaurants.RestaurantsListScreenRefactor;
import datamodels.Restaurant;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantsListScreenRefactor f61814b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Restaurant f61815c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f61816d;

    public /* synthetic */ c(RestaurantsListScreenRefactor restaurantsListScreenRefactor, Restaurant restaurant, String str) {
        this.f61814b = restaurantsListScreenRefactor;
        this.f61815c = restaurant;
        this.f61816d = str;
    }

    public final void accept(Object obj) {
        this.f61814b.lambda$GaOnRestaurantsClicked$0(this.f61815c, this.f61816d, (HashMap) obj);
    }
}
