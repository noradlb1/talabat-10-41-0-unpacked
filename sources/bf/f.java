package bf;

import com.talabat.adapters.restaurantslist.RestaurantsListAdapterRefactor;
import datamodels.Restaurant;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class f implements Function2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantsListAdapterRefactor f50850b;

    public /* synthetic */ f(RestaurantsListAdapterRefactor restaurantsListAdapterRefactor) {
        this.f50850b = restaurantsListAdapterRefactor;
    }

    public final Object invoke(Object obj, Object obj2) {
        return this.f50850b.lambda$onCreateViewHolder$0((Restaurant) obj, (Integer) obj2);
    }
}
