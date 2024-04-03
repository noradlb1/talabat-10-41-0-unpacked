package ct;

import com.talabat.restaurants.RestaurantsListScreenRefactor;
import java.util.concurrent.Callable;

public final /* synthetic */ class e implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantsListScreenRefactor f61818b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f61819c;

    public /* synthetic */ e(RestaurantsListScreenRefactor restaurantsListScreenRefactor, String str) {
        this.f61818b = restaurantsListScreenRefactor;
        this.f61819c = str;
    }

    public final Object call() {
        return this.f61818b.lambda$onInlineAdsAppeard$1(this.f61819c);
    }
}
