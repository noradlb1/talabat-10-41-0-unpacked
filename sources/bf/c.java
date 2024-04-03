package bf;

import com.talabat.adapters.restaurantslist.RestaurantsListAdapterRefactor;
import datamodels.Restaurant;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class c implements Function2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantsListAdapterRefactor f50846b;

    public /* synthetic */ c(RestaurantsListAdapterRefactor restaurantsListAdapterRefactor) {
        this.f50846b = restaurantsListAdapterRefactor;
    }

    public final Object invoke(Object obj, Object obj2) {
        return this.f50846b.lambda$onBindViewHolder$1((Restaurant) obj, (Integer) obj2);
    }
}
